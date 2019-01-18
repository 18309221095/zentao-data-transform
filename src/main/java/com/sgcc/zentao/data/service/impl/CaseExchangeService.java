/**
 * 
 */
package com.sgcc.zentao.data.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.zentao.data.domain.Case;
import com.sgcc.zentao.data.domain.Casestep;
import com.sgcc.zentao.data.mapper.source.SourceCaseDao;
import com.sgcc.zentao.data.mapper.target.TargetCaseDao;
import com.sgcc.zentao.data.service.ICaseExchangeService;
import com.sgcc.zentao.data.util.Logger;

/**
 * @author tangliang
 *
 */
@Service
public class CaseExchangeService implements ICaseExchangeService {
	@Autowired
	private SourceCaseDao sourceDao;
	@Autowired
	private TargetCaseDao targetDao;

	/* (non-Javadoc)
	 * @see com.sgcc.zentao.data.service.ICaseEchangeService#exchangeCase(java.util.Map, java.util.Map, java.util.Map)
	 */
	@Override
	public Map<Integer, Map<String, Integer>> exchangeCase(Map<Integer, Integer> product, Map<Integer, Integer> module,
			Map<Integer, Map<String, Integer>> story) {
		System.out.println("Case迁移执行...");
		Map<Integer, Map<String, Integer>> result = new HashMap<>();
		Map<String, Integer> init = new HashMap<>();
		init.put("new", 0);
		result.put(0, init);
		List<Case> cases = sourceDao.getCases();
		int maxCount = targetDao.maxCount();
		int oldId = 0, newId = maxCount;
		for(Case case1: cases){
			if(!product.containsKey(case1.getProduct())){
				Logger.logById(case1.getId(), "关联产品被删除");
				continue;
			}
			if(!module.containsKey(case1.getModule())){
				Logger.logById(case1.getId(), "关联模块被删除");
				continue;
			}
			if(!story.containsKey(case1.getStory())){
				Logger.logById(case1.getId(), "关联需求被删除");
				continue;
			}
			oldId = case1.getId();
			newId += 1;
			case1.setId(newId);
			
			case1.setProduct(product.get(case1.getProduct()));
			case1.setModule(module.get(case1.getModule()));
			case1.setStory(story.get(case1.getStory()).get("new"));
			
			case1.setLastEditedDate(case1.getLastEditedDate() == null ? "0000-00-00 00:00:00" : case1.getLastEditedDate());
			case1.setOpenedDate(case1.getOpenedDate() == null ? "0000-00-00 00:00:00" : case1.getOpenedDate());
			case1.setLastRunDate(case1.getLastRunDate() == null ? "0000-00-00 00:00:00" : case1.getLastRunDate());
			case1.setReviewedDate(case1.getReviewedDate() == null ? "0000-00-00" : case1.getReviewedDate());
			case1.setScriptedDate(case1.getScriptedDate() == null ? "0000-00-00" : case1.getScriptedDate());
			
			Map<String, Integer> pairs = new HashMap<>();
			if(case1.getFromBug() != 0){
				pairs.put("fromBug", case1.getFromBug());
			}
			pairs.put("new", newId);
			result.put(oldId, pairs);
			
			targetDao.insertCase(case1);
		}
		
		return result;
	}

	@Override
	public Map<Integer, Integer> exchangeCaseStep(Map<Integer, Map<String, Integer>> cases) {
		System.out.println("Casestep迁移执行...");
		Map<Integer, Integer> result = new HashMap<>();
		List<Casestep> casesteps = sourceDao.getCaseSteps();
		int maxCount = targetDao.maxStepCount();
		int oldId = 0, newId = maxCount;
		List<Casestep> casesteps2 = new ArrayList<>();
		for(Casestep casestep: casesteps){
			if(!cases.containsKey(casestep.getCase_s())){
				continue;
			}
			oldId = casestep.getId();
			newId += 1;
			casestep.setId(newId);
			casestep.setCase_s(cases.get(casestep.getCase_s()).get("new"));
			result.put(oldId, newId);
			casesteps2.add(casestep);
		}
		for(Casestep casestep: casesteps2){
			if(casestep.getParent() != 0){
				casestep.setParent(result.get(casestep.getParent()));
			}
			targetDao.insertCaseStep(casestep);
		}
		return result;
	}

}

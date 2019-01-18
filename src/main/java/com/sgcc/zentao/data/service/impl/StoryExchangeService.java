/**
 * 
 */
package com.sgcc.zentao.data.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.zentao.data.domain.Story;
import com.sgcc.zentao.data.domain.Storyspec;
import com.sgcc.zentao.data.mapper.source.SourceStoryDao;
import com.sgcc.zentao.data.mapper.target.TargetStoryDao;
import com.sgcc.zentao.data.service.IStoryExchangeService;
import com.sgcc.zentao.data.util.Logger;

/**
 * @author tangliang
 *
 */
@Service
public class StoryExchangeService implements IStoryExchangeService {
	@Autowired
	private SourceStoryDao sourceDao;
	@Autowired
	private TargetStoryDao targetDao;

	/* (non-Javadoc)
	 * @see com.sgcc.zentao.data.service.IStoryExchangeService#exchangeStory(java.util.Map, java.util.Map, java.util.Map)
	 */
	@Override
	public Map<Integer, Map<String, Integer>> exchangeStory(Map<Integer, Integer> product, Map<Integer, Integer> plan,
			Map<Integer, Integer> module) {
		System.out.println("Story迁移执行...");
		
		Map<Integer, Map<String, Integer>> result = new HashMap<>();
		Map<String, Integer> init = new HashMap<>();
		init.put("new", 0);
		result.put(0, init);
		
		List<Story> stories = sourceDao.getStories();
		int maxCount = targetDao.maxCount();
		int oldId = 0, newId = maxCount;
		for(Story story : stories){
			if(!product.containsKey(story.getProduct())
					|| !plan.containsKey(story.getPlan())
					|| !module.containsKey(story.getModule())){
				Logger.logById(story.getId());
				continue;
			}
			
			oldId = story.getId();
			// 方案1 maxCount累加
			newId += 1;
			// 方案2 maxCount+源id
			// newId = maxCount + oldId;
			story.setId(newId);
			
			story.setProduct(product.get(story.getProduct()));
			story.setPlan(plan.get(story.getPlan()));
			story.setModule(module.get(story.getModule()));
			
			// 解决0000-00-00等的null错误
			story.setAssignedDate(story.getAssignedDate() == null ? "0000-00-00 00:00:00" : story.getAssignedDate());
			story.setClosedDate(story.getClosedDate() == null ? "0000-00-00 00:00:00" : story.getClosedDate());
			story.setLastEditedDate(story.getLastEditedDate() == null ? "0000-00-00 00:00:00" : story.getLastEditedDate());
			story.setOpenedDate(story.getOpenedDate() == null ? "0000-00-00 00:00:00" : story.getOpenedDate());
			story.setReviewedDate(story.getReviewedDate() == null ? "0000-00-00" : story.getReviewedDate());
			
			Map<String, Integer> pairs = new HashMap<>();
			pairs.put("new", newId);
			if(story.getFromBug() != 0){
				pairs.put("fromBug", story.getFromBug());
			}
			if(story.getToBug() != 0){
				pairs.put("toBug", story.getToBug());
			}
			result.put(oldId, pairs);
			targetDao.insertStory(story);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.sgcc.zentao.data.service.IStoryExchangeService#exchangeStorySpec(java.util.Map)
	 */
	@Override
	public void exchangeStorySpec(Map<Integer, Map<String, Integer>> story) {
		System.out.println("Storyspec迁移执行...");
		List<Storyspec> storyspecs = sourceDao.getStorySpecs();
		for(Storyspec storyspec: storyspecs){
			if(!story.containsKey(storyspec.getStory())){
				Logger.logById(storyspec.getStory());
				continue;
			}
			storyspec.setStory(story.get(storyspec.getStory()).get("new"));
			targetDao.insertStorySpec(storyspec);
		}
	}

}

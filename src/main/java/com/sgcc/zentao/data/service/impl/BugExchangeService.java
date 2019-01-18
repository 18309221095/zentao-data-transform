/**
 * 
 */
package com.sgcc.zentao.data.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.zentao.data.domain.Bug;
import com.sgcc.zentao.data.mapper.source.SourceBugDao;
import com.sgcc.zentao.data.mapper.target.TargetBugDao;
import com.sgcc.zentao.data.mapper.target.TargetStoryDao;
import com.sgcc.zentao.data.mapper.target.TargetTaskDao;
import com.sgcc.zentao.data.service.IBugExchangeService;
import com.sgcc.zentao.data.util.Logger;

/**
 * @author tangliang
 *
 */
@Service
public class BugExchangeService implements IBugExchangeService {
	@Autowired
	private TargetTaskDao taskDao;
	@Autowired
	private TargetStoryDao storyDao;
	@Autowired
	private SourceBugDao sourceDao;
	@Autowired
	private TargetBugDao targetDao;
	
	/* (non-Javadoc)
	 * @see com.sgcc.zentao.data.service.IBugExchangeService#exchangeBug(java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map)
	 */
	@Override
	public Map<Integer, Integer> exchangeBug(Map<Integer, Integer> product, 
			Map<Integer, Integer> project,
			Map<Integer, Integer> plan, 
			Map<Integer, Integer> module, 
			Map<Integer, Map<String, Integer>> story,
			Map<Integer, Map<String, Integer>> task, 
			Map<Integer, Map<String, Integer>> cases) {
		System.out.println("Bug迁移执行...");
		Map<Integer, Integer> result = new HashMap<>();
		result.put(0, 0);
		List<Bug> bugs = sourceDao.getBugs();
		int maxCount = targetDao.maxCount();
		int oldId = 0, newId = maxCount;
		for(Bug bug : bugs){
			if(!product.containsKey(bug.getProduct())
					|| !project.containsKey(bug.getProject())
					|| !plan.containsKey(bug.getPlan())
					|| !module.containsKey(bug.getModule())
					|| !story.containsKey(bug.getStory())
					|| !task.containsKey(bug.getTask())
					|| !cases.containsKey(bug.getCase_s())){
				Logger.logById(bug.getId());
				continue;
			}
			oldId = bug.getId();
			newId += 1;
			bug.setId(newId);
			
			bug.setProduct(product.get(bug.getProduct()));
			bug.setProject(project.get(bug.getProject()));
			bug.setPlan(plan.get(bug.getPlan()));
			bug.setCase_s(cases.get(bug.getCase_s()).get("new"));
			bug.setModule(module.get(bug.getModule()));
			bug.setStory(story.get(bug.getStory()).get("new"));
			bug.setTask(task.get(bug.getTask()).get("new"));
			
			bug.setAssignedDate(bug.getAssignedDate() == null ? "0000-00-00 00:00:00" : bug.getAssignedDate());
			bug.setClosedDate(bug.getClosedDate() == null ? "0000-00-00 00:00:00" : bug.getClosedDate());
			bug.setLastEditedDate(bug.getLastEditedDate() == null ? "0000-00-00 00:00:00" : bug.getLastEditedDate());
			bug.setOpenedDate(bug.getOpenedDate() == null ? "0000-00-00 00:00:00" : bug.getOpenedDate());
			bug.setResolvedDate(bug.getResolvedDate() == null ? "0000-00-00 00:00:00" : bug.getResolvedDate());
			bug.setTestCommentDate(bug.getResolvedDate() == null ? "0000-00-00 00:00:00" : bug.getResolvedDate());
			bug.setDeadline(bug.getDeadline() == null ? "0000-00-00" : bug.getDeadline());
			
			// toStory与toTask
			if(bug.getToStory() != 0){
				bug.setToStory(story.get(bug.getToStory()).get("new"));
				storyDao.updateFromBug(story.get(bug.getToStory()).get("new"), newId);
			}
			if(bug.getToTask() != 0){
				bug.setToTask(task.get(bug.getToTask()).get("new"));
				taskDao.updateFromBug(task.get(bug.getToTask()).get("new"), newId);
			}
			result.put(oldId, newId);
			targetDao.insertBug(bug);
		}
		
		return result;
	}

}

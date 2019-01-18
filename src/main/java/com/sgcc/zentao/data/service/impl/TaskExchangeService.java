/**
 * 
 */
package com.sgcc.zentao.data.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.zentao.data.domain.Task;
import com.sgcc.zentao.data.mapper.source.SourceTaskDao;
import com.sgcc.zentao.data.mapper.target.TargetTaskDao;
import com.sgcc.zentao.data.service.ITaskExchangeService;
import com.sgcc.zentao.data.util.Logger;

/**
 * @author tangliang
 *
 */
@Service
public class TaskExchangeService implements ITaskExchangeService {
	@Autowired
	private SourceTaskDao sourceDao;
	@Autowired
	private TargetTaskDao targetDao;
	
	/* (non-Javadoc)
	 * @see com.sgcc.zentao.data.service.ITaskExchangeService#exchangeTask(java.util.Map, java.util.Map, java.util.Map)
	 */
	
	@Override
	public Map<Integer, Map<String, Integer>> exchangeTask(Map<Integer, Integer> project, Map<Integer, Integer> module,
			Map<Integer, Map<String, Integer>> story) {
		System.out.println("Task迁移执行...");
		Map<Integer, Map<String, Integer>> result = new HashMap<>();
		Map<String, Integer> init = new HashMap<>();
		init.put("new", 0);
		result.put(0, init);
		List<Task> tasks = sourceDao.getTasks();
		int maxCount = targetDao.maxCount();
		int oldId = 0, newId = maxCount;
		for(Task task : tasks){
			/**
			 * module story均可以等于0
			 */
			if(!project.containsKey(task.getProject())
					|| !module.containsKey(task.getModule())
					|| !story.containsKey(task.getStory())){
				Logger.logById(task.getId());
				continue;
			}
			oldId = task.getId();
			newId += 1;
			task.setId(newId);
			
			task.setProject(project.get(task.getProject()));
			task.setModule(module.get(task.getModule()));
			task.setStory(story.get(task.getStory()).get("new"));
			
			task.setAssignedDate(task.getAssignedDate() == null ? "0000-00-00 00:00:00" : task.getAssignedDate());
			task.setClosedDate(task.getClosedDate() == null ? "0000-00-00 00:00:00" : task.getClosedDate());
			task.setLastEditedDate(task.getLastEditedDate() == null ? "0000-00-00 00:00:00" : task.getLastEditedDate());
			task.setOpenedDate(task.getOpenedDate() == null ? "0000-00-00 00:00:00" : task.getOpenedDate());
			task.setCanceledDate(task.getCanceledDate() == null ? "0000-00-00 00:00:00":task.getCanceledDate());
			task.setFinishedDate(task.getFinishedDate() == null ? "0000-00-00 00:00:00": task.getFinishedDate());
			task.setDeadline(task.getDeadline() == null ? "0000-00-00" : task.getDeadline());
			task.setEstStarted(task.getEstStarted() == null ? "0000-00-00" : task.getEstStarted());
			task.setRealStarted(task.getRealStarted() == null ? "0000-00-00" : task.getRealStarted());
			
			Map<String, Integer> pairs = new HashMap<>();
			if(task.getFromBug() != 0){
				pairs.put("fromBug", task.getFromBug());
			}
			pairs.put("new", newId);
			result.put(oldId, pairs);
			
			targetDao.insertTask(task);
		}
		
		return result;
	}

}

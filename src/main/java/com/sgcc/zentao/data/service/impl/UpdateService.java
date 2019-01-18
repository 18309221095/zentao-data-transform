/**
 * 
 */
package com.sgcc.zentao.data.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgcc.zentao.data.mapper.target.TargetCaseDao;
import com.sgcc.zentao.data.mapper.target.TargetStoryDao;
import com.sgcc.zentao.data.service.IUpdateService;

/**
 * @author tangliang
 * 可以在这里更新其他的，目前是在bug迁移中完成了
 */
@Service
public class UpdateService implements IUpdateService {
	
	@Autowired
	private TargetStoryDao storyDao;
	@Autowired
	private TargetCaseDao caseDao;

	
	/* (non-Javadoc)
	 * @see com.sgcc.zentao.data.service.IUpdateService#updateStories(java.util.Map, java.util.Map)
	 */
	@Override
	public void updateStories(Map<Integer, Integer> bug, Map<Integer, Map<String, Integer>> story) {
		for(Map.Entry<Integer, Map<String, Integer>> entry : story.entrySet()){
			Map<String, Integer> current = entry.getValue();
			if(current.containsKey("toBug")){
				storyDao.updateToBug(entry.getKey(), bug.get(current.get("toBug")));
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see com.sgcc.zentao.data.service.IUpdateService#updateCases(java.util.Map, java.util.Map)
	 */
	@Override
	public void updateCases(Map<Integer, Integer> bug, Map<Integer, Map<String, Integer>> cases) {
		for(Map.Entry<Integer, Map<String, Integer>> entry : cases.entrySet()){
			Map<String, Integer> current = entry.getValue();
			if(current.containsKey("fromBug")){
				caseDao.updateCaseFromBug(entry.getKey(), bug.get(current.get("fromBug")));
			}
		}
	}

}

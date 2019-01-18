/**
 * 
 */
package com.sgcc.zentao.data.service;

import java.util.Map;

/**
 * @author tangliang
 *
 */
public interface IUpdateService {
	public void updateCases(Map<Integer, Integer> bug, Map<Integer, Map<String, Integer>> cases);
	public void updateStories(Map<Integer, Integer> bug, Map<Integer, Map<String, Integer>> story);
}

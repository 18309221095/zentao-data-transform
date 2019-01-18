/**
 * 
 */
package com.sgcc.zentao.data.service;

import java.util.Map;

/**
 * @author tangliang
 *
 */
public interface IBugExchangeService {
	/**
	 * 
	 * @param product 产品id对应表
	 * @param project 项目id对应表
	 * @param plan 计划id对应表
	 * @param module 模块id对应表
	 * @param story 需求id对应表 额外字段fromBug toBug
	 * @param task 任务id对应表 额外字段fromBug
	 * @return
	 */
	public Map<Integer, Integer> exchangeBug(Map<Integer, Integer> product, Map<Integer, Integer> project, Map<Integer, Integer> plan,
			Map<Integer, Integer> module, Map<Integer, Map<String, Integer>> story, 
			Map<Integer, Map<String, Integer>> task, Map<Integer, Map<String, Integer>> cases);
}

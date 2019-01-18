package com.sgcc.zentao.data.service;

import java.util.Map;

/**
 * 
 * @author tangliang
 *
 */
public interface IStoryExchangeService {

	/**
	 * 
	 * @param product 产品id对应表
	 * @param plan 计划id对应表
	 * @param module 模块id对应表
	 * @return map 返回计划任务id对应表，附加字段fromBug
	 */
	public Map<Integer, Map<String, Integer>> exchangeStory(Map<Integer, Integer> product, Map<Integer, Integer> plan,
			Map<Integer, Integer> module);
	
	/**
	 * 
	 * @param story 需求id对照表
	 */
	public void exchangeStorySpec(Map<Integer, Map<String, Integer>> story);
}

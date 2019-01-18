package com.sgcc.zentao.data.service;

import java.util.Map;

public interface ITaskExchangeService {
	/**
	 * 
	 * @param product
	 *            产品id对应表
	 * @param module
	 *            模块id对应表
	 * @param story
	 *            需求id对应表
	 * @return 任务id对应表 额外字段fromBug
	 */
	public Map<Integer, Map<String, Integer>> exchangeTask(Map<Integer, Integer> project, Map<Integer, Integer> module,
			Map<Integer, Map<String, Integer>> story);
}

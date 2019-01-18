/**
 * 
 */
package com.sgcc.zentao.data.service;

import java.util.Map;

/**
 * @author tangliang
 *
 */
public interface ICaseExchangeService {
	
	/**
	 * 
	 * @param product
	 * @param module
	 * @param story
	 * @return
	 */
	public Map<Integer, Map<String, Integer>> exchangeCase(
			Map<Integer, Integer> product, Map<Integer, Integer> module,
			Map<Integer, Map<String, Integer>> story);
	
	
	public Map<Integer, Integer> exchangeCaseStep(Map<Integer, Map<String, Integer>> cases);
}

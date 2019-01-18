/**
 * 
 */
package com.sgcc.zentao.data.mapper.source;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sgcc.zentao.data.domain.Case;
import com.sgcc.zentao.data.domain.Casestep;

/**
 * @author tangliang
 *
 */
@Mapper
public interface SourceCaseDao {
	/**
	 * 获取源库所有用例
	 * @return list
	 */
	public List<Case> getCases();
	
	/**
	 * 获取所有的用例步骤
	 * @return list
	 */
	public List<Casestep> getCaseSteps();
}

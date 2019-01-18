/**
 * 
 */
package com.sgcc.zentao.data.mapper.source;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sgcc.zentao.data.domain.Bug;

/**
 * @author tangliang
 *
 */
@Mapper
public interface SourceBugDao {
	
	/**
	 * 获取源库所有bug
	 * @return list
	 */
	public List<Bug> getBugs();
}

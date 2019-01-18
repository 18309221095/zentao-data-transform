/**
 * 
 */
package com.sgcc.zentao.data.mapper.source;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sgcc.zentao.data.domain.Task;

/**
 * @author tangliang
 *
 */
@Mapper
public interface SourceTaskDao {
	/**
	 *  获取源库所有的任务
	 * @return list
	 */
	public List<Task> getTasks();
}

/**
 * 
 */
package com.sgcc.zentao.data.mapper.source;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sgcc.zentao.data.domain.Story;
import com.sgcc.zentao.data.domain.Storyspec;

/**
 * @author tangliang
 *
 */
@Mapper
public interface SourceStoryDao {
	/**
	 * 
	 * @return 所有的需求
	 */
	public List<Story> getStories();
	
	/**
	 * 
	 * @return 需求描述相关内容
	 */
	public List<Storyspec> getStorySpecs();
}

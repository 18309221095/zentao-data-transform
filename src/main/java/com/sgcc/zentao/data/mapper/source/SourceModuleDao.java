//******************************************************************
//系统名称：PMS2.5
//模块名称：TODO
//版本信息
//版本:1.0    日期:2019年1月3日    作者:唐亮     备注:新建
//******************************************************************

package com.sgcc.zentao.data.mapper.source;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sgcc.zentao.data.domain.Module;

/**
 * <b>概述</b>： <blockquote>源module表操作</blockquote>
 * <p/>
 * <b>功能</b>： <blockquote>主要做插入操作</blockquote>
 * 
 * @author <a href="mailto:1284676837@qq.com">唐亮</a>
 **/
@Mapper
public interface SourceModuleDao {
    /**
     * 
     * <b>功能</b>：<br/>
     *  获取所有的module
     * @return List Module
     */
    public List<Module> getModules();
}

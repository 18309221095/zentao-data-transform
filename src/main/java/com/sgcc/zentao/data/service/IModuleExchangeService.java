package com.sgcc.zentao.data.service;

import java.util.Map;

/**
 * 
 * <b>概述</b>：
 * <blockquote>协助的迁移服务</blockquote>
 * <p/>
 * <b>功能</b>：
 * <blockquote>执行数据迁移</blockquote>
 * @author  <a href="mailto:1284676837@qq.com">唐亮</a>
 *
 */
public interface IModuleExchangeService {
    /**
     * 
     * <b>功能</b>：<br/>
     *  执行数据迁移 <br />
     *  zt_module表
     *  @param root root字段转换表
     *  return Map 源id：新id
     */
    public Map<Integer, Integer> exchangeModule(Map<Integer, Integer> root);
}

//******************************************************************
//系统名称：PMS2.5
//模块名称：TODO
//版本信息
//版本:1.0    日期:2019年1月2日    作者:唐亮     备注:新建
//******************************************************************
package com.sgcc.zentao.data.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sgcc.zentao.data.domain.Module;
import com.sgcc.zentao.data.mapper.source.SourceModuleDao;
import com.sgcc.zentao.data.mapper.target.TargetModuleDao;
import com.sgcc.zentao.data.service.IModuleExchangeService;
import com.sgcc.zentao.data.util.Logger;

/**
 * <b>概述</b>：
 * <blockquote>请补充</blockquote>
 * <p/>
 * <b>功能</b>：
 * <blockquote>请补充</blockquote>
 * @author  <a href="mailto:1284676837@qq.com">唐亮</a>
 **/
@Service
public class ModuleExchangeService implements IModuleExchangeService {
    /**
     * 源表
     */
    @Autowired
    private SourceModuleDao sourceDao;
    /**
     * 目标表
     */
    @Autowired
    private TargetModuleDao targetDao;

    /** 
     * @see com.sgcc.zentao.data.service.IModuleExchangeService#exchangeModule(java.util.Map)
     */
    @Override
    public Map<Integer, Integer> exchangeModule(Map<Integer, Integer> root) {
    	System.out.println("Module迁移执行...");
        List<Module> modules = sourceDao.getModules();
        Map<Integer, Integer> result = new HashMap<>();
        // 初始化
        result.put(0, 0);
        int maxCount = targetDao.maxCount();
        String path[] = null;
        int newId = 0, oldId = 0;
        for(Module module : modules) {
        	// 新环境不存在此product
        	if(!root.containsKey(module.getRoot())){
        		maxCount -= 1;
        		Logger.logById(module.getId());
        		continue;
        	}
        	oldId = module.getId();
        	newId = oldId + maxCount;
        	// 设置id为原id + max
            module.setId(newId);
            result.put(oldId, newId);
            // 更新root为新环境的product id
            module.setRoot(root.get(module.getRoot()));
            // 更新父节点信息
            module.setParent(module.getParent() == 0 ? 0 : module.getParent() + maxCount);
            // 更新路径节点信息
            path = module.getPath().split(",");
            for (int i = 0; i < path.length; i++) {
            	if(path[i].length() > 0) {
                	// 原+max
                    path[i] = String.valueOf(Integer.valueOf(path[i]) + maxCount);
                }
			}
            module.setPath(StringUtils.arrayToDelimitedString(path, ",") + ",");
            // 插入目标库
            targetDao.insertModules(module);
        }
        return result;
    }

}

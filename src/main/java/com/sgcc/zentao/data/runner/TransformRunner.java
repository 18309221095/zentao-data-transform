package com.sgcc.zentao.data.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sgcc.zentao.data.service.IBugExchangeService;
import com.sgcc.zentao.data.service.ICaseExchangeService;
import com.sgcc.zentao.data.service.IModuleExchangeService;
import com.sgcc.zentao.data.service.IStoryExchangeService;
import com.sgcc.zentao.data.service.ITaskExchangeService;
import com.sgcc.zentao.data.service.IUpdateService;
import com.sgcc.zentao.data.util.Parser;


/**
 * <b>概述</b>： <blockquote>执行迁移</blockquote>
 * <p/>
 * <b>功能</b>： <blockquote>请补充</blockquote>
 * 
 * @author <a href="mailto:1284676837@qq.com">唐亮</a>
 **/
@Component
public class TransformRunner implements CommandLineRunner {
	public static final int INIT = 0;
	public static final int MODULE = 1;
	public static final int STORY = 2;
	public static final int TASK = 3;
	public static final int BUG = 6;
	public static final int CASE = 4;
	public static final int CASESTEP = 5;
	public static final int UPDATE = 7;
	@Autowired
	private IModuleExchangeService moduleService;
	@Autowired
	private IStoryExchangeService storySevice;
	@Autowired
	private ITaskExchangeService taskService;
	@Autowired
	private ICaseExchangeService caseService; 
	@Autowired
	private IBugExchangeService bugService;
	@Autowired
	private IUpdateService updateService;
	@Value("${localuser.file.path}")
	private String configFile;

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 1) {
			configFile = arg0[1].trim();
		}
		
		Map<Integer, Integer> product = null;
		Map<Integer, Integer> project = null;
		Map<Integer, Integer> plan = null;
		Map<Integer, Integer> module = null;
		Map<Integer, Integer> bug = null;
		Map<Integer, Integer> casestep = null;
		// 额外字段fromBug
		Map<Integer, Map<String, Integer>> cases = null;
		// 额外字段fromBug toBug
		Map<Integer, Map<String, Integer>> story = null;
		// 额外字段fromBug
		Map<Integer, Map<String, Integer>> task = null;
		
		int current = INIT, next = MODULE;
		try {
			product = Parser.getPairs(configFile, "product");
			project = Parser.getPairs(configFile, "project");
			plan = Parser.getPairs(configFile, "plan");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("解析配置文件错误，请注意标准格式");
		}
		try {
			// 模块 只涉及product 对应字段root
			if (product != null && product.size() > 0) {
				System.out.println("6s后将执行数据迁移，请确认已完成数据备份，确保已关闭禅道并保持数据库服务启动");
				Thread.sleep(6000);
				current = MODULE;
				next = STORY;
				module = moduleService.exchangeModule(product);
			}
			// 需求 设计product module plan
			if (next == STORY && (module != null && module.size() > 0) && (plan != null && plan.size() > 0)) {
				current = STORY;
				next = TASK;
				story = storySevice.exchangeStory(product, plan, module);
				storySevice.exchangeStorySpec(story);
			}
			// 任务 涉及project module story
			if (next == TASK 
					&& (story != null && story.size() > 0)
					&& (project != null && project.size() > 0)) {
				current = TASK;
				next = CASE;
				task = taskService.exchangeTask(project, module, story);
			}
			
			// case 涉及product module story
			if (next == CASE) {
				current = CASE;
				next = CASESTEP;
				cases = caseService.exchangeCase(product, module, story);
			}
			// casestep 
			if (next == CASESTEP && (cases != null && cases.size() > 0)) {
				current = CASESTEP;
				next = BUG;
				casestep = caseService.exchangeCaseStep(cases);
			}
			// bug 涉及project module product plan story task
			if (next == BUG && (project != null && project.size() > 0)) {
				current = BUG;
				next = UPDATE;
				bug = bugService.exchangeBug(product, project, plan, module, story, task, cases);
			}
			
			if(next == UPDATE){
				current = UPDATE;
				next = INIT;
				updateService.updateCases(bug, cases);
				updateService.updateStories(bug, story);
			}
			

		} catch (Exception e) {
			current = INIT;
			e.printStackTrace();
		}
		if (current != UPDATE) {
			System.out.println("部分迁移失败(step:" + current + ")，请恢复目标库，检查后重新迁移");
		}

	}

}

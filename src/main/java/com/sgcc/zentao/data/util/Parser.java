/**
 * v1.0
 */
package com.sgcc.zentao.data.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * @author tangliang
 * 解析文件内容
 */
public class Parser {
	
	/**
	 * 
	 * @param pathname
	 * @param match
	 * @return
	 * @throws IOException
	 */
	public static Map<Integer, Integer> getPairs(String pathname, String match) throws IOException {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		File file = new File(pathname);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String temp = null;
		String tag = null;
		result.put(0, 0);
		
		while ((temp = reader.readLine()) != null) {
			// 之后可以用作多项配置，执行不同的解析规则
			if (temp.trim().startsWith("#")) {
				tag = getTag(temp.trim());
				continue;
			}else if(temp.trim().startsWith("//")){
				// 不予理会的行可以使用`//`
				continue;
			}
			if(match.equalsIgnoreCase(tag) && !StringUtils.isEmpty(temp.trim())){
				String key = null, value = null;
				for(String s : temp.split(" ")){
					s = s.trim();
					if(s.length() > 0 && key == null){
						key = s;
					}else if(s.length() > 0){
						value = s;
					}
					if(key != null && value != null){
						result.put(Integer.valueOf(key), Integer.valueOf(value));
						break;
					}
				}
			}
		}
		reader.close();
		return result;
	}
	
	/**
	 * 
	 * @param tagment
	 * @return
	 */
	public static String getTag(String tagment) {
		return tagment.split("#")[1].trim();
	}
}

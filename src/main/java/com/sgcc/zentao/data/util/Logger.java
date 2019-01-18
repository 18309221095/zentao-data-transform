/**
 * 
 */
package com.sgcc.zentao.data.util;

/**
 * @author tangliang
 *
 */
public class Logger {
	/**
	 * 迁移失败
	 * @param id
	 */
	public static void logById(Integer id) {
		System.out.println("迁移失败:id(" + id + ")");
	}
	
	public static void logById(Integer id, String reason) {
		System.out.println("迁移失败id(" + id + "):" + reason);
	}
}

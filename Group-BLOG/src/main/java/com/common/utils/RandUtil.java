package com.common.utils;

import java.util.Random;

/**
 * 常用工具类
 */
public class RandUtil {
	/**
	 * 生成激活码
	 * @param size
	 * @return
	 */
	public static String createActiveCode(Integer size) {
		String str = "1234567890";
		String result = "";
		
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			result += str.charAt(random.nextInt(str.length()));
		}
		
		return result;
	}
}
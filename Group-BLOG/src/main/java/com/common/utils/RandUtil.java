package com.common.utils;

import java.util.Random;

/**
 * ���ù�����
 */
public class RandUtil {
	/**
	 * ���ɼ�����
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
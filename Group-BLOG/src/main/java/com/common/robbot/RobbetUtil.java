package com.common.robbot;


public class RobbetUtil {
	public static void closeDB(AutoCloseable... c){
		for (AutoCloseable autoCloseable : c) {
			if(autoCloseable!=null){
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
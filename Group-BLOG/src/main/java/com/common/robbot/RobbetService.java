package com.common.robbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class RobbetService {
	private static String baseUrl = "http://www.tuling123.com/openapi/api";// API接口
	private static String APIKEY = "2c55436d70aa411a8116062502613e54";// APIKEY
	private static String queryUrl = baseUrl + "?key=" + APIKEY + "&info=";// GET模式提交参数

	public static String getTheResult(String info) {
		BufferedReader in = null;
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(queryUrl + new String(info.getBytes("UTF-8")));
			URLConnection con = url.openConnection();// 回车
			in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			String str = "";
			while ((str = in.readLine()) != null) {
				sb.append(str);// 将读取到的数据存入str中
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			RobbetUtil.closeDB(in);
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}


}


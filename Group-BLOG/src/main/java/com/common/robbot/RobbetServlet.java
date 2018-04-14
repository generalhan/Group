package com.common.robbot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




  public class RobbetServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//设置字符编码格式
		request.setCharacterEncoding("UTF-8");//请求编码格式
		response.setCharacterEncoding("UTF-8");//响应编码格式
		//获取info
		String info = request.getParameter("info");
		//调用方法获取结果
		String result=RobbetService.getTheResult(info);
		//将结果输出到页面
		response.getWriter().print(result);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

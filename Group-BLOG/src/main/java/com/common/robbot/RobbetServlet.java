package com.common.robbot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




  public class RobbetServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		//�����ַ������ʽ
		request.setCharacterEncoding("UTF-8");//��������ʽ
		response.setCharacterEncoding("UTF-8");//��Ӧ�����ʽ
		//��ȡinfo
		String info = request.getParameter("info");
		//���÷�����ȡ���
		String result=RobbetService.getTheResult(info);
		//����������ҳ��
		response.getWriter().print(result);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

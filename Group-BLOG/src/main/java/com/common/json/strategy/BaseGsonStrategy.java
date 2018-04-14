package com.common.json.strategy;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
/**
 * GSON²ßÂÔ
 * @author zwl
 *
 */
public class BaseGsonStrategy implements Strategy{

	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public BaseGsonStrategy(){

	}
	
	public Object JsonDeal(Object object) {
		
		try {
		
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().setCharacterEncoding("utf-8");
		 ((ServletResponse) RequestContextHolder.getRequestAttributes()).setCharacterEncoding("UTF-8");
		 ((ServletResponse) RequestContextHolder.getRequestAttributes()).setContentType("application/json; charset=utf-8");          
		 ((HttpServletResponse) RequestContextHolder.getRequestAttributes()).setHeader("Cache-Control", "no-cache");                 
		 ((HttpServletResponse) RequestContextHolder.getRequestAttributes()).setHeader("Pragma", "no-cache");  
			PrintWriter out = ((ServletResponse) RequestContextHolder.getRequestAttributes()).getWriter();
			 out.write(this.GsonWrite(object));
			 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private String GsonWrite(Object object){
		Gson gson=new Gson();
		return gson.toJson(object);
	}
	
	  
		public static HttpServletResponse Tojson() throws Exception{
			HttpServletResponse response=((ServletRequestAttributes) ContextLoader.getCurrentWebApplicationContext().getServletContext()).getResponse();
			HttpServletRequest request=((ServletRequestAttributes) ContextLoader.getCurrentWebApplicationContext().getServletContext()).getRequest();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");          
		    response.setHeader("Cache-Control", "no-cache");                 
		    response.setHeader("Pragma", "no-cache");  
			PrintWriter out = response.getWriter();
			return response;
		}
	
}

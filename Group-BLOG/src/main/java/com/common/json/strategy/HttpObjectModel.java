package com.common.json.strategy;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * http信息域简单包装类
 * @author zwl
 */
public class HttpObjectModel {
   
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public HttpObjectModel(){
		request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public HttpServletRequest getRequest() {
		 ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		
		 return request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public HttpObjectModel setAttributes(String name,Object o){
		request.setAttribute(name, o);
		return this;
	}
}

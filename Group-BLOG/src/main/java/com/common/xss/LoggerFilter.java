package com.common.xss;

import java.io.IOException;
import java.util.Date;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.common.json.strategy.HttpObjectModel;
import com.common.utils.AddressUtils;
import com.common.utils.DateUtil;
import com.front.entity.TVisitInfoEntity;
import com.front.service.TVisitInfoService;
import com.sys.entity.TUserEntity;

public class LoggerFilter implements Filter {

	
	private TVisitInfoService tVisitInfoService;
	
	private static Logger logger = LoggerFactory.getLogger(LoggerFilter.class);
	
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext sc = filterConfig.getServletContext(); 
        XmlWebApplicationContext cxt = (XmlWebApplicationContext)WebApplicationContextUtils.getWebApplicationContext(sc);
        
        if(cxt != null && cxt.getBean("tVisitInfoService") != null && tVisitInfoService == null)
        	tVisitInfoService = (TVisitInfoService) cxt.getBean("tVisitInfoService");  
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");
		  HttpServletRequest httpRequest = (HttpServletRequest)request;		 
		  Date time_begin = new Date();
		   chain.doFilter(request, response); // 继续执行
		   Date time_end = new Date();	   
		   /**成功登录**/
		   if(request.getAttribute("flag")!=null){
		  /**请求耗时 **/
		   long i = (long) ((time_end.getTime() - time_begin.getTime()));
		   /**保存日志**/
		   loggerSave(httpRequest, i);
		   }
		  else{
			  logger.info("error");
		  }
	}

	private void loggerSave(HttpServletRequest httpRequest, long i) {
		try {
		TVisitInfoEntity t=new TVisitInfoEntity();
		  t.setLoggerName("登录系统");
		      t.setLoggerType("业务日志");
		      t.setRequestUrl(httpRequest.getServletPath());
		      t.setRequestType(httpRequest.getMethod());
		      t.setUserName(httpRequest.getParameter("userName"));
		      t.setVisitorIp(httpRequest.getRemoteAddr());
		      t.setRequestTime((int)i);
		      /**获得ip对应的实际地址**/
		      String json_result=AddressUtils.getAddresses("ip="+httpRequest.getRemoteAddr(), "utf-8");
		      JSONObject json = new JSONObject(json_result);		  
              String region = JSON.toJSONString(((JSONObject) json.get("data")).get("region"));   
              String city = JSON.toJSONString(((JSONObject) json.get("data")).get("city"));              
              String s= region.replace("\"","");
              String s1= city.replace("\"","");
              t.setIpAddress(s+" "+s1);
		      t.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		      t.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		      tVisitInfoService.save(t);} catch (Exception e) {
			}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	
	




}

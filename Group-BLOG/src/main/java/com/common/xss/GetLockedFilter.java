package com.common.xss;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sys.entity.TUserEntity;
import com.sys.service.TUserService;



/**
 * 过滤被拉黑的用户
 * @author zwl
 *
 */

public class GetLockedFilter extends AccessControlFilter{

    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
	@Resource
	private TUserService tUserService;
	 
	 private String loginUrl = "/500.jsp"; 
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		     String userName=request.getParameter("userName");
		     System.out.println(userName);
		     logger.debug(userName);
		     logger.info(userName);
		     Map<String, Object> map=new HashMap<String, Object>();
		         map.put("userName", userName);
		         TUserEntity t=(TUserEntity)tUserService.getTUserEntity(map);
		      if(t.getUserState()==1){
		    	 return false;
		     }	     
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		WebUtils.issueRedirect(request, response, loginUrl);
		return false;
	}

}

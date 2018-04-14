package com.common.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.common.global.annotions.Constants;
import com.front.entity.TLinkInfoEntity;
import com.front.service.TLinkInfoService;
import com.sys.entity.TUserEntity;
import com.sys.service.TUserService;



public class InitBlogDataListener implements ServletContextListener{

	
	
	private ApplicationContext context = null;  
    private  TUserService tUserService=null;


    public void contextInitialized(ServletContextEvent sce) {
           
        context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
       
         //根据spring的上下文获取bloggerService这个bean
         tUserService = (TUserService) context.getBean("tUserService");
          //获取博主信息
             Map<String, Object> map=new HashMap<String, Object>();
                 map.put("userName", Constants.MASTER_NAME);
                 TUserEntity user =(TUserEntity)tUserService.getTUserEntity(map);
               /**清空密码**/
                 user.setUserPwd("");
               /**将信息存入application域中**/
                 sce.getServletContext().setAttribute("blogger", user);
              
              //初始换链接信息
                 TLinkInfoService linkService = (TLinkInfoService) context.getBean("tLinkInfoService");
                 List<TLinkInfoEntity> linkList = linkService.getLinkData();
                 sce.getServletContext().setAttribute("linkList", linkList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }


}

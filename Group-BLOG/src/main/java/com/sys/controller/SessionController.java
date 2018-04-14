package com.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.common.global.annotions.Constants;
import com.front.service.TSessionService;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * 在线人数控制类
 * 由于精力有限，导致这里写的算法复杂度有点高，可以改进
 * PS：缓存用不好会让人想吐血，这里的目的就是根据缓存中的所有在线会话，清除缓存队列中已失效会话同时还要筛选所有非登录的会话
 * 我的思路是通过异常，筛选出未登录的，而筛选可以通过保存在队列中已登录的会话作比对
 * @author zwl
 *
 */

@Controller
@RequestMapping("/sessions")
public class SessionController {
	
	 @Autowired
	    private SessionDAO sessionDAO;
	    
	    @Autowired
	    private TSessionService tSessionService;
	    
	    @RequestMapping("currentSession")
	    public String list(Model model) throws Exception{
	    	
	                  model.addAttribute("sessions", tSessionService.getActivesSessions());
	                    model.addAttribute("sessionCount", tSessionService.visitorOnlineCount());
	                     return "sys/sessionList";
	    }

		

	    @RequestMapping("/{sessionId}/forceLogout")
	    public String forceLogout (
	            @PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes)throws Exception {
	        try {
	            Session session = sessionDAO.readSession(sessionId);
	            if(session != null) {
	                session.setAttribute(Constants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);
	            }
	        } catch (Exception e) {/*ignore*/}
	        redirectAttributes.addFlashAttribute("msg", "强制退出成功！");
	        return "redirect:/sessions/currentSession";
	    }

	    
	    

}

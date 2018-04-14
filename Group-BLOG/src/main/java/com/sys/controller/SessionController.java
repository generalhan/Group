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
 * ��������������
 * ���ھ������ޣ���������д���㷨���Ӷ��е�ߣ����ԸĽ�
 * PS�������ò��û���������Ѫ�������Ŀ�ľ��Ǹ��ݻ����е��������߻Ự����������������ʧЧ�Ựͬʱ��Ҫɸѡ���зǵ�¼�ĻỰ
 * �ҵ�˼·��ͨ���쳣��ɸѡ��δ��¼�ģ���ɸѡ����ͨ�������ڶ������ѵ�¼�ĻỰ���ȶ�
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
	        redirectAttributes.addFlashAttribute("msg", "ǿ���˳��ɹ���");
	        return "redirect:/sessions/currentSession";
	    }

	    
	    

}

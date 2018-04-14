package com.common.listener;
import java.util.Date;
 import java.util.Hashtable;
import java.util.Iterator;
 
 import javax.servlet.http.HttpSession;
 import javax.servlet.http.HttpSessionEvent;
 import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.common.utils.StringUtil;
import com.front.service.TSessionService;
 


 /**
12  * 
13  * @ClassName: SessionListener
14  * @Description: 记录所有登陆的Session信息，为在线列表做基础
 *
 */
 public class SessionListener implements HttpSessionListener {
	 
	 @Autowired
	 private TSessionService tSessionService;
     
     //在线列表<uid,session>
    private static Hashtable<String,HttpSession> sessionList = new Hashtable<String, HttpSession>();
    
 
     public void sessionCreated(HttpSessionEvent event) {
         //不做处理，只处理登陆用户的列表
         //从redis中查找用户是否存在，不存在添加登记表
    	 event.getSession().getServletContext().setAttribute("visitorCount",tSessionService.visitorOnline(event.getSession().getId()));  
    System.out.println("begin");
     }
 
     public void sessionDestroyed(HttpSessionEvent event) {
        removeSession(event.getSession());
     }
     
     public static void removeSession(HttpSession session){
        if(session == null){
             return ;       }

         String uid=(String)session.getAttribute("currrentUser");//已登陆状态会将用户的UserId保存在session中
         if(!StringUtil.isNotEmpty(uid)){//判断是否登陆状态
            removeSession(uid);
         }
     }
     
     public static void removeSession(String uid){
        HttpSession session = sessionList.get(uid);
         try{
             sessionList.remove(uid);//先执行，防止session.invalidate()报错而不执行
            if(session != null){
                session.invalidate();
            }
         }catch (Exception e) {
            System.out.println("Session invalidate error!");
        }
    }
    
    public static void addSession(String uid,HttpSession session){
         sessionList.put(uid, session);
    }
     
     public static int getSessionCount(){
         return sessionList.size();
     }
     
     public static Iterator<HttpSession> getSessionSet(){
         return sessionList.values().iterator();
     }
    
     public static HttpSession getSession(String id){
         return sessionList.get(id);
     }
    
     public static boolean contains(String uid){
         return sessionList.containsKey(uid);
     }
     
     /**
      * 
      * @Title: isLoginOnThisSession
      * @Description: 检测是否已经登陆
      * @param @param uid 用户UserId
      * @param @param sid 发起请求的用户的SessionId
      * @return boolean true 校验通过 
      */
     public static boolean isLoginOnThisSession(String uid,String sid){
         if(uid==null||sid==null){
             return false;
         }
         if(contains(uid)){
             HttpSession session = sessionList.get(uid);
             
             if(session!=null&&session.getId().equals(sid)){
                 return true;
             }
         }
         return false;
     }
     
 }
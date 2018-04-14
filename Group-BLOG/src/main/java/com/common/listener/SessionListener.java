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
14  * @Description: ��¼���е�½��Session��Ϣ��Ϊ�����б�������
 *
 */
 public class SessionListener implements HttpSessionListener {
	 
	 @Autowired
	 private TSessionService tSessionService;
     
     //�����б�<uid,session>
    private static Hashtable<String,HttpSession> sessionList = new Hashtable<String, HttpSession>();
    
 
     public void sessionCreated(HttpSessionEvent event) {
         //��������ֻ�����½�û����б�
         //��redis�в����û��Ƿ���ڣ���������ӵǼǱ�
    	 event.getSession().getServletContext().setAttribute("visitorCount",tSessionService.visitorOnline(event.getSession().getId()));  
    System.out.println("begin");
     }
 
     public void sessionDestroyed(HttpSessionEvent event) {
        removeSession(event.getSession());
     }
     
     public static void removeSession(HttpSession session){
        if(session == null){
             return ;       }

         String uid=(String)session.getAttribute("currrentUser");//�ѵ�½״̬�Ὣ�û���UserId������session��
         if(!StringUtil.isNotEmpty(uid)){//�ж��Ƿ��½״̬
            removeSession(uid);
         }
     }
     
     public static void removeSession(String uid){
        HttpSession session = sessionList.get(uid);
         try{
             sessionList.remove(uid);//��ִ�У���ֹsession.invalidate()�������ִ��
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
      * @Description: ����Ƿ��Ѿ���½
      * @param @param uid �û�UserId
      * @param @param sid ����������û���SessionId
      * @return boolean true У��ͨ�� 
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
package com.common.xss;



import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ������½��������
 * @author zwl
 *
 */
public class KickoutSessionControlFilter extends AccessControlFilter {

    private String kickoutUrl; //�߳��󵽵ĵ�ַ
    private boolean kickoutAfter = false; //�߳�֮ǰ��¼��/֮���¼���û� Ĭ���߳�֮ǰ��¼���û�
    private int maxSession = 100; //ͬһ���ʺ����Ự�� Ĭ��1
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());

    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    	return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
         Session session = subject.getSession();
          String username = (String) subject.getPrincipal();       
           Serializable sessionId = session.getId();
             if(!subject.isAuthenticated() && !subject.isRemembered()) {
               //���û�е�¼��ֱ�ӽ���֮�������
               return true;
          }
       
        synchronized (this.cache) {  
            Deque<Serializable> deque = this.cache.get(username);  
            if (deque == null) {  
                deque = new ConcurrentLinkedDeque<Serializable>(); 
            }  
  
            if (!deque.contains(sessionId) && session.getAttribute("kickOut") == null) {  
                session.setAttribute("username", username);  
                deque.addLast(sessionId);  
            }  
            this.logger.debug("logged user:" + username + ", deque size = " + deque.size());  
            this.logger.debug("deque = " + deque);  
            if(deque.size() > this.maxSession) { 
            	System.out.println("����"+deque.size());
                if (!this.kickoutAfter) {  
                	sessionId = deque.removeFirst(); 
                	System.out.println("�߳�����");
                    this.logger.debug("kick out head session: " + sessionId);  
                } else {  
                	sessionId = deque.removeLast();  
                	System.out.println("���ǰ��");
                    this.logger.debug("kick out tail session: " + sessionId);  
                }  
                try {
                    Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(sessionId));
                    if(kickoutSession != null) {    
                    	System.out.println("over");
                        //���ûỰ��kickout���Ա�ʾ�߳���
                       // kickoutSession.setAttribute("kickout", true);
                    	 kickoutSession.stop();
                    }
                } catch (Exception e) {//ignore exception
                }
            }  
  
            this.cache.put(username, deque); 
        }
        
       
        
            //������߳��ˣ�ֱ���˳����ض����߳���ĵ�ַ
            if (session.getAttribute("kickout") != null) {           	
                //�Ự���߳���
                try {
                    subject.logout();
                } catch (Exception e) { //ignore
                }
                saveRequest(request);
                WebUtils.issueRedirect(request, response, kickoutUrl);
                return false;
            }            
            return true;
        }  
}


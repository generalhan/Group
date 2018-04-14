package com.common.listener;

import java.io.Serializable;
import java.util.Deque;
import java.util.Iterator;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.cache.CacheManager;

/**
 * ���������ʧЧ�ĻỰ
 * @author zwl
 *
 */
public class KickOutSessionListener implements SessionListener {  
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());  
    private Cache<String, Deque<Serializable>> cache;  
    
    @Autowired
    private SessionDAO sessionDAO;
  
    public void setCacheManager(CacheManager cacheManager) {  
        this.cache =  cacheManager.getCache("shiro-kickout-session");      
    }  
  
    private void removeSessionFromCache(Session session) { 
    	/**�õ����˳��ĻỰ���˴������������˳�����ǿ���˳�����ͬһ�˺�ͬʱ��½�����˳�**/
       String username = (String) session.getAttribute("username"); 
         logger.info("�Ѹ���һ�λỰ");
          if (username != null) {  
        	  logger.info("remove session: " + session.getId() + " in deque of " + username  
                    + "@shiro-kickout-session");
             /** ���ֻ�����Ϣ����ͬ��**/
            synchronized (this.cache) {  
            	    /**�õ�������½����ͬ�˺ŵĻ������**/
                Deque<Serializable> deque = this.cache.get(username);
                   /**ע��shiro�Ѿ��ߵ��˲����˺ŵ����壬��������������ǻ����ڻ����еĻỰid**/
                 deque.remove(session.getId()); 
                   /**ɾ���ûỰ**/
               sessionDAO.delete(session);  
                   
               this.cache.put(username, deque);  
            }  
        }  
    }     
  
    public void onStop(Session session) {     
    	this.removeSessionFromCache(session);  
    }  
  
  
    public void onExpiration(Session session) { 
     this.removeSessionFromCache(session);  
    }

	public void onStart(Session session) {		
	}  

}

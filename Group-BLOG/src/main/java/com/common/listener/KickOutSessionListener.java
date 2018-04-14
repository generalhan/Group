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
 * 监听并清除失效的会话
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
    	/**得到已退出的会话，此处可能是自主退出，被强制退出或者同一账号同时登陆受限退出**/
       String username = (String) session.getAttribute("username"); 
         logger.info("已更新一次会话");
          if (username != null) {  
        	  logger.info("remove session: " + session.getId() + " in deque of " + username  
                    + "@shiro-kickout-session");
             /** 保持缓存信息更新同步**/
            synchronized (this.cache) {  
            	    /**得到并发登陆的相同账号的缓存队列**/
                Deque<Serializable> deque = this.cache.get(username);
                   /**注意shiro已经踢掉了并发账号的主体，这里我们清除的是还存在缓存中的会话id**/
                 deque.remove(session.getId()); 
                   /**删除该会话**/
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

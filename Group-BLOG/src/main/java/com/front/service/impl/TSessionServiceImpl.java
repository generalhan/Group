package com.front.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.front.service.TSessionService;
import com.redis.dao.JedisClient;
import com.redis.dao.JedisOnlinePool;

@Service
public class TSessionServiceImpl implements TSessionService {

	@Autowired
	private JedisOnlinePool jedisOnlinePool;

	@Autowired
    private SessionDAO sessionDAO;
	
	public int visitorOnline(String sid) {
		/**统计游客人数**/
		if(!jedisOnlinePool.isVisitorOnline(sid)){
			jedisOnlinePool.login(sid);
		}		
		return jedisOnlinePool.onlineVisitorCount();
	}

	public int visitorOnlineCount() {
		        
		return getActiveSession().size();
	}
	
	public Collection<Session> getActivesSessions() {
		
		return getActiveSession();
	}

	   /**得到活跃会话信息**/
	private Collection<Session> getActiveSession() {
		/**获得当前所有活跃的在线用户**/
        Collection<Session> sessionss =  sessionDAO.getActiveSessions(); 
         /**用来保存仍然存在缓存中但已失效的的用户会话  **/
       Collection<Session> sessions=new LinkedList<Session>();        
        List<Session> list=(List<Session>) sessionss;  
         /**筛选出有效的会话**/
           ActiveSessions(sessionss, sessions, list);
               /**剩下正常的在线用户**/
	            Collection<Session> sessionsss=sessionDAO.getActiveSessions();
	            return sessionsss;
	}
	
	
	
	/**得到在线活跃会话**/
    private void ActiveSessions(Collection<Session> sessionss, Collection<Session> sessions, List<Session> list) {
		Iterator<Session> it= sessionss.iterator();
          /**删选出已失效的会话**/
       while(it.hasNext()){
    	   try {  	   
    	   Session session=it.next();  
             PrincipalCollection principalCollection =
               (PrincipalCollection)session.getAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY);
                  sessions.add(session); } catch (Exception e) {
  	}		   
       }
       /**删除缓存活跃会话中失效的会话**/
               Iterator<Session> t=sessions.iterator();
                while(t.hasNext()){
    	               Session temp=t.next();  	 
    	                  for(int i=0;i<list.size();i++){
    		                     String sss=list.get(i).getId().toString();
    		                 if(sss.equals(temp.getId().toString()))
    		                    {
    			                 sessionDAO.delete(list.get(i));
    		                    }
    	 }
      }
	}

	

	
}

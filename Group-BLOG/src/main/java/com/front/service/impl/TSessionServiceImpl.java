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
		/**ͳ���ο�����**/
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

	   /**�õ���Ծ�Ự��Ϣ**/
	private Collection<Session> getActiveSession() {
		/**��õ�ǰ���л�Ծ�������û�**/
        Collection<Session> sessionss =  sessionDAO.getActiveSessions(); 
         /**����������Ȼ���ڻ����е���ʧЧ�ĵ��û��Ự  **/
       Collection<Session> sessions=new LinkedList<Session>();        
        List<Session> list=(List<Session>) sessionss;  
         /**ɸѡ����Ч�ĻỰ**/
           ActiveSessions(sessionss, sessions, list);
               /**ʣ�������������û�**/
	            Collection<Session> sessionsss=sessionDAO.getActiveSessions();
	            return sessionsss;
	}
	
	
	
	/**�õ����߻�Ծ�Ự**/
    private void ActiveSessions(Collection<Session> sessionss, Collection<Session> sessions, List<Session> list) {
		Iterator<Session> it= sessionss.iterator();
          /**ɾѡ����ʧЧ�ĻỰ**/
       while(it.hasNext()){
    	   try {  	   
    	   Session session=it.next();  
             PrincipalCollection principalCollection =
               (PrincipalCollection)session.getAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY);
                  sessions.add(session); } catch (Exception e) {
  	}		   
       }
       /**ɾ�������Ծ�Ự��ʧЧ�ĻỰ**/
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

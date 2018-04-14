package com.redis.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.redis.dao.JedisOnlinePool;
import com.sys.entity.TUserEntity;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
  * 
  * Redis�����д������key��
  * 1.SID_PREFIX��ͷ����ŵ�½�û���SessionId��ClientUser��Json����
  * 2.UID_PREFIX��ͷ����ŵ�¼�û���UID��SessionId���ڵ�����
  * 3.VID_PREFIX��ͷ�����λ��ָ��ҳ���û������ݣ���Ajaxһ��ʹ�ã�����ʵ��ָ��ҳ��ͬʱ������������ƹ��ܣ�
  */
@Service
public class JedisOnlinePoolImpl implements JedisOnlinePool {
	
	@Autowired
	private JedisPool jedisPool;
	
	@Value("${SID_PREFIX}")
	private String SID_PREFIX;
	
	@Value("${UID_PREFIX}")
	private String UID_PREFIX;
	
	@Value("${VID_PREFIX}")
	private String VID_PREFIX;
	
	@Value("${NAME_PREFIX}")
	private String NAME_PREFIX;
	
	private static final int OVERDATETIME=30*60;
	
	private static final int BROADCAST_OVERDATETIME= 70;
	
	private static final String VISITOR="ONLINE_VISITOR";
	
	public void login(String sid){
		Jedis jedis = jedisPool.getResource();
		jedis.setex(VISITOR+sid, OVERDATETIME, sid);
		jedis.close();
	}
	
	public void login(String name, String sid) {
		Jedis jedis = jedisPool.getResource();
		  jedis.setex(NAME_PREFIX+name, OVERDATETIME, name);
		  jedis.setex(SID_PREFIX+sid, OVERDATETIME, sid);
		  jedis.close();
		
	}

	public void login(String sid, TUserEntity user) {
		Jedis jedis = jedisPool.getResource();
		jedis.setex(SID_PREFIX+sid, OVERDATETIME, userToString(user));
          jedis.setex(UID_PREFIX+user.getPkId(), OVERDATETIME, sid);
           jedis.close();
		
	}

	public void broadcast(String uid, String identify) {
		if(uid==null||"".equals(uid)) //�쳣���ݣ���������µ�½�û��Żᷢ�������
		             return ;
		Jedis jedis = jedisPool.getResource();
         jedis.setex(VID_PREFIX+identify+":"+uid, BROADCAST_OVERDATETIME, uid);
		
	}

	public String userToString(TUserEntity user) {
		return null;
	}

	public void logout(String sid, String uid) {
		// TODO Auto-generated method stub
		
	}

	public void logout(String uid) {
		// TODO Auto-generated method stub
		
	}

	public String getClientUserBySessionId(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getClientUserByUid(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List online() {
		// TODO Auto-generated method stub
		return null;
	}

	public List onlineByPage(int page, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getKey(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public int onlineCount() {
		
		Jedis jedis = jedisPool.getResource();
		Set online = jedis.keys(SID_PREFIX+"*");
		jedis.close();
		return online.size();
	}
	
	public int onlineVisitorCount(){
		Jedis jedis = jedisPool.getResource();
		Set online = jedis.keys(VISITOR+"*");
		jedis.close();
		return online.size();
	}

	public int broadcastCount(String identify) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isOnline(String name) {
		Jedis jedis = jedisPool.getResource();
		boolean isLogin = jedis.exists(NAME_PREFIX+name);
		  jedis.close();
		return isLogin;
	}
	
	public boolean isVisitorOnline(String sid){
		Jedis jedis = jedisPool.getResource();
		boolean isLogin = jedis.exists(VISITOR+sid);
		  jedis.close();
		return isLogin;
	}

	public boolean isOnline(String uid, String sid) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}

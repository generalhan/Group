package com.redis.dao;

import java.util.List;

import com.sys.entity.TUserEntity;

public interface JedisOnlinePool {
	//
	void login(String sid);
	//
	void login(String name,String sid);
	//
	void login(String sid,TUserEntity user);
	//
	void broadcast(String uid,String identify);
	//
	String userToString(TUserEntity user);
	//
	void logout(String sid,String uid);
	//
	void logout(String uid);
	//
	String getClientUserBySessionId(String sid);
	//
	String getClientUserByUid(String uid);
	//���е�key
	List online();
	//��ҳ��ʾ�����б�
	List onlineByPage(int page,int pageSize) throws Exception;
	//
	String getKey(Object obj);
	//����������
	int onlineCount();
	//�ο�������
	int onlineVisitorCount();
	//��ȡָ��ҳ��������������
	int broadcastCount(String identify);
	//�ο��Ƿ�����
	boolean isVisitorOnline(String sid);
	//ָ���˺��Ƿ��½
	boolean isOnline(String name);
	//
	boolean isOnline(String uid,String sid);
	
}

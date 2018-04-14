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
	//所有的key
	List online();
	//分页显示在线列表
	List onlineByPage(int page,int pageSize) throws Exception;
	//
	String getKey(Object obj);
	//总在线人数
	int onlineCount();
	//游客总人数
	int onlineVisitorCount();
	//获取指定页面在线人数总数
	int broadcastCount(String identify);
	//游客是否在线
	boolean isVisitorOnline(String sid);
	//指定账号是否登陆
	boolean isOnline(String name);
	//
	boolean isOnline(String uid,String sid);
	
}

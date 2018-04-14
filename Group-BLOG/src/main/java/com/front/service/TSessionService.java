package com.front.service;

import java.util.Collection;

import org.apache.shiro.session.Session;

public interface TSessionService {

	//游客登记处理
	int visitorOnline(String sid);
	//按一定时间间隔统计统计当天登录人数
	int visitorOnlineCount();
	//统计所有在线会话
	Collection<Session> getActivesSessions();
}

package com.front.service;

import java.util.Collection;

import org.apache.shiro.session.Session;

public interface TSessionService {

	//�ο͵ǼǴ���
	int visitorOnline(String sid);
	//��һ��ʱ����ͳ��ͳ�Ƶ����¼����
	int visitorOnlineCount();
	//ͳ���������߻Ự
	Collection<Session> getActivesSessions();
}

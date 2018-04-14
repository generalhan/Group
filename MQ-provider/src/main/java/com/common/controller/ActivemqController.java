package com.common.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.common.activemq.producer.QueueSender;
import com.common.activemq.producer.TopicSender;
import com.common.utils.DesUtils;
import com.common.utils.Global;
import com.common.utils.TEmailCodeEntity;




@Controller
@RequestMapping("/activemq")
public class ActivemqController {
	
	@Resource 
	QueueSender queueSender;
	@Resource 
	TopicSender topicSender;
	
	/**
	 * ������Ϣ������
	 * Queue���У�����һ�������߻��յ���Ϣ����Ϣһ��������Ͳ�����ڶ�����
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("queueSender")
	public String queueSender(String emailCode,String emailAddress){		
		try {
			queueSender.send(Global.MQ_QUEUE_DESTIONATION, JSON.toJSONString(new TEmailCodeEntity(new DesUtils().decrypt(emailAddress),new DesUtils().decrypt(emailCode))));
			return JSON.toJSONString(1);
		} catch (Exception e) {
	   return JSON.toJSONString(0);
		}
	}
	
	/**
	 * ������Ϣ������
	 * Topic���� ������һ����Ϣ�����ж����߶����յ� 
	 * ���������Ŀ�ĵ���һ�Զ��
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender(@RequestParam("msg")String msg){
		try {
			topicSender.send(Global.MQ_TOPIC_DESTIONATION, msg);
			return JSON.toJSONString(1);
		} catch (Exception e) {
	   return JSON.toJSONString(0);
		}
	}
	
}

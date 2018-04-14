package com.common.listener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.common.controller.WebsocketController;
import com.common.utils.Global;


/**
 * 推送消息
 * @author Administrator
 *
 */
@Component("topicReceiverlistener")
public class TopicReceiverListener implements MessageListener{
	 protected static final Logger logger = Logger.getLogger(TopicReceiverListener.class);
		
	
		public void onMessage(Message message) {
		        TextMessage textMessage = (TextMessage) message;
		        try {
		            String jsonStr = textMessage.getText();
		            if (jsonStr != null) {
		            	/**推送给前台**/
		                WebsocketController.broadcast(Global.PUSH_MSG, jsonStr);
		            }
		        } catch (JMSException e) {
		            logger.error("[Message]:receive message occured an exception",e);
		        }
		    }

	
	
}

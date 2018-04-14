package com.common.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.common.utils.MailUtil;
import com.common.utils.SendMailToSomeone;
import com.common.utils.TEmailCodeEntity;

/**
 * 发送邮件
 * @author Administrator
 *
 */
@Component("queueReceiverlistener")
public class QueueReceiverListener implements MessageListener{

	 protected static final Logger logger = Logger.getLogger(QueueReceiverListener.class);
	 
	public synchronized void onMessage(Message message) {
		 TextMessage textMessage = (TextMessage) message;
	        try {
	            String jsonStr = textMessage.getText();
	            TEmailCodeEntity email=JSONObject.parseObject(jsonStr, TEmailCodeEntity.class);
	            if (jsonStr != null) {
	            	/**发送邮件**/
	            	new SendMailToSomeone().send("激活码",email.getEmailCode() ,email.getEmailAddress(),MailUtil.getInstance().getfromEmail(),MailUtil.getInstance().getPassword(),MailUtil.getInstance().getmailType());
	            }
	        } catch (JMSException e) {
	            logger.error("[Message]:receive message occured an exception",e);
	        }
		
	}

}

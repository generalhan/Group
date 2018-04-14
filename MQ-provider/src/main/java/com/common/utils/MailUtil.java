package com.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 得到邮件主体配置的信息
 * @author zwl
 *
 */
public class MailUtil {
   private static MailUtil mailUtil;
   private static String fromEmail;
   private static String password;
   private static String mailType;
   private static Properties properties=new Properties();
	
	private MailUtil(){}
	
	public static MailUtil getInstance(){
		if(mailUtil==null){
			mailUtil=new MailUtil();
		}
		return mailUtil;
	}
	
	static {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("mail-config.properties");
			properties.load(in);
			fromEmail = properties.getProperty("fromEmail");
			password = properties.getProperty("password");
			mailType = properties.getProperty("mailType");	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getfromEmail(){
		return this.fromEmail;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getmailType(){
		return this.mailType;
	}
}

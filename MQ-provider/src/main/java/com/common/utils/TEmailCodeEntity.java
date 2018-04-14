package com.common.utils;

import java.io.Serializable;




/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
public class TEmailCodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	

	//
	private String emailAddress;
	//
	private String emailCode;

	
	

	public TEmailCodeEntity() {
		super();
	}
	
	public TEmailCodeEntity(String emailAddress, String emailCode) {
		super();
		this.emailAddress = emailAddress;
		this.emailCode = emailCode;
	}
	
	/**
	 * 璁剧疆锛�
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getEmailCode() {
		return emailCode;
	}
}

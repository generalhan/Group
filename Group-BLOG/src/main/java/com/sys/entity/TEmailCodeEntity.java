package com.sys.entity;

import java.io.Serializable;
import java.util.Date;



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
	private Integer pkId;
	//
	private String emailAddress;
	//
	private String emailCode;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	
	

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
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getPkId() {
		return pkId;
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
	/**
	 * 璁剧疆锛�
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
}

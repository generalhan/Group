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
public class TUserEntity extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private String userName;
	//
	private String userPwd;
	//
	private Integer userState;
	//
	private String emailAddress;
	//
	private String userRealName;
	//
	private String userPersonality;
	//
	private Date userOnTime;
	//
	private Date userLeaveTime;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	//
	private String userHeadimg;

	public String getUserHeadimg() {
		return userHeadimg;
	}

	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}

	public TUserEntity(){
		
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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getUserPwd() {
		return userPwd;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setUserState(Integer userState) {
		this.userState = userState;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getUserState() {
		return userState;
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
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getUserRealName() {
		return userRealName;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setUserPersonality(String userPersonality) {
		this.userPersonality = userPersonality;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getUserPersonality() {
		return userPersonality;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setUserOnTime(Date userOnTime) {
		this.userOnTime = userOnTime;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Date getUserOnTime() {
		return userOnTime;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setUserLeaveTime(Date userLeaveTime) {
		this.userLeaveTime = userLeaveTime;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Date getUserLeaveTime() {
		return userLeaveTime;
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

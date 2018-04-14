package com.front.entity;

import java.io.Serializable;
import java.util.Date;

import com.sys.entity.BaseEntity;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
public class TVisitInfoEntity extends BaseEntity implements Serializable {
private static final long serialVersionUID = 1L;
	
	//
	private String ipAddress;
	//
	private Integer pkId;
	//
	private String visitorIp;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	//
	private String requestUrl;
	//
	private String requestType;
	//
	private String userName;
	//
	private String loggerName;
	//
	private String loggerType;
	//
	private Integer requestTime;

	/**
	 * 设置：
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	/**
	 * 获取：
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	/**
	 * 设置：
	 */
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
	/**
	 * 获取：
	 */
	public Integer getPkId() {
		return pkId;
	}
	/**
	 * 设置：
	 */
	public void setVisitorIp(String visitorIp) {
		this.visitorIp = visitorIp;
	}
	/**
	 * 获取：
	 */
	public String getVisitorIp() {
		return visitorIp;
	}
	/**
	 * 设置：
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
	/**
	 * 设置：
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	/**
	 * 获取：
	 */
	public String getRequestUrl() {
		return requestUrl;
	}
	/**
	 * 设置：
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	/**
	 * 获取：
	 */
	public String getRequestType() {
		return requestType;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}
	/**
	 * 获取：
	 */
	public String getLoggerName() {
		return loggerName;
	}
	/**
	 * 设置：
	 */
	public void setLoggerType(String loggerType) {
		this.loggerType = loggerType;
	}
	/**
	 * 获取：
	 */
	public String getLoggerType() {
		return loggerType;
	}
	/**
	 * 设置：
	 */
	public void setRequestTime(Integer requestTime) {
		this.requestTime = requestTime;
	}
	/**
	 * 获取：
	 */
	public Integer getRequestTime() {
		return requestTime;
	}
}

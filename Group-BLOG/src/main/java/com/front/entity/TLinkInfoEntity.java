package com.front.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
public class TLinkInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private String linkName;
	//
	private String linkUrl;
	//
	private Integer linkOrder;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;

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
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getLinkUrl() {
		return linkUrl;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setLinkOrder(Integer linkOrder) {
		this.linkOrder = linkOrder;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getLinkOrder() {
		return linkOrder;
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

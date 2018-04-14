package com.front.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:29
 */
public class TCritiquerecordInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private Integer blogId;
	//
	private String visitIp;
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
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getBlogId() {
		return blogId;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setVisitIp(String visitIp) {
		this.visitIp = visitIp;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getVisitIp() {
		return visitIp;
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

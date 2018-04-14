package com.front.entity;

import java.io.Serializable;
import java.util.Date;

import com.sys.entity.BaseEntity;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:44
 */
public class TCommentInfoEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private String blogComment;
	//
	private Integer fkUid;
	//
	private Integer fkBlogId;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	//
	private String userName;
	//
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getBlogComment() {
		return blogComment;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setFkUid(Integer fkUid) {
		this.fkUid = fkUid;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getFkUid() {
		return fkUid;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setFkBlogId(Integer fkBlogId) {
		this.fkBlogId = fkBlogId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getFkBlogId() {
		return fkBlogId;
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

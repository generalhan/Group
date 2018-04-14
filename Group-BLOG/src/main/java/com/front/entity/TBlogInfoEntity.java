package com.front.entity;

import java.io.Serializable;
import java.util.Date;

import com.sys.entity.BaseEntity;
import com.sys.entity.TUserEntity;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:44
 */
public class TBlogInfoEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer Id;
	//
	private String blogTitle;
	//
	private String blogContent;
	//
	private String visitIp;
	//
	private Integer fkUid;
	//
	private Integer visitorHasread;
	//
	private Integer blogState;// 置顶:1、加精:2、加精且置顶:3普通贴0,
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	//
	private String blogLable;
	//
	private String userName;
	//
	private String item;
	//
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getPkId() {
		return Id;
	}
	public void setPkId(Integer pkId) {
		this.Id = pkId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getFkUid() {
		return fkUid;
	}
	public void setFkUid(Integer fkUid) {
		this.fkUid = fkUid;
	}
	
	/**
	 * 璁剧疆锛�
	 */
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getBlogTitle() {
		return blogTitle;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getBlogContent() {
		return blogContent;
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
	public void setVisitorHasread(Integer visitorHasread) {
		this.visitorHasread = visitorHasread;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getVisitorHasread() {
		return visitorHasread;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setBlogState(Integer blogState) {
		this.blogState = blogState;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getBlogState() {
		return blogState;
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
	/**
	 * 璁剧疆锛�
	 */
	public void setBlogLable(String blogLable) {
		this.blogLable = blogLable;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getBlogLable() {
		return blogLable;
	}
}

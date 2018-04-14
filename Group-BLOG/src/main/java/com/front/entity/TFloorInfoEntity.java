package com.front.entity;

import java.io.Serializable;
import java.util.Date;

import com.sys.entity.BaseEntity;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:43
 */
public class TFloorInfoEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private Integer blogId;
	//
	private Integer commentId;
	//
	private Integer userId;
	//
	private String floorComment;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	//
	private String userName;
	//
	private String replyedName;
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
	public String getReplyedName() {
		return replyedName;
	}
	public void setReplyedName(String replyedName) {
		this.replyedName = replyedName;
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
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getCommentId() {
		return commentId;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setFloorComment(String floorComment) {
		this.floorComment = floorComment;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getFloorComment() {
		return floorComment;
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

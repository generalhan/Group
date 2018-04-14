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
public class TMessageInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private String visitorIp;
	//
	private String messageContent;
	//
	private Integer messageState;
	//
	private Integer parentNode;
	//
	private Integer currentNode;
	//
	private Integer replyNode;
	//
	private Integer messagePraise;
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
	public void setVisitorIp(String visitorIp) {
		this.visitorIp = visitorIp;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getVisitorIp() {
		return visitorIp;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getMessageContent() {
		return messageContent;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setMessageState(Integer messageState) {
		this.messageState = messageState;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getMessageState() {
		return messageState;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setParentNode(Integer parentNode) {
		this.parentNode = parentNode;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getParentNode() {
		return parentNode;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setCurrentNode(Integer currentNode) {
		this.currentNode = currentNode;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getCurrentNode() {
		return currentNode;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setReplyNode(Integer replyNode) {
		this.replyNode = replyNode;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getReplyNode() {
		return replyNode;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setMessagePraise(Integer messagePraise) {
		this.messagePraise = messagePraise;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getMessagePraise() {
		return messagePraise;
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

package com.common.indecorator;


public class TMessageIndecorator {

	private Integer id;
	private String contents;
	private String currentName;
	private String parentName;
	private String replyName;
	private String ip;
	private String time;
	private int currentNode;
	
	public int getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(int currentNode) {
		this.currentNode = currentNode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getContents() {
		return contents;
	}
	public String getCurrentName() {
		return currentName;
	}
	public String getParentName() {
		return parentName;
	}
	public String getReplyName() {
		return replyName;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setCurrentName(String currentName) {
		this.currentName = currentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
}

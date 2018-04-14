package com.common.indecorator;

import java.util.Date;

public class SearchModel {

	//
	private String blogContent;
	//
	private String blogTitle;
	//
	private Date gmtCreate;
	//
	private String item;
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getBlogContent() {
		return blogContent;
	}
	
	public String getBlogTitle() {
		return blogTitle;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
}

package com.front.entity;

import java.io.Serializable;
import java.util.Date;

public class TAlgotithmsTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
    //
	private String algotithmsType;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;
	//
	private Integer pkId;
	public String getAlgotithmsType() {
		return algotithmsType;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public Integer getPkId() {
		return pkId;
	}
	public void setAlgotithmsType(String algotithmsType) {
		this.algotithmsType = algotithmsType;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
	
	
	
	
}

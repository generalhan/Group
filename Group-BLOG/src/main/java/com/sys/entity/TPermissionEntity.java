package com.sys.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
public class TPermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private String permissionName;
	//
	private String permissionDescription;
	//
	private Boolean permissionAvailable;
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
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getPermissionName() {
		return permissionName;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getPermissionDescription() {
		return permissionDescription;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setPermissionAvailable(Boolean permissionAvailable) {
		this.permissionAvailable = permissionAvailable;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Boolean getPermissionAvailable() {
		return permissionAvailable;
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

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
public class TRolePermissionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer roleId;
	//
	private Integer permissionId;
	//
	private Date gmtCreate;
	//
	private Date gmtModified;

	/**
	 * 璁剧疆锛�
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getPermissionId() {
		return permissionId;
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

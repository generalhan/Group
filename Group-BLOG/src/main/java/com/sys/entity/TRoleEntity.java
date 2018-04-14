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
public class TRoleEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer pkId;
	//
	private String roleName;
	//
	private String roleDescription;
	//
	private Boolean roleAvailable;
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
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public String getRoleName() {
		return roleName;
	}
	
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	/**
	 * 璁剧疆锛�
	 */
	public void setRoleAvailable(Boolean roleAvailable) {
		this.roleAvailable = roleAvailable;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Boolean getRoleAvailable() {
		return roleAvailable;
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

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
public class TUserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer userId;
	//
	private Integer roleId;

	
	public TUserRoleEntity() {
		super();
	}
	
	
	public TUserRoleEntity(Integer userId, Integer roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
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
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 鑾峰彇锛�
	 */
	public Integer getRoleId() {
		return roleId;
	}
}

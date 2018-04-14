package com.sys.dao;


import org.apache.ibatis.annotations.Mapper;

import com.sys.entity.TUserRoleEntity;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TUserRoleDao  {
	
	//
	void save(TUserRoleEntity tuserRole);
}

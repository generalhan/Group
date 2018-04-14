package com.sys.dao;


import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.sys.entity.TRoleEntity;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TRoleDao {
	//
	Set<TRoleEntity> findRoles(String userName);
	//
	void updateRolesOfUser(Map<String, Object> map);
}

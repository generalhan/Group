package com.sys.service;

import java.util.Map;
import java.util.Set;

import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.sys.entity.TRoleEntity;



public interface TRoleService {

	//
	Set<TRoleEntity> findRoles(String userName);
	//
	Pagemodal getListbyPage(Page page, Map<String, Object> map);
	//
	void updateRole(Map<String, Object> map);
}

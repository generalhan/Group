package com.sys.service;

import java.util.Map;

import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.sys.entity.TUserEntity;


public interface TUserService<TUserEntity> extends SysBaseService{

	//用户是否存在
	boolean getUserEntity(Map<String, Object> map);
	//
	void save(TUserEntity user);
    //
	void update(Map<String, Object> map);
	//
	TUserEntity getTUserEntity(Map<String, Object> map);
	//
	void remove(int pkId);
	//
	long getCount();
}

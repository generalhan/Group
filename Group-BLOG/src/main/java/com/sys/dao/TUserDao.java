package com.sys.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sys.entity.TUserEntity;


/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TUserDao {
	
	//
	List<Map<String, Object>> getAllUsersOfMap();
	//
	List<TUserEntity> queryList(Map<String, Object> map);
	//
	Long queryTotal(Map<String, Object> map);
	//
	void save(TUserEntity user);
	//
	void update(Map<String, Object> map);
	//
	void delete(int pkId);
	//
	void deleteBatch(int[] pkId);
	//
	TUserEntity getTUserByid(int pkId);
}

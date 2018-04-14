package com.front.dao;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.front.entity.TCritiquerecordInfoEntity;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:29
 */
@Mapper
public interface TCritiquerecordInfoDao  {
	//
	void save(TCritiquerecordInfoEntity t);
	//
	TCritiquerecordInfoEntity queryObject(Map<String, Object> map);
	//
	void delete(Map<String, Object> map);
	//
	void deleteBatch(int[] pkId);
}

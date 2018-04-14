package com.front.dao;

import com.front.entity.TFloorInfoEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:43
 */
@Mapper
public interface TFloorInfoDao{
	
	//
	void save(TFloorInfoEntity floorInfo);
	//
	List<TFloorInfoEntity>  queryList(Map<String, Object> map);
	//
	Long queryTotal(Map<String, Object> map);
	//
	void delete(Map<String, Object> map);
	//
	void deleteBatch(int[] pkId);
}

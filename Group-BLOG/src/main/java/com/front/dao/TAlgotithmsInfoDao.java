package com.front.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.front.entity.TAlgotithmsInfoEntity;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TAlgotithmsInfoDao{
	//
	void save(TAlgotithmsInfoEntity tAlgotithmsInfo);
	//
	List<TAlgotithmsInfoEntity> queryList(Map<String, Object> map);
}

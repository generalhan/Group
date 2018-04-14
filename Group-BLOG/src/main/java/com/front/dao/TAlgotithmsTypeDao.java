package com.front.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.front.entity.TAlgotithmsInfoEntity;
import com.front.entity.TAlgotithmsTypeEntity;


/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TAlgotithmsTypeDao{
	//
	void save(TAlgotithmsTypeEntity tAlgotithmsType);
	//
	List<TAlgotithmsTypeEntity> queryList(Map<String, Object> map);
}

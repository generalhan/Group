package com.sys.dao;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.sys.entity.TEmailCodeEntity;


/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TEmailCodeDao  {
	//
	List<TEmailCodeEntity> queryList(Map<String, Object> map);
	//
	void save(TEmailCodeEntity emailCode);
}

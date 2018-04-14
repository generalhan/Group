package com.front.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.front.entity.TVisitInfoEntity;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TVisitInfoDao {
	//
	void save(TVisitInfoEntity t);
	//
	List<TVisitInfoEntity> queryList(Map<String, Object> map);
	//
	Long queryTotal(Map<String, Object> map);
	//
	void delete(int pkId);
	//
	void deleteBatch(List<Integer> list);
}

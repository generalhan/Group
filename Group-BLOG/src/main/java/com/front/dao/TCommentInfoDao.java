package com.front.dao;

import com.front.entity.TCommentInfoEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:44
 */
@Mapper
public interface TCommentInfoDao {
	
	//
	void save(TCommentInfoEntity commentInfo);
	//
	List<TCommentInfoEntity> queryList(Map<String, Object> map);
	//
	Long queryTotal(Map<String, Object> map);
	//
	void update(Map<String, Object> map);
	//
	void delete(Map<String, Object> map);
	//
	void deleteBatch(int[] pkId);
}

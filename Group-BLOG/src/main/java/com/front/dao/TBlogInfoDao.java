package com.front.dao;

import com.front.entity.TBlogInfoEntity;

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
public interface TBlogInfoDao {
	
	//
	void save(TBlogInfoEntity blogInfo);
	//
	List<TBlogInfoEntity> queryAllList(Map<String, Object> map);
	//
	Long queryTotal(Map<String, Object> map);
	//
	List<TBlogInfoEntity> getListByStatus(List<Integer> status);
	//
	void update(Map<String, Object> map);
	//
	void delete(int pkId);
	//
	void deleteBatch(int[] pkId);
	
}

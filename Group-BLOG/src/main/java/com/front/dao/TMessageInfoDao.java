package com.front.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.front.entity.TMessageInfoEntity;


/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TMessageInfoDao {
	
	//
	void save(TMessageInfoEntity MessageInfo);
	//
    public List<TMessageInfoEntity> queryAllParentNodeMessage();
	//
	public List<TMessageInfoEntity> queryNotAllOfParentNodeMessage();
}

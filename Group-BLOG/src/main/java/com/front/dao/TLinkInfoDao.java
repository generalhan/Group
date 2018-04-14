package com.front.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.front.entity.TLinkInfoEntity;



/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
@Mapper
public interface TLinkInfoDao  {
	
	//获取友情链接
    public List<TLinkInfoEntity> getLinkData();
}

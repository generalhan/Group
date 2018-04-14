package com.front.service;

import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.front.entity.TCommentInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:44
 */
public interface TCommentInfoService {
	
	//
	void save(TCommentInfoEntity tCommentInfo);
	//
	Pagemodal getListbyPage(Page page, Map<String, Object> map);
	//
	long getCount();
	//
	void remove(Map<String, Object> map);
	

}

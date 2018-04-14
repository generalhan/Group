package com.front.service;

import java.util.List;
import java.util.Map;

import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.front.entity.TBlogInfoEntity;
import com.sys.entity.TUserEntity;

public interface TBlogInfoService {

	//
	void save(TBlogInfoEntity blogInfo,TUserEntity user);
	//
	Pagemodal getListbyPage(Page page, Map<String, Object> map);
	//
	long getCount();
	//
	List<TBlogInfoEntity> getListByStatus();
	//
	TBlogInfoEntity getBlogInfo(Map<String, Object> map);
	//
	void update(Map<String, Object> map);
	//
	void remove(int pkId);
	//
	List<TBlogInfoEntity> getListHotBlog();
	
}

package com.front.service;

import java.util.Map;

import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.front.entity.TVisitInfoEntity;

public interface TVisitInfoService {

	//
	void save(TVisitInfoEntity t);
	//
	Pagemodal getListbyPage(Page page, Map<String, Object> map);
	//
	long getCount();
	//
	void remove(int pkId);
	//
	void removeAll(String ids);
}

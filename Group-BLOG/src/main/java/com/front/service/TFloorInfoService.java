package com.front.service;

import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.front.entity.TFloorInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:43
 */
public interface TFloorInfoService {

	//
	void save(TFloorInfoEntity tFloorInfo);
	//
	Pagemodal getListbyPage(Page page, Map<String, Object> map);
	//
	long getCount();
	//
	void remove(Map<String, Object> map);

}

package com.sys.service;

import java.util.Map;

import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;

public interface SysBaseService {

	//
	public Pagemodal getListbyPage(Page page,Map<String, Object> map);
	//
	
}

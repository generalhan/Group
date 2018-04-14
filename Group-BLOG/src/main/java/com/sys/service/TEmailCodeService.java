package com.sys.service;

import java.util.List;
import java.util.Map;

import com.sys.entity.TEmailCodeEntity;

public interface TEmailCodeService {

	    //用户是否存在
		boolean getEmailCodeEntity(Map<String, Object> map);
		//
		List<TEmailCodeEntity> getEmailCodeList(Map<String, Object> map);
		//
		void save(TEmailCodeEntity emailCode);
}

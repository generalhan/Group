package com.sys.service;

import java.util.List;
import java.util.Map;

import com.sys.entity.TEmailCodeEntity;

public interface TEmailCodeService {

	    //�û��Ƿ����
		boolean getEmailCodeEntity(Map<String, Object> map);
		//
		List<TEmailCodeEntity> getEmailCodeList(Map<String, Object> map);
		//
		void save(TEmailCodeEntity emailCode);
}

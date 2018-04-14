package com.front.service;

import java.util.List;

import com.common.datamodel.TBean;
import com.front.entity.TAlgotithmsInfoEntity;

public interface TAlgotithmsInfoService {
    //
	boolean save(TAlgotithmsInfoEntity tAlgotithmsInfo);
	//
	String getAlgotithmsInfoTBean();
	//
	String getAlgotithmsInfoBypkId(Long funcIndex);
	//
	void gettest();
}

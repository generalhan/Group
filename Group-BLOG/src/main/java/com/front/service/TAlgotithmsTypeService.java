package com.front.service;

import java.util.List;

import com.front.entity.TAlgotithmsTypeEntity;

public interface TAlgotithmsTypeService {

	 //
	boolean save(String algotithmsType, String gmtCreate);
	//
	List<TAlgotithmsTypeEntity> queryList();
}

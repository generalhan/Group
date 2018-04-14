package com.front.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.front.dao.TLinkInfoDao;
import com.front.entity.TLinkInfoEntity;
import com.front.service.TLinkInfoService;

@Service("tLinkInfoService")
public class TLinkInfoServiceImpl implements TLinkInfoService {

	@Resource
	private TLinkInfoDao tLinkInfoDao;
	
	public List<TLinkInfoEntity> getLinkData() {
		try {
			return tLinkInfoDao.getLinkData();
		} catch (Exception e) {
			return null;
		}
	}

}

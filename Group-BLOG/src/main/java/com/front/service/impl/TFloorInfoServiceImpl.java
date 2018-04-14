package com.front.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.pagehelper.Page;
import com.common.pagehelper.PageUtil;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.common.utils.DateUtil;
import com.front.dao.TFloorInfoDao;
import com.front.entity.TCommentInfoEntity;
import com.front.entity.TFloorInfoEntity;
import com.front.service.TFloorInfoService;

@Service
public class TFloorInfoServiceImpl implements TFloorInfoService {

	@Resource
	private TFloorInfoDao tFloorInfoDao;
	
	
	public void save(TFloorInfoEntity tFloorInfo) {
		try {
			 tFloorInfo.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		         tFloorInfo.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		         tFloorInfoDao.save(tFloorInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public Pagemodal getListbyPage(Page page, Map<String, Object> map) {
		try {		       			       
	        page=PageUtil.createPage(page, tFloorInfoDao.queryTotal(map).intValue());
	        map.put("beginIndex",page.getBeginIndex());
	        map.put("everyPage", page.getEveryPage());	
	        List<TFloorInfoEntity> pageList=tFloorInfoDao.queryList(map);
    return new pageListUtil().pageList(page, map, pageList);
} catch (Exception e) {
	return null;
}
	}


	public long getCount() {
		try {
			return tFloorInfoDao.queryTotal(new HashMap<String, Object>());
		} catch (Exception e) {
			return 0l;
		}
	}
	
	public void remove(Map<String, Object> map) {
		try {
			tFloorInfoDao.delete(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

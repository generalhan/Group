package com.front.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.pagehelper.Page;
import com.common.pagehelper.PageUtil;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.front.dao.TVisitInfoDao;
import com.front.entity.TFloorInfoEntity;
import com.front.entity.TVisitInfoEntity;
import com.front.service.TVisitInfoService;

@Service("tVisitInfoService")
public class TVisitInfoServiceImpl implements TVisitInfoService{

	@Resource
	private TVisitInfoDao tVisitInfoDao;
	
	public void save(TVisitInfoEntity t) {
		try {
			tVisitInfoDao.save(t);
		} catch (Exception e) {
			
		}
		
	}

	public Pagemodal getListbyPage(Page page, Map<String, Object> map) {
		try {		       			       
	        page=PageUtil.createPage(page, tVisitInfoDao.queryTotal(map).intValue());
	        map.put("beginIndex",page.getBeginIndex());
	        map.put("everyPage", page.getEveryPage());	
	        List<TVisitInfoEntity> pageList=tVisitInfoDao.queryList(map);
    return new pageListUtil().pageList(page, map, pageList);
} catch (Exception e) {
	return null;
}
	}

	public long getCount() {
		try {
			return tVisitInfoDao.queryTotal(new HashMap<String, Object>());
		} catch (Exception e) {
			return 0l;
		}
	}

	public void remove(int pkId) {
		try {
			tVisitInfoDao.delete(pkId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void removeAll(String ids) {
		try {
			List<Integer> list=new ArrayList<Integer>();
			for(String id: ids.split(",")){
				list.add(Integer.parseInt(id));
			}
			tVisitInfoDao.deleteBatch(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

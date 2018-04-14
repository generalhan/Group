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
import com.front.dao.TCommentInfoDao;
import com.front.dao.TFloorInfoDao;
import com.front.entity.TBlogInfoEntity;
import com.front.entity.TCommentInfoEntity;
import com.front.service.TCommentInfoService;

@Service
public class TCommentInfoServiceImpl implements TCommentInfoService{

	@Resource
	private TCommentInfoDao tCommentInfoDao;
	
	@Resource
	private TFloorInfoDao tFloorInfoDao;

	public void save(TCommentInfoEntity tCommentInfo) {
		try {
			commentObj(tCommentInfo);
			tCommentInfoDao.save(tCommentInfo);
		} catch (Exception e) {
			
		}
		
	}

	public Pagemodal getListbyPage(Page page, Map<String, Object> map) {
		try {		       			       
	        page=PageUtil.createPage(page, tCommentInfoDao.queryTotal(map).intValue());
	        map.put("beginIndex",page.getBeginIndex());
	        map.put("everyPage", page.getEveryPage());	
	        List<TCommentInfoEntity> pageList=tCommentInfoDao.queryList(map);
    return new pageListUtil().pageList(page, map, pageList);
} catch (Exception e) {
	return null;
}
	}

	public long getCount() {
		try {
			return tCommentInfoDao.queryTotal(new HashMap<String, Object>());
		} catch (Exception e) {
			return 0l;
		}
	}
	
	public void remove(Map<String, Object> map) {
		try {
			tFloorInfoDao.delete(map);
			tCommentInfoDao.delete(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private void commentObj(TCommentInfoEntity tCommentInfo) throws Exception {
		tCommentInfo.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		tCommentInfo.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
	}

	

}

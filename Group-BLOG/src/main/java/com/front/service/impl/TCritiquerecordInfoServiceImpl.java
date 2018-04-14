package com.front.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.utils.DateUtil;
import com.front.dao.TCritiquerecordInfoDao;
import com.front.entity.TCritiquerecordInfoEntity;
import com.front.service.TCritiquerecordInfoService;

@Service
public class TCritiquerecordInfoServiceImpl implements TCritiquerecordInfoService {

	@Resource
	private TCritiquerecordInfoDao tCritiquerecordInfoDao;
	
	public boolean addCritiqued(String visitIp, int blogId) {
		try {
			Map<String, Object> map=new HashMap<String, Object>();
		    map.put("visitIp", visitIp);
		    map.put("blogId", blogId);
		    if(tCritiquerecordInfoDao.queryObject(map)==null){
		    	saveCritiqued(visitIp, blogId);
		    	return false;
		    }
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	/**保存文章访问记录**/
	private void saveCritiqued(String visitIp, int blogId) throws Exception {
		TCritiquerecordInfoEntity t=new TCritiquerecordInfoEntity();
		t.setBlogId(blogId);
		t.setVisitIp(visitIp);
		t.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		t.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		tCritiquerecordInfoDao.save(t);
	}

}

package com.front.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.utils.DateUtil;
import com.front.dao.TAlgotithmsTypeDao;
import com.front.entity.TAlgotithmsTypeEntity;
import com.front.service.TAlgotithmsTypeService;

@Service
public class TAlgotithmsTypeServiceImpl implements TAlgotithmsTypeService {

	@Resource
	private TAlgotithmsTypeDao tAlgotithmsTypeDao;
	
	public boolean save(String algotithmsType, String gmtCreate) {
		  try {
			  Map<String, Object> map=new HashMap<String, Object>();
			     map.put("algotithmsType", algotithmsType);
			if(tAlgotithmsTypeDao.queryList(map).size()!=0){return false;}
				 TAlgotithmsTypeEntity tAlgotithmsType=new TAlgotithmsTypeEntity();
			     this.gmtDateHandle(gmtCreate, tAlgotithmsType);
			     tAlgotithmsType.setAlgotithmsType(algotithmsType);
			     tAlgotithmsTypeDao.save(tAlgotithmsType);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public List<TAlgotithmsTypeEntity> queryList() {
		Map<String, Object> map=null;
		    try {
		    	List<TAlgotithmsTypeEntity> list=tAlgotithmsTypeDao.queryList(map);
		    	return list;
		    } catch (Exception e) {
				return null;
			}	
	}

	private void gmtDateHandle(String gmtCreate,TAlgotithmsTypeEntity tAlgotithmsType){
		
		    	try {
		    		 if("".equals(gmtCreate)||gmtCreate==null){
		    			 tAlgotithmsType.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		    			 tAlgotithmsType.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		    		    }
		    		  else{
					     tAlgotithmsType.setGmtCreate(DateUtil.formatString(gmtCreate, "yyyy-MM-dd HH:mm"));
					     tAlgotithmsType.setGmtModified(DateUtil.formatString(gmtCreate, "yyyy-MM-dd HH:mm"));
		    		    } 
		    	}catch (Exception e) {
					e.printStackTrace();
				}
	}

}

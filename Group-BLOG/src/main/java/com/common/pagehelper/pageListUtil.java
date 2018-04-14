package com.common.pagehelper;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.sys.entity.BaseEntity;
import com.sys.entity.TUserEntity;

/**
 * 分页集合工具类
 * @author Administrator
 *
 */

public class pageListUtil {

/**
 * pagemodel公有基础参数设定
 * @param page
 * @param map 包含动态的sql中数据
 * @param clazz 得到的集合需要转型的实体
 * @return
 */
	public  Pagemodal pageList(Page page, Map<String, Object> map,  List<? extends BaseEntity> clazz) {
		try {	 
		       Pagemodal pm=new Pagemodal();
		       pm.setList(clazz);
		       pm.setPage(page);
	 return pm;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * ModelAndView公有基础参数设定
	 * @param currentPage 当前页
	 * @param mv 
	 * @param pg
	 * @param page
	 * @return
	 */
	public  ModelAndView pageModelList(long totalRecord, ModelAndView mv, Pagemodal pg,Page page) {		
		try {					 
			            List<? extends BaseEntity> TotalList= (List<? extends BaseEntity>) pg.getList();			          
			            mv.addObject("TotalList", TotalList);
			            mv.addObject("page", page);
			            mv.addObject("totalCurrentRecord",TotalList!=null?TotalList.size():0);
			            mv.addObject("totalRecord",totalRecord);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   return mv;
	}

	
}

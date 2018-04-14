package com.common.pagehelper;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.sys.entity.BaseEntity;
import com.sys.entity.TUserEntity;

/**
 * ��ҳ���Ϲ�����
 * @author Administrator
 *
 */

public class pageListUtil {

/**
 * pagemodel���л��������趨
 * @param page
 * @param map ������̬��sql������
 * @param clazz �õ��ļ�����Ҫת�͵�ʵ��
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
	 * ModelAndView���л��������趨
	 * @param currentPage ��ǰҳ
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

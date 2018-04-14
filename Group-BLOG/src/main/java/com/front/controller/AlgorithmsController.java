package com.front.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.common.datamodel.TBean;
import com.common.utils.R;
import com.front.entity.TAlgotithmsInfoEntity;
import com.front.entity.TAlgotithmsTypeEntity;
import com.front.service.TAlgotithmsInfoService;
import com.front.service.TAlgotithmsTypeService;


@Controller
@RequestMapping("/algorithms")
public class AlgorithmsController {
	@Resource
	private TAlgotithmsInfoService tAlgotithmsInfoService;
	
	@Resource
	private TAlgotithmsTypeService tAlgotithmsTypeService;
	
	/*@RequestMapping("test")
	@ResponseBody
	public R test(){
		tAlgotithmsInfoService.gettest();
		return R.ok();
	}*/
	
	/**
	 * ����
	 * @param al
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public  R AddAlgorithms(TAlgotithmsInfoEntity al){
		try {			
	     return	tAlgotithmsInfoService.save(al)==true?R.ok():R.fail();
		} catch (Exception e) {
			
	     return R.fail();
		}	
	}
	
	/**
	 * �㷨����ҳ��չʾ
	 * @return
	 */
	@RequestMapping("addView")
	public ModelAndView showAddView(){
		ModelAndView mv=null;
		try {
			List<TAlgotithmsTypeEntity> typeListTotal=tAlgotithmsTypeService.queryList();
			    mv=new ModelAndView();
			        mv.setViewName("sys/algotithmsInfo");
			        mv.addObject("typeListTotal",typeListTotal);			
		} catch (Exception e) {
			return null;
		}
		return mv;
	}
	
	/**
	 * �㷨ҳ��չʾ
	 * @return
	 */
	@RequestMapping("showView")
	public ModelAndView showAlgorithmsView(){
		ModelAndView mv=new ModelAndView();
		try {
			mv.setViewName("algorithms/algorithmsShow");			
	     List<TBean> bean = JSONArray
	                .parseArray(tAlgotithmsInfoService.getAlgotithmsInfoTBean(),TBean.class);
	     mv.addObject("AlgotithmsList",bean);
		} catch (Exception e) {
			return null;
		}
		return mv;
	}
	
	@RequestMapping("showAlgorithms")
	@ResponseBody
	public String showAlgorithmsBypkId(String funcIndex){
		try {
		return tAlgotithmsInfoService.getAlgotithmsInfoBypkId(Long.valueOf(funcIndex));
		} catch (Exception e) {
			return JSON.toJSONString("0");
		}
	}
}

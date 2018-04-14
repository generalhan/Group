package com.front.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.common.utils.R;
import com.front.entity.TAlgotithmsInfoEntity;
import com.front.service.TAlgotithmsInfoService;
import com.front.service.TAlgotithmsTypeService;


@Controller
@RequestMapping("/algorithmsType")
public class AlgorithmsTypeController {
	@Resource
	private TAlgotithmsTypeService tAlgotithmsTypeService;
	
	/**
	 * 增加算法类型
	 * @param algotithmsType
	 * @param gmtCreate
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public  R AddAlgorithmsType(String algotithmsType, String gmtCreate){
		try {
	     return	tAlgotithmsTypeService.save(algotithmsType, gmtCreate)==true?R.ok():R.fail();
		} catch (Exception e) {
			return R.fail();
		}	
	}
}

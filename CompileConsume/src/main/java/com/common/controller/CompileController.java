package com.common.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.common.algorithms.service.DynamicCompileService;

@Controller
@RequestMapping("/auxiliary")
public class CompileController {
	
	@Resource
	private DynamicCompileService dynamicCompileService;
	
	/**
	 * ¥˙¬Î±‡“Î
	 * @param code
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping("complie")
	public   @ResponseBody String show(String code){	
		try {
			synchronized (this) {
				String s=dynamicCompileService.getResult(code);
	  			 return JSON.toJSONString(s);
			}
		} catch (RuntimeException e) {		
			return JSON.toJSONString("error!");
		}
	}
}

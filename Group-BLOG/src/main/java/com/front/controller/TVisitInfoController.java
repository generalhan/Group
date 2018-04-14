package com.front.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.common.global.annotions.Constants;
import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.common.utils.R;
import com.front.service.TVisitInfoService;

@RestController
@RequestMapping("tvisitinfo")
public class TVisitInfoController {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private TVisitInfoService tVisitInfoService;
	
	/**
	 * 加载日志信息
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/showVisitInfoView/{currentPage}")
	public ModelAndView showVisitInfoView(@PathVariable  int currentPage){
		try {         
	           Pagemodal pg=tVisitInfoService.getListbyPage(new Page(currentPage,Constants.LOGGER_PAGE),new HashMap<String, Object>());
	               return new pageListUtil().pageModelList(tVisitInfoService.getCount(),new ModelAndView("sys/SysLoggerInfo"),pg,pg.getPage());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 单个删除日志
	 * @param pkId
	 * @return
	 */
	@RequestMapping("/removeVisitInfo")
	@ResponseBody
	public R removeVisitInfo(String pkId){
		try {
			synchronized (this) {
				tVisitInfoService.remove(Integer.parseInt(pkId));
				return R.ok();
			}
		} catch (Exception e) {
			logger.info("日志删除出现一个异常");
			return R.fail();
		}
	}
	
	@RequestMapping("/removeAll")
	@ResponseBody
	public R removeAll(String ids){
		try {
			synchronized (this) {
				tVisitInfoService.removeAll(ids);
				return R.ok();
			}
		} catch (Exception e) {
			logger.info("日志删除出现一个异常");
			return R.fail();
		}
	}
	
}

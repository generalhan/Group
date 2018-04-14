package com.front.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.common.indecorator.TMessageIndecorator;
import com.common.json.strategy.HttpObjectModel;
import com.common.utils.R;
import com.front.entity.TMessageInfoEntity;
import com.front.service.TMessageInfoService;
import com.sys.entity.TUserEntity;


/**
 * 留言版
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/message")
public class MessageInfoController {

	@Resource
	private TMessageInfoService tMessageInfoService;
	
	
	/**
	 * 显示所有留言类	
	 * @return
	 */
	@RequestMapping("showMsg")
	@ResponseBody 
	public String showAllmsg() {
		try {
			return JSON.toJSONString(tMessageInfoService.readAllMessage()==null?0:tMessageInfoService.readAllMessage());
		} catch (Exception e) {
			return JSON.toJSONString(0);
		}
	}
	
	/**
	 * 用户评论留言
	 * @param msg
	 * @param request
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping("addOnlyUserMessage")
	@ResponseBody
	public  R addOnlyMsg(TMessageInfoEntity msg,HttpServletRequest request) throws Exception{
		   try {
			   synchronized(this){
			   msg.setVisitorIp(request.getRemoteAddr());		    
				  tMessageInfoService.save(msg,false,null);		
				    return R.ok();	
			   }
		} catch (Exception e) {
			return R.fail();
		}
			
	}
	
	/**
	 * 用户回复留言
	 * @param tmsg
	 * @param request
	 * @return
	 */
	
	@RequestMapping("addReplyUserMessage")
	@ResponseBody
	public  R addReplyMsg(TMessageIndecorator tmsg,HttpServletRequest request){
		 try {
			   synchronized(this){
			   tmsg.setIp(request.getRemoteAddr());		    
				  tMessageInfoService.save(null, true, tmsg);		
				    return R.ok();	
			   }
		} catch (Exception e) {
			return R.fail();
		}
	}
	
}

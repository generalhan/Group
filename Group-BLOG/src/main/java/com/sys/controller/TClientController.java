package com.sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.terracotta.statistics.ConstantValueStatistic;

import com.common.global.annotions.Constants;
import com.common.utils.FastDFSUtil;
import com.common.utils.R;
import com.common.utils.UploadUtil;
import com.sys.entity.TUserEntity;
import com.sys.service.TUserService;



@Controller
@RequestMapping("/client")
public class TClientController {
	
	@Resource
	private TUserService tUserService;
	
	/***
	 * 修改用户个人信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public R upload(HttpServletRequest request,ModelMap model){ 
		synchronized (this) {
			/**获得当前shiro绑定的会话**/
			TUserEntity user=(TUserEntity) SecurityUtils.getSubject().getSession().getAttribute("CurrentUser");
			    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
			    Map<String, Object> map=null;
		try {	
			fastdfsImagesObj(user, multipartRequest,map);
		        return R.ok();
		} catch (Exception e) {
			try {				
			    localImagesObj(user, multipartRequest, map);
			 return R.ok();
			} catch (Exception e2) {
				return R.fail();
			}
		}
		}
	}

	

	/**
	 * 客户端展示页面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView showUserIndex(){
		return new ModelAndView("user/index");
	}
	
	@RequestMapping("/right")
	public ModelAndView showRightIndex(){
		return new ModelAndView("user/right");
	}
	
	@RequestMapping("/left")
	public ModelAndView showLeftIndex(){
		return new ModelAndView("user/left");
	}

	
	@RequestMapping("/top")
	public String showTopIndex(){
		return "user/top";
	}
	
	@RequestMapping("/bottom")
	public ModelAndView showBottomIndex(){
		return new ModelAndView("user/bottom");
	}
	
	@RequestMapping("/editHeader")
	public ModelAndView showEditHeaderIndex(){
		return new ModelAndView("user/datas/editHead");
	}
	
	/**上传到tomcat服务器**/
	private void localImagesObj(TUserEntity user, MultipartHttpServletRequest multipartRequest, Map<String, Object> map)
			throws Exception {
		/**本地服务器图片上传地址**/
		String url=UploadUtil.uploadFile(multipartRequest.getFile("files"), multipartRequest);
		/**更新头像**/
		map.put("userHeadimg", Constants.UPLOAD_PATH+url);		    
		tUserService.update(map);
		user.setUserHeadimg(Constants.UPLOAD_PATH+url);
		/**更新当前会话信息**/
		SecurityUtils.getSubject().getSession().setAttribute("CurrentUser", user);
	}

	/**上传到fasdfs服务器**/
	private void fastdfsImagesObj(TUserEntity user, MultipartHttpServletRequest multipartRequest,
		Map<String, Object> map){
		map=new HashMap<String, Object>();	
		/**个性签名是否修改了**/
		    if(!user.getUserPersonality().equals(multipartRequest.getParameter("userPersonality"))){map.put("userPersonality", multipartRequest.getParameter("userPersonality"));user.setUserPersonality(multipartRequest.getParameter("userPersonality"));}
		  /**真实姓名是否修改了**/ 
		    if(!user.getUserRealName().equals(multipartRequest.getParameter("userRealName"))){map.put("userRealName", multipartRequest.getParameter("userRealName"));user.setUserRealName( multipartRequest.getParameter("userRealName"));}
		        map.put("pkId", multipartRequest.getParameter("pkId"));
		        /**fastdfs图片地址**/
		             String urls=FastDFSUtil.uploadFile(multipartRequest.getFile("files"));
		             map.put("userHeadimg", urls);
		             tUserService.update(map);
		             /**更新会话**/
		             user.setUserHeadimg(urls);
		             SecurityUtils.getSubject().getSession().setAttribute("CurrentUser", user);
	}
	
}

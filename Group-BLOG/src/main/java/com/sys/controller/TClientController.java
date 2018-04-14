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
	 * �޸��û�������Ϣ
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public R upload(HttpServletRequest request,ModelMap model){ 
		synchronized (this) {
			/**��õ�ǰshiro�󶨵ĻỰ**/
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
	 * �ͻ���չʾҳ��
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
	
	/**�ϴ���tomcat������**/
	private void localImagesObj(TUserEntity user, MultipartHttpServletRequest multipartRequest, Map<String, Object> map)
			throws Exception {
		/**���ط�����ͼƬ�ϴ���ַ**/
		String url=UploadUtil.uploadFile(multipartRequest.getFile("files"), multipartRequest);
		/**����ͷ��**/
		map.put("userHeadimg", Constants.UPLOAD_PATH+url);		    
		tUserService.update(map);
		user.setUserHeadimg(Constants.UPLOAD_PATH+url);
		/**���µ�ǰ�Ự��Ϣ**/
		SecurityUtils.getSubject().getSession().setAttribute("CurrentUser", user);
	}

	/**�ϴ���fasdfs������**/
	private void fastdfsImagesObj(TUserEntity user, MultipartHttpServletRequest multipartRequest,
		Map<String, Object> map){
		map=new HashMap<String, Object>();	
		/**����ǩ���Ƿ��޸���**/
		    if(!user.getUserPersonality().equals(multipartRequest.getParameter("userPersonality"))){map.put("userPersonality", multipartRequest.getParameter("userPersonality"));user.setUserPersonality(multipartRequest.getParameter("userPersonality"));}
		  /**��ʵ�����Ƿ��޸���**/ 
		    if(!user.getUserRealName().equals(multipartRequest.getParameter("userRealName"))){map.put("userRealName", multipartRequest.getParameter("userRealName"));user.setUserRealName( multipartRequest.getParameter("userRealName"));}
		        map.put("pkId", multipartRequest.getParameter("pkId"));
		        /**fastdfsͼƬ��ַ**/
		             String urls=FastDFSUtil.uploadFile(multipartRequest.getFile("files"));
		             map.put("userHeadimg", urls);
		             tUserService.update(map);
		             /**���»Ự**/
		             user.setUserHeadimg(urls);
		             SecurityUtils.getSubject().getSession().setAttribute("CurrentUser", user);
	}
	
}

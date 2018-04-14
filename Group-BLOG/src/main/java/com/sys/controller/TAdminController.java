package com.sys.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.global.annotions.Constants;
import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.common.utils.R;
import com.front.entity.TBlogInfoEntity;
import com.front.service.TBlogInfoService;
import com.front.service.TCommentInfoService;
import com.front.service.TFloorInfoService;
import com.sys.entity.TUserEntity;
import com.sys.service.TRoleService;
import com.sys.service.TUserService;

@Controller
@RequestMapping("tadmin")
public class TAdminController {

   private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
	@Resource
	private TUserService tUserService;
	
	@Autowired
	private TRoleService tRoleService;
	
	@Autowired
	private TBlogInfoService tBlogInfoService;
	
	@Autowired
	private TCommentInfoService tCommentInfoService;
	
	@Autowired
	private TFloorInfoService tFloorInfoService;
	
	
	/**
	 * 权限加载
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/showAuthorizedView/{currentPage}")
	public ModelAndView showAuthorizedView(@PathVariable  int currentPage){
		try {         
	           Pagemodal pg=tRoleService.getListbyPage(new Page(currentPage,Constants.EVERY_PAGE),new HashMap<String, Object>());
	               return new pageListUtil().pageModelList(tUserService.getCount(),new ModelAndView("sys/SysAuthorized"),pg,pg.getPage());
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/updateAuthorized")
	@ResponseBody
	public R updateAuthorized(String role_id,String pkId){
		try {
			 synchronized (this) {
				Map<String, Object> map=new HashMap<String, Object>();
				    map.put("role_id", Integer.parseInt(role_id));
				    map.put("pkId", Integer.parseInt(pkId));
				    tRoleService.updateRole(map);
				    return R.ok().put("msg", "更新成功");
			 }
		} catch (Exception e) {
			logger.info("权限设置出现一个异常");
			return R.fail().put("msg", "更新失败");
		}		
	}
	
	/**
	 * 帖子加载
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/showBlogInfoView/{currentPage}")
	public ModelAndView showBlogInfoView(@PathVariable  int currentPage){
		try {        
			Pagemodal pg=tBlogInfoService.getListbyPage(new Page(currentPage,Constants.EVERY_PAGE),new HashMap<String, Object>());
			   return new pageListUtil().pageModelList(tBlogInfoService.getCount(),new ModelAndView("sys/SysBlogInfo"),pg,pg.getPage());			    
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/updateBlogState")
	@ResponseBody
	public R updateBlogState(String blogState,String pkId){
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			    map.put("pkId", pkId);
			    map.put("blogState", blogState);
			    tBlogInfoService.update(map);
			    return R.ok().put("msg", "更新成功");
		} catch (Exception e) {
			return R.fail().put("msg", "更新失败");
		}
	}
	
	@RequestMapping("/updateBlogInfo")
	@ResponseBody
	public R updateBlogInfo(TBlogInfoEntity blogInfo){
		try {
			Map<String, Object> map=new HashMap<String, Object>();
			    map.put("pkId", blogInfo.getPkId());
			    map.put("blogTitle", blogInfo.getBlogTitle());
			    map.put("blogContent", blogInfo.getBlogContent());
			    map.put("blogLable", blogInfo.getBlogLable());
			    tBlogInfoService.update(map);
			    return R.ok().put("msg", "更新成功");
		} catch (Exception e) {
			return R.fail().put("msg", "更新失败");
		}
	}
	
	@RequestMapping("/removeBlogInfo")
	@ResponseBody
	public R removeBlogInfo(String pkId){
		try {
			synchronized (this) {
				tBlogInfoService.remove(Integer.parseInt(pkId));
				return R.ok();
			}
		} catch (Exception e) {
			logger.info("帖子删除出现一个异常");
			return R.fail();
		}
	}
	
	/**
	 * 评论加载
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/showCommentInfoView/{currentPage}")
	public ModelAndView showCommentInfoView(@PathVariable  int currentPage){
		try {        
			Pagemodal pg=tCommentInfoService.getListbyPage(new Page(currentPage,Constants.EVERY_PAGE),new HashMap<String, Object>());
			   return new pageListUtil().pageModelList(tCommentInfoService.getCount(),new ModelAndView("sys/SysCommentInfo"),pg,pg.getPage());			    
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/removeCommentInfo")
	@ResponseBody
	public R removeCommentInfo(String pkId){
		try {
			synchronized (this) {
				Map<String, Object> map=new HashMap<String, Object>();
			    map.put("pkId", pkId);
			    map.put("commentId", pkId);
			    tCommentInfoService.remove(map);
				return R.ok();
			}
		} catch (Exception e) {
			logger.info("评论删除出现一个异常");
			return R.fail();
		}
	}
	
	/**
	 * 楼中楼
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/showFloorInfoView/{currentPage}")
	public ModelAndView showFloorInfoView(@PathVariable  int currentPage){
		try {        
			Pagemodal pg=tFloorInfoService.getListbyPage(new Page(currentPage,Constants.EVERY_PAGE),new HashMap<String, Object>());
			   return new pageListUtil().pageModelList(tFloorInfoService.getCount(),new ModelAndView("sys/SysFloorInfo"),pg,pg.getPage());			    
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/removeFloorInfo")
	@ResponseBody
	public R removeFloorInfo(String pkId){
		try {
			synchronized (this) {
				Map<String, Object> map=new HashMap<String, Object>();
			    map.put("pkId", pkId);
			    tFloorInfoService.remove(map);
				return R.ok();
			}
		} catch (Exception e) {
			logger.info("楼中楼删除出现一个异常");
			return R.fail();
		}
	}
	
	/**
	 * 黑名单设置
	 * @param pkId
	 * @param userState
	 * @return
	 */
	@RequestMapping("/defriend")
	@ResponseBody
	public R defriend(TUserEntity user){
		try {
			 synchronized (this) {
				 return updateObj(user);
			 }
		} catch (Exception e) {
			logger.info("黑名单设置出现一个异常");
			return R.fail().put("msg", "更新失败");
		}		
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	public R editInfo(TUserEntity user){
		try {
			synchronized (this) {
				return updateObj(user);
			}
		} catch (Exception e) {
			logger.info("用户信息修改出现一个异常");
			return R.fail().put("msg", "更新失败");
		}
	}
	
	/**
	 * 删除用户
	 * @param pkId
	 * @return
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public R remove(String pkId){
		try {
			synchronized (this) {
				tUserService.remove(Integer.parseInt(pkId));
				return R.ok();
			}
		} catch (Exception e) {
			logger.info("用户删除出现一个异常");
			return R.fail();
		}
	}

	/**修改参数设置**/
	private R updateObj(TUserEntity user) {
		Map<String, Object> map = userMapObj(user);
		   tUserService.update(map);
		   return R.ok().put("msg", "更新成功");
	}

	private Map<String, Object> userMapObj(TUserEntity user) {
		Map<String, Object> map=new HashMap<String, Object>();
		   map.put("pkId",user.getPkId());
		   if(user.getUserState()!=null){map.put("userState", user.getUserState());}
		   if(user.getUserRealName()!=null){map.put("userRealName", user.getUserRealName());}
		   if(user.getUserPersonality()!=null){map.put("userPersonality", user.getUserPersonality());}
		   return map;
	}
}

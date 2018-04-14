package com.front.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.common.global.annotions.Constants;
import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.common.utils.R;
import com.front.entity.TBlogInfoEntity;
import com.front.entity.TCommentInfoEntity;
import com.front.service.TBlogInfoService;
import com.front.service.TCommentInfoService;
import com.front.service.TCritiquerecordInfoService;
import com.front.service.TFloorInfoService;
import com.sys.entity.TUserEntity;






/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:44
 */
@RestController
@RequestMapping("tcommentinfo")
public class TCommentInfoController {
	
	@Autowired
	private TBlogInfoService tBlogInfoService;
	
	@Autowired
	private TCommentInfoService tCommentInfoService;
	
	@Autowired
	private TFloorInfoService tFloorInfoService;
	
	@Autowired
	private TCritiquerecordInfoService tCritiquerecordInfoService;
	
	/**
	 * es����ȫ��
	 * @param item
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("showEsSearch/{item}")
	public void esItemToBlogId(@PathVariable  String item,HttpServletResponse response) throws IOException{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("item", item);
		int fkBlogId=tBlogInfoService.getBlogInfo(map).getPkId();
		String root=Constants.REDIRECT_ROOT_PATH+Constants.ROOT_NAME+"/tcommentinfo/showAllCommentView/1/"+fkBlogId;
		response.sendRedirect(root);
	}
	
	/**
	 * ����ָ�����¼�������
	 * @param fkBlogId
	 * @return
	 */
	@RequestMapping("showAllCommentView/{currentPage}/{fkBlogId}")
	public ModelAndView showAllView(@PathVariable  int currentPage,@PathVariable  int fkBlogId,HttpServletRequest request){
		try {				
			synchronized (this) {
				Map<String,Object> map=new HashMap<String, Object>();
				ModelAndView mv=new ModelAndView("article/articleContent");
				map.put("pkId", fkBlogId);
				/**��������**/
				mv.addObject("blogInfo",tBlogInfoService.getBlogInfo(map));
				/**¥��¥����**/
				Map<String,Object> map1=new HashMap<String, Object>();
				map1.put("blogId", fkBlogId);
				Pagemodal pg=tFloorInfoService.getListbyPage(new Page(), map1);
				mv.addObject("Floor",pg.getList());
				/**���·�����**/
				if(!tCritiquerecordInfoService.addCritiqued(request.getRemoteAddr(), fkBlogId)){
					hasReaded(fkBlogId);
				}
			    return showCommentObj(currentPage, fkBlogId,mv, new HashMap<String, Object>());
			}
			} catch (Exception e) {
			return null;
		}
	}

	
	/**
	 * �������
	 * @param tCommentInfo
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public R saveComment(TCommentInfoEntity tCommentInfo){
		try {
			TUserEntity user=(TUserEntity) SecurityUtils.getSubject().getSession().getAttribute("CurrentUser");
			tCommentInfo.setUserName(user.getUserName());
			tCommentInfo.setImgUrl(user.getUserHeadimg());
			tCommentInfoService.save(tCommentInfo);
			return R.ok();
		} catch (Exception e) {
			return R.fail();
		}
	}
	
	/**չʾ������������**/
	private ModelAndView showCommentObj(int currentPage, int fkBlogId, ModelAndView mv, Map<String, Object> map) {
		 map.put("fkBlogId", fkBlogId);
		 /**�����������۷�ҳ����**/
		 Pagemodal pg=tCommentInfoService.getListbyPage(new Page(currentPage,Constants.EVERY_PAGE),map);
		  new pageListUtil().pageModelList(tCommentInfoService.getCount(),mv,pg,pg.getPage());
		return mv;
	}
	
	/**���·�����**/
	private void hasReaded(int fkBlogId) {
		Map<String, Object> maps=new HashMap<String, Object>();
		   maps.put("pkId",fkBlogId);
		   int hasRead=tBlogInfoService.getBlogInfo(maps).getVisitorHasread();
		   maps.put("visitorHasread",++hasRead);
		   tBlogInfoService.update(maps);
	}
	
}

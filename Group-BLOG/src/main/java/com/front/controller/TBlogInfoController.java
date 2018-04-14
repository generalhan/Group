package com.front.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import com.common.elasticsearch.EsUtil;
import com.common.global.annotions.Constants;
import com.common.indecorator.SearchModel;
import com.common.pagehelper.Page;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.Pages;
import com.common.pagehelper.pageListUtil;
import com.common.utils.R;
import com.front.entity.TBlogInfoEntity;
import com.front.service.TBlogInfoService;
import com.front.service.TCritiquerecordInfoService;
import com.sys.entity.TUserEntity;







/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-02-12 21:06:44
 */
@RestController
@RequestMapping("tbloginfo")
public class TBlogInfoController {
	@Autowired
	private TBlogInfoService tBlogInfoService;
	
	
	
    @RequestMapping("save")
    public R saveBlog(TBlogInfoEntity blogInfo){
    	try {
    		tBlogInfoService.save(blogInfo,(TUserEntity) SecurityUtils.getSubject().getSession().getAttribute("CurrentUser"));
    		 return R.ok();
		} catch (Exception e) {
			return R.fail();
		}
    }
    
    /**
     * 加载所有用户的帖子
     * @param currentPage
     * @return
     */
    @RequestMapping("showAllBlogView/{currentPage}")
	public ModelAndView showAllView(@PathVariable  int currentPage){
		try {        
			ModelAndView mv=new ModelAndView("article/articleList");
			/**置顶帖**/
			    mv.addObject("topBlog", tBlogInfoService.getListByStatus());
			    return blogsObj(currentPage, mv, new HashMap<String, Object>());
		} catch (Exception e) {
			return null;
		}
	}
	
    /**
     * 加载用户个人全部帖子
     * @param currentPage
     * @param fkUid
     * @return
     */
    @RequestMapping("showUserBlogView/{currentPage}/{fkUid}")
   	public ModelAndView showUserView(@PathVariable  int currentPage,@PathVariable  int fkUid){
   		try {        
   			ModelAndView mv=new ModelAndView("article/articleUserList");
   			mv.addObject("fkUid", fkUid);
   			 Map<String,Object> map=new HashMap<String, Object>();
   			   map.put("fkUid", fkUid);
   	            return blogsObj(currentPage, mv, map);
   		} catch (Exception e) {
   			return null;
   		}
   	}
    
    /**
     * 加载热门贴
     * @param currentPage
     * @return
     */
    @RequestMapping("showHotBlog")
	public ModelAndView showHotBlog(){
    	try {
    		ModelAndView mv=new ModelAndView();  
    		    mv.addObject("hotBlog", tBlogInfoService.getListHotBlog());
    		    mv.setViewName("portal/index");
    		    return mv;
		} catch (Exception e) {
			return null;
		}
    }
    /**
     * es搜索
     * @param key
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public String SearchArticle(@RequestParam("key")String key,@RequestParam("recordCount")String recordCount){
    	List<SearchModel> search = esSearch(key);
       return JSON.toJSONString(search);
    }

    
    @RequestMapping("/searchview")
    public ModelAndView SearchArticleView(@RequestParam(defaultValue="")String key){
    	 ModelAndView mv=new ModelAndView();
         mv.addObject("key",key);
         List<SearchModel> search = esSearch(key);
         mv.addObject("recordCount",search.size());
         mv.setViewName("article/search");
         return mv;
    }
    
	private List<SearchModel> esSearch(String key) {
		HashSet<String> set = new HashSet<String>();
		set.add("blogTitle");
		set.add("blogContent");
		Pages page = EsUtil.getDocHighLight(key, Constants.BLOG_SEARCH, set, 1, Constants.ES_MAX_PAGE, true);
		List<SearchModel> search=(List<SearchModel>) page.getRecordList();
		return search;
	}

	private ModelAndView blogsObj(int currentPage, ModelAndView mv, Map<String, Object> map) {
		Pagemodal pg=tBlogInfoService.getListbyPage(new Page(currentPage,Constants.EVERY_PAGE),map);
		   return new pageListUtil().pageModelList(tBlogInfoService.getCount(),mv,pg,pg.getPage());
	}
	
	private String changeToRightShow(String result){
		 result = result.replace("\"", "'");
		  return result;
	}
    
}

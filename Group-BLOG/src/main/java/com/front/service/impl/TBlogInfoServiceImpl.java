package com.front.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.elasticsearch.EsUtil;
import com.common.global.annotions.Constants;
import com.common.indecorator.SearchModel;
import com.common.pagehelper.Page;
import com.common.pagehelper.PageUtil;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.common.utils.DateUtil;
import com.common.utils.IDUtils;
import com.front.dao.TBlogInfoDao;
import com.front.dao.TCommentInfoDao;
import com.front.dao.TFloorInfoDao;
import com.front.entity.TBlogInfoEntity;
import com.front.service.TBlogInfoService;
import com.sys.dao.TUserDao;
import com.sys.entity.TUserEntity;

@Service
public class TBlogInfoServiceImpl implements TBlogInfoService {
	
	@Resource
	private TBlogInfoDao tBlogInfoDao;
	
	@Resource
	private TCommentInfoDao tCommentInfoDao;
	
	@Resource
	private TFloorInfoDao tFloorInfoDao;
	
	@Resource
	private TUserDao tUserDao;

	public void save(TBlogInfoEntity blogInfo,TUserEntity user) {		
		try {
			gmtObj(blogInfo);
			    blogInfo.setFkUid(user.getPkId());
			    blogInfo.setUserName(user.getUserName());
			    blogInfo.setImgUrl(user.getUserHeadimg());
			    blogInfo.setVisitorHasread(0);
			    blogInfo.setBlogState(Constants.STATUS_COMMON);
			    /**����������**/
			    String item=String.valueOf(IDUtils.genItemId());
			    blogInfo.setItem(item);
			    tBlogInfoDao.save(blogInfo);
			    /**������ݵ�es��**/
			    SearchModel search=new SearchModel();
			    search.setBlogTitle(blogInfo.getBlogTitle());
			    search.setBlogContent(blogInfo.getBlogContent());
			    search.setGmtCreate(blogInfo.getGmtCreate());
			    EsUtil.addDoc(Constants.BLOG_SEARCH, item, search);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Pagemodal getListbyPage(Page page, Map<String, Object> map) {
		try {		       			       
			        page=PageUtil.createPage(page, tBlogInfoDao.queryTotal(map).intValue());
			        map.put("beginIndex",page.getBeginIndex());
			        map.put("everyPage", page.getEveryPage());	
			        List<TBlogInfoEntity> pageList=tBlogInfoDao.queryAllList(map);
		    return new pageListUtil().pageList(page, map,subsBlog(pageList));
		} catch (Exception e) {
			return null;
		}
	}

	
	public long getCount(){
		try {
			return tBlogInfoDao.queryTotal(new HashMap<String, Object>());
		} catch (Exception e) {
			return 0l;
		}
		
	}
	
	public List<TBlogInfoEntity> getListByStatus() {
		try {
			List<Integer> status=new ArrayList<Integer>();
			     status.add(Constants.STATUS_TOP);
			     status.add(Constants.STATUS_TOP_HOT);
			     return tBlogInfoDao.getListByStatus(status);
				} catch (Exception e) {
			return null;
		}	
	}
	
	public TBlogInfoEntity getBlogInfo(Map<String, Object> map) {
		try {
			List<TBlogInfoEntity> blogList=tBlogInfoDao.queryAllList(map);
		      return blogList.size()==0?null:blogList.get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public void update(Map<String, Object> map) {
		try {
			tBlogInfoDao.update(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void remove(int pkId) {
		try {
			/**ɾ��es��������**/
			Map<String, Object> maps=new HashMap<String, Object>();
			maps.put("pkId", pkId);
			String item=getBlogInfo(maps).getItem();
			EsUtil.delDoc(Constants.BLOG_SEARCH, item);
			/**ɾ���������ݿ�**/
			Map<String, Object> map=new HashMap<String, Object>();
			    map.put("fkBlogId", pkId);
			    map.put("blogId", pkId);
			    tFloorInfoDao.delete(map);
			    tCommentInfoDao.delete(map);
			    tBlogInfoDao.delete(pkId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<TBlogInfoEntity> getListHotBlog() {
		try {
			List<TBlogInfoEntity> hotList=this.getListByStatus();
			    if(hotList==null)return null;			    
			    for(TBlogInfoEntity t:hotList){
			    	String temp=t.getBlogContent();
			    	if(temp.length()>Constants.HOT_BLOG_COUNT){
			    		t.setBlogContent(temp.substring(0, Constants.HOT_BLOG_COUNT));
			    	}
			    	replyCount(t);
	
			    }
			    return hotList;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/**ͳ�ƻظ���**/
	private void replyCount(TBlogInfoEntity t) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("fkBlogId", t.getPkId());
		map.put("blogId", t.getPkId());
		Long commentCount=tCommentInfoDao.queryTotal(map);
   Long floorCount=tFloorInfoDao.queryTotal(map);
   t.setId(commentCount.intValue()+floorCount.intValue());
	}

	
	
	/**���ڲ�������**/
	private void gmtObj(TBlogInfoEntity blogInfo) throws Exception {
		blogInfo.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		    blogInfo.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
	}

	
	private List<TBlogInfoEntity> subsBlog(List<TBlogInfoEntity> pageList) {
		List<TBlogInfoEntity> lists=new ArrayList<TBlogInfoEntity>();
		for(TBlogInfoEntity t:pageList){
			String s=t.getBlogContent().substring(0, 20);
			t.setBlogContent(s);
			lists.add(t);
		}
		return lists;
	}



}

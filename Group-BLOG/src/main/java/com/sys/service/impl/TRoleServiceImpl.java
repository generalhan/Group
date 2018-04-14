package com.sys.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.pagehelper.Page;
import com.common.pagehelper.PageUtil;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.sys.dao.TRoleDao;
import com.sys.dao.TUserDao;
import com.sys.entity.TRoleEntity;
import com.sys.entity.TUserEntity;
import com.sys.service.TRoleService;

@Service
public class TRoleServiceImpl implements TRoleService {

	/**读写锁**/
	private ReadWriteLock rwLock=new ReentrantReadWriteLock();
	
	@Autowired
	private TRoleDao tRoleDao;
	
	@Resource
	private TUserDao tUserDao;
	
	public Set<TRoleEntity> findRoles(String userName) {
		try {
			Set<TRoleEntity> roles=tRoleDao.findRoles(userName);
			  return roles.isEmpty()?null:roles;
		} catch (Exception e) {			
			return null;
		}
	}

	public Pagemodal getListbyPage(Page page, Map<String, Object> map) {
		try {
		     rwLock.readLock().lock();		       			       
			        page=PageUtil.createPage(page, tUserDao.queryTotal(map).intValue());
			        map.put("beginIndex",page.getBeginIndex());
			        map.put("everyPage", page.getEveryPage());
			        List<TUserEntity> pageList=tUserDao.queryList(map);			 
			        setRoles(pageList);
			        return new pageListUtil().pageList(page, map, pageList);
		} catch (Exception e) {
			return null;
		}finally{
			rwLock.readLock().unlock();
		}      	 		
	}
	
	public void updateRole(Map<String, Object> map) {
		try {
			tRoleDao.updateRolesOfUser(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**用户与角色对应关系**/
	private void setRoles(List<TUserEntity> pageList){
		for(TUserEntity t:pageList){
		  Set<TRoleEntity> set=findRoles(t.getUserName());
		    Iterator<TRoleEntity> it=set.iterator();
		      while(it.hasNext()){
			     TRoleEntity tt=it.next();
			       t.setRoleDescription(tt.getRoleDescription());
			       t.setId(tt.getPkId());
		      }    
		}
	}

	

}

package com.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.global.annotions.Constants;
import com.common.pagehelper.Page;
import com.common.pagehelper.PageUtil;
import com.common.pagehelper.Pagemodal;
import com.common.pagehelper.pageListUtil;
import com.common.utils.DateUtil;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.jndi.toolkit.url.Uri;
import com.sys.dao.TUserDao;
import com.sys.dao.TUserRoleDao;
import com.sys.entity.BaseEntity;
import com.sys.entity.TUserEntity;
import com.sys.entity.TUserRoleEntity;
import com.sys.service.TUserService;

@Service("tUserService")
public class TUserServiceImpl implements TUserService<TUserEntity> {
	/**��д��**/
	private ReadWriteLock rwLock=new ReentrantReadWriteLock(); 
	
	@Resource
	private TUserDao tUserDao;
	
	@Resource
	private TUserRoleDao tUserRoleDao;

	  /**�õ������û���Ϣ**/
	public Pagemodal getListbyPage(Page page, Map<String, Object> map) {
		try {
		     rwLock.readLock().lock();		       			       
			        page=PageUtil.createPage(page, tUserDao.queryTotal(map).intValue());
			        map.put("beginIndex",page.getBeginIndex());
			        map.put("everyPage", page.getEveryPage());	
			        List<TUserEntity> pageList=tUserDao.queryList(map);	
		    return new pageListUtil().pageList(page, map, pageList);
		} catch (Exception e) {
			return null;
		}finally{
			rwLock.readLock().unlock();
		}      	 		
	}

	public boolean getUserEntity(Map<String, Object> map) {
		try {
			rwLock.readLock().lock();
			return tUserDao.queryList(map).size()==0?false:true;
		} catch (Exception e) {
			return false;
		}finally{
			rwLock.readLock().unlock();
		}
	}

	public void save(TUserEntity user) {
		try {
			rwLock.writeLock().lock();
			   user.setUserHeadimg(Constants.DEFAULT_HEAD_IMG);
			   user.setUserState(0);
			   userGmt(user);
			       tUserDao.save(user);//�����û�
			       getUserVObyname(user);//�����û�Ȩ��			     
		} catch (Exception e) {
			
		}finally{
			rwLock.writeLock().unlock();
		}
		
	}

	
	
	public void update(Map<String, Object> map) {
		try {
			rwLock.writeLock().lock();
			   tUserDao.update(map);
		} catch (Exception e) {
			
		}finally{
			rwLock.writeLock().unlock();
		}
		
	}
	
	public void remove(int pkId){
		try {
			tUserDao.delete(pkId);
		} catch (Exception e) {
			
		}
	}
	
	public TUserEntity getTUserEntity(Map<String, Object> map) {
		try {
			rwLock.readLock().lock();
			List<TUserEntity> t=tUserDao.queryList(map);
			     return t.size()==0?null:(TUserEntity)t.get(0);
		} catch (Exception e) {
			return null;
		}finally{
			rwLock.readLock().unlock();
		}
	}
	
	public long getCount(){
		try {
			return tUserDao.queryTotal(null);
		} catch (Exception e) {
			return 0l;
		}
		
	}

	/**��������**/
	private void userGmt(TUserEntity user) throws Exception {
		user.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		 user.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
	}

	/**ע���û��ɹ���Ȩ��Ϊ��ͨ�û�������Ϊ�ο�**/
	private void getUserVObyname(TUserEntity user) {
		Map<String, Object> map=new HashMap<String, Object>();
		     map.put("userName",user.getUserName());
		        List<TUserEntity> list=tUserDao.queryList(map);
		             TUserEntity t=list.size()!=0?list.get(0):null;
		     if(t!=null){
		    	 tUserRoleDao.save(new TUserRoleEntity(t.getPkId(),Constants.AUTHORITY_USER));
		    	 }
		     else{
		    	 tUserRoleDao.save(new TUserRoleEntity(t.getPkId(),Constants.AUTHORITY_VISITOR));
		     }
	}

	

	

}

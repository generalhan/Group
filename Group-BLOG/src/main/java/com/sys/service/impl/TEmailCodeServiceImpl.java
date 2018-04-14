package com.sys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.common.utils.DateUtil;
import com.sys.dao.TEmailCodeDao;
import com.sys.entity.TEmailCodeEntity;
import com.sys.service.TEmailCodeService;

@Service
public class TEmailCodeServiceImpl implements TEmailCodeService {

	/**∂¡–¥À¯**/
	private ReadWriteLock rwLock=new ReentrantReadWriteLock(); 
	
	@Resource
	private  TEmailCodeDao tEmailCodeDao;
	
	public boolean getEmailCodeEntity(Map<String, Object> map) {
		try {
			rwLock.readLock().lock();
			return tEmailCodeDao.queryList(map).size()==0?false:true;
		} catch (Exception e) {
			return false;
		}finally{
			rwLock.readLock().unlock();
		}
	}

	public List<TEmailCodeEntity> getEmailCodeList(Map<String, Object> map) {
		try {
			rwLock.readLock().lock();
			return tEmailCodeDao.queryList(map).size()==0?null:tEmailCodeDao.queryList(map);
		} catch (Exception e) {
			return null;
		}finally{
			rwLock.readLock().unlock();
		}
	}

	public void save(TEmailCodeEntity emailCode) {
		try {
			rwLock.writeLock().lock();
			 setGmt(emailCode);
			 tEmailCodeDao.save(emailCode);
		} catch (Exception e) {
		 
		}finally{
			rwLock.writeLock().unlock();
		}
		
	}

	/**…Ë÷√»’∆⁄**/
	private void setGmt(TEmailCodeEntity emailCode) throws Exception {
		emailCode.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		 emailCode.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
	}

}

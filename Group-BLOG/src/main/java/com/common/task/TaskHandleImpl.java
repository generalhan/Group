package com.common.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.front.dao.TCritiquerecordInfoDao;


@Component
public class TaskHandleImpl implements TaskHandle {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());

	@Resource
	private TCritiquerecordInfoDao tCritiquerecordInfoDao;
	
	
	 @Scheduled(cron="0 30 2 * * ? ")   //每天凌晨2点半删除访问记录
	public void deleteCritiqueHandle() {
		 logger.info("定时任务开始......");
         long begin = System.currentTimeMillis();
     
         //执行数据库操作
         tCritiquerecordInfoDao.delete(null);
     
         long end = System.currentTimeMillis();
         logger.info("定时任务结束，共耗时：[" + (end-begin) / 1000 + "]秒");
	}

}

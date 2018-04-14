package com.common.task;

/**
 * 定时处理数据
 * @author zwl
 *
 */
public interface TaskHandle {

	//删除访问帖子的访问量记录器的所有数据库记录
	public void deleteCritiqueHandle();
	
}

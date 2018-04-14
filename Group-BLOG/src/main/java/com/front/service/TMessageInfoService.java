package com.front.service;



import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.common.indecorator.TMessageIndecorator;
import com.front.entity.TMessageInfoEntity;

/**
 * 
 * 
 * @author zwl
 * @email ${email}
 * @date 2018-01-31 16:00:30
 */
public interface TMessageInfoService {
	
	//
	boolean save(TMessageInfoEntity tMessageInfo,boolean isChild,Object obj);
	//
	List<Stack<TMessageIndecorator>> readAllMessage();
	
	
}

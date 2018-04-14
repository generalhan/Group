package com.common.json.strategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author zwl
 *
 */
public interface Strategy {
	
//处理不同形式的json
public Object JsonDeal(Object object);

}

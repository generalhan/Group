package com.common.json.strategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author zwl
 *
 */
public interface Strategy {
	
//����ͬ��ʽ��json
public Object JsonDeal(Object object);

}

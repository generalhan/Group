package com.common.json.strategy;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
/**
 * JSON²ßÂÔ
 * @author zwl
 *
 */
public class BaseJsonStrategy implements Strategy {

	public Object JsonDeal(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().setContentType("text/html;charset=utf-8");
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().getWriter().write(json);
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().getWriter().flush();
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

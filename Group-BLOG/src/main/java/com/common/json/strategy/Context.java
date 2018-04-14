package com.common.json.strategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���Ե���ģ��
 * @author zwl
 *
 */


public class Context {

	private Strategy strategy;
	private Object object;
	private HttpObjectModel Http;
	
	public Context(Strategy strategy,Object object){
		this.strategy=strategy;
		this.object=object;
	}
	

	
	public void DealJson(){
		this.strategy.JsonDeal(object);
	}
}

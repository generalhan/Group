package com.common.json.strategy;

import java.io.Serializable;
/**
 * 
 * @author zwl
 *
 */
public class BaseJsonManager implements Serializable{

	/**
	 * 返回前台基本json信息
	 * @param successMsg
	 * @param errorMsg
	 * @param obj
	 * @param tempFlag
	 * @param BaseStrategy
	 * @throws Exception
	 */
	public void IsJson(String successMsg,String errorMsg,Object obj,boolean tempFlag, Strategy BaseStrategy) throws Exception{
		BaseJsonObjectModel json=new BaseJsonObjectModel(successMsg, true, obj);
		 Strategy strategy=BaseStrategy;
		   Context context=new Context(strategy, json);
		      if(tempFlag){
		    	  context.DealJson();		
		        }
		      else{
		    	json.setMsg(errorMsg);
		    	json.setSuccess(false);
		    	context.DealJson();
		      }
	}
	
}

package com.common.json.strategy;


public class BaseJsonObjectModel implements java.io.Serializable{

	/**
	 * 基础数据包装
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean success = false;

	private String msg = "";

	private Object obj = null;
	
	public BaseJsonObjectModel(){
		
	}
	
	public BaseJsonObjectModel(String msg,boolean success,Object obj)
	{
		this.msg=msg;
		this.obj=obj;
		this.success=success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}

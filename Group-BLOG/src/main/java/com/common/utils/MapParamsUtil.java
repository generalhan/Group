package com.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态添加map工具类
 * @author Administrator
 *
 */
public class MapParamsUtil extends HashMap<String, Object> {

	//key-value相同
	private Object[] values;
	//强制为[][2]形式数组，并且第一列为key，第二列为value
	private Object[][] keyValues;
	
	public MapParamsUtil(){}
	
	public MapParamsUtil(Object[][] keyValues){
		this.keyValues=keyValues;
	}
	
	public Map setKeyandValues(){
		Map<String, Object> map=new HashMap<String, Object>();
		    for(int i=0;i<keyValues.length;i++){
		    	map.put((String) keyValues[i][0], keyValues[i][1]);
		    }
		    	return map;
	}
	
}

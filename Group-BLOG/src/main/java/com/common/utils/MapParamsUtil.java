package com.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬���map������
 * @author Administrator
 *
 */
public class MapParamsUtil extends HashMap<String, Object> {

	//key-value��ͬ
	private Object[] values;
	//ǿ��Ϊ[][2]��ʽ���飬���ҵ�һ��Ϊkey���ڶ���Ϊvalue
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

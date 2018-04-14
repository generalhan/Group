package com.common.characterFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

/**
 * 根据索引处理加密解密工厂类
 * @author zwl
 *
 */
@Service
public class CharacterTempleFactory {
  

	private String flag;  //加密源的索引号
    private String path;  //要反射的类路径


    
    
    public  String getCharacter(String strTarget){
    	try {
    		return getByMethod(strTarget);
		} catch (Exception e) {
			return null;
		}
    }
    
    //根据索引得到加密解密后的字符
    private  String getByMethod(String strTarget){
    	try {
    		Class c=Class.forName(path);
		    Object o=c.newInstance();
		        Method[] methods=c.getMethods();
		        for(Method m:methods){
			if(m.getName().equals(CharacterSimpleFactory.getChar(flag)))
				return (String) m.invoke(null, new Object[]{strTarget});	
			}
			return null;
		} catch (Exception e) {
			return null;
		}
    							
    }
    
    
    public String getFlag() {
  		return flag;
  	}

  	public void setFlag(String flag) {
  		this.flag = flag;
  	}

  	public String getPath() {
  		return path;
  	}

  	public void setPath(String path) {
  		this.path = path;
  	}
	
}

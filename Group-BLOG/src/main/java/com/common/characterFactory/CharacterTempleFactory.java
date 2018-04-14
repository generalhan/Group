package com.common.characterFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

/**
 * ��������������ܽ��ܹ�����
 * @author zwl
 *
 */
@Service
public class CharacterTempleFactory {
  

	private String flag;  //����Դ��������
    private String path;  //Ҫ�������·��


    
    
    public  String getCharacter(String strTarget){
    	try {
    		return getByMethod(strTarget);
		} catch (Exception e) {
			return null;
		}
    }
    
    //���������õ����ܽ��ܺ���ַ�
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

package com.common.characterFactory;

/**
 * 加密解密简单工厂选择类
 * @author zwl
 *
 */
public class CharacterSimpleFactory {

	public static String getChar(String flag){
		try {
			int flagTonum=Integer.parseInt(flag);
			switch (Integer.parseInt(flag)) {
			case 0:  
				return CharacterSource.Base64StrKey.toString();
			case 1:  
				return CharacterSource.Base64GetStrKey.toString();
			case 2:  
				return CharacterSource.HexStrKey.toString();
			case 3:  
				return CharacterSource.HexGetStrKey.toString();
			case 4:  
				return CharacterSource.toBytes.toString();
			case 5:  
				return CharacterSource.ToString.toString();
			case 6:  
				return CharacterSource.AesCipherStrKey.toString();
			case 7:  
				return CharacterSource.AesCipherGetStrKey.toString();
			case 8:  
				return CharacterSource.strKey.toString();
			case 9:  
				return CharacterSource.getstrKey.toString();
			default:
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		
	}
	
}

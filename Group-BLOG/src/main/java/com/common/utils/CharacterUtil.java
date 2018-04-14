package com.common.utils;

import java.security.Key;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.BlowfishCipherService;

/**
 * 加密与解密工具包
 * 
 *
 */
public class CharacterUtil {

	private static String salt="zwl"; //加密盐值
	
	private static AesCipherService aesCipherService=null;
	
	private static Key Aeskey; //公钥
	
	private static BlowfishCipherService blowfishCipherService;
	
	private static Key BlowKey;
	
	private static DesUtils des; //自定义的加密与解密类
	
	static{
		try {
			aesCipherService = new AesCipherService();
		      aesCipherService.setKeySize(128);//设置key长度		      
		        Aeskey = aesCipherService.generateNewKey();//生成key
		         blowfishCipherService = new BlowfishCipherService();
		           blowfishCipherService.setKeySize(128);
		         BlowKey = blowfishCipherService.generateNewKey();
		       des = new DesUtils(salt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Base64加密
	public static String Base64StrKey(String str){
		
		return Base64.encodeToString(str.getBytes());
	}
	
	//Base64解密
	public static String Base64GetStrKey(String str){
		return Base64.decodeToString(str);
	}
	
	//16进制字符串编码
	public static String HexStrKey(String str){
		return Hex.encodeToString(str.getBytes());
	}
	
	//16进制字符串解码
	public static String HexGetStrKey(String str){
		return new String(Hex.decode(str.getBytes()));
	}
	
	//变成byte数组
	public static byte[] toBytes(String str){
		return CodecSupport.toBytes(str, "utf-8"); 
	}
	
	//变成String
	public static String ToString(byte[] str){
		return CodecSupport.toString(str, "utf-8");
	}
	
	//AES算法加密
	public static String AesCipherStrKey(String str){
		return aesCipherService.encrypt(str.getBytes(), Aeskey.getEncoded()).toHex();
	}
	
	//AES算法解密
	public static String AesCipherGetStrKey(String str){
		return new String(aesCipherService.decrypt(Hex.decode(str), Aeskey.getEncoded()).getBytes());
	}
	
	//Blowfish算法加密
	public static String BlowCipherStrKey(String str){
		return blowfishCipherService.encrypt(str.getBytes(), BlowKey.getEncoded()).toHex();
	}
	
	//Blowfish算法解密
	public static String BlowCipherStrGetKey(String str){
		return new String(blowfishCipherService.decrypt(Hex.decode(str), BlowKey.getEncoded()).getBytes());
	}
	
	 //自定义加密类的加密
	public static String strKey(String str) throws Exception{
			 return des.encrypt(str);
		}
		
	//自定义加密类的解密
	public static String getstrKey(String str) throws Exception{
			 return des.decrypt((str));
		}
}

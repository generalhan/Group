package com.common.utils;

import java.security.Key;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.BlowfishCipherService;

/**
 * ��������ܹ��߰�
 * 
 *
 */
public class CharacterUtil {

	private static String salt="zwl"; //������ֵ
	
	private static AesCipherService aesCipherService=null;
	
	private static Key Aeskey; //��Կ
	
	private static BlowfishCipherService blowfishCipherService;
	
	private static Key BlowKey;
	
	private static DesUtils des; //�Զ���ļ����������
	
	static{
		try {
			aesCipherService = new AesCipherService();
		      aesCipherService.setKeySize(128);//����key����		      
		        Aeskey = aesCipherService.generateNewKey();//����key
		         blowfishCipherService = new BlowfishCipherService();
		           blowfishCipherService.setKeySize(128);
		         BlowKey = blowfishCipherService.generateNewKey();
		       des = new DesUtils(salt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Base64����
	public static String Base64StrKey(String str){
		
		return Base64.encodeToString(str.getBytes());
	}
	
	//Base64����
	public static String Base64GetStrKey(String str){
		return Base64.decodeToString(str);
	}
	
	//16�����ַ�������
	public static String HexStrKey(String str){
		return Hex.encodeToString(str.getBytes());
	}
	
	//16�����ַ�������
	public static String HexGetStrKey(String str){
		return new String(Hex.decode(str.getBytes()));
	}
	
	//���byte����
	public static byte[] toBytes(String str){
		return CodecSupport.toBytes(str, "utf-8"); 
	}
	
	//���String
	public static String ToString(byte[] str){
		return CodecSupport.toString(str, "utf-8");
	}
	
	//AES�㷨����
	public static String AesCipherStrKey(String str){
		return aesCipherService.encrypt(str.getBytes(), Aeskey.getEncoded()).toHex();
	}
	
	//AES�㷨����
	public static String AesCipherGetStrKey(String str){
		return new String(aesCipherService.decrypt(Hex.decode(str), Aeskey.getEncoded()).getBytes());
	}
	
	//Blowfish�㷨����
	public static String BlowCipherStrKey(String str){
		return blowfishCipherService.encrypt(str.getBytes(), BlowKey.getEncoded()).toHex();
	}
	
	//Blowfish�㷨����
	public static String BlowCipherStrGetKey(String str){
		return new String(blowfishCipherService.decrypt(Hex.decode(str), BlowKey.getEncoded()).getBytes());
	}
	
	 //�Զ��������ļ���
	public static String strKey(String str) throws Exception{
			 return des.encrypt(str);
		}
		
	//�Զ��������Ľ���
	public static String getstrKey(String str) throws Exception{
			 return des.decrypt((str));
		}
}

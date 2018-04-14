package com.utilsTest;

import java.lang.reflect.Method;

import org.junit.Test;

import com.common.utils.CharacterUtil;

import redis.clients.jedis.Jedis;

public class utilTest {

	public void testCh1()throws Exception{
		long a=151764663969500l;
		long b=151764663969500l;
		System.out.println(a==b);
	}
   

	public void testCh12()throws Exception{
		Jedis redis=new Jedis("116.196.117.113", 6800);
		//��������
		//redis.set("zwl", "hello world");
		//��ȡ���ݣ���ʱ�Ѿ���linux�ͻ��������˼�name��ֵ
		//System.out.println(redis.get("zwl"));
		System.out.println(redis.lrange("REDIS_ALGORITHMS_LIST_KEY", 0,-1).size());
		System.out.println(redis.get("REDIS_ALGORITHMS_LIST_TBEAN"));
		//System.out.println(redis.get("name"));
		//�ͷ���Դ
		redis.close();
	}
	public void testCh()throws Exception{
		/*//����ip�Ķ˿ںţ��Ѿ�����linux��redisԶ������
		Jedis redis=new Jedis("111.230.246.33", 6379);
		//��������
		redis.set("zwl", "hello world");
		//��ȡ���ݣ���ʱ�Ѿ���linux�ͻ��������˼�name��ֵ
		System.out.println(redis.get("zwl"));
		System.out.println(redis.get("name"));
		//�ͷ���Դ
		redis.close();*/
		//String ch=CharacterUtil.AesCipherStrKey(str)
	String str="com.common.utils.CharacterUtil";
		String s=CharacterUtil.strKey("nav");
		System.out.println(s);
		/*String p=CharacterUtil.AesCipherGetStrKey("YWRtaW4=");
		System.out.println(p);*/
		/*Class c=Class.forName(str);
		Object o=c.newInstance();
		Method[] methods=c.getMethods();
		for(Method m:methods){
			if(m.getName().equals("HexGetStrKey")){
			Object s= m.invoke(null, new Object[]{"HexGetStrKey"});
	
			System.out.println(s);
			}
			
		}*/
	}
	
}

package com.utilsTest;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.common.elasticsearch.EsUtil;
import com.common.pagehelper.Pages;
import com.google.gson.JsonObject;
import com.sys.entity.BaseEntity;
import com.sys.entity.TRoleEntity;


public class MyTest {


 public void save()throws Exception{
	 BaseEntity b=new BaseEntity();
	 b.setRoleDescription("name");
	 EsUtil.addDoc("java", 1, b);
	 
 }
 

 public void del()throws Exception{
	 EsUtil.delDoc("java", 1);
 }
	

	public void testgetone() throws Exception {
		HashSet<String> set = new HashSet<String>();
		set.add("roleDescription");
		Pages page = EsUtil.getDocHighLight("name", "java", set, 1, 10, true);
		System.out.println(page.getRecordList());
		System.out.println(page.getRecordList().toString());
	}

	// ��������

	public void testget() throws Exception {
		final HashSet<String> set = new HashSet<String>();
		set.add("name");

		ExecutorService pool = Executors.newFixedThreadPool(8);
		for (int i = 0; i < 500; i++) {
			pool.execute(new Runnable() {
				public void run() {
					Pages page = EsUtil.getDocHighLight("��", "user", set, 1, 10, true);
					System.err.println("�����ɹ�����Ϊ:" + page.getRecordCount());
				}
			});
		}
		pool.shutdown();
		while (!pool.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
			System.out.println("ִ�г�ʱ������������");
			pool.shutdownNow();
		}
	}


	public void testreindex() throws Exception {
		EsUtil.reindex();
	}
}
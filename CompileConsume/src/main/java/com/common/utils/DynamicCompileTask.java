package com.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;


/**
 * �߳�����
 * @author Administrator
 *
 */
public class DynamicCompileTask implements Runnable{

	 private CountDownLatch countDownLatch;  //�̼߳�����
	 private Lock lock=new ReentrantLock();  
	 
	 private static DynamicCompileTask instance = new DynamicCompileTask();
	 private DynamicCompileTask(){}//˽�л����췽��
	 public static DynamicCompileTask getInstance()
	 {
	 return instance;
	 }
	 

	
	public void run() {
		try {
			synchronized (this) { 
	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}

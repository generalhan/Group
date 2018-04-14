package com.common.algorithms.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.algorithms.service.DynamicCompileService;

public class DynamicCompileServiceImpl implements DynamicCompileService{
private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
	private Lock lock=new ReentrantLock();  
	
	public String getResult(String originStr){
		//类级别同步控制
		lock.lock();
        // 1.创建需要动态编译的代码字符串
        String nr = "\r\n"; //回车
        String source = "package temp.com; " + nr +
               originStr;
        // 2.将欲动态编译的代码写入文件中 1.创建临时目录 2.写入临时文件目录
        File dir = new File(System.getProperty("user.dir") + "/temp"); //临时目录
        // 如果 \temp 不存在 就创建
        if (!dir.exists()) {
            dir.mkdir();
        }
        System.out.println(dir);
        FileWriter writer;
		try {
			writer = new FileWriter(new File(dir,"Main.java"));
			  writer.write(source);
		        writer.flush();
		        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        
        // 3.取得当前系统的编译器
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        // 4.获取一个文件管理器
        StandardJavaFileManager javaFileManager = javaCompiler.getStandardFileManager(null, null, null);
        // 5.文件管理器根与文件连接起来
        Iterable it = javaFileManager.getJavaFileObjects(new File(dir,"Main.java"));
        // 6.创建编译任务
        CompilationTask task = javaCompiler.getTask(null, javaFileManager, null, Arrays.asList("-d", "./temp"), null, it);
        boolean k=false;
        Exception ee=new RuntimeException();        
        try {
        	   // 7.执行编译
            k=task.call();
            if(!k)
            	return "sorry ! your code has some problems,please check!";
			
        // 8.运行程序
        Runtime run = Runtime.getRuntime();     
        Process process=null;
		try {
			try {
				process = run.exec("java -cp ./temp temp/com/Main");
			} catch (Exception e) {
				e.printStackTrace();
			}			
			  InputStream in = process.getInputStream();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		        String info  = "";
		        StringBuilder sb=new StringBuilder();
		        try {
					while ((info = reader.readLine()) != null) {
					    sb.append(info+"<br/>");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println(sb.toString());
		            return sb.toString();
		}catch(RuntimeException e){	
			return "err";
		}
        }finally{
        	lock.unlock();
        }
		
		}
}

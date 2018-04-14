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
		//�༶��ͬ������
		lock.lock();
        // 1.������Ҫ��̬����Ĵ����ַ���
        String nr = "\r\n"; //�س�
        String source = "package temp.com; " + nr +
               originStr;
        // 2.������̬����Ĵ���д���ļ��� 1.������ʱĿ¼ 2.д����ʱ�ļ�Ŀ¼
        File dir = new File(System.getProperty("user.dir") + "/temp"); //��ʱĿ¼
        // ��� \temp ������ �ʹ���
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
      
        
        // 3.ȡ�õ�ǰϵͳ�ı�����
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        // 4.��ȡһ���ļ�������
        StandardJavaFileManager javaFileManager = javaCompiler.getStandardFileManager(null, null, null);
        // 5.�ļ������������ļ���������
        Iterable it = javaFileManager.getJavaFileObjects(new File(dir,"Main.java"));
        // 6.������������
        CompilationTask task = javaCompiler.getTask(null, javaFileManager, null, Arrays.asList("-d", "./temp"), null, it);
        boolean k=false;
        Exception ee=new RuntimeException();        
        try {
        	   // 7.ִ�б���
            k=task.call();
            if(!k)
            	return "sorry ! your code has some problems,please check!";
			
        // 8.���г���
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

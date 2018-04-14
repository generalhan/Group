package com.common.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

	public static String uploadFile( MultipartFile multipartFile,HttpServletRequest request)throws Exception{
        
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/");   
        /**����ͼƬ�����Ŀ¼**/ 
        String logoPathDir = "/userImgs"+ dateformat.format(new Date());   

        /**�õ�ͼƬ����Ŀ¼����ʵ·��**/   
        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);   
 
        /**������ʵ·������Ŀ¼**/   
        File logoSaveFile = new File(logoRealPathDir); if(!logoSaveFile.exists()) logoSaveFile.mkdirs();   

        /**ҳ��ؼ����ļ���**/ /**��ȡ�ļ��ĺ�׺**/  
        String suffix = multipartFile.getOriginalFilename().substring (multipartFile.getOriginalFilename().lastIndexOf("."));  
        // /**ʹ��UUID�����ļ�����**/ //  
        String logImageName = UUID.randomUUID().toString()+ suffix;  
        //�����ļ�����   
       // String logImageName = multipartFile.getOriginalFilename();  
        /**ƴ���������ļ�����·�����ļ�**/   
       String fileName = logoRealPathDir + File.separator + logImageName; 
 
       File file = new File(fileName);   
       try {   
         multipartFile.transferTo(file);  
        }  
       catch (IllegalStateException e)  
        { e.printStackTrace(); }   
        catch (IOException e)   
        { e.printStackTrace(); } 
       
       return logoPathDir + logImageName;
	}
	
}

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
        /**构建图片保存的目录**/ 
        String logoPathDir = "/userImgs"+ dateformat.format(new Date());   

        /**得到图片保存目录的真实路径**/   
        String logoRealPathDir = request.getSession().getServletContext().getRealPath(logoPathDir);   
 
        /**根据真实路径创建目录**/   
        File logoSaveFile = new File(logoRealPathDir); if(!logoSaveFile.exists()) logoSaveFile.mkdirs();   

        /**页面控件的文件流**/ /**获取文件的后缀**/  
        String suffix = multipartFile.getOriginalFilename().substring (multipartFile.getOriginalFilename().lastIndexOf("."));  
        // /**使用UUID生成文件名称**/ //  
        String logImageName = UUID.randomUUID().toString()+ suffix;  
        //构建文件名称   
       // String logImageName = multipartFile.getOriginalFilename();  
        /**拼成完整的文件保存路径加文件**/   
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

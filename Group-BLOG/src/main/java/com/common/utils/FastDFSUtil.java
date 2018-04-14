package com.common.utils;

import org.springframework.web.multipart.MultipartFile;

import com.common.global.annotions.Constants;

public class FastDFSUtil {
	
	

	public static String uploadFile(MultipartFile picFile){
		/**��ͼƬ�ϴ�**/
		if(picFile.isEmpty())return null;
		//�ϴ���ͼƬ������
				try {
					//ȡͼƬ��չ��
					String originalFilename = picFile.getOriginalFilename();
					//ȡ��չ����Ҫ��.��
					String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
					FastDFSClientUtil client = new FastDFSClientUtil("classpath:mybatis/client.conf");
					String url = client.uploadFile(picFile.getBytes(), extName);
					//��url��Ӧ���ͻ���
					url=Constants.BASE_URL+url;
					return url;
				} catch (Exception e) {
					return null;
				}
	}
	
}

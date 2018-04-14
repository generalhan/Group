package com.algorithms.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.common.algorithms.modal.HuffmNode;
import com.common.algorithms.service.DataStructService;
import com.common.utils.FileUtils;





@Controller
@RequestMapping("/algorithms")
public class dataStructController {

	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private DataStructService dataStructService;
	
	/**
	 * 模式匹配
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("indexOf")
	public @ResponseBody String indexOf(String yourInput){
		String[] str=yourInput.split(",");
		if(str.length!=3)return JSON.toJSONString("error");
       if(!isRightable(str[2],"[0-9]+"))return JSON.toJSONString("error");
		return JSON.toJSONString(dataStructService.indexOf(str[0], str[1], Integer.parseInt(str[2])));
	}
	
	/**
	 * KMP算法
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("indexOfKMP")
	public @ResponseBody String indexOfKMP(String yourInput){
		String[] str=yourInput.split(",");
		if(str.length!=3)return JSON.toJSONString("error");
       if(!isRightable(str[2],"[0-9]+")) return JSON.toJSONString("error");
		return JSON.toJSONString(dataStructService.indexOfKMP(str[0], str[1], Integer.parseInt(str[2])));
	}
	
	/**
	 * 哈夫曼编码 
	 * @param yourInput
	 * @return
	 */
	
	@RequestMapping("getHuffmCode")
	public @ResponseBody String getHuffmCode(String yourInput){ 
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
		int[] strs = sortBefore(yourInput);
		 List<String> list=dataStructService.getHuffer(strs,"");
		  return JSON.toJSONString(getStrOfList((ArrayList<String>) list));
	}
	
	/**
	 * 哈夫曼树之压缩
	 * @param yourInput
	 * @return
	 */
	@RequestMapping("Compress")
	public @ResponseBody String Compress(String yourInput){
		synchronized (this) {
		 String result="";
		if(!isRightable(yourInput,"\\w+\\s+"))
			return JSON.toJSONString("error");
		//创建压缩对象  
	      com.common.algorithms.modal.Compress compress = dataStructService.getCompress(); 
	      FileUtils ds=null;
	      //统计文件中0-255出现的次数  
	      try {
	    	  ds=new FileUtils();
	    	  ds.writeStringToFile(yourInput,FileUtils.FILE_ROOT_PATH+"1.txt");
			compress.countTimes(FileUtils.FILE_ROOT_PATH+"1.txt");
			//构造哈夫曼树，并得到根节点  
		      HuffmNode root=compress.createTree();  
		      //得到哈夫曼编码  
		      compress.getHuffmCode(root, "");  
		      //压缩文件  
		      compress.compress(FileUtils.FILE_ROOT_PATH+"1.txt",  
		    		  FileUtils.FILE_ROOT_PATH+"hufferCode.txt");
		     String code=compress.getStr();
		      int total=((code.length())/8)+1;
		      String strcodes=ds.readStringToFile(FileUtils.FILE_ROOT_PATH+"hufferCode.txt");
		      result="压缩后的哈夫曼编码是"+code+" "+" 压缩后的空间是"+total+""+"字节"+" 压缩后的gbk码是 :"+strcodes;
	      } catch (Exception e) {
			return JSON.toJSONString("error");
		}  
	    
		return JSON.toJSONString(result);
		}
	}
	
	/**
	 * 哈夫曼树之含有解密信息的压缩
	 * @param yourInput
	 * @return
	 */
	
	@RequestMapping("ArCompress")
	public @ResponseBody String ArCompress(String yourInput){
		synchronized (this) {
		 String result="";
		if(!isRightable(yourInput,"\\w+"))return JSON.toJSONString("error");
		//创建压缩对象  
		com.common.algorithms.modal.ArCompress compress = dataStructService.getArCompress(); 
	      //统计文件中0-255出现的次数  
		 FileUtils ds=null;
	      try {
	    	  ds=new FileUtils();
	    	  ds.writeStringToFile(yourInput,FileUtils.FILE_ROOT_PATH+"2.txt");
			compress.countTimes(FileUtils.FILE_ROOT_PATH+"2.txt");
			//构造哈夫曼树，并得到根节点  
		      HuffmNode root=compress.createTree();  
		      //得到哈夫曼编码  
		      compress.getHuffmCode(root, "");  
		      //压缩文件  
		      compress.compress(FileUtils.FILE_ROOT_PATH+"2.txt",  
		    		  FileUtils.FILE_ROOT_PATH+"huffer.txt");		   		 
		      String strcodes=ds.readFileByBytes(FileUtils.FILE_ROOT_PATH+"huffer.txt");
		      int strlen=strcodes.length();
		      result="压缩后含解密信息的总长度为"+strlen+"字节  压缩后的二进制码是"+strcodes;
	      } catch (Exception e) {
			return JSON.toJSONString("error");
		}  	    
		return JSON.toJSONString(result);
		}
	}
	
	/**
	 * 哈夫曼树之解压
	 * @param yourInput
	 * @return
	 */
	
	@RequestMapping("Decompress")
	public @ResponseBody String Decompress(String yourInput){
		 String result="";
		if(!isRightable(yourInput,"\\w+"))return JSON.toJSONString("error");
		//创建压缩对象  
				com.common.algorithms.modal.ArCompress compress = dataStructService.getArCompress(); 
			      //统计文件中0-255出现的次数  
				 FileUtils ds=null;
			      try {
			    	  ds=new FileUtils();
			    	  ds.writeStringToFile(yourInput, FileUtils.FILE_ROOT_PATH+"3.txt");
					compress.countTimes( FileUtils.FILE_ROOT_PATH+"3.txt");
					//构造哈夫曼树，并得到根节点  
				      HuffmNode root=compress.createTree();  
				      //得到哈夫曼编码  
				      compress.getHuffmCode(root, "");  
				      //压缩文件  
				      compress.compress( FileUtils.FILE_ROOT_PATH+"3.txt",  
				    		  FileUtils.FILE_ROOT_PATH+"huffers.txt");		   		       
				      dataStructService.getDecompress().decompress(FileUtils.FILE_ROOT_PATH+"huffers.txt",  
				    		  FileUtils.FILE_ROOT_PATH+"mytes.txt");
				        String strcodes=ds.readStringToFile(FileUtils.FILE_ROOT_PATH+"mytes.txt");
				        result="解压后的原码是  "+strcodes;
			      } catch (Exception e) {
					return JSON.toJSONString("error");
				}  
			      return JSON.toJSONString(result);
	}
	
	/**
	 * 快速排序
	 * @param yourInput
	 * @return
	 */
	@RequestMapping("qSort")
	public @ResponseBody String qSort(String yourInput){ 
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
		int[] strs = sortBefore(yourInput);		
		dataStructService.qSort(strs, 0, strs.length-1);
		  StringBuffer sb = sortAfter(strs);
		  return JSON.toJSONString(sb.toString());
	}


	
	/**
	 * 直接插入
	 * @param yourInput
	 * @return
	 */
		@RequestMapping("insertSort")
	public @ResponseBody String insertSort(String yourInput){
			if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
			int[] strs = sortBefore(yourInput);		
			  dataStructService.insertSort(strs);
			   StringBuffer sb = sortAfter(strs);
			  return JSON.toJSONString(sb.toString());
	
	}
		
		/**
		 * 希尔排序
		 * @param yourInput
		 * @return
		 */
		@RequestMapping("shellSort")
		public @ResponseBody String shellSort(String yourInput){
			if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
			int[] strs = sortBefore(yourInput);	
			for(int i=0;i<strs.length;i++){
				System.out.println(strs[i]+"before");
			}
			  dataStructService.shellSort(strs);
			  for(int i=0;i<strs.length;i++){
					System.out.println(strs[i]+"after");
				}
			   StringBuffer sb = sortAfter(strs);
			   for(int i=0;i<strs.length;i++){
					System.out.println(strs[i]+"end");
				}
			  return JSON.toJSONString(sb.toString());
		}
		
		/**
		 * 冒泡排序
		 * @param yourInput
		 * @return
		 */
		@RequestMapping("bubbleSort")
		public @ResponseBody String bubbleSort(String yourInput){
			if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
			int[] strs = sortBefore(yourInput);		
			  dataStructService.bubbleSort(strs);
			   StringBuffer sb = sortAfter(strs);
			  return JSON.toJSONString(sb.toString());
		}
		
		/**
		 * 选择排序
		 * @param yourInput
		 * @return
		 */
		@RequestMapping("ChooseSort")
		public @ResponseBody String ChooseSort(String yourInput){
			if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
			int[] strs = sortBefore(yourInput);		
			  dataStructService.ChooseSort(strs);
			   StringBuffer sb = sortAfter(strs);
			  return JSON.toJSONString(sb.toString());
		}
		
		/**
		 * 归并排序
		 * @param yourInput
		 * @return
		 */
		@RequestMapping("mSort")
		public @ResponseBody String mSort(String yourInput){
			if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
			int[] strs = sortBefore(yourInput);
			  dataStructService.mSort(strs, strs, 0, strs.length-1);
			  StringBuffer sb = sortAfter(strs);
			  return JSON.toJSONString(sb.toString());
		}
		
		/**
		 * 二分查找
		 * @param yourInput
		 * @return
		 */
		@RequestMapping("binarySearch")
		public @ResponseBody String binarySearch(String yourInput){
			if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");	
			String[] str=yourInput.split(" ");
			int[] strs = sortBefore(yourInput);		
			dataStructService.qSort(strs, 0, strs.length-1);
			int count=dataStructService.binarySearch(strs, Integer.parseInt(str[str.length-1]));
			count++;
			return JSON.toJSONString("该数的位置为第"+count);
		}
	
	/**验证输入的数据格式**/
	private boolean isRightable(String yourInput,String match) {
		boolean isRight=yourInput.matches(match);		
		return isRight==true?true:false;
	}
	
	/**将字符集集合变成单一字符串**/
	private String getStrOfList(ArrayList<String> list) {
		String result="";
		  for(String s:list){
			  result=result+s+",";
		  }
		  result=result.substring(0, result.length()-1);
		return result;
	}
	
	private int[] sortBefore(String yourInput) {
		String[] str=yourInput.split(" ");
		 int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		return strs;
	}

	private StringBuffer sortAfter(int[] strs) {
		StringBuffer sb=new StringBuffer();
		  for(int i=0;i<strs.length;i++)			  
		 sb.append(String.valueOf(strs[i]+" "));
		return sb;
	}
}

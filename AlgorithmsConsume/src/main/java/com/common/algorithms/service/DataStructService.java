package com.common.algorithms.service;

import java.util.List;

import com.common.algorithms.modal.ArCompress;
import com.common.algorithms.modal.Compress;
import com.common.algorithms.modal.Decompress;

public interface DataStructService {

	 //模式匹配，pattern为待匹配子串，begin为起始匹配位置
    int indexOf(String target,String pattern,int begin);
	//KMP算法
	int indexOfKMP(String target,String pattern,int begin);
	//哈夫曼编码
	List<String> getHuffer(int [] datas,String code);
	//快速排序
    void qSort(int[] a,int low,int high);
    //直接插入
    void insertSort(int[] a);
    //希尔排序
    void shellSort(int[] a);
    //冒泡排序
    void bubbleSort(int a[]);
   //选择排序
   void ChooseSort(int[] a);
   //归并排序
   void mSort(int[] b,int[] a,int i,int j);
   //二分查找
   int binarySearch(int[] a,int key);
   //得到压缩对象
   Compress getCompress();
   //
   ArCompress getArCompress();
   //
   Decompress getDecompress();


}

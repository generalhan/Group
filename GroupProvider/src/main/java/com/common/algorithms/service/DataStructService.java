package com.common.algorithms.service;

import java.util.List;

import com.common.algorithms.modal.ArCompress;
import com.common.algorithms.modal.Compress;
import com.common.algorithms.modal.Decompress;

public interface DataStructService {

	 //ģʽƥ�䣬patternΪ��ƥ���Ӵ���beginΪ��ʼƥ��λ��
    int indexOf(String target,String pattern,int begin);
	//KMP�㷨
	int indexOfKMP(String target,String pattern,int begin);
	//����������
	List<String> getHuffer(int [] datas,String code);
	//��������
    void qSort(int[] a,int low,int high);
    //ֱ�Ӳ���
    void insertSort(int[] a);
    //ϣ������
    void shellSort(int[] a);
    //ð������
    void bubbleSort(int a[]);
   //ѡ������
   void ChooseSort(int[] a);
   //�鲢����
   void mSort(int[] b,int[] a,int i,int j);
   //���ֲ���
   int binarySearch(int[] a,int key);
   //�õ�ѹ������
   Compress getCompress();
   //
   ArCompress getArCompress();
   //
   Decompress getDecompress();


}

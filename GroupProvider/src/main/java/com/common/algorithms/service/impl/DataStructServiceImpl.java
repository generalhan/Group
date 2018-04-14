package com.common.algorithms.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.common.algorithms.service.DataStructService;
import com.common.algorithms.modal.ArCompress;
import com.common.algorithms.modal.Compress;
import com.common.algorithms.modal.Decompress;
import com.common.algorithms.modal.HuffmNode;;

public class DataStructServiceImpl implements DataStructService {

	//ģʽƥ�䣬patternΪ��ƥ���Ӵ���beginΪ��ʼƥ��λ��
	public int indexOf(String target,String pattern,int begin){
		//��ƥ���Ӵ���Ϊ�ղ��ҳ��ȴ���0��Ŀ�괮���ڵ��ڴ�ƥ���Ӵ�
		if(pattern!=null&&pattern.length()>0&&target.length()>=pattern.length())
		{
			int i=begin,j=0; //��¼iΪ��ʼλ�ã�jΪ��ƥ���Ӵ�������
			while(i<=target.length()){ //Ŀ�괮ȫ��ƥ���꣬�˳�
				if(target.charAt(i)==pattern.charAt(j))//��������ַ����
				{
					i++; //����������1�����ҿ�ʼ�ȽϺ�һ���ַ�
					j++;
				}
				else{
					i=i+j+1; //i���ݣ������һ��Ŀ�괮ƥ���ַ�����һ���ַ�
					j=0;    //��ƥ���ַ�������Ϊ0
				}
				if(j==pattern.length())
					return i-j+1; //����ƥ�䵽��λ��
			}
		}
		
		           return -1; //ƥ��ʧ��
	}
	
	//KMP�㷨
	public int indexOfKMP(String target,String pattern,int begin){
		if(pattern!=null&&pattern.length()>0&&target.length()>=pattern.length())
		{
		int i=begin,j=0;
		int[] next=getNext(pattern); //���next���飬�����Ϳ��Ա���һЩ�ظ��Ƚ���
		while(i<target.length()){
			if(j==-1||target.charAt(i)==pattern.charAt(j))
			{
				i++;
				j++;
			}
			else
				j=next[j]; //�˻ص�next[J]���ַ���ʼ�Ƚ�
			if(j==pattern.length())
				return i-j+1;
		}
		}
		return -1;
	}
	
	private int[] getNext(String pattern){
		int j=0,k=-1;
		int[] next=new int[pattern.length()];
		next[0]=-1;
		while(j<pattern.length()-1)
		{
			if(k==-1||pattern.charAt(j)==pattern.charAt(k))
			{
				j++;
				k++;
				if(pattern.charAt(j)!=pattern.charAt(k))//�Ľ�֮��
				next[j]=k;
				else
					next[j]=next[k];
			}
			else
				k=next[k];
			return next;
		}
		return next;
	}
	
	//���������� 
    public LinkedList<HuffmNode> list = new LinkedList<HuffmNode>();  
    private List<String> huffmcode=new ArrayList<String>();
    public HuffmNode createTree(int [] datas) {  
        //���մ�С����Ľ����ݷ�װ�ɽڵ�  
        for (int i = 0; i < datas.length; i++) {  
            HuffmNode node = new HuffmNode(datas[i]);  
            //�õ���Ҫ�����λ������  
            int index=getIndex(node);  
            //��������ӵ�������  
            list.add(index, node);  
        }  
        //�����������  
        while(list.size()>1){  
            //�Ƴ������еĵ�һ���ڵ�  
            HuffmNode firstNode =list.removeFirst();  
            //������ԭ���ĵڶ����ڵ����µĵ�һ���ڵ�  
            HuffmNode secondNode =list.removeFirst();  
            //���츸�ڵ�������  
            HuffmNode fatherNode = new HuffmNode(firstNode.getData()+secondNode.getData());  
            //���츸�ڵ�����Ҷ  
            fatherNode.setLeft(firstNode);  
            //���츸�ڵ�����Ҷ  
            fatherNode.setRight(secondNode);  
            //�õ�����õĸ��ڵ������  
            int index=getIndex(fatherNode);  
            //�����ڵ����ɭ��  
            list.add(index, fatherNode);  
        }  
        //���ظ��ڵ�  
        return list.getFirst();  
    }  
      
    //�õ�����  
    public int getIndex(HuffmNode node) {  
        for (int i = 0; i < list.size(); i++) {  
            if(node.getData()>list.get(i).getData()){  
                continue;  
            }else {  
                return i;  
            }  
        }  
        //����������е��κ�һ����������������  
        return list.size();  
    }  
      
    //�õ�����������  
    public void getHuffmCode(HuffmNode root,String code) {  
        if(root.getLeft()!=null){  
            getHuffmCode(root.getLeft(),code+"0");  
        }  
        if(root.getRight()!=null){  
            getHuffmCode(root.getRight(),code+"1");  
        }  
        if(root.getLeft()==null && root.getRight()==null){  
        	huffmcode.add((root.getData()+":"+code));  
        }  
    }   
    
    public List<String> getHuffer(int [] datas,String code){
    	this.getHuffmCode(createTree(datas),code);
    	return huffmcode;
    }
    
    //��������
    public void qSort(int[] a,int low,int high){
    	int pivot=0;
    	if(low<high){
    		pivot=partition(a,low,high);
    		qSort(a,low,pivot);
    		qSort(a,pivot+1,high);
    	}
    }
    
    private int partition(int[] a,int low,int high) {
    	int pivotKey=a[low];
    	while(low<high){
    		while(low<high&&a[high]>=pivotKey){
    			high--;
    		}
    		swap(a,low,high);
    		while(low<high&&a[low]<=pivotKey){
    			low++;
    		}
    		swap(a,low,high);
    	}
    	return low;
    }
    
    private void swap(int[] a,int low,int high){
    	int temp=a[low];
    	 a[low]=a[high];
    	 a[high]=temp;
    }
    
    //ֱ�Ӳ���
    public void insertSort(int[] a){
    	int i,j,temp;
    	for(i=1;i<a.length;i++){
    		if(a[i]<a[i-1]){
    			temp=a[i];
    			for(j=i-1;j>=0&&a[j]>temp;j--){
    				a[j+1]=a[j];
    			}
    			a[j+1]=temp;
    		}
    	}
    }
    
    //ϣ������
    public void shellSort(int[] a){
    	int inc=a.length,i,j,k;
    	do{
    		inc=inc/3+1;
    		for(i=inc;i<a.length;i++){
    			k=a[i];
    			for(j=i-inc;j>=0&&k<a[j];j-=inc){
    				a[j+inc]=a[j];
    			}
    			a[j+inc]=k;  				
    		}   		
    	}while(inc>1);
    }
    
    //ð������
    public  void bubbleSort(int a[]){
    	int temp;
    	boolean flag=true; //������Ϊ���
    	for(int i=a.length-1;i>0&&flag;i--){ //���flagΪfalse��Ҳ�����Ѿ������ˣ��˳�
    		flag=false;  //��ʼ��Ϊfalse
    		for(int j=0;j<=i-1;j++)
    			if(a[j]>a[j+1])
    			{
    				temp=a[j+1];
    				a[j+1]=a[j];
    				a[j]=temp;
    				flag=true;  //��������ݽ���������Ϊtrue
    			}
    }}
    
    //ѡ������
    public void ChooseSort(int[] a){
    	int min,temp;  //�ֱ�Ϊÿһ��ѭ���ĵ�ǰ��С��������ʱ����
    	for(int i=0;i<a.length;i++){
    		 min=i; //��ʼ����С������Ϊ��ǰѭ���ĵ�һ������
    	 for(int j=i+1;j<a.length;j++)
    	 {
    		 if(a[j]<a[i])  //�ҵ��ȵ�ǰѭ������С����С�ļ�¼������¼�±�
    			 min=j;
    	 }
    	 if(min!=i) //����бȵ�ǰ��С����С���򽻻���¼
    	 {
    		 temp=a[min];
    		 a[min]=a[i];
    		 a[i]=temp;			 
    	 }
    	}
    }
    
    //�鲢����
   public void mSort(int[] b,int[] a,int i,int j){
    	int m=0;
    	int[] c=new int[a.length];
    	if(i==j){
    		a[i]=b[i];
    	}else{
    		m=(i+j)/2;
    		mSort(b,c,i,m);
    		mSort(b,c,m+1,j);
    		merge(c,a,i,m,j);
    	}
    }
    
 
    private void merge(int[] b,int[] a,int i,int m,int t){
    	int j=0,k=0,l=0;
    	for(j=m+1,k=i;i<=m&&j<=t;k++){
    		if(b[i]<b[j]){
    			a[k]=b[i++];
    		}else{
    			a[k]=b[j++];
    		}
    	}
    	if(i<=m){
    		for(l=0;l<=m-i;l++){
    			a[k+l]=b[i+l];
    		}
    	}
    	if(j<=t){
    		for(l=0;l<=t-j;l++)
    			a[k+l]=b[j+l];
    	}
    }

    //���ֲ���
    public int binarySearch(int[] a,int key){
    	int low=0;
    	int high=a.length-1;
    	int mid=0;
    	while(low<=high){
    		mid=(low+high)/2;
    		if(a[mid]==key)return mid;
    		if(a[mid]>key) high=mid-1;
    		if(a[mid]<key) low=mid+1;
    	}
    	return -1;
    }

	public Compress getCompress() {
		return new Compress();
	}

	public ArCompress getArCompress() {
		// TODO Auto-generated method stub
		return new ArCompress();
	}

	public Decompress getDecompress() {
		// TODO Auto-generated method stub
		return new Decompress();
	}
    
}

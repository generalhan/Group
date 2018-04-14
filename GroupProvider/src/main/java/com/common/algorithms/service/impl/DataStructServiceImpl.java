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

	//模式匹配，pattern为待匹配子串，begin为起始匹配位置
	public int indexOf(String target,String pattern,int begin){
		//待匹配子串不为空并且长度大于0和目标串大于等于带匹配子串
		if(pattern!=null&&pattern.length()>0&&target.length()>=pattern.length())
		{
			int i=begin,j=0; //记录i为开始位置，j为待匹配子串计数器
			while(i<=target.length()){ //目标串全部匹配完，退出
				if(target.charAt(i)==pattern.charAt(j))//如果，有字符相等
				{
					i++; //计数器都加1，并且开始比较后一个字符
					j++;
				}
				else{
					i=i+j+1; //i回溯，变成上一个目标串匹配字符的下一个字符
					j=0;    //待匹配字符，回溯为0
				}
				if(j==pattern.length())
					return i-j+1; //返回匹配到的位置
			}
		}
		
		           return -1; //匹配失败
	}
	
	//KMP算法
	public int indexOfKMP(String target,String pattern,int begin){
		if(pattern!=null&&pattern.length()>0&&target.length()>=pattern.length())
		{
		int i=begin,j=0;
		int[] next=getNext(pattern); //求得next数组，这样就可以避免一些重复比较了
		while(i<target.length()){
			if(j==-1||target.charAt(i)==pattern.charAt(j))
			{
				i++;
				j++;
			}
			else
				j=next[j]; //退回到next[J]个字符开始比较
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
				if(pattern.charAt(j)!=pattern.charAt(k))//改进之处
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
	
	//哈夫曼编码 
    public LinkedList<HuffmNode> list = new LinkedList<HuffmNode>();  
    private List<String> huffmcode=new ArrayList<String>();
    public HuffmNode createTree(int [] datas) {  
        //按照从小到大的将数据封装成节点  
        for (int i = 0; i < datas.length; i++) {  
            HuffmNode node = new HuffmNode(datas[i]);  
            //得到需要插入的位置索引  
            int index=getIndex(node);  
            //将数据添加到容器中  
            list.add(index, node);  
        }  
        //构造哈夫曼树  
        while(list.size()>1){  
            //移除容器中的第一个节点  
            HuffmNode firstNode =list.removeFirst();  
            //容器中原来的第二个节点变成新的第一个节点  
            HuffmNode secondNode =list.removeFirst();  
            //构造父节点数据域  
            HuffmNode fatherNode = new HuffmNode(firstNode.getData()+secondNode.getData());  
            //构造父节点左子叶  
            fatherNode.setLeft(firstNode);  
            //构造父节点右子叶  
            fatherNode.setRight(secondNode);  
            //得到构造好的父节点的索引  
            int index=getIndex(fatherNode);  
            //将父节点加入森林  
            list.add(index, fatherNode);  
        }  
        //返回根节点  
        return list.getFirst();  
    }  
      
    //得到索引  
    public int getIndex(HuffmNode node) {  
        for (int i = 0; i < list.size(); i++) {  
            if(node.getData()>list.get(i).getData()){  
                continue;  
            }else {  
                return i;  
            }  
        }  
        //如果比容器中的任何一个数大，则插入最后面  
        return list.size();  
    }  
      
    //得到哈夫曼编码  
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
    
    //快速排序
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
    
    //直接插入
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
    
    //希尔排序
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
    
    //冒泡排序
    public  void bubbleSort(int a[]){
    	int temp;
    	boolean flag=true; //用来作为标记
    	for(int i=a.length-1;i>0&&flag;i--){ //如果flag为false，也就是已经有序了，退出
    		flag=false;  //初始化为false
    		for(int j=0;j<=i-1;j++)
    			if(a[j]>a[j+1])
    			{
    				temp=a[j+1];
    				a[j+1]=a[j];
    				a[j]=temp;
    				flag=true;  //如果有数据交换，则设为true
    			}
    }}
    
    //选择排序
    public void ChooseSort(int[] a){
    	int min,temp;  //分别为每一次循环的当前最小变量和临时变量
    	for(int i=0;i<a.length;i++){
    		 min=i; //初始化最小变量，为当前循环的第一个变量
    	 for(int j=i+1;j<a.length;j++)
    	 {
    		 if(a[j]<a[i])  //找到比当前循环的最小变量小的记录，并记录下标
    			 min=j;
    	 }
    	 if(min!=i) //如果有比当前最小变量小，则交换记录
    	 {
    		 temp=a[min];
    		 a[min]=a[i];
    		 a[i]=temp;			 
    	 }
    	}
    }
    
    //归并排序
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

    //二分查找
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

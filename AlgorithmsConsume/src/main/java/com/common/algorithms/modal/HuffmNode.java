package com.common.algorithms.modal;

public class HuffmNode implements java.io.Serializable{
	//构造HuffmNode类  
    private int data;  
    private HuffmNode left;  
    private HuffmNode right; 
    //索引  
    private int index;  
    //HuffmNode类构造函数  
    public  HuffmNode(int data) {  
        this.data=data;  
    }  
    //哈夫曼节点的构造函数  
    public HuffmNode(int data,int index){  
        this.data=data;  
        this.index=index;  
    }  
    //封装属性  
    public int getData() {  
        return data;  
    }  
    public void setData(int data) {  
        this.data = data;  
    }  
    public HuffmNode getLeft() {  
        return left;  
    }  
    public void setLeft(HuffmNode left) {  
        this.left = left;  
    }  
    public HuffmNode getRight() {  
        return right;  
    }  
    public void setRight(HuffmNode right) {  
        this.right = right;  
    }  
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }  
}

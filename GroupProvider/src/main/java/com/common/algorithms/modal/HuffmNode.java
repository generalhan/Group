package com.common.algorithms.modal;

public class HuffmNode implements java.io.Serializable{
	//����HuffmNode��  
    private int data;  
    private HuffmNode left;  
    private HuffmNode right; 
    //����  
    private int index;  
    //HuffmNode�๹�캯��  
    public  HuffmNode(int data) {  
        this.data=data;  
    }  
    //�������ڵ�Ĺ��캯��  
    public HuffmNode(int data,int index){  
        this.data=data;  
        this.index=index;  
    }  
    //��װ����  
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

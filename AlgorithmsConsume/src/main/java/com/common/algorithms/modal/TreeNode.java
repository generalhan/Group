package com.common.algorithms.modal;

public class TreeNode<T> implements java.io.Serializable{

	public T value;
	
	public TreeNode(T value){
		this.value=value;
	}
	
	public TreeNode left;
	public TreeNode right;
	
}

package com.common.algorithms.service;

import java.util.ArrayList;
import java.util.List;

import com.common.algorithms.modal.ListNode;
import com.common.algorithms.modal.TreeNode;




public interface OfferAlgorithmsService {

	//从尾到头打印链表
	ArrayList<String>  printListFromTailToHead(ListNode<String> listNode);
	//替换空格 
    String replaceSpace(StringBuffer str);
    //二进制中1的个数
    int NumberOf1(int n);
    //数值的整数次方 
  	double Power(double base, int exponent);
    //调整数组顺序使奇数位于偶数前面
    void reOrderArray(int [] array);
    //链表中倒数第k个结点 
    ListNode<String> FindKthToTail(ListNode head,int k);
    //反转链表 
    ListNode ReverseList(ListNode head);
    //合并两个排序的链表
    ListNode<Integer> Merge(ListNode<Integer> list1,ListNode<Integer> list2);
    //树的子结构
    boolean HasSubtree(TreeNode<String> root1,TreeNode<String> root2);
    //二叉树的镜像 
    void Mirror(TreeNode root);
    //从上往下打印二叉树 
    ArrayList<String> PrintFromTopToBottom(TreeNode<String> root);
    //二叉搜索树的后序遍历序列 
    boolean VerifySquenceOfBST(int [] sequence);
    //二叉树的深度
    int TreeDepth(TreeNode root);
    //平衡二叉树 
    boolean IsBalanced_Solution(TreeNode root);
    //序列化二叉树
	 String Serialize(TreeNode root);
	//反序列化二叉树
	TreeNode Deserialize(String str);
	//字符串的排列 
	ArrayList<String> Permutation(String str);
	//先序遍历
    void preOrder(TreeNode<String> node,List<String> list);
    //约瑟夫环
    int CountnQuit(int total,int n);
   //栈的压入弹出序列 
   boolean IsPopOrder(int [] pushA,int [] popA);
   //
   void push(int node);
   //
   void pushs(int node);
   //用两个栈实现队列
   int pop();
   //包含min函数的栈
   int min();
  //旋转数组的最小数字
   int minNumberInRotateArray(int [] array);
  //最小的K个数 
  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k);
  //把数组排成最小的数  
  String PrintMinNumber(int [] numbers);
  //数组中出现次数超过一半的数字 
  int MoreThanHalfNum_Solution(int [] array);
  //整数中1出现的次数（从1到n整数中1出现的次数）
  int NumberOf1Between1AndN_Solution(int n);
  //第一个只出现一次的字符
  int FirstNotRepeatingChar(String str);
  //连续子数组的最大和 
  int FindGreatestSumOfSubArray(int[] array);
  //丑数
  int GetUglyNumber_Solution(int index);
  //二维数组中的查找
  boolean Find(int target, int [][] array);
  //斐波那契数列 
  int Fibonacci(int n);
  //跳台阶
  int JumpFloor(int target);
  //变态跳台阶 
  int JumpFloorII(int target);
  //矩形覆盖 
  int RectCover(int target);
  //左旋转字符串 
  String LeftRotateString(String str,int n);
  //翻转单词顺序列
  String ReverseSentence(String str);
  //扑克牌顺子 
  boolean isContinuous(int [] numbers);
  //求1+2+3+...+n 
  int Sum_Solution(int n);
  //不用加减乘除做加法
  int Add(int num1,int num2);
  //数组中重复的数字
  boolean duplicate(int numbers[],int length,int [] duplication);
  //正则表达式匹配
  boolean match(char[] str,char[] pattern);
  //
  void Insert(char ch);
  //表示数值的字符串
  boolean isNumeric(char[] str);
  //字符流中第一个不重复的字符
  char FirstAppearingOnce();
  //滑动窗口的最大值
  ArrayList<Integer> maxInWindows(int [] num, int size);
  //和为S的连续正数序列 
  ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum);
  //和为S的两个数字
  ArrayList<Integer> FindNumbersWithSum(int [] array,int sum);
  //数组中只出现一次的数字 
  void FindNumsAppearOnce(int [] array,int num1[] , int num2[]);
  //数字在排序数组中出现的次数
  int GetNumberOfK(int [] array , int k);
 
 
}

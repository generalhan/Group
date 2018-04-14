package com.common.algorithms.service;

import java.util.ArrayList;
import java.util.List;

import com.common.algorithms.modal.ListNode;
import com.common.algorithms.modal.TreeNode;




public interface OfferAlgorithmsService {

	//��β��ͷ��ӡ����
	ArrayList<String>  printListFromTailToHead(ListNode<String> listNode);
	//�滻�ո� 
    String replaceSpace(StringBuffer str);
    //��������1�ĸ���
    int NumberOf1(int n);
    //��ֵ�������η� 
  	double Power(double base, int exponent);
    //��������˳��ʹ����λ��ż��ǰ��
    void reOrderArray(int [] array);
    //�����е�����k����� 
    ListNode<String> FindKthToTail(ListNode head,int k);
    //��ת���� 
    ListNode ReverseList(ListNode head);
    //�ϲ��������������
    ListNode<Integer> Merge(ListNode<Integer> list1,ListNode<Integer> list2);
    //�����ӽṹ
    boolean HasSubtree(TreeNode<String> root1,TreeNode<String> root2);
    //�������ľ��� 
    void Mirror(TreeNode root);
    //�������´�ӡ������ 
    ArrayList<String> PrintFromTopToBottom(TreeNode<String> root);
    //�����������ĺ���������� 
    boolean VerifySquenceOfBST(int [] sequence);
    //�����������
    int TreeDepth(TreeNode root);
    //ƽ������� 
    boolean IsBalanced_Solution(TreeNode root);
    //���л�������
	 String Serialize(TreeNode root);
	//�����л�������
	TreeNode Deserialize(String str);
	//�ַ��������� 
	ArrayList<String> Permutation(String str);
	//�������
    void preOrder(TreeNode<String> node,List<String> list);
    //Լɪ��
    int CountnQuit(int total,int n);
   //ջ��ѹ�뵯������ 
   boolean IsPopOrder(int [] pushA,int [] popA);
   //
   void push(int node);
   //
   void pushs(int node);
   //������ջʵ�ֶ���
   int pop();
   //����min������ջ
   int min();
  //��ת�������С����
   int minNumberInRotateArray(int [] array);
  //��С��K���� 
  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k);
  //�������ų���С����  
  String PrintMinNumber(int [] numbers);
  //�����г��ִ�������һ������� 
  int MoreThanHalfNum_Solution(int [] array);
  //������1���ֵĴ�������1��n������1���ֵĴ�����
  int NumberOf1Between1AndN_Solution(int n);
  //��һ��ֻ����һ�ε��ַ�
  int FirstNotRepeatingChar(String str);
  //��������������� 
  int FindGreatestSumOfSubArray(int[] array);
  //����
  int GetUglyNumber_Solution(int index);
  //��ά�����еĲ���
  boolean Find(int target, int [][] array);
  //쳲��������� 
  int Fibonacci(int n);
  //��̨��
  int JumpFloor(int target);
  //��̬��̨�� 
  int JumpFloorII(int target);
  //���θ��� 
  int RectCover(int target);
  //����ת�ַ��� 
  String LeftRotateString(String str,int n);
  //��ת����˳����
  String ReverseSentence(String str);
  //�˿���˳�� 
  boolean isContinuous(int [] numbers);
  //��1+2+3+...+n 
  int Sum_Solution(int n);
  //���üӼ��˳����ӷ�
  int Add(int num1,int num2);
  //�������ظ�������
  boolean duplicate(int numbers[],int length,int [] duplication);
  //������ʽƥ��
  boolean match(char[] str,char[] pattern);
  //
  void Insert(char ch);
  //��ʾ��ֵ���ַ���
  boolean isNumeric(char[] str);
  //�ַ����е�һ�����ظ����ַ�
  char FirstAppearingOnce();
  //�������ڵ����ֵ
  ArrayList<Integer> maxInWindows(int [] num, int size);
  //��ΪS�������������� 
  ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum);
  //��ΪS����������
  ArrayList<Integer> FindNumbersWithSum(int [] array,int sum);
  //������ֻ����һ�ε����� 
  void FindNumsAppearOnce(int [] array,int num1[] , int num2[]);
  //���������������г��ֵĴ���
  int GetNumberOfK(int [] array , int k);
 
 
}

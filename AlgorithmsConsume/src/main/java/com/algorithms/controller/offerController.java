package com.algorithms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.common.algorithms.modal.ListNode;
import com.common.algorithms.modal.TreeNode;
import com.common.algorithms.service.OfferAlgorithmsService;




@Controller
@RequestMapping("/algorithms")
public class offerController {

	@Autowired
	private OfferAlgorithmsService algorithmsService;
	
	/**
	 * 从尾到头打印链表
	 */
	@RequestMapping("printListFromTailToHead")
	public @ResponseBody String printListFromTailToHead(String yourInput){
		  if(!isRightable(yourInput,"(\\w,)+\\w$"))return JSON.toJSONString("error"); 	
		   /**创建头结点**/
		   ListNode<String> head = CreateListNodeHead(yourInput);
		   /**得到从尾到头打印的结点集合**/
		 ArrayList<String> list= algorithmsService.printListFromTailToHead(head);
		  return JSON.toJSONString(getStrOfList(list));
	}

	/**
	 * 替换空格
	 */
	@RequestMapping("replaceSpace")
	public @ResponseBody String replaceSpace(String yourInput){
		if(yourInput.trim().equals(""))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.replaceSpace(new StringBuffer(yourInput)));
	}
	
	/**
	 * 二进制中1的个数
	 */
	@RequestMapping("NumberOf1")
	public @ResponseBody String NumberOf1(String yourInput){
		if(!isRightable(yourInput,"[0-9]+"))return JSON.toJSONString("error");		
		   int result=Integer.parseInt(yourInput);
		    if(result>=Integer.MAX_VALUE||result<=Integer.MIN_VALUE)
		    	return JSON.toJSONString("error");		
		    return JSON.toJSONString(algorithmsService.NumberOf1(result));
	}
	
	/**
	 * 数值的整数次方
	 */
	@RequestMapping("Power")
	public @ResponseBody String Power(String yourInput){
		String[] str=yourInput.split(" ");
		if(str.length!=2)
			return JSON.toJSONString("error");
		  Double result=algorithmsService.Power(Double.parseDouble(str[0]),Integer.parseInt(str[1]));
	       return JSON.toJSONString(result);
	}
	
	/**
	 * 调整数组顺序使奇数位于偶数前面
	 */
	@RequestMapping("reOrderArray")
	public @ResponseBody String reOrderArray(String yourInput){
		if(!isRightable(yourInput,"([0-9]+\\s)+"))return JSON.toJSONString("error");	
		   String[] str=yourInput.split(" ");		
		       int[] array=new int[str.length];
		       for(int i=0;i<str.length;i++)
			      array[i]=Integer.parseInt(str[i]);	
		          algorithmsService.reOrderArray(array);
		          StringBuffer sb=new StringBuffer(2*str.length);
		            for(int i=0;i<2*str.length;i++){
		    	       if(i%2==0)
		    		       sb.append(array[i/2]);
		    	       else
		    		       sb.append(" ");}	  			    
	   return JSON.toJSONString(new String(sb));
	}
	
	/**
	 * 链表中倒数第k个结点
	 */
	@RequestMapping("FindKthToTail")
	public @ResponseBody String FindKthToTail(String yourInput){
	 if(!isRightable(yourInput,"(\\w,)+\\w$"))return JSON.toJSONString("error");
	    String[] str=yourInput.split(",");
		ListNode<String> head=CreateListNodeHead(yourInput);
		ListNode<String> kNode=algorithmsService.FindKthToTail(head, Integer.parseInt(str[str.length-1]));
	  if(kNode==null)
		  return JSON.toJSONString("error");
	  return JSON.toJSONString(kNode.val);
	}
	
	/**
	 * 反转链表
	 * @param yourInput
	 * @return
	 */
	@RequestMapping("ReverseList")
	public @ResponseBody String ReverseList(String yourInput){
		 if(!isRightable(yourInput,"(\\w,)+\\w$"))return JSON.toJSONString("error");
        ListNode<String> head=CreateListNodeHead(yourInput);
		ListNode<String> node=algorithmsService.ReverseList(head);
		 List<String> list=new ArrayList<String>();
		  while(node!=null){
			 list.add(node.val);
			 node=node.next;
		}
		  return JSON.toJSONString(getStrOfList((ArrayList<String>) list));
	}
	
	/**
	 * 合并两个排序的链表
	 * @param yourInput
	 * @return
	 */
	@RequestMapping("Merge")
	public @ResponseBody String Merge(String yourInput){
		String[] strs=yourInput.split(",");
		 if(strs.length!=2)
			 return JSON.toJSONString("error");	 
		 boolean isRight=strs[0].matches("((\\d)+\\s)+(\\d+)$");
		 boolean Right=strs[1].matches("((\\d)+\\s)+(\\d+)$");
		 if(!isRight||!Right)
			 return JSON.toJSONString("error");
		 String[] str1=strs[0].split(" ");
		 String[] str2=strs[1].split(" ");	
		 boolean IsSorted=compare(changeToInt(str1));
		 boolean Sorted=compare(changeToInt(str2));
		 if(!IsSorted||!Sorted)
			 return JSON.toJSONString("error");
		 ListNode<Integer> list1=createIntNode(strs[0]);
		 ListNode<Integer> list2=createIntNode(strs[1]);
		 ListNode<Integer> node=algorithmsService.Merge(list1, list2);
		 List<String> list=new ArrayList<String>();
		 while(node!=null){
				list.add(String.valueOf((node.val)));
				node=node.next;
			}
			  return JSON.toJSONString(getStrOfList((ArrayList<String>) list));		 
	}
	
	/**
	 * 树的子结构
	 * @param str
	 * @return
	 */
	@RequestMapping("HasSubtree")
	public @ResponseBody String HasSubtree(String yourInput){
		String[] str=yourInput.split(",");
		String[] str1=str[0].split(" ");
		String[] str2=str[1].split(" ");
		boolean isRight=str[0].matches("(\\w\\s)+\\w$");	
		boolean Right=str[1].matches("(\\w\\s)+\\w$");	
		 if((yourInput.length()+1)%2!=0||str.length==0||!isRight||!Right)
			 return JSON.toJSONString("error");
		 TreeNode root1=new TreeNode(str1[0]);
		 TreeNode root2=new TreeNode(str2[0]);
		 List<String> list1=new ArrayList<String>();
		 List<String> list2=new ArrayList<String>();
		 for(int i=1;i<str1.length;i++)
			 list1.add(str1[i]);
		 TreeNode head1=createTree(root1,list1);
		 for(int i=1;i<str2.length;i++)
			 list2.add(str2[i]);
		 TreeNode head2=createTree(root2,list2);
		 Boolean flag=algorithmsService.HasSubtree(head1, head2);
		 return JSON.toJSONString(flag);
	}
	
	/**
	 * 二叉树的镜像
	 * @param str
	 * @return
	 */
	@RequestMapping("Mirror")
	public @ResponseBody String Mirror(String yourInput){
		String[] str=yourInput.split(" ");
		boolean isRight=yourInput.matches("(\\w\\s)+\\w$");
		if(!isRight||(yourInput.length()+1)%2!=0)
			 return JSON.toJSONString("error");
		TreeNode<String> head = getTreeHead(str);
		  algorithmsService.Mirror(head);
		  List<String> nodeList=new ArrayList<String>();
		  algorithmsService.preOrder(head, nodeList);
			  return JSON.toJSONString(getStrOfList((ArrayList<String>) nodeList));
	}
	
	/**
	 * 从上往下打印二叉树
	 * @param str
	 * @return
	 */
	@RequestMapping("PrintFromTopToBottom")
	public @ResponseBody String PrintFromTopToBottom(String yourInput){
		String[] str=yourInput.split(" ");
		boolean isRight=yourInput.matches("(\\w\\s)+\\w$");
		if(!isRight||(yourInput.length()+1)%2!=0)
			 return JSON.toJSONString("error");
		TreeNode<String> head = getTreeHead(str);
		  List<String> nodeList=algorithmsService.PrintFromTopToBottom(head);
		  return JSON.toJSONString(getStrOfList((ArrayList<String>) nodeList));		
	}
	
	/**
	 * 二叉搜索树的后序遍历序列 
	 * @param str
	 * @return
	 */
	@RequestMapping("VerifySquenceOfBST")
	public @ResponseBody String VerifySquenceOfBST(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		return JSON.toJSONString(algorithmsService.VerifySquenceOfBST(strs));
	}
	
	/**
	 * 二叉树的深度
	 * @param str
	 * @return
	 */
	@RequestMapping("TreeDepth")
	public @ResponseBody String TreeDepth(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		TreeNode<String> head = getTreeHead(str);
		  return JSON.toJSONString(algorithmsService.TreeDepth(head));
	}
	
	/**
	 * 平衡二叉树 
	 * @param str
	 * @return
	 */
	@RequestMapping("IsBalanced_Solution")
	public @ResponseBody String TIsBalanced_Solution(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");
		 String[] str=yourInput.split(" ");
		TreeNode<String> head = getTreeHead(str);
		  return JSON.toJSONString(algorithmsService.IsBalanced_Solution(head));
	}
	
	/**
	 * 序列化二叉树
	 * @param str
	 * @return
	 */
	@RequestMapping("Serialize")
	public @ResponseBody String Serialize(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");
		 String[] str=yourInput.split(" ");
			TreeNode<String> head = getTreeHead(str);
		   return JSON.toJSONString(algorithmsService.Serialize(head));
	}
	
	/**
	 * 字符串的排列 
	 * @param str
	 * @return
	 */
	@RequestMapping("Permutation")
	public @ResponseBody String Permutation(String yourInput){
		boolean isRight=yourInput.matches("\\w+");
		if(!isRight||yourInput.length()==0)
			return JSON.toJSONString("error");
		 List<String> list=algorithmsService.Permutation(yourInput);
		  return JSON.toJSONString(getStrOfList((ArrayList<String>) list));			
	}
	
	/**
	 * 约瑟夫环
	 * @param yourInput
	 * @return
	 */
	
	@RequestMapping("CountnQuit")
	public @ResponseBody String CountnQuit(String yourInput){
		boolean isNum = yourInput.matches("((\\d)+\\s)(\\d+)$"); 
		String[] str=yourInput.split(" ");
		int Num=Integer.parseInt(str[0])-Integer.parseInt(str[1]);
		if(!isNum||Num<0)
			return JSON.toJSONString("error");	
		 int count=algorithmsService.CountnQuit(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
	 return JSON.toJSONString("被赦免的人是第"+count+"人");
	}
	
	/**
	 * 栈的压入弹出序列 
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("IsPopOrder")
	public @ResponseBody String IsPopOrder(String yourInput){
		String[] str=yourInput.split(",");
		String[] str1=str[0].split(" ");
		String[] str2=str[1].split(" ");
		boolean isRight=str[0].matches("(\\d+\\s)+\\d$");	
		boolean Right=str[1].matches("(\\d+\\s)+\\d$");
		if(str.length==0||!isRight||!Right||str1.length!=str2.length)
			 return JSON.toJSONString("error");
		int[] pushA=new int[str1.length];
		int[] popA=new int[str2.length];
		for(int i=0;i<str1.length;i++){
			pushA[i]=Integer.parseInt(str1[i]);
			popA[i]=Integer.parseInt(str2[i]);			
		}
		return JSON.toJSONString(algorithmsService.IsPopOrder(pushA, popA));
	}
	
	/**
	 * 用两个栈实现队列
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("pushAndpop")
	public @ResponseBody String pushAndpop(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		for(int i=0;i<str.length;i++)
			algorithmsService.push(Integer.parseInt(str[i]));
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<str.length;i++)
				sb.append(algorithmsService.pop()+" ");
			return JSON.toJSONString(sb.toString());
	}
	
	/**
	 * 包含min函数的栈
	 * @param yourInput
	 * @return
	 */
	@RequestMapping("min")
	public @ResponseBody String min(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		for(int i=0;i<str.length;i++)
			algorithmsService.pushs(Integer.parseInt(str[i]));
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<str.length;i++)
				sb.append(algorithmsService.min()+" ");
			return JSON.toJSONString(sb.toString());
	}
	
	/**
	 * 旋转数组的最小数字
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("minNumberInRotateArray")
	public @ResponseBody String minNumberInRotateArray(String yourInput){
		boolean isRight=yourInput.matches("((\\d)+\\s)+(\\d+)$");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		if(!isRight||!isminNumberInRotateArray(strs))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.minNumberInRotateArray(strs));
	}
	
	/**
	 * 最小的K个数 
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("GetLeastNumbers_Solution")
	public @ResponseBody String GetLeastNumbers_Solution(String yourInput){
		boolean isRight=yourInput.matches("((\\d)+\\s)+(\\d+)$");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length-1];
		for(int i=0;i<str.length-1;i++)
			strs[i]=Integer.parseInt(str[i]);
		if(!isRight)
			return JSON.toJSONString("error");
		ArrayList<Integer> list=algorithmsService.GetLeastNumbers_Solution(strs, Integer.parseInt(str[str.length-1]));
	    StringBuilder sb=new StringBuilder();
	     for(Integer i:list){
	    	 sb.append(i+" ");
	     }
	     return JSON.toJSONString(sb.toString());
	}
	
	/**
	 * 把数组排成最小的数 
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("PrintMinNumber")
	public @ResponseBody String PrintMinNumber(String yourInput){
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.PrintMinNumber(strs));
	}
	
	/**
	 * 数组中出现次数超过一半的数字
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("MoreThanHalfNum_Solution")
	public @ResponseBody String MoreThanHalfNum_Solution(String yourInput){
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.MoreThanHalfNum_Solution(strs));
	}
	
	/**
	 * 整数中1出现的次数（从1到n整数中1出现的次数）
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("NumberOf1Between1AndN_Solution")
	public @ResponseBody String NumberOf1Between1AndN_Solution(String yourInput){
		 int n=Integer.parseInt(yourInput);
		if(!isRightable(yourInput,"(\\d)+"))
			return JSON.toJSONString("error");
		 return JSON.toJSONString(algorithmsService.NumberOf1Between1AndN_Solution(n));
	}
	
	/**
	 * 第一个只出现一次的字符
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("FirstNotRepeatingChar")
	public @ResponseBody String FirstNotRepeatingChar(String yourInput){
		if(!isRightable(yourInput,"(\\w)+\\w$"))
			return JSON.toJSONString("error");
		 return JSON.toJSONString(algorithmsService.FirstNotRepeatingChar(yourInput));
	}
	
	/**
	 * 连续子数组的最大和
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("FindGreatestSumOfSubArray")
	public @ResponseBody String FindGreatestSumOfSubArray(String yourInput){
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		if(!isRightable(yourInput,"((((\\-|\\+?))\\d)+\\s)+((\\-|\\+?)\\d+)$"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.FindGreatestSumOfSubArray(strs));
	}
	
	/**
	 * 丑数
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("GetUglyNumber_Solution")
	public @ResponseBody String GetUglyNumber_Solution(String yourInput){
		 int n=Integer.parseInt(yourInput);
		if(!isRightable(yourInput,"(\\d)+"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.GetUglyNumber_Solution(n));
	}
	
	/**
	 * 二维数组中的查找
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("Find")
	public @ResponseBody String Find(String yourInput){
		   String[] str=yourInput.split(",");
			int[][] s=new int[str.length-1][str[0].length()-1];
			for(int j=0;j<str.length-1;j++){
				String[] strs=str[j].split(" ");
			 for(int i=0;i<str[j].length()-1;i++){
	       s[j][i]=Integer.parseInt(strs[i]);
			 }
			}
		if(!IsFind(s))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.Find(Integer.parseInt(str[str.length-1]), s));
	}
	
	/**
	 * 斐波那契数列
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("Fibonacci")
	public @ResponseBody String Fibonacci(String yourInput){
		 int n=Integer.parseInt(yourInput);
		if(!isRightable(yourInput,"(\\d)+"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.Fibonacci(n));
	}
	
	/**
	 * 跳台阶
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("JumpFloor")
	public @ResponseBody String JumpFloor(String yourInput){
		 int n=Integer.parseInt(yourInput);
		if(!isRightable(yourInput,"(\\d)+"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.JumpFloor(n+1));
	}
	
	/**
	 * 变态跳台阶
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("JumpFloorII")
	public @ResponseBody String JumpFloorII(String yourInput){
		 int n=Integer.parseInt(yourInput);
		if(!isRightable(yourInput,"(\\d)+"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.JumpFloorII(n));
	}

	
	/**
	 * 矩形覆盖
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("RectCover")
	public @ResponseBody String RectCover(String yourInput){
		 int n=Integer.parseInt(yourInput);
			if(!isRightable(yourInput,"(\\d)+"))
				return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.RectCover(n));
	}
	
	/**
	 * 左旋转字符串 
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("LeftRotateString")
	public @ResponseBody String LeftRotateString(String yourInput){
		if(!isRightable(yourInput,"((\\w)+\\s)(\\d+)$"))
			return JSON.toJSONString("error");
		String str[]=yourInput.split(" ");
		int n=Integer.parseInt(str[1]);
		return JSON.toJSONString(algorithmsService.LeftRotateString(str[0], n));
	}
	
	/**
	 * 翻转单词顺序列
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("ReverseSentence")
	public @ResponseBody String ReverseSentence(String yourInput){
		if(!isRightable(yourInput,"((\\w)+\\s)(\\d+)$"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.ReverseSentence(yourInput));
	}
	
	/**
	 * 扑克牌顺子
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("isContinuous")
	public @ResponseBody String isContinuous(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		int[] count=new int[str.length];
		for(int i=0;i<str.length;i++)
			count[i]=Integer.parseInt(str[i]);
		if(!Continuous(count))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.isContinuous(count));
		
	}
	
	/**
	 * 求1+2+3+...+n
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("Sum_Solution")
	public @ResponseBody String Sum_Solution(String yourInput){
		boolean isRight=yourInput.matches("(\\d)+");
		 int n=Integer.parseInt(yourInput);
		if(!isRight||n<0)
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.Sum_Solution(n));
	}
	
	/**
	 * 不用加减乘除做加法
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("Add")
	public @ResponseBody String Add(String yourInput){
		if(!isRightable(yourInput,"(\\d)+\\s(\\d)+$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		return JSON.toJSONString(algorithmsService.Add(Integer.parseInt(str[0]), Integer.parseInt(str[1])));		
	}
	
	/**
	 * 数组中重复的数字
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("duplicate")
	public @ResponseBody String duplicate(String yourInput){
		if(!isRightable(yourInput,"(\\d)+\\s(\\d)+$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		int[] d=new int[2];
		return JSON.toJSONString(algorithmsService.duplicate(strs, strs.length,d)+","+d[0]);
		
	}
	
	/**
	 * 正则表达式匹配
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("matchRegCore")
	public @ResponseBody String matchRegCore(String yourInput){
		if(!isRightable(yourInput,"(\\w)+\\s(.)+$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		return JSON.toJSONString(algorithmsService.match(str[0].toCharArray(), str[1].toCharArray()));
	}
	
	/**
	 * 表示数值的字符串
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("isNumeric")
	public @ResponseBody String isNumeric(String yourInput){
		if(!isRightable(yourInput,"(.)+$"))
			return JSON.toJSONString("error");
		return JSON.toJSONString(algorithmsService.isNumeric(yourInput.toCharArray()));
	}
	
	/**
	 * 字符流中第一个不重复的字符
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("FirstAppearingOnce")
	public @ResponseBody String FirstAppearingOnce(String yourInput){
		if(!isRightable(yourInput,"(\\w)+"))
			return JSON.toJSONString("error");
		char[] c=yourInput.toCharArray();
		for(char s:c){
			algorithmsService.Insert(s);
		 }
		return JSON.toJSONString(algorithmsService.FirstAppearingOnce());
	}
	
	/**
	 * 滑动窗口的最大值
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("maxInWindows")
	public @ResponseBody String maxInWindows(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length-1];
		for(int i=0;i<str.length-1;i++)
			strs[i]=Integer.parseInt(str[i]);
		ArrayList<Integer> array=algorithmsService.maxInWindows(strs, Integer.parseInt(str[str.length-1]));
		StringBuffer sb=new StringBuffer();
		 for(Integer s:array){
			sb.append(s+" ");
		}
		 return JSON.toJSONString(sb.toString());
	}
	
	/**
	 * 和为S的连续正数序列
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("FindContinuousSequence")
	public @ResponseBody String FindContinuousSequence(String yourInput){
		if(!isRightable(yourInput,"(\\d)+"))
			return JSON.toJSONString("error");
		ArrayList<ArrayList<Integer> > list=algorithmsService.FindContinuousSequence(Integer.parseInt(yourInput));
		StringBuffer sb=new StringBuffer();
		for(ArrayList<Integer> a:list){
			for(Integer s:a){
				sb.append(s+" ");
			}
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		return JSON.toJSONString(sb.toString());
	}
	
	/**
	 * 和为S的两个数字
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("FindNumbersWithSum")
	public @ResponseBody String FindNumbersWithSum(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length-1];
		for(int i=0;i<str.length-1;i++)
			strs[i]=Integer.parseInt(str[i]);
		ArrayList<Integer> list=algorithmsService.FindNumbersWithSum(strs, Integer.parseInt(str[str.length-1]));
		StringBuilder sb=new StringBuilder();
		if(!list.isEmpty()){
		for(Integer a:list)
			sb.append(a+" ");
		}
		else{
			sb.append("不存在");
		}
		return JSON.toJSONString(sb.toString());
	}
	
	/**
	 * 数组中只出现一次的数字 
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("FindNumsAppearOnce")
	public @ResponseBody String FindNumsAppearOnce(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length];
		for(int i=0;i<str.length;i++)
			strs[i]=Integer.parseInt(str[i]);
		if(!isFindNumsAppearOnce(strs))	
			return JSON.toJSONString("error");
		int[] num1=new int[1];
		int[] num2=new int[1];
		algorithmsService.FindNumsAppearOnce(strs, num1, num2);
		return JSON.toJSONString(num1[0]+" "+num2[0]);
	}
	
	/**
	 * 数字在排序数组中出现的次数 
	 * @param yourInput
	 * @return
	 */	
	@RequestMapping("GetNumberOfK")
	public @ResponseBody String GetNumberOfK(String yourInput){
		if(!isRightable(yourInput,"((\\d)+\\s)+(\\d+)$"))
			return JSON.toJSONString("error");
		String[] str=yourInput.split(" ");
		int[] strs=new int[str.length-1];
		Integer[] s=new Integer[str.length-1];
		for(int i=0;i<strs.length;i++){
			strs[i]=Integer.parseInt(str[i]);
			s[i]=Integer.parseInt(str[i]);
		}
		if(!this.compare(s))
			return JSON.toJSONString("error");
		    Arrays.sort(strs);
		    return JSON.toJSONString(algorithmsService.GetNumberOfK(strs, Integer.parseInt(str[str.length-1])));
		    
	}
	
	/**得到二叉树头结点**/
	private TreeNode<String> getTreeHead(String[] str) {
		TreeNode<String> root=new TreeNode<String>(str[0]);
		 List<String> list=new ArrayList<String>();
		 for(int i=1;i<str.length;i++)
			 list.add(str[i]);
		  TreeNode<String> head=createTree(root,list);
		return head;
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

	/**验证输入的数据格式**/
	private boolean isRightable(String yourInput,String match) {
		boolean isRight=yourInput.matches(match);		
		return isRight==true?true:false;
	}

	/**构造链表结点**/
	private ListNode<String> CreateListNodeHead(String yourInput) {
		String[] str=yourInput.split(",");
		ListNode<String> head=new ListNode<String>(str[0]);
		ListNode<String> top=head;
		ListNode<String> node=null;
		for(int i=1;i<str.length;i++)
		{
			node=new ListNode<String>(str[i]);
			top.next=node;
			top=top.next;			
		}
		return head;
	}
	
	private ListNode<Integer> createIntNode(String yourInput){
		String[] str=yourInput.split(" ");
		ListNode<Integer> head=new ListNode<Integer>(Integer.parseInt(str[0]));
		ListNode<Integer> top=head;
		ListNode<Integer> node=null;
		for(int i=1;i<str.length;i++)
		{
			node=new ListNode<Integer>(Integer.parseInt(str[i]));
			top.next=node;
			top=top.next;			
		}
		return head;
	}
	
	 //根据根节点创建完全二叉树  
    private TreeNode createTree(TreeNode root, List<String> list) {  
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
        int count = 0;  
        while (!queue.isEmpty() && count < list.size()) {  
            TreeNode lastNode = queue.poll();  
  
            if (count < list.size()) {  
                TreeNode left = new TreeNode(list.get(count++));  
                lastNode.left = left;  
                queue.add(left);  
            }  
            if (count < list.size()) {  
  
                TreeNode right = new TreeNode(list.get(count++));  
                lastNode.right = right;  
                queue.add(right);  
            }  
        }  
        return root;  
    }  
	
	
	/**从小到大排列**/
	private boolean compare(Integer[] str){
		for(int i=0;i<str.length-1;i++){
			if(str[i+1]<str[i])
				return false;
		}
		return true;
	}
	
	/**字符变整数**/
	private Integer[] changeToInt(String[] str){
		Integer[] strs=new Integer[str.length];
		for(int i=0;i<str.length;i++){
			strs[i]=Integer.parseInt(str[i]);
		}
		return strs;
	}
	
	private boolean isminNumberInRotateArray(int[] array){
		int k=0;
		boolean flag=true;
		for(int i=1;i<array.length&&flag;i++){
			if(array[i-1]>array[i]){
				flag=false;
				k=i;
			}
		}
		if(k!=array.length-1){
			for(int j=k;j<array.length-1;j++){
				if(array[j]>array[j+1]){
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean IsFind(int[][] array){
		for(int i=0;i<array.length-1;i++)
		 for(int j=0;j<array[0].length-1;j++){
			 if(array[i][j]>array[i][j+1])
				 return false;
			 if(array[j][i]>array[j+1][i])
				 return false;
		 }
		return true;
	}
	
	private boolean Continuous(int[] str){
		String strs="0,1,2,3,4,5,6,7,8,9,10,11,12,13";
		 Arrays.sort(str);
		 int count=0;
		 for(int i=0;i<str.length-1;i++){
			 if(str[i]==str[i+1])
				 count++;
		 }
		 if(count>1){
			 return false;
		 }
		for(int j=0;j<str.length;j++)
		{
			if(!strs.contains(String.valueOf(str[j]))){
				return false;
			}
		}
		return true;
	}
	
	private boolean isFindNumsAppearOnce(int[] num){
		Arrays.sort(num);
		int count=0;
		if(num[0]==num[1])
			count++;
		for(int j=1;j<num.length-1;j++){
			if(num[j]==num[j-1]||num[j]==num[j+1]){
				count++;
			}
		}
		if(count==num.length-2)return true;
		return false;
			
	}
	
}

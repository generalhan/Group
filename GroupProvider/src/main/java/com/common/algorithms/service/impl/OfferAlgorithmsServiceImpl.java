package com.common.algorithms.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

import com.common.algorithms.modal.ListNode;
import com.common.algorithms.service.OfferAlgorithmsService;
import com.common.algorithms.modal.TreeNode;

public class OfferAlgorithmsServiceImpl implements OfferAlgorithmsService {

	private ArrayList<String> list=new ArrayList<String>();
	//从尾到头打印链表
	public ArrayList<String> printListFromTailToHead(ListNode<String> listNode) {	
		if(listNode!=null)
		{
			if(listNode.next!=null){
			printListFromTailToHead(listNode.next);
			}
			list.add(listNode.val);
		}		
		return list;
	}

	//二进制中1的个数
		 public int NumberOf1(int n){
			 int sum=0;
			 while(n!=0){
				 sum++;
				 n=n&(n-1);
			 }
			 return sum;
		 }
		 
		 //替换空格 
		 public String replaceSpace(StringBuffer str) {
		    	if(str==null)
		            return null;
		        StringBuffer sb=new StringBuffer();
		         for(int i=0;i<str.length();i++)
		             {
		             if(str.charAt(i)==' ')
		                 {
		                 sb.append("%");
		                 sb.append("2");
		                 sb.append("0");
		             }
		             else{
		                 sb.append(str.charAt(i));
		             }
		         }
		        return sb.toString();
		    }
		 
		 //数值的整数次方 
		 public double Power(double base, int exponent) {
		      double sum = 0, temp = base;
		        if (exponent == 0) {
		            return 1;
		        }
		        if (exponent == 1) {
		            return base;
		        }
		        if (exponent > 1) {
		            for (int i = 1; i < exponent; i++) {
		                sum = temp * base;
		                temp = sum;
		            }
		        } else {
		            for (int i = -1; i > exponent; i--) {
		                sum = temp * base;
		                temp = sum;
		            }
		            sum = 1/sum;	 
		        }	 
		        return sum;       
		  }
		 
		 //调整数组顺序使奇数位于偶数前面
		 public void reOrderArray(int [] array) {
		        List<Integer> list1=new ArrayList<Integer>();
		         List<Integer> list2=new ArrayList<Integer>();
		          for(int i=0;i<array.length;i++){
		              if(!isEven(array[i]))
		                  list1.add(array[i]);
		              else{
		                  list2.add(array[i]);
		              }
		          }
		        list1.addAll(list2);
		        for(int i=0;i<array.length;i++)
		            array[i]=list1.get(i);
		    }
		    //判断是否是偶数
		    private boolean isEven(int i){
		        if((i&0x1)==0)
		            return true;
		        else return false;
		    }
		    
		   //链表中倒数第k个结点 
		    public ListNode<String> FindKthToTail(ListNode head,int k) {
		        if(head==null||k<=0)
		            return null;
		        ListNode<String> pre=head;
		        ListNode<String> behind=head;
		        for(int i=0;i<k-1;i++){
		            if(pre.next!=null){               
		               pre=pre.next;    
		            }else{
		                return null;
		            }
		    }
		    while(pre.next!=null){
		        pre=pre.next;
		        behind=behind.next;      
		    }
		    return behind;
		}
		    
		    //反转链表 
		    public ListNode ReverseList(ListNode head) {
		        ListNode phead=null;
		        ListNode currentNode=head;
		        ListNode pre=null;
		        while(currentNode!=null){
		          ListNode nextNode=currentNode.next;
		            if(nextNode==null)
		                phead=currentNode;
		            currentNode.next=pre;
		            pre=currentNode;
		            currentNode=nextNode;
		        }
		        return phead;
		    }
		    
		    //合并两个排序的链表
		    public ListNode<Integer> Merge(ListNode<Integer> list1,ListNode<Integer> list2) {
		        if(list1==null)return list2;
		         if(list2==null)return list1;
		          ListNode<Integer> list=null;
		         if(list1.val<list2.val)
		             {
		             list=list1;
		             list.next=Merge(list1.next,list2);
		         }
		         else{
		             list=list2;
		             list.next=Merge(list1,list2.next);
		         }
		         return list;
		     }
		    
		//树的子结构
		    public boolean HasSubtree(TreeNode<String> root1,TreeNode<String> root2) {
		        
		        boolean flag=false;
		         if(root1!=null&&root2!=null){
		             if(root1.value.equals(root2.value)){
		                 flag=nodesIsEquals(root1,root2);}
		             if(!flag){
		                 flag=HasSubtree(root1.left,root2);}
		             if(!flag){
		                 flag=HasSubtree(root1.right,root2);}
		         }
		        return flag;
		        
		    }
		    
		    
		    private boolean nodesIsEquals(TreeNode root1,TreeNode root2){
		        if(root2==null)
		            return true;
		        if(root1==null)
		            return false;
		        if(!root1.value.equals(root2.value))
		            return false;
		        return nodesIsEquals(root1.left,root2.left)&&nodesIsEquals(root1.right,root2.right);
		        	    }
		
	      //二叉树的镜像 
		    public void Mirror(TreeNode root) {
		        if(root==null||(root.left==null&&root.right==null))
		            return;
		        TreeNode temp=root.left;
		         root.left=root.right;
		          root.right=temp;
		        if(root.left!=null)
		            Mirror(root.left);
		        if(root.right!=null)
		            Mirror(root.right);
		    }  
		    
		    //从上往下打印二叉树 
		    public ArrayList<String> PrintFromTopToBottom(TreeNode<String> root) {
		        ArrayList<String> list=new ArrayList<String>();
		         if(root==null)
		             return list;
		        Deque<TreeNode> deque=new LinkedList<TreeNode>();
		         deque.add(root);
		        while(!deque.isEmpty())
		            {
		            TreeNode temp=deque.pop();
		             list.add((String) temp.value);
		            if(temp.left!=null)
		                deque.add(temp.left);
		            if(temp.right!=null)
		                deque.add(temp.right);
		        }
		        return list;
		    }
		    
		    //二叉搜索树的后序遍历序列 
		    public boolean VerifySquenceOfBST(int [] sequence) {
		    	   int count=sequence.length;
		    	        if(count==0)
		    	            return false;
		    	        return isRight(sequence,0,count-1);
		    	          
		    	    }
		    	      
		    public boolean isRight(int[] sequence,int start,int end){
		    	        if(start>=end) return true;
		    	        int i=end-1;
		    	        while(sequence[i]>sequence[end]&&i>start) i--;
		    	          for(int j=start;j<i;j++){
		    	              if(sequence[j]>sequence[end])
		    	                  return false;
		    	          }
		    	        return isRight(sequence,start,i)&&isRight(sequence,i+1,end-1); 	          
		    	    }
		    
		   //二叉树的深度
		    public int TreeDepth(TreeNode root) {
		        if(root==null)
		            return 0;
		        int leftTreeDepth=TreeDepth(root.left);
		        int rightTreeDepth=TreeDepth(root.right);
		        return leftTreeDepth>rightTreeDepth?leftTreeDepth+1:rightTreeDepth+1;
		    }
		    
		    //平衡二叉树 
		    public boolean IsBalanced_Solution(TreeNode root) {
		        if(root==null)return true;
		        int left=TreeDepth(root.left);
		        int right=TreeDepth(root.right);
		        int dir=left-right;
		        if(dir<-1||dir>1)return false;
		        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
		    }
		    
		   //序列化二叉树
		  public  String Serialize(TreeNode root) {
		        
		        StringBuilder sb=new StringBuilder();
		          if(root==null){
		              sb.append("$"+",");
		                  return sb.toString();
		          }
		         sb.append(root.value+",");
		          sb.append(Serialize(root.left));
		           sb.append(Serialize(root.right));
		         return sb.toString();
		         
		   }
		     
		  //反序列化二叉树
		     int n=-1;
		   public  TreeNode Deserialize(String str) {
		        n++;
		         if(str.length()<=n)
		             return null;
		          TreeNode node=null;
		         String s[]=str.split(",");
		          if(!s[n].equals("$")){
		              node=new TreeNode(Integer.parseInt(s[n]));
		               node.left=Deserialize(str);
		                node.right=Deserialize(str);
		          }
		         return node;
		   }
		
	      //字符串的排列 
		   public ArrayList<String> Permutation(String str) {
		       ArrayList<String> list=new ArrayList<String>();
		       if(str==null||str.length()<0)
		       return list;
		          list=permitution(list,str.toCharArray(),0,str.length());
		         Collections.sort(list);
		         return list;
		    }
		    
		    private ArrayList<String> permitution(ArrayList<String> list,char[] str,int begin,int length)
		   {
		          if(begin==length-1)
		 {
		            if(!list.contains(str))
		        list.add(String.valueOf(str));
		}
		       else{
		         for(int i=begin;i<length;i++){
		         if(i==begin||str[i]!=str[begin]){
		           swap(str,begin,i);
		        permitution(list,str,begin+1,length);
		           swap(str,begin,i);
		}
		}
		}
		return list;
		}
		    public void swap(char[] str,int begin,int i){
		char temp=str[i];
		str[i]=str[begin];
		str[begin]=temp;
		}
		   
		    
		    
		    //先序遍历
		    public void preOrder(TreeNode<String> node,List<String> list){
		    	if(node!=null){
		    		list.add(node.value);
		    		preOrder(node.left,list);
		    		preOrder(node.right,list);
		    	}
		    }
		    
		    //约瑟夫环
		    public int CountnQuit(int total,int n){
		    	boolean[] arr=new boolean[total];
		    	 for(int i=0;i<total;i++)
		    		 arr[i]=true;
		    	 int len=arr.length;
		    	 int index=0;
		    	 int count=0;
		    	 while(len>1){
		    		 if(arr[index]==true)
		    		 {
		    			 count++;
		    			 if(count==n){
		    				 count=0;
		    				 arr[index]=false;
		    				 len--;
		    			 }
		    		 }
		    		 index++;
		    		 if(index==arr.length)
		    			 index=0;
		    	 }
		    	for(int i=0;i<arr.length;i++)
		    		if(arr[i]==true)
		    	      return i+1;
				return 0;
		    }
		    
		    //栈的压入弹出序列 
		    public boolean IsPopOrder(int [] pushA,int [] popA) {
		        if(pushA.length==0||popA.length==0)
		            return false;
		          Stack<Integer> stack=new Stack<Integer>();
		          int index=0;
		          for(int i=0;i<pushA.length;i++){
		              stack.push(pushA[i]);
		              while(!stack.isEmpty()&&stack.peek()==popA[index]){
		                  stack.pop();
		                  index++;
		              }
		          }
		          return stack.isEmpty();
		      }
		    
		    //用两个栈实现队列
		   private Stack<Integer> stack1 = new Stack<Integer>();
		   private Stack<Integer> stack2 = new Stack<Integer>();
		    
		    public void push(int node) {
		        stack1.push(node);
		    }
		    
		    public int pop() {
		    if(stack2.isEmpty()){
		        while(!stack1.isEmpty()){
		            stack2.push(stack1.pop());
		        }
		    }
		        
		        return stack2.pop();
		    }
		    
		    //包含min函数的栈
		   private Stack<Integer> m_data=new Stack<Integer>();
			 private  Stack<Integer> m_min=new Stack<Integer>();
		    
		    public void pushs(int node) {
		        		   m_data.push(node);	   
				    if(m_min.size()==0||node<m_min.peek())
				    	m_min.push(node);
				    else{
				    	m_min.push(m_min.peek());
				    }
		    }
		    
		    public void pops() {
		        if(m_data.size()>0&&m_min.size()>0)
				   {
					   m_data.pop();
					   m_min.pop();
				   }
		    }
		    
		    public int top() {
		        		   if(m_data.size()>0&&m_min.size()>0)
				   {
					return  m_data.peek();
					  
				   }
		        return 0;
		    }
		    
		    public int min() {
		        		   if(m_data.size()>0&&m_min.size()>0)
					   return m_min.pop();
				   return 0;
		    }
		    
		    //旋转数组的最小数字
		    public int minNumberInRotateArray(int [] array) {
		          if(array==null||array.length<=0)
		              return 0;
		        int low=0;
		        int high=array.length-1;
		        int mid=low;
		        while(array[low]>=array[high]){
		            if(high-low==1){
		                return array[high];
		            }
		                mid=(high+low)/2;
		            if(array[low]==array[high]&&array[mid]==array[high]){
		                
		            }
		            if(array[mid]>=array[low]){
		                low=mid;
		            }
		            else if(array[mid]<=array[high]){
		                high=mid;
		            }
		        }
		        return array[mid];           
		    }
		    
		    //最小的K个数 
		    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		          ArrayList<Integer> list=new ArrayList<Integer>();
		        if(k<0||k>input.length)
		            return list; 
		        TreeSet<Integer> s=new TreeSet<Integer>();
		        for(int i=0;i<input.length;i++){
		        	if(s.size()<k){
		        		s.add(input[i]);
		        	}else{
		        		if(input[i]<s.last()){
		        			s.remove(s.last());
		        			s.add(input[i]);
		        		}
		        	}
		        }
		        Iterator<Integer> it=s.iterator();
		        while(it.hasNext()){
		        	list.add(it.next());
		        }
		        return list;
		    }
		    
		   //把数组排成最小的数  
		    public String PrintMinNumber(int [] numbers) {
		        if(numbers==null||numbers.length<=0)return "";
		          String[] strs=new String[numbers.length];
		          for(int i=0;i<numbers.length;i++)
		              strs[i]=numbers[i]+"";
		          StringBuilder sb=new StringBuilder();
		          Arrays.sort(strs,new Comparator<String>(){
		              public int compare(String o1,String o2){
		                  return (o1+o2).compareTo(o2+o1);
		              }
		          });
		          for(int i=0;i<strs.length;i++)
		              sb.append(strs[i]);
		          return sb.toString();
		      }
		    
		    //数组中出现次数超过一半的数字 
		    public int MoreThanHalfNum_Solution(int [] array) {
		        int count=0;
		        int temp=0;
		        for(int j=0;j<array.length;j++){
		        for(int i=j;i<array.length;i++){
		            temp=array[j];
		            if(temp==array[i]){
		                count++;
		            }
		            if(count>array.length/2){
		                return temp;
		            }
		            if(j>array.length/2)
		                return 0;
		        }
		                count=0;
		        }
		        return 0;
		    }
		    
		    //整数中1出现的次数（从1到n整数中1出现的次数）
		    public int NumberOf1Between1AndN_Solution(int n) {
		        if(n==0) return 0;
		         if(n<=9)return 1;
		         int number=0;
		         for(int i=1;i<=n;i++)
		             number+=NumberOfone(i);
		         return number;
		         
		     }
		         
		     private int NumberOfone(int n){
		         int number=0;
		         while(n>0){
		             if(n%10==1)number++;
		             n=n/10;
		         }
		         return number;
		     }
		    
		     //第一个只出现一次的字符
		    public int FirstNotRepeatingChar(String str) {
		    	if(str==null||str.equals(" "))return 0;
		    	char[] ch=str.toCharArray();
		    	HashMap<Character, Integer> hash=new HashMap<Character, Integer>();
		    	for(char c:ch){
		    		if(hash.get(c)!=null){
		    			hash.put(c, hash.get(c)+1);
		    		}else{
		    			hash.put(c, 1);
		    		}
		    	}
		    	for(int i=0;i<ch.length;i++){
		    		if(hash.get(ch[i])==1)
		    			return i+1;
		    	}
		        return 0;
		    }
		    
		    //连续子数组的最大和 
		    public int FindGreatestSumOfSubArray(int[] array) {
		        if(array.length==0)
		            return 0;
		        else{
		            int total=array[0],maxSum=array[0];
		            for(int i=1;i<array.length;i++){
		                if(total>=0)
		                    total+=array[i];
		                else{
		                    total=array[i];
		                }
		                if(total>maxSum)
		                    maxSum=total;
		            }
		            return maxSum;
		        }
		    }
		    
		    //丑数
		    public int GetUglyNumber_Solution(int index) {
		        if(index<=0)return 0;
		        int[] ugly=new int[index];
		        ugly[0]=1;
		        int count=1;
		        int num2=0;
		        int num3=0;
		        int num5=0;
		        while(count<index){
		            int min=IsUglyNumber(ugly[num2]*2,ugly[num3]*3,ugly[num5]*5);
		            ugly[count]=min;
		            count++;
		            if(min==ugly[num2]*2)
		                num2++;
		            if(min==ugly[num3]*3)
		                num3++;
		            if(min==ugly[num5]*5)
		                num5++;
		        }    
		        return ugly[index-1];
		    }
		    
		    private int IsUglyNumber(int num2,int num3,int num5){
		        int min=num2<num3?num2:num3;
		        return min<num5?min:num5;
		    }
		    
		    //二维数组中的查找
		    public boolean Find(int target, int [][] array) {
		        boolean found=false;
		        int rows=array.length;
		        int colums=array[0].length;
		        int row=0;
		        int colum=colums-1;
		        while(row<rows&&colum>=0){
		            if(array[row][colum]==target){
		                found=true;
		                return found;
		            }
		            else if(array[row][colum]<target)
		                row++;
		            else
		                colum--;
		        }
		        return found;
		    }
		    
		    //斐波那契数列 
		    public int Fibonacci(int n) {
				int result=0;
				int preOne=0;
				int preTwo=1;
				if(n==0){
					return preOne;
				}
				if(n==1){
					return preTwo;
				}
				for(int i=1;i<=n;i++)
				{
					preOne=preTwo;
					preTwo=result;
					result=preOne+preTwo;
				}
				return result;
		    }
		    
		    //跳台阶
		    public int JumpFloor(int target) {
		          int[] r={0,1,2};
		          if(target<0)
		        	  return -1;
		        if(target<=2&&target>=0)
		            return r[target];
		          int one=1;
		          int two=2;
		          int result=0;
		        for(int i=3;i<=target;i++){
		            result=one+two;
		            one=two;
		            two=result;
		        }
		        return result;
		    }
		    
		    //变态跳台阶 
		    public int JumpFloorII(int target) {
		        if(target<=0)return -1;
		        if(target==1) return 1;
		        return 2*JumpFloorII(target-1);
		    }
		    
		   //矩形覆盖 
		    public int RectCover(int target) {
		    	 if(target<=0)return 0;
		    	        if(target==1||target==2)
		    	            return target;
		    	        return RectCover(target-1)+RectCover(target-2);
		    	    }
		    
		    //左旋转字符串 
		    public String LeftRotateString(String str,int n) {
		        if(str==null||str.equals("")||n>str.length())
		            return "";
		        if(n==0)
		            return str;
		        	char[] s1=new char[n];
				char[] s2=new char[str.length()-n];
				char[] s3=str.toCharArray();
				for(int i=0;i<str.length();i++){
					if(i>=0&&i<n)
						s1[i]=s3[i];
					else
						s2[i-n]=s3[i];
				}
				StringBuffer sb=new StringBuffer(str.length());
				for(int i=0;i<s2.length;i++)
					sb.append(s2[i]);
				for(int i=0;i<s1.length;i++)
					sb.append(s1[i]);
		        return sb.toString();
		    }
		    
		    //翻转单词顺序列
		    public String ReverseSentence(String str) {
		        if(str == null){ return null;}
		         if(str.trim().equals("")){
		            return str;
		        }
		            String[] s=str.split(" ");
				StringBuffer sb=new StringBuffer(s.length);
				for(int i=s.length-1;i>=0;i--){
					if(i!=0)
					sb.append(s[i]+" ");
					else
						sb.append(s[i]);
				}
		        return sb.toString();
		    }
		    
		   //扑克牌顺子 
		    public boolean isContinuous(int [] numbers) {
		          if(numbers==null)
		              return false;
		        Arrays.sort(numbers);
		        int i=0,zero=0;
		        for(;i<numbers.length&&numbers[i]==0;i++)
		            zero++;
		        for(;i<numbers.length-1&&zero>=0;i++){
		            if(numbers[i]==numbers[i+1])
		                return false;
		            if(numbers[i]+1+zero>=numbers[i+1]){
		                zero-=numbers[i+1]-numbers[i]-1;
		            }
		            else
		                return false;
		        }
		        if(i==numbers.length -1)
		            return true;
		        else
		            return false;
		    }
		    
		    //求1+2+3+...+n 
		    private int result=0;
		    public int Sum_Solution(int n) {
		        cale(n);
		        return result;
		    }
		    
		    private boolean cale(int n){
		        result+=n;
		        return n!=0&&cale(n-1);
		    }
		    
		    //不用加减乘除做加法
		    public int Add(int num1,int num2) {
		        int sum,carry;
		        do{
		            sum=num1^num2;
		            carry=(num1&num2)<<1;
		            num1=sum;
		            num2=carry;
		        }while(num2!=0);
		        return num1;
		    }
		    
		    //数组中重复的数字
		    // Parameters:
		    //    numbers:     an array of integers
		    //    length:      the length of array numbers
		    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
		    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
		    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
		    // Return value:       true if the input is valid, and there are some duplications in the array number
		    //                     otherwise false
		    public boolean duplicate(int numbers[],int length,int [] duplication) {
		        if(length==0||numbers==null)
		        {
		            duplication[0]=-1;
		            return false;
		        }
		           Arrays.sort(numbers);
		           for(int i=0;i<numbers.length-1;i++){
		               if(numbers[i]==numbers[i+1])
		               {
		                   duplication[0]=numbers[i];
		                   return true;
		               }
		           }
		        return false;
		    }
		    
		    //正则表达式匹配
		    public boolean match(char[] str,char[] pattern){
				if(str==null||pattern==null)
					return false;
				return matchRegCore(str,0,str.length,pattern,0,pattern.length);
			}
			
			private boolean matchRegCore(char[] str,int i,int length1,char[] pattern,int j,int length2){
				if(i==length1&&j==length2){
					if(j==length2||pattern[j]=='*')
						return true;
					else
						return false;
				}
				if(i!=length1&&j==length2)
					return false;
				if(j+1<length2&&pattern[j+1]=='*'){
					if(i<length1&&(pattern[j]==str[i]||pattern[j]=='.')){
						return matchRegCore(str,i+1,length1,pattern,j,length2)||
								matchRegCore(str,i+1,length1,pattern,j+2,length2)||
								matchRegCore(str,i,length1,pattern,j+2,length2);
					}else{
						return matchRegCore(str,i,length1,pattern,j+2,length2);
					}
				}
				if(i<length1&&(str[i]==pattern[j]||pattern[j]=='.')){
					return matchRegCore(str,i+1,length1,pattern,j+1,length2);
				}
				return false;
			}
			
			//表示数值的字符串
			public boolean isNumeric(char[] str) {
		        if(str==null||str.length==0)return false;
		        int index=0;
		        int length=str.length;
		        while(index<length&&str[index]==' ')index++;
		        if(index>=length)return false;
		        while(str[length-1]==' ')length--;
		        if(str[index]=='+'||str[index]=='-')index++;
		        if(index>=length)return false;
		        
		        while(index<length&&str[index]>='0'&&str[index]<='9')index++;
		        if(index==length) return true;
		        int index2=index;
		        
		        if(str[index]=='.'){
		        	index++;
		        	if(index==length)return true;
		        	index2=index;
		        	while(index<length&&str[index]>='0'&&str[index]<='9')index++;
		        	if(index==index2) return false;
		        	if(index==length) return true;
		        }
		       
		        if(str[index]=='e'||str[index]=='E'){
		        	index++;
		        	if(index==length)return false;
		        	if(str[index]=='+'||str[index]=='-')index++;
		        	index2=index;
		        	while(index<length&&str[index]>='0'&&str[index]<='9')index++;
		        	if(index==index2) return false;
		        	if(index==length) return true;
		        }
		        	return false;
		    }
			
			//字符流中第一个不重复的字符
			private Map<Character, Integer> map=new HashMap<Character, Integer>();
			  private List<Character> lists=new ArrayList<Character>();
			  
			  //Insert one char from stringstream
			  public void Insert(char ch)
			  {
				  if(!map.containsKey(ch)){
					  map.put(ch, 1);
					  lists.add(ch);
				  }else{
					  map.put(ch, map.get(ch)+1);
					  if(lists.contains(ch))
						  lists.remove(Character.valueOf(ch));
				  }
			      
			  }
			//return the first appearence once char in current stringstream
			  public char FirstAppearingOnce()
			  {
			  if(lists.isEmpty())return '#';
			  return lists.get(0);
			  }
			  
			  //滑动窗口的最大值
			  public ArrayList<Integer> maxInWindows(int [] num, int size)
			    {
					ArrayList<Integer> array=new ArrayList<Integer>();
			        if(num==null||size<=0)return array;
			        int len=num.length;
			        int k=0;
			       while(k+size<=len){
			    	  array.add(maxInWindow(num,k,size));
			    	  k++;
			       }
			   return array;
			        
			    }
			  
			  private int maxInWindow(int[] num,int k,int size){
					int i=k;
					int top=num[k];
					for(;i<k+size;i++){
						if(num[i]>top)
							top=num[i];
					}
						return top;
				}
			  
			  //和为S的连续正数序列 
			  public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
			       ArrayList<ArrayList<Integer>> sqList=new ArrayList<ArrayList<Integer>>();
			        if(sum<3)return sqList;
			        int small=1;
			        int big=2;
			        int curSum=small+big;
			        int middle=(1+sum)/2;
			        while(small<middle){
			            ArrayList<Integer> sq=new ArrayList<Integer>();
			           if(curSum==sum){
			                for(int i=small;i<=big;i++)
			                    sq.add(i);
			            }
			            while(curSum>sum&&small<middle){
			                curSum-=small;
			                small++;
			                if(curSum==sum){
			                for(int i=small;i<=big;i++)
			                    sq.add(i);
			            }
			            }
			 
			        if(sq.size()>0)sqList.add(sq);
			        big++;
			        curSum+=big;
			        }
			        return sqList;
			    }
			  
			  //和为S的两个数字
			  public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
			        ArrayList<Integer> list=new ArrayList<Integer>();
			         ArrayList<Integer> lists=new ArrayList<Integer>();
			        if(array==null||sum<=0) return list;
			        int start=0;
			        int end=array.length-1;
			        int curSum=array[start]+array[end];
			        while(start<end){
			            if(curSum==sum){
			                    list.add(array[start]);
			                    list.add(array[end]);
			                }
			            while(curSum>sum){
			                end--;
			                 curSum=array[start]+array[end];
			                if(curSum==sum){
			                    list.add(array[start]);
			                    list.add(array[end]);
			                }
			            }
			            start++;  
			            curSum=array[start]+array[end];
			        }
			        if(list.size()==0)return list;
			        lists.add(list.get(0));
			        lists.add(list.get(1));
			        return lists;
			    }
			  
			  //数组中只出现一次的数字 
			  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		          ArrayList<Integer> list=new ArrayList<Integer>();
		        for(int i=0;i<array.length;i++){
		            if(list.contains(array[i])){
		                list.remove((Integer)array[i]);
		            }else{
		                list.add(array[i]);
		            }
		        }
		        num1[0]=list.get(0);
		        num2[0]=list.get(1);
		    }
				
		 //数字在排序数组中出现的次数
			  public int GetNumberOfK(int [] array , int k) {
					 int length = array.length;
				        if(length == 0){
				            return 0;
				        }
				        int firstK = getFirstK(array, k, 0, length-1);
				        int lastK = getLastK(array, k, 0, length-1);
				        if(firstK != -1 && lastK != -1){
				             return lastK - firstK + 1;
				        }
				        return 0;
				}
				
				private int getFirstK(int array[],int k,int start,int end){
					if(start>end)return -1;
					 int mid=(start+end)>>1;
					if(array[mid]>k)return getFirstK(array,k,start,mid-1);
					else if(array[mid]<k) return getFirstK(array,k,mid+1,end);
			        else if(mid-1 >=0 && array[mid-1] == k){
			            return getFirstK(array, k, start, mid-1);
			        }
					else return mid;
				}
				
				private int getLastK(int array[],int k,int start,int end){
			        int length = array.length;
					int mid=(start+end)>>1;
					while(start<=end){
						if(array[mid]<k)
							start=mid+1;
						else if(array[mid]>k)
							end=mid-1;
			            else if(mid+1 < length && array[mid+1] == k){
			                start = mid+1;
			            }
						else 
							return mid;
						mid=(start+end)>>1;
					}
					return -1;
				}
		    
		    private int orderSearch(int[] array,int low,int high){
		        int result=array[low];
		        for(int i=low+1;i<=high;i++){
		            if(result>array[i]){
		                result=array[i];	              
		            }
		        }
		            return result;
		    }


		    
		    
	
}

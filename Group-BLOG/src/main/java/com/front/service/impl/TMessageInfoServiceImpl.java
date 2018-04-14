package com.front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.indecorator.TMessageIndecorator;
import com.common.utils.DateUtil;
import com.front.dao.TMessageInfoDao;
import com.front.entity.TMessageInfoEntity;
import com.front.service.TMessageInfoService;
import com.sys.dao.TUserDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;





@Service("tMessageInfoService")
public class TMessageInfoServiceImpl implements TMessageInfoService {
	
	/**读写锁**/
	private ReadWriteLock rwLock=new ReentrantReadWriteLock(); 
	
	@Autowired
	private TMessageInfoDao tMessageInfoDao;
	
	@Autowired
	private TUserDao tUserDao;
	 
	
	//按一定规则取出留言信息
	public List<Stack<TMessageIndecorator>> readAllMessage() {
		try {
			rwLock.readLock().lock();
			return getAllmsg();
		} catch (Exception e) {
			return null;
		}finally{
			rwLock.readLock().unlock();
		}		
	}

	private List<Stack<TMessageIndecorator>> getAllmsg() {
		/**得到顶层父节点集合**/
		List<TMessageInfoEntity> parent=tMessageInfoDao.queryAllParentNodeMessage();	
		 if(parent.size()==0) return null;
		 /**得到所有孩子结点**/
		  List<TMessageInfoEntity> child=tMessageInfoDao.queryNotAllOfParentNodeMessage();
		  TMessageInfoEntity temp=null;	
		  /**保存信息的数据结构**/
		      List<Stack<TMessageIndecorator>> listStack=new ArrayList<Stack<TMessageIndecorator>>();
		  /**复杂度太高，可优化**/
		      Stack<TMessageIndecorator> stack=null;
		   /**通过父节点找到所有子节点,然后放入到栈**/
		      for(int i=0;i<parent.size();i++)
		 {
			  stack=new Stack<TMessageIndecorator>();
			      stack.push(TmsgChangeToIndeco(parent.get(i)));
			          int k=parent.get(i).getPkId();
		               for(int j=0;j<child.size();j++){	
                            if(child.get(j).getParentNode()==k){
                                temp=child.get(j);
		    		            TMessageIndecorator tmg=TmsgChangeToIndeco(temp);
		    		            stack.push(tmg);
		    	}
		    }
		         listStack.add(stack);
		 }		 
		 return listStack;
	}

	//保存留言信息
	public boolean save(TMessageInfoEntity tMessageInfo, boolean isChild, Object obj) {
		try {
			rwLock.writeLock().lock();
			 if(!isChild){
				 tMessageInfo.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
				 tMessageInfo.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
				 tMessageInfoDao.save(tMessageInfo);}
			 else{
				 tMessageInfoDao.save(tmsgIndecoChangeTomsg((TMessageIndecorator)obj));
			 }
			 return true;
			} catch (Exception e) {
				return false;
			}finally{
				rwLock.writeLock().unlock();
			}		
	}
	
	/** 实体类转假包装类***/
	private TMessageIndecorator TmsgChangeToIndeco(TMessageInfoEntity msg){
		TMessageIndecorator tmg=new TMessageIndecorator();
		   Map<Integer, String> map=getUserIdByUserName(getAllUser_id());
		  return msgToindeco(msg, tmg, map);
	}

	private TMessageIndecorator msgToindeco(TMessageInfoEntity msg, TMessageIndecorator tmg, Map<Integer, String> map) {
		if(msg.getReplyNode()!=0){
			  tmg.setReplyName(getUsernameById(msg.getReplyNode(),map));
		 }	
			  tmg.setCurrentName(getUsernameById(msg.getCurrentNode(),map));		   		    
			      tmg.setTime(msg.getGmtCreate().toLocaleString());
			     tmg.setContents(msg.getMessageContent());
			    tmg.setId(msg.getPkId());
			    tmg.setCurrentNode(msg.getCurrentNode());
			     return tmg;
	}
	
	/** 假包装类转实体类***/
	private TMessageInfoEntity tmsgIndecoChangeTomsg(TMessageIndecorator tmsg) throws Exception{
		TMessageInfoEntity msg=new TMessageInfoEntity();
		    Map<Integer, String> map=getUserIdByUserName(getAllUser_id());		 
	            return tmsgIndecTomsg(tmsg, msg, map);
	}

	private TMessageInfoEntity tmsgIndecTomsg(TMessageIndecorator tmsg, TMessageInfoEntity msg,
			Map<Integer, String> map) throws Exception {
		String us=tmsg.getCurrentName().substring(0,tmsg.getCurrentName().length()-3);	       
		msg.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		msg.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
		msg.setMessageContent(tmsg.getContents());		      
		msg.setReplyNode(getIdByUsername(tmsg.getReplyName(),map));		       		     
		msg.setCurrentNode(getIdByUsername(us,map));
		msg.setParentNode(Integer.parseInt(tmsg.getParentName()));		          
      
      return msg;
	}
	
   /**通过用户id得到用户名**/
	private String getUsernameById(int id,Map<Integer,String> map){
		for (Entry<Integer, String> entry : map.entrySet()){
			if(entry.getKey()==id)
			{
				return entry.getValue();
			}
		}
		return null;
	}
	
   /**通过用户名得到用户id**/
	private int getIdByUsername(String str,Map<Integer, String> map){
		for (Entry<Integer, String> entry : map.entrySet()){
			if(entry.getValue().equals(str))
			{
				return entry.getKey().intValue();
			}
		}
		 return 0;
	}
	
	 /**将用户的用户名和id作为map保存，这样搜索就在这里搜索**/
		private Map<Integer, String> getUserIdByUserName(List<Map<String, Object>> list){			 
			String value = null;
		    Integer key=null ;	    
			Map<Integer, String> resultMap = new HashMap<Integer,String>();
		    for (Map<String, Object> map : list) {	  
		      for (Entry<String, Object> entry : map.entrySet()) {
		    	  if ("user_name".equals(entry.getKey())) {
		    	      value = (String) entry.getValue();	    	
		    	      } else if ("pk_id".equals(entry.getKey())) {
		    	          key =  (Integer) entry.getValue();
		    	      }
		      }
		     resultMap.put(key, value);	    
		    }
			return resultMap; 		  
		}
	
   /** 得到所有的用户的id，username属性集**/
	private List<Map<String,Object>> getAllUser_id(){
		return tUserDao.getAllUsersOfMap().size()==0?null:tUserDao.getAllUsersOfMap();   
	}


	
}

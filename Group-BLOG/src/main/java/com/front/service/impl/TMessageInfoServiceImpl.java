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
	
	/**��д��**/
	private ReadWriteLock rwLock=new ReentrantReadWriteLock(); 
	
	@Autowired
	private TMessageInfoDao tMessageInfoDao;
	
	@Autowired
	private TUserDao tUserDao;
	 
	
	//��һ������ȡ��������Ϣ
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
		/**�õ����㸸�ڵ㼯��**/
		List<TMessageInfoEntity> parent=tMessageInfoDao.queryAllParentNodeMessage();	
		 if(parent.size()==0) return null;
		 /**�õ����к��ӽ��**/
		  List<TMessageInfoEntity> child=tMessageInfoDao.queryNotAllOfParentNodeMessage();
		  TMessageInfoEntity temp=null;	
		  /**������Ϣ�����ݽṹ**/
		      List<Stack<TMessageIndecorator>> listStack=new ArrayList<Stack<TMessageIndecorator>>();
		  /**���Ӷ�̫�ߣ����Ż�**/
		      Stack<TMessageIndecorator> stack=null;
		   /**ͨ�����ڵ��ҵ������ӽڵ�,Ȼ����뵽ջ**/
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

	//����������Ϣ
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
	
	/** ʵ����ת�ٰ�װ��***/
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
	
	/** �ٰ�װ��תʵ����***/
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
	
   /**ͨ���û�id�õ��û���**/
	private String getUsernameById(int id,Map<Integer,String> map){
		for (Entry<Integer, String> entry : map.entrySet()){
			if(entry.getKey()==id)
			{
				return entry.getValue();
			}
		}
		return null;
	}
	
   /**ͨ���û����õ��û�id**/
	private int getIdByUsername(String str,Map<Integer, String> map){
		for (Entry<Integer, String> entry : map.entrySet()){
			if(entry.getValue().equals(str))
			{
				return entry.getKey().intValue();
			}
		}
		 return 0;
	}
	
	 /**���û����û�����id��Ϊmap���棬��������������������**/
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
	
   /** �õ����е��û���id��username���Լ�**/
	private List<Map<String,Object>> getAllUser_id(){
		return tUserDao.getAllUsersOfMap().size()==0?null:tUserDao.getAllUsersOfMap();   
	}


	
}

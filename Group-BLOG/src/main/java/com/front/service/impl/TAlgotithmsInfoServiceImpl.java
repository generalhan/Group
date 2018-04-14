package com.front.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.common.characterFactory.CharacterSimpleFactory;
import com.common.datamodel.TBean;
import com.common.utils.DateUtil;
import com.common.utils.IDUtils;
import com.front.dao.TAlgotithmsInfoDao;
import com.front.dao.TAlgotithmsTypeDao;
import com.front.entity.TAlgotithmsInfoEntity;
import com.front.entity.TAlgotithmsTypeEntity;
import com.front.service.TAlgotithmsInfoService;
import com.redis.dao.JedisClient;


@Service("tAlgotithmsInfoService")
public class TAlgotithmsInfoServiceImpl implements TAlgotithmsInfoService {

	@Autowired
	private TAlgotithmsInfoDao tAlgotithmsInfoDao;
	
	@Resource
	private TAlgotithmsTypeDao tAlgotithmsTypeDao;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_ALGORITHMS_LIST_KEY}")
	private String REDIS_ALGORITHMS_LIST_KEY;
	
	@Value("${REDIS_ALGORITHMS_LIST_TBEAN}")
	private String REDIS_ALGORITHMS_LIST_TBEAN;
	
	public void gettest(){
		List<TAlgotithmsInfoEntity> list=tAlgotithmsInfoDao.queryList(null);
		for(TAlgotithmsInfoEntity t: list){
			jedisClient.lpush("REDIS_ALGORITHMS_LIST_KEY", JSON.toJSONString(t));
		}
		String s=JSON.toJSONString(getTBeanBytype(tAlgotithmsTypeDao.queryList(null),new ArrayList<TBean<String>>(),tAlgotithmsInfoDao.queryList(null)));
		jedisClient.set("REDIS_ALGORITHMS_LIST_TBEAN", s);
	}
	
	//�����㷨
	public boolean save(TAlgotithmsInfoEntity tAlgotithmsInfo) {
		try {			
			Map<String, Object> map=new HashMap<String, Object>();
		      map.put("funcName", tAlgotithmsInfo.getFuncName());
		      //����������
		       if(tAlgotithmsInfoDao.queryList(map).size()>0){return false;}
			   savedAvaible(tAlgotithmsInfo);
	                 
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	

	//�õ������㷨����Դ
	public String getAlgotithmsInfoTBean() {
		try {		
			//�ȴ�redis��ȡ������
			if(jedisClient.get(REDIS_ALGORITHMS_LIST_TBEAN)==null){
				throw new Exception();}
			return jedisClient.get(REDIS_ALGORITHMS_LIST_TBEAN);
		} catch (Exception e) {
			try {
				//�ӱ������ݿɿ���ȡ����
				return JSON.toJSONString(getTBeanBytype(tAlgotithmsTypeDao.queryList(null),new ArrayList<TBean<String>>(),tAlgotithmsInfoDao.queryList(null)));
			} catch (Exception e2) {
				return null;
			}
		}
	}
	
	
	//��������ɾѡ���ض��㷨��Ϣ
	public String getAlgotithmsInfoBypkId(Long funcIndex) {
		try {
			
			//�ȴ�redis��ȡ������
			if(getAlgotithmsBypkId(funcIndex,jedisClient.lrange(REDIS_ALGORITHMS_LIST_KEY, 0,-1))==null){throw new Exception();}
			return getAlgotithmsBypkId(funcIndex,jedisClient.lrange(REDIS_ALGORITHMS_LIST_KEY, 0,-1));
		} catch (Exception e) {
			try {
				Map<String, Object> map=new HashMap<String, Object>();
				     map.put("funcIndex", funcIndex);
				     return tAlgotithmsInfoDao.queryList(map).size()>0?JSON.toJSONString(codeRightShow(tAlgotithmsInfoDao.queryList(map).get(0))):null;
			} catch (Exception e2) {
				return null;
			}
		}
	}
	

	/**
	 * ����������redis��ɾѡ���ض��㷨��Ϣ
	 * @param funcIndex
	 * @param redisList
	 * @return
	 */
	private String getAlgotithmsBypkId(Long funcIndex,List<String> redisList){
		try {
			//��ֵ����
			if(redisList==null||redisList.size()==0)return null;
			TAlgotithmsInfoEntity al=null;
			for(String s:redisList){
				 al=JSON.parseObject(s,TAlgotithmsInfoEntity.class);
				 if(al.getFuncIndex()==funcIndex){					 
				    return JSON.toJSONString(codeRightShow(al));
				 }
			}
		} catch (Exception e) {
			return null;
		}	
		return null;
	}

	
	

	/**
	 * redis jsonת����(list)
	 * @param type
	 * @param tbean
	 * @param redisList
	 * @return
	 */
	private synchronized List<TBean<String>> getAlgotithmsInfoByRedis(List<TAlgotithmsTypeEntity> type,List<TBean<String>> tbean,List<String> redisList){
		
		//��ֵ����
		if(redisList==null||redisList.size()==0)return null;
		//jsonת���϶���
		List<TAlgotithmsInfoEntity> list=new LinkedList<TAlgotithmsInfoEntity>();
		TAlgotithmsInfoEntity al=null;
		for(String s:redisList){
			 al=JSON.parseObject(s,TAlgotithmsInfoEntity.class);
			 list.add(al);
		}
		return getTBeanBytype(type, tbean, list);
	}


	/**
	 * �õ�tbeanͨ����
	 * @param type
	 * @param tbean
	 * @param list
	 * @return
	 */
	private synchronized  List<TBean<String>> getTBeanBytype(List<TAlgotithmsTypeEntity> type, List<TBean<String>> tbean,
			List<TAlgotithmsInfoEntity> list) {
		//�Ӽ����а��㷨����ѡ��,���Ż�
		//��Ҫͨ��ɾ���Ѿ�ѡ����������ʱ�临�Ӷ�
			for(int i=0;i<type.size();i++){
				List<TAlgotithmsInfoEntity> typeInfo=new ArrayList<TAlgotithmsInfoEntity>();
				for(int j=0;j<list.size();j++){
					if(list.get(j).getAlgotithmsType()==type.get(i).getPkId()){
						typeInfo.add(list.get(j));
						//list.remove(list.get(j));
					}
				}
				tbean.add(new TBean<String>(typeInfo, type.get(i).getAlgotithmsType()));
			}
	
		return tbean;
	}
	
	   //�����㷨
		private void savedAvaible(TAlgotithmsInfoEntity tAlgotithmsInfo) throws Exception {
			tAlgotithmsInfo.setGmtCreate(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
			    tAlgotithmsInfo.setGmtModified(DateUtil.formatString(DateUtil.getCurrentDateStr(), "yyyy-MM-dd HH:mm"));
			         //������ɺ�������
			         tAlgotithmsInfo.setFuncIndex(IDUtils.genItemId());
			         tAlgotithmsInfoDao.save(tAlgotithmsInfo);
			         tAlgotithmsInfo.setPkId((int) (jedisClient.llen(REDIS_ALGORITHMS_LIST_KEY)+1));
			         jedisClient.lpush(REDIS_ALGORITHMS_LIST_KEY,JSON.toJSONString(tAlgotithmsInfo) );
			         //�洢tbean��redis
			         jedisClient.set(REDIS_ALGORITHMS_LIST_TBEAN,JSON.toJSONString(getAlgotithmsInfoByRedis(tAlgotithmsTypeDao.queryList(null),new ArrayList<TBean<String>>(),jedisClient.lrange(REDIS_ALGORITHMS_LIST_KEY, 0,-1))));
		}
		
		
		/**
		 * ת�������ʽ
		 * @param al
		 * @return
		 */
		private TAlgotithmsInfoEntity codeRightShow(TAlgotithmsInfoEntity al) {
			al.setAlgotithmsCode(changeToRightShow(al.getAlgotithmsCode()));
			 al.setControllerCode(changeToRightShow(al.getControllerCode()));
			 return al;
		}

	/**
	 * �����ת����ȷjson��ʽ
	 * @param result
	 * @return
	 */
	private String changeToRightShow(String result){
		  result = result.replace("\n\r", "<br>  ");
		  result = result.replace("\r\n", "<br>  ");
		 result = result.replace("\t", "    ");
		  result = result.replace(" ", " ");
		 result = result.replace("\"", "'");
		  return result;
	}

}

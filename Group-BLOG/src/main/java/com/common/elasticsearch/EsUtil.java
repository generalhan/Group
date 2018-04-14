package com.common.elasticsearch;

import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.common.pagehelper.Pages;

// es������
public class EsUtil {

	// ��ʼ��һ������ʵ��
	private static GenericObjectPool<Es> pool;

	static {
		// ���������ļ�
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(10);// ���������ֵ
		config.setMaxIdle(10);// ������
		config.setMinIdle(2);// ��С����
		config.setMaxWaitMillis(-1);// ���ȴ�ʱ�䣬-1��ʾһֱ��
		config.setBlockWhenExhausted(true);// �������û�п��ж���ʱ���µĻ�ȡ����������Ƿ�������true������Ĭ��ֵ��true
		config.setTestOnBorrow(false);// �ڴӶ���ػ�ȡ����ʱ�Ƿ��������Ч��true�ǣ�Ĭ��ֵ��false
		config.setTestOnReturn(false);// ���������й黹����ʱ�Ƿ��������Ч��true�ǣ�Ĭ��ֵ��false
		config.setTestWhileIdle(true);// �ڼ����ж����̼߳�⵽������Ҫ�Ƴ�ʱ���Ƿ���������Ч�ԡ�true�ǣ�Ĭ��ֵ��false
		config.setMinEvictableIdleTimeMillis(10 * 60000L); // �ɷ�����ʱ��,10mins
		config.setTestWhileIdle(true); // ���������Ƴ���ʱ���Ƿ�testһ����
		

		pool = new GenericObjectPool<Es>(new EsFactory(), config);
	}

	/**
	 * 
	 * @Description:����ĵ�
	 */
	public static void addDoc(String type, Object id, Object object) {
		Es es = null;
		try {
			es = pool.borrowObject();
			es.addDoc(type, id, object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.returnObject(es);
		}
	}

	/**
	 * 
	 * @Description:�����ĵ�
	 */
	public static void updateDoc(String type, Object id, Object object) {
		Es es = null;
		try {
			es = pool.borrowObject();
			es.updateDoc(type, id, object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.returnObject(es);
		}
	}

	/**
	 * 
	 * @Description:ɾ���ĵ�
	 */
	public static void delDoc(String type, Object id) {
		Es es = null;
		try {
			es = pool.borrowObject();
			es.delDoc(type, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.returnObject(es);
		}
	}

	/**
	 * 
	 * @Description: ��ҳ������ѯ
	 */
	public static Pages getDocHighLight(String keywords, String type, Set<String> fields, int currentPage, int pageSize, boolean isHighlight) {
		Es es = null;
		try {
			es = pool.borrowObject();
			return es.getDocHighLight(keywords, type, fields, currentPage, pageSize, isHighlight);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.returnObject(es);
		}
		return null;
	}

	/**
	 * 
	 * @Description:�ع�����
	 */
	public static void reindex() {
		Es es = null;
		try {
			es = pool.borrowObject();
			es.reindex();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.returnObject(es);
		}
	}

}

package com.common.elasticsearch;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

//���ӹ��������ӵ�һЩ����������ʵ��
public class EsFactory extends BasePooledObjectFactory<Es> {

	// ��������
	@Override
	public Es create() throws Exception {
		return new Es();
	}

	// ��װ����
	@Override
	public PooledObject<Es> wrap(Es arg0) {
		return new DefaultPooledObject<Es>(arg0);
	}

	// ���ٶ���ر�����
	@Override
	public void destroyObject(PooledObject<Es> p) throws Exception {
		p.getObject().close();
		super.destroyObject(p);
	}

	// У������Ƿ�����
	@Override
	public boolean validateObject(PooledObject<Es> p) {
		return p.getObject().validate();
	}
}

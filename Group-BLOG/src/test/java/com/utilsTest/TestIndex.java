package com.utilsTest;

import java.net.InetAddress;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.JsonObject;

public class TestIndex {

	private static String host="116.196.117.113"; // ��������ַ
    private static int port=9300; // �˿�
    
    private TransportClient client=null;
    
    @SuppressWarnings({ "resource", "unchecked" })
	
    public void getCient()throws Exception{
    	client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
    }
    

    public void close(){
    	if(client!=null){
    		client.close();
    	}
    }
    
    /**
     * �������� ����ĵ�
     * @throws Exception
     */

    public void testIndex()throws Exception{
    	JsonObject jsonObject=new JsonObject();
    	jsonObject.addProperty("name", "java���˼��");
    	jsonObject.addProperty("publishDate", "2012-11-11");
    	jsonObject.addProperty("price", 100);
    	
    	IndexResponse response=client.prepareIndex("book", "java", "1")
    		.setSource(jsonObject.toString(), XContentType.JSON).get();
    	System.out.println("�������ƣ�"+response.getIndex());
    	System.out.println("���ͣ�"+response.getType());
    	System.out.println("�ĵ�ID��"+response.getId());
    	System.out.println("��ǰʵ��״̬��"+response.status());
    }
    
    /**
     * ����id��ȡ�ĵ�
     * @throws Exception
     */
    
    public void testGet()throws Exception{
    	GetResponse response=client.prepareGet("testindex", "java", "1").get();
    	System.out.println(response.getSourceAsString());
    }
    
    /**
     * ����id�޸��ĵ�
     * @throws Exception
     */
   
    public void testUpdate()throws Exception{
    	JsonObject jsonObject=new JsonObject();
    	jsonObject.addProperty("name", "java���˼��2");
    	jsonObject.addProperty("publishDate", "2012-11-12");
    	jsonObject.addProperty("price", 102);
    	
    	UpdateResponse response=client.prepareUpdate("book", "java", "1").setDoc(jsonObject.toString(), XContentType.JSON).get();
    	System.out.println("�������ƣ�"+response.getIndex());
    	System.out.println("���ͣ�"+response.getType());
    	System.out.println("�ĵ�ID��"+response.getId());
    	System.out.println("��ǰʵ��״̬��"+response.status());
    }
    
    /**
     * ����idɾ���ĵ�
     * @throws Exception
     */

    public void testDelete()throws Exception{
    	DeleteResponse response=client.prepareDelete("book", "java", "1").get();
    	System.out.println("�������ƣ�"+response.getIndex());
    	System.out.println("���ͣ�"+response.getType());
    	System.out.println("�ĵ�ID��"+response.getId());
    	System.out.println("��ǰʵ��״̬��"+response.status());
    }
	
}

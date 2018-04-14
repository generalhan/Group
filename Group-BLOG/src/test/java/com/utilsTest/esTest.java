package com.utilsTest;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class esTest {

	private static String host="116.196.117.113"; // 服务器地址
    private static int port=9300; // 端口
	
	public static void main(String[] args) throws Exception{
		@SuppressWarnings({ "resource", "unchecked" })
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port));
		System.out.println(client);
		client.close();
	}
}

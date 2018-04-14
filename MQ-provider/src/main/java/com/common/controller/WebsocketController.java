package com.common.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * ����˵����websocket������, ʹ��J2EE7�ı�׼
 */
@ServerEndpoint("/websocket/{myWebsocket}")
public class WebsocketController {
	private static final Logger logger = LoggerFactory.getLogger(WebsocketController.class);

    public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();

    /**
     * ������ʱ����
     * @param myWebsocket
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("myWebsocket") String myWebsocket, Session session){
        System.out.println("���룺"+myWebsocket);
        clients.put(myWebsocket, session);
    }

    /**
     * �յ��ͻ�����Ϣʱ����
     * @param myWebsocket
     * @param message
     * @return
     */
    @OnMessage
    public String onMessage(@PathParam("myWebsocket") String myWebsocket, String message) {
        return "Got your message ("+ message +").Thanks !";
    }

    /**
     * �쳣ʱ����
     * @param myWebsocket
     * @param throwable
     */
    @OnError
    public void onError(@PathParam("myWebsocket") String myWebsocket, Throwable throwable) {
        logger.info("Websocket Connection Exception:" + myWebsocket);
        logger.info(throwable.getMessage(), throwable);
        clients.remove(myWebsocket);
    }

    /**
     * �ر�����ʱ����
     * @param myWebsocket
     */
    @OnClose
    public void onClose(@PathParam("myWebsocket") String myWebsocket) {
        logger.info("Websocket Close Connection:" + myWebsocket);
        clients.remove(myWebsocket);
    }


    /**
     * �����ݴ��ؿͻ���
     * �첽�ķ�ʽ
     * @param myWebsocket
     * @param message
     */
    public static void broadcast(String myWebsocket, String message) {      
    	if (clients.containsKey(myWebsocket)) {
            clients.get(myWebsocket).getAsyncRemote().sendText(message);
        } else {
            throw new NullPointerException("[" + myWebsocket +"]Connection does not exist");
        }
    }

}
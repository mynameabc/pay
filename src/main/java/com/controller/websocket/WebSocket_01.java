package com.controller.websocket;

import lombok.Data;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

/**
 * websocket是多例对象
 */
@Data
@ServerEndpoint("/websocket/{name}")
public class WebSocket_01 {

    private String name;        //用于记录当前websocket是谁
    private Session session;    //链接, 用于记录当前链接

    private static Map<String, WebSocket_01> allClients = new HashMap<>();

    /**
     * 当建立链接的时候调用此方法
     * @param name 代表地址参数中的name 用于区分链接是谁
     * @param session1 当前建立的链接
     */
    @OnOpen
    public void onOpen(@PathParam("name") String name, Session session1) {
        this.name = name;
        this.session = session1;
        allClients.put(name, this);
    }

    /**
     * 用来接收客户端发来的消息, 这个地方应该根据自己的实际业务需求, 来决定到底写什么
     * @param session1
     * @param message
     */
    @OnMessage
    public void onMessage(Session session1, String message) {

        String to = ""; //TODO 需要具体解析的JSON
        String toMessage = "";

        WebSocket_01 webSocket_01 = allClients.get(0);
        if (null != webSocket_01) {

            Session toSession = webSocket_01.getSession();
            if (toSession.isOpen()) {
                toSession.getAsyncRemote().sendText(toMessage);
            }

        } else {

            session.getAsyncRemote().sendText("对方不在线!");
            //正常来说应该缓存这个消息, 这里直接给发送者返回一条对方不在线
        }
    }

    /**
     * 当出现异常时触发
     * @param session1
     * @param e
     */
    @OnError
    public void OnError(Session session1, Throwable e) {

    }

    /**
     * 当关闭链接触发
     * @param session1
     */
    @OnClose
    public void OnClose(Session session1) {
        this.session = session1;
    }
}

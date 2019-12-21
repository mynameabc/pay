package com.controller.websocket;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket是多例对象
 */
@Data
@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocket {

    //接收sid
    private String userId = "";

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //根据userId来获取对应的WebSocket
    private static ConcurrentHashMap<String, WebSocket> websocketMap = new ConcurrentHashMap<>();

    /**
     * 当建立链接的时候调用此方法
     * @param userId 代表地址参数中的name 用于区分链接是谁
     * @param session 当前建立的链接
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        this.userId = userId;
        this.session = session;
        websocketMap.put(userId, this);
        addOnlineCount();           //在线数加1
        System.out.println(userId + ":链接被建立!, 当前在线人数为:" + getOnlineCount());
    }

    /**
     * 当关闭链接触发
     */
    @OnClose
    public void OnClose() {
        if(null != websocketMap.get(this.userId)){
            websocketMap.remove(this.userId);
            subOnlineCount();           //在线数减1
            System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
        }
    }

    /**
     * 用来接收客户端发来的消息, 这个地方应该根据自己的实际业务需求, 来决定到底写什么
     * @param session
     * @param message
     */
    @OnMessage
    public void onMessage(Session session, String message) {

        if(StringUtils.isNotBlank(message)) {

            JSONArray list = JSONArray.parseArray(message);
            for (int index = 0; index < list.size(); index++) {

                try {
                    //解析发送的报文
                    JSONObject object = list.getJSONObject(index);
                    String toUserId = object.getString("toUserId");
                    String contentText = object.getString("contentText");
                    object.put("fromUserId", this.userId);
                    //传送给对应用户的websocket
                    if(StringUtils.isNotBlank(toUserId) && StringUtils.isNotBlank(contentText)) {
                        WebSocket socket = websocketMap.get("25");
                        //需要进行转换，userId
                        if(null != socket){

                            System.out.println("发送消息被调用!");
                            socket.sendMessage("你好!");
                            //此处可以放置相关业务代码，例如存储到数据库
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 当出现异常时触发
     * @param session
     * @param e
     */
    @OnError
    public void OnError(Session session, Throwable e) {
        e.printStackTrace();
    }

    /**
     * 返回当前链接数
     * @return
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 添加链接数
     */
    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    /**
     * 减除链接数
     */
    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}

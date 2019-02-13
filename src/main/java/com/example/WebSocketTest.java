package com.example;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value="/websocket")
public class WebSocketTest {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session + " 打开连接");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println(session + " 关闭连接");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        RemoteEndpoint.Basic remote = session.getBasicRemote();
        remote.sendText(message);
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println(session + " 连接出错");
        error.printStackTrace();
    }
}




package com.example.dashboard;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming messages
        session.sendMessage(new TextMessage("Hello, " + message.getPayload() + "!"));
    }
}

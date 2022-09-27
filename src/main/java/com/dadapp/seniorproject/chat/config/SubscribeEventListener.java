package com.dadapp.seniorproject.chat.config;


import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

@Component
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent> {


    @Override
    public void onApplicationEvent(SessionSubscribeEvent sessionSubscribeEvent) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionSubscribeEvent.getMessage());
        System.out.println("[SubscribeEventListener Listener Event Type]"+headerAccessor.getCommand().getMessageType());
        //The session ID must be inserted after the Handshake Interceptor intercepts before it can be retrieved.
        System.out.println("[SubscribeEventListener Listener event sessionId]"+headerAccessor.getSessionAttributes().get("sessionId"));
        System.out.println(headerAccessor.getSessionAttributes().get("sessionId").toString());
    }
}
package com.wave.websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.wave.websocket.interceptor.WebSocketHandshakeInterceptor;

@Configuration  
@EnableWebSocket  
public class WebSocketConfig extends WebMvcConfigurerAdapter implements  WebSocketConfigurer {  
    public transient final Logger log = LogManager.getLogger(getClass()); 
    public WebSocketConfig() {  
    }  
  
    @Override  
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {  
        registry.addHandler(systemWebSocketHandler(), "/websocket").addInterceptors(new WebSocketHandshakeInterceptor());  
        log.debug("注册不支持websocket浏览器的接口！");
        registry.addHandler(systemWebSocketHandler(), "/websocketjs/websocket").addInterceptors(new WebSocketHandshakeInterceptor()).withSockJS();  
  
    }  
  
    @Bean  
    public WebSocketHandler systemWebSocketHandler() { 
        return new com.wave.websocket.MyWebSocketHandler();  
    }  
  
}  
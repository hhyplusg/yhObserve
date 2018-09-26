package com.wave.websocket.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.wave.common.cnstants.Constants;
import com.wave.user.vo.SUserVo;
@Component  
public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {  
  
    @Override  
    public boolean beforeHandshake(ServerHttpRequest request,  
            ServerHttpResponse response, WebSocketHandler wsHandler,  
            Map<String, Object> attributes) throws Exception {  
          
        //解决The extension [x-webkit-deflate-frame] is not supported问题  
        if(request.getHeaders().containsKey("Sec-WebSocket-Extensions")) {  
            request.getHeaders().set("Sec-WebSocket-Extensions", "permessage-deflate");  
        }  
          
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                //使用userName区分WebSocketHandler，以便定向发送消息
                SUserVo sUserVo = (SUserVo) session.getAttribute(Constants.WEB_SESSION_USER_INFO);
                attributes.put(Constants.WEB_SESSION_USER_INFO,sUserVo);
            }
        return true;
    }
        
        System.out.println("Before Handshake");  
        return super.beforeHandshake(request, response, wsHandler, attributes);  
    }  
  
    @Override  
    public void afterHandshake(ServerHttpRequest request,  
            ServerHttpResponse response, WebSocketHandler wsHandler,  
            Exception ex) {  
        System.out.println("After Handshake");  
        super.afterHandshake(request, response, wsHandler, ex);  
    }  
  
}
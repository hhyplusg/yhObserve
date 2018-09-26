package com.wave.websocket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.wave.core.util.HttpUtil; 
import com.wave.websocket.MyWebSocketHandler;

/**
 * 测试向在线用户发送消息。
 * */
@Controller
public class TestWebSocketController {
	
	 

    @Bean
    public MyWebSocketHandler WebSocketHandler() {
        return new com.wave.websocket.MyWebSocketHandler();
    }


    @RequestMapping("/testwebsocket/{msg}")
    @ResponseBody
    public String auditing(HttpServletRequest request,@PathVariable("msg")String msg) throws IOException{
        //无关代码都省略了
         String userIdString = HttpUtil.getUserInfo().getUserId();
         // 发送给所有用户
        // WebSocketHandler().sendMessageToUsers(new TextMessage(msg));
         //发送给指定用户
         List<String> userIdList = new ArrayList<String>();
         userIdList.add(userIdString);
     
         String strMsg ="";
//       String shipMsg =StringZip.zipString(fromObject.toString());
         System.out.println("******************************");
         System.out.println(strMsg);
         System.out.println(strMsg.length());
         System.out.println("******************************");
         WebSocketHandler().sendMessageToAllUser( new TextMessage(strMsg));
//        WebSocketHandler().sendMessageToAllUser( new TextMessage(msg));
        return msg;
    }
}
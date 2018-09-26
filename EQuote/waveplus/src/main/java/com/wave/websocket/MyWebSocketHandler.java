package com.wave.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.wave.common.cnstants.Constants;
import com.wave.core.util.StringUtil;
import com.wave.user.vo.SUserVo;

/** 
 * 
 * @author 
 */  
@Component  
public class MyWebSocketHandler implements WebSocketHandler {  
  
    public transient final Logger log = LogManager.getLogger(getClass()); 

    private static final Map<String,WebSocketSession> usersMap = new HashMap<>(); 
    
    // 存储用户扩展信息,如:第一次获取船舶数据的时间
    private static final Map<String,HashMap<String,String>> usersExtendInfoMap = new HashMap<String,HashMap<String,String>>();   
 
   /* @Autowired
    private WebSocketService webSocketService;
*/
    /**
     * 双工通讯 连接后 并且在这里心跳
     * */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("connect to the websocket success......");
        SUserVo sUserVo = getUserVoInWebSocketSession(session);
        if(sUserVo!= null){
            // 链接成功能返回用户消息
            //构造回应的消息，每次连接成功后要回应消息吖！告诉客户端已经连接成功了！消息就在这里面构造
            session.sendMessage(new TextMessage("链接成功！"));
            usersMap.put(sUserVo.getUserId(), session);
	        usersExtendInfoMap.put(sUserVo.getUserId(), new HashMap<String,String>());
        }
    }
    
    /**
     * 处理发送过来的消息
     * 如果连接成功！！这里面会不停的接收到心跳包！！ 怎么处理~看你的了！！！ 总之这个方法就是接受客户端发来消息的方法！！！
     * message.getPayload()得到的是客户端发来的消息，比如“你好啊！” 之类的。得到后转成String就能处理了！
     * */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        SUserVo sUserVo = getUserVoInWebSocketSession(session);
        TextMessage returnMessage = new TextMessage(sUserVo.getUserName() + "说：" + message.getPayload().toString());  
        sendMessageToUsers(returnMessage);
    }

    private SUserVo getUserVoInWebSocketSession(WebSocketSession session) {
        return (SUserVo) session.getAttributes().get(Constants.WEB_SESSION_USER_INFO);
    }
     
    /**
     * //所谓异常断开，例如：突然关闭HTML页面等等，总之不是用户正常关闭的！
　　　　 //这个也是我自己实现的 异常处理的业务逻辑，你可以自己写
     * */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        removeUser(session);
        log.debug("websocket connection closed......");
    }
    /**
     * //只要是断开连接！不管是异常断开，还是普通正常断开，一定会进入这个方法。
     * */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.debug("websocket connection closed......");
        removeUser(session);
    }

    /**
     *  握手成功 初始化操作在这里面进行
     * */
    @Override
    public boolean supportsPartialMessages() {
      //一旦HTTP认证成功 这个方法先被调用 如果返回true 则进行上面那么N多方法的流程。如果返回的是false就直接拦截掉了。不会调用上面那些方法了！！
      //就好像个构造器一样。这个是处理器 BootstrapHandler的构造器~
        return true;
    }
    /**
     * 判断是否有用户在线
     *
     * @param message
     * @throws IOException 
     */
    public boolean isExistsUser() throws IOException {
         if(usersMap.isEmpty()) {
        	 return false;
         } else {
        	 return true;
         } 
    }
    /**
     * 给所有在线用户发送消息
     *
     * @param message
     * @throws IOException 
     */
    public void sendMessageToUsers(TextMessage message) throws IOException {
        Iterator<Map.Entry<String, WebSocketSession>> it = usersMap.entrySet().iterator();
        WebSocketSession userSession;
        while (it.hasNext()) {
             Map.Entry<String, WebSocketSession> entry = it.next();
             userSession = entry.getValue();
             if (userSession.isOpen()) {
                 userSession.sendMessage(message);
             }
        }
    }

    /**
     * 给某些个用户发送消息
     *
     * @param userId
     * @param message
     * @throws IOException 
     */
    public void sendMessageToUser(List<String> userIdList, TextMessage message) throws IOException {
        if (userIdList == null || userIdList.size() < 1) {
            return;
        }
        String userId;
        
        Iterator<Map.Entry<String, WebSocketSession>> it = usersMap.entrySet().iterator();
        WebSocketSession userSession;
        while (it.hasNext()) {
             Map.Entry<String, WebSocketSession> entry = it.next();
             userSession = entry.getValue();
             userId = getUserVoInWebSocketSession(userSession).getUserId();
             if (userIdList.contains(userId) && userSession.isOpen()) {
                 userSession.sendMessage(message);
             } 
        }
    }
    
    public void sendMessageToAllUser(TextMessage message) throws IOException {
         
        Iterator<Map.Entry<String, WebSocketSession>> it = usersMap.entrySet().iterator();
        WebSocketSession userSession;
        while (it.hasNext()) {
             Map.Entry<String, WebSocketSession> entry = it.next();
             userSession = entry.getValue(); 
             userSession.sendMessage(message); 
        }
    }
    
    /**
     * 给个用户发送消息
     *
     * @param userId
     * @param message
     * @throws IOException 
     */
    public void sendMessageToUser(String userId, TextMessage message) throws IOException {
        if (StringUtil.isEmpty(userId)) {
            return;
        }
        Iterator<Map.Entry<String, WebSocketSession>> it = usersMap.entrySet().iterator();
        WebSocketSession userSession;
        String tempUserId;
        while (it.hasNext()) {
             Map.Entry<String, WebSocketSession> entry = it.next();
             userSession = entry.getValue();
             tempUserId = getUserVoInWebSocketSession(userSession).getUserId();
             if (userId.equals(tempUserId)) {
                 if (userSession.isOpen()) {
                     userSession.sendMessage(message);
                }
                 break;
             } 
        }
    }
    
    private void removeUser(WebSocketSession session) {
        SUserVo sUserVo = getUserVoInWebSocketSession(session);
        usersMap.remove(sUserVo.getUserId());
        usersExtendInfoMap.remove(sUserVo.getUserId()); 
    }
    
    public Map<String,WebSocketSession>  getUsersMap () {
		return usersMap;
    	
    }
    
    public Map<String,HashMap<String,String>>   getUsersExtendInfoMap () {
		return usersExtendInfoMap;
    	
    }
}   
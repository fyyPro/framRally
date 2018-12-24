package com.ssm.websocket;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class WebSocket implements WebSocketHandler{

	private static final Logger log = Logger.getLogger(WebSocket.class);
	
	//所有用户列表
	private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();
	
	/**
	 * 关闭连接时
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession websocket, CloseStatus cs)
			throws Exception {
		log.info("连接关闭!");
		users.remove(websocket);
	}

	/**
	 * 连接就绪时
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession websocket)
			throws Exception {
		log.info("连接WebSocket成功!");
		users.add(websocket);
	}

	/**
	 * 处理信息
	 */
	@Override
	public void handleMessage(WebSocketSession websocket, WebSocketMessage<?> wsm)
			throws Exception {
		log.info("消息："+ wsm.getPayload() +"发送!");
		
		TextMessage textMessage = new TextMessage(wsm.getPayload().toString(),true);
		sendMsgToAllUsers(textMessage);
	}

	/**
	 * 处理传输时异常
	 */
	@Override
	public void handleTransportError(WebSocketSession websocket, Throwable tb)
			throws Exception {
		
	}

	@Override
	public boolean supportsPartialMessages() {
		
		return false;
	}
	
	public void sendMsgToAllUsers(WebSocketMessage<?> wsm) throws Exception{
		for(WebSocketSession user:users){
			user.sendMessage(wsm);
		}
	}

	
}

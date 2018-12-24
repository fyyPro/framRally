package com.ssm.interceptor;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import com.ssm.websocket.WebSocket;

/**
 * WebSocket握手拦截
 */
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{

	private static final Logger log = Logger.getLogger(HandshakeInterceptor.class);
	
	/**
	 * 握手前
	 */
	public boolean beforeHandshake(ServerHttpRequest request,ServerHttpResponse response,
			WebSocket websocket,Map<String, Object> attrs) throws Exception{
		log.info("*************握手前************"+attrs);
		return super.beforeHandshake(request, response, websocket, attrs);
	}
	
	/**
	 * 握手后
	 */
	public void afterHandshake(ServerHttpRequest request,ServerHttpResponse response,
			WebSocket websocket,Exception ex){
		log.info("*************握手后************");
		super.afterHandshake(request, response, websocket, ex);
	}
	
	
	
	
}

package com.ssm.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.ssm.interceptor.HandshakeInterceptor;

@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocket(), "/websocket").addInterceptors(new HandshakeInterceptor());
		
		
		registry.addHandler(webSocket(), "/sockjs/websocket")
				.addInterceptors(new HandshakeInterceptor())
				.withSockJS();
	}
	
	/**
	 * 处理类
	 */
	@Bean
	public WebSocket webSocket(){
		return new WebSocket();
	}

}

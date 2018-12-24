package com.ssm.web.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 基于jdk1.6以上的javax.jws 发布webservice接口
 * @WebService 注解，用在类上指定将此类发布成一个ws
 * Endpoint 此类为端点服务类，
 * 			方法publish用于将一个已经添加了
 * 			@WebService注解对象绑定到一个地址的端口上
 */
@WebService
public class ServiceHello {

	/**
	 * 供客户端调用方法 非静态 会被发布
	 * @param name
	 */
	@WebMethod
	public String sayHello(String name){
		return "你好"+name;
	}
	
	/**
	 * 方法上加@WebMentod(exclude=true)后，此方法不被发布
	 * @param name
	 */
	@WebMethod(exclude=true)
	public String getHello(String name){
		return "你好"+name;
	}
	
	/**
	 * 静态方法不会被发布
	 * @param name
	 */
	public static String getString(String name){
		return "你好"+name;
	}
	
	
	public static void main(String[] args) {
		
		//通过EndPoint(端点服务)发布一个WebService
		Endpoint.publish("http://192.168.100.156:8081/Service/ServiceHello", new ServiceHello());
		
	}

}

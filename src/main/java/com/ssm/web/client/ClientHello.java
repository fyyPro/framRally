package com.ssm.web.client;

import com.ssm.web.client.jws.ServiceHello;
import com.ssm.web.client.jws.ServiceHelloService;

/**
 * webService 客户端调用
 */
public class ClientHello {

	public static void main(String[] args) {
		
		ServiceHello hello = new ServiceHelloService().getServiceHelloPort();
		
		String str = hello.sayHello("冯云阳");
		
		System.out.println(str);
		
	}

}

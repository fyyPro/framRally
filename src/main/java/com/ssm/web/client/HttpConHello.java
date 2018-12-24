package com.ssm.web.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

/**
 * httpclient
 */
public class HttpConHello {

	public static void main(String[] args) throws HttpException, IOException {
		
		StringBuffer soap = new StringBuffer();
		soap.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		soap.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ");
		soap.append("xmlns:ser=\"http://service.web.ssm.com/\">");
		soap.append("<soapenv:Header/>");
		soap.append("<soapenv:Body>");
		soap.append("<ser:sayHello>");
		soap.append("<arg0>");
		soap.append("冯云阳");
		soap.append("</arg0>");
		soap.append("</ser:sayHello>");
		soap.append("</soapenv:Body>");
		soap.append("</soapenv:Envelope>");
		System.out.println(soap.toString());
		
		String url = "http://192.168.100.156:8081/Service/ServiceHello?wsdl";
		PostMethod postMethod = new PostMethod(url);
		
		byte[] b = soap.toString().getBytes("utf-8");
		
		InputStream is = new ByteArrayInputStream(b,0,b.length);
		RequestEntity re = new InputStreamRequestEntity(is,b.length,
				"text/xml;charset=UTF-8");
		postMethod.setRequestEntity(re);
		
		HttpClient httpClient = new HttpClient();
		int statusCode = httpClient.executeMethod(postMethod);
		
		if(200 == statusCode){
			String result = postMethod.getResponseBodyAsString();
			System.out.println("返回结果："+result);
		}else{
			System.out.println(statusCode);
		}
		
		
	}

}

package com.ssm.web.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL Connection 
 */
public class UrlConHello {

	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://192.168.100.156:8081/Service/ServiceHello");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
			conn.connect();
			
			
			OutputStream os = conn.getOutputStream();
			
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
			os.write(soap.toString().getBytes());
			
			InputStream in = conn.getInputStream();
			byte[] b = new byte[1024];
			int len = 0;
			String s = "";
			while((len = in.read(b)) != -1){
				String ss = new String(b,0,len,"UTF-8");
				s += ss;
			}
			System.out.println(s);
			
			//关闭流
			in.close();
			os.close();
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

package com.Hello.controller;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Hello.pojo.User;

@RestController
public class TestController {
	private static HashMap<String, String> map;
	private boolean isUser = false;
	private String mString = "当前无连接";
	private static ServerSocket serverSocket;
	static {
		map.put("hero", "123456");
		map.put("dear", "123456");
	}
	@SuppressWarnings("resource")
	@RequestMapping(value="/love",method=RequestMethod.GET)
	public String love(User user){
		for(String name:map.keySet()) {
			if(map.get(name).equals(user.getPassWord())) {
				isUser = true;
				try {
					DatagramSocket datagramSocket = new DatagramSocket();
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mString = name+"已连接";
			}
		}
		return mString;
	}
	@RequestMapping(value="/ok",method=RequestMethod.GET)
	public String startServer() {
	        try {
	        	serverSocket = new ServerSocket(66521);
	        	while(true) {
	        	serverSocket.accept();
	        	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return null;
	}
}

package com.iot.chinamobile.thrift.rpc.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//服务端启动
public class DubboServerStart {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-dubbo-server.xml");
			context.start();
			Thread.sleep(3000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

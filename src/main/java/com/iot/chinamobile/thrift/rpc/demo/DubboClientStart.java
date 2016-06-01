package com.iot.chinamobile.thrift.rpc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.veeson.dubbo.rpc.facade.DubboService;

import com.iot.chinamobile.rpc.dubbo.client.DubboClient;
import com.iot.chinamobile.rpc.dubbo.source.DynamicDubboClient;

//客户端调用
@SuppressWarnings("resource")
public class DubboClientStart {
	public static void main(String[] args) {
//		simple();
		spring();
	}

	public static void spring() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-dubbo-client.xml");
//			DubboClient dubboClient = (DubboClient) context.getBean("demoRpcService");
			DynamicDubboClient dubboClientFactory = (DynamicDubboClient) context.getBean("dynamicDubboClient");
			DubboService dubboService = dubboClientFactory.getDubboClient("demoRpcService");
			Thread.sleep(1000);
			for (int i = 0; i < 100; i++) {
				TThread t = new TThread(dubboService);
				t.start();
				Thread.sleep(3000);
			}
			Thread.sleep(3000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class TThread extends Thread {
		DubboService demoService;

		TThread(DubboService service) {
			demoService = service;
		}

		public void run() {
			try {
				System.out.println(Thread.currentThread().getName()+"  "+demoService.echoHello());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

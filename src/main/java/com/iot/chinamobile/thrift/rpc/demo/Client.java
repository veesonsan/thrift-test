package com.iot.chinamobile.thrift.rpc.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.veeson.thrift.rpc.facade.DemoService;

//客户端调用
@SuppressWarnings("resource")
public class Client {
	public static void main(String[] args) {
//		simple();
		spring();
	}

	public static void spring() {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-thrift-client.xml");
			DemoService.Iface demoService = (DemoService.Iface) context.getBean("demoService");
			Thread.sleep(1000);
			for (int i = 0; i < 1; i++) {
				TThread t = new TThread(demoService);
				t.start();
				Thread.sleep(3000);
			}
			Thread.sleep(3000000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class TThread extends Thread {
		DemoService.Iface demoService;

		TThread(DemoService.Iface service) {
			demoService = service;
		}

		public void run() {
			try {
				System.out.println(Thread.currentThread().getName()+"  "+demoService.echo("hello"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

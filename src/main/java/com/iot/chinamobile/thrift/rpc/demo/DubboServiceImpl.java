package com.iot.chinamobile.thrift.rpc.demo;

import org.springframework.stereotype.Service;
import org.veeson.dubbo.rpc.facade.DubboService;

@Service("dubboServiceImpl")
public class DubboServiceImpl implements DubboService {

	public String echoHello() {
		System.out.println("Hello");
		return "Hello";
	}

}

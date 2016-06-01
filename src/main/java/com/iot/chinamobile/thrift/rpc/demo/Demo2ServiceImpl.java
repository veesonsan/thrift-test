package com.iot.chinamobile.thrift.rpc.demo;

import org.apache.thrift.TException;
import org.veeson.thrift.rpc.facade.Demo2Service;
//实现类
public class Demo2ServiceImpl implements Demo2Service.Iface {

	public String echo(String msg) throws TException {
		return "server1 :"+msg;
	}

	public String sayHello(String msg) throws TException {
		// TODO Auto-generated method stub
		return "Hello";
	}
}

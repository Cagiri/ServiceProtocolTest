package com.serviceprotocolclient.hessian;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;
import com.serviceprotocolfacade.hessian.CommunicationService;

public class HessianClientExp {

	public static void main(String[] args) {
		String url = "http://localhost:8080/communication-service";
		HessianProxyFactory factory = new HessianProxyFactory();
		CommunicationService basic;
		try {
			basic = (CommunicationService) factory.create(CommunicationService.class, url);
			System.out.println(basic.communicate("Test Test Test"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}

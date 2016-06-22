package com.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EjbContainer
 */
@Stateless
public class MsgService implements MsgServiceRemote {

	public MsgService() {

	}

	@Override
	public String sendMsg(String str) {

		return str + " msg sending...";
	}

	@PostConstruct
	public void initialize() {
		// Initialize here objects which will be used
		// by the session bean
		System.out.println("SessionDemoBean initialized.");
	}

	@PreDestroy
	public void destroyBean() {
		
		System.out.println("SessionDemoBean initialized.");
	}
}

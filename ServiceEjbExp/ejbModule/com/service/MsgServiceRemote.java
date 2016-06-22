package com.service;

import javax.ejb.Remote;

@Remote
public interface MsgServiceRemote {
	
	public String sendMsg(String str);
}

package com.serviceprotocolclient.protobuf;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.serviceprotocolmodel.protobuf.bean.ControlMsg;

public class ProtobufClientExp {
	

	public static void main(String[] args) {
		new ProtobufClientExp().getMsg();
	}

	private void getMsg() {
		ProtobufHttpMessageConverter msgConverter = new ProtobufHttpMessageConverter();
		
		RestTemplate restTemplate =  new RestTemplate(Arrays.asList(msgConverter));
		ResponseEntity<ControlMsg.Msg> response = restTemplate.getForEntity("http://localhost:8080/msg/1", ControlMsg.Msg.class);
		
		ControlMsg.Msg msg= response.getBody();
		
		
		System.out.println(msg);
		
	}
}

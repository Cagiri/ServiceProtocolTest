package com.serviceprotocol.protobuf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceprotocolmodel.protobuf.bean.ControlMsg;
import com.serviceprotocolmodel.protobuf.bean.fakeData.MsgDataGenerate;
import com.serviceprotocolmodel.protobuf.bean.repository.ControlMsgRepository;

@RestController
public class ProtobufController {

	@Autowired
	private ControlMsgRepository controlMsgRep;

	@RequestMapping("/msg/{id}")
	ControlMsg.Msg msg(@PathVariable Integer id) {
		ControlMsg.Msg sendingMsg = this.controlMsgRep.findById(id);
		return sendingMsg;
	}
	

	@Bean
	ControlMsgRepository controlMsgRepository() {
		
		return MsgDataGenerate.controlMsgRepository();
	}
}

package com.serviceprotocolmodel.protobuf.bean.fakeData;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.serviceprotocolmodel.protobuf.bean.ControlMsg;
import com.serviceprotocolmodel.protobuf.bean.repository.ControlMsgRepository;

public class MsgDataGenerate {

	public static ControlMsgRepository controlMsgRepository() {
		Map<Integer, ControlMsg.Msg> msg = new ConcurrentHashMap<>();
		// populate with some dummy data

		Arrays.asList(message(1, "first msg sending..."), 
				      message(2, "second msg sending..."), 
				      message(3, "third msg sending..."),
				      message(4, "fourth msg sending..."))
		.forEach(m -> msg.put(m.getId(), m));

		// our lambda just gets forwarded to Map#get(Integer)
		return msg::get;
	}
	
	private static ControlMsg.Msg message(int id, String msg) {

		return ControlMsg.Msg.newBuilder().setId(id).setMessage(msg).build();
	}
}

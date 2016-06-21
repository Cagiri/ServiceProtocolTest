package com.serviceprotocolmodel.protobuf.bean.repository;

import com.serviceprotocolmodel.protobuf.bean.ControlMsg;

public interface ControlMsgRepository {
	
	ControlMsg.Msg findById(int id);
}

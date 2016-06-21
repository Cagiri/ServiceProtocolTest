
package com.serviceprotocolclient.tcpclient;

import java.io.IOException;
import java.net.Socket;

import com.serviceprotocolmodel.protobuf.bean.ControlMsg;
import com.serviceprotocolmodel.protobuf.bean.ControlMsg.Msg;

public class TcpClientExp {

	public static void main(String argv[]) throws Exception {
		String serverName = "localhost";
		int port = 6789;
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			
			Msg ms = ControlMsg.Msg.newBuilder().setId(1).setMessage("").build();
			ms.writeDelimitedTo(client.getOutputStream());
			
			ms = Msg.parseDelimitedFrom(client.getInputStream());
			
			System.out.println("Sending Msg : " + ms.getId() + " - " + ms.getMessage());
			
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

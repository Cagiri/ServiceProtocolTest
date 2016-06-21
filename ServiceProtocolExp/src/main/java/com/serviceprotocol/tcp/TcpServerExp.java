package com.serviceprotocol.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import com.serviceprotocolmodel.protobuf.bean.ControlMsg.Msg;
import com.serviceprotocolmodel.protobuf.bean.fakeData.MsgDataGenerate;
import com.serviceprotocolmodel.protobuf.bean.repository.ControlMsgRepository;

public class TcpServerExp implements Runnable {

	private ServerSocket serverSocket;

	public TcpServerExp(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(100000);
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());

				ControlMsgRepository msgRepo = MsgDataGenerate.controlMsgRepository();
				Msg ms = Msg.parseDelimitedFrom(server.getInputStream());
				System.out.println("Message Id : " + ms.getId());
				ms = msgRepo.findById(ms.getId());
				
				ms.writeDelimitedTo(server.getOutputStream());
				server.close();
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		int port = 6789;
		try {
			Thread t = new Thread(new TcpServerExp(port));
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

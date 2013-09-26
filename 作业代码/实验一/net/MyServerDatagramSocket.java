package com.hyh.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class MyServerDatagramSocket extends DatagramSocket{
	
	static final int MAX_LEN=100;

	public MyServerDatagramSocket(int serverPort) throws SocketException {
		super(serverPort);
	}
	
	public String receiveMessage() throws IOException{
		byte[] receivebuffer=new byte[MAX_LEN];
		DatagramPacket pack=new DatagramPacket(receivebuffer,MAX_LEN);
		this.receive(pack);
		String message=new String(receivebuffer);
		return message;	
	}
	public DatagramMessage receiveMessageAndSender() throws IOException {
		byte[] receivebuffer=new byte[MAX_LEN];
		DatagramPacket pack=new DatagramPacket(receivebuffer,MAX_LEN);
		this.receive(pack);
		DatagramMessage msg=new DatagramMessage();
		msg.putVal(new String(receivebuffer),pack.getAddress(),pack.getPort());
		return msg;
	}

	public void sendMessage(InetAddress address, int port, String message) throws IOException {
		byte[] sendbuffer=message.getBytes();
		DatagramPacket pack=new DatagramPacket(sendbuffer,sendbuffer.length,
				address,port);
		this.send(pack);
		
	}

}

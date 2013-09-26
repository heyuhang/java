package com.hyh.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MyClientDatagramSocket extends DatagramSocket
{
	static final int MAX_LEN=100;
	
	private DatagramSocket socket;
	
	public MyClientDatagramSocket() throws SocketException{
		super();
	}
	public MyClientDatagramSocket(int portNum) throws SocketException{
		super(portNum);
	}

	public void sendMessage(InetAddress serverhost, int serverport,
			String message) throws IOException{
		byte[] sendbuffer=message.getBytes();
		DatagramPacket datagram=new DatagramPacket(sendbuffer, sendbuffer.length,
				serverhost,serverport);
		this.send(datagram);
		
	}

	public void close() {
		socket.close();
		
	}

	public String receiveMessage() throws IOException{
		byte[] receivebuffer=new byte[MAX_LEN];
		DatagramPacket datagram=new DatagramPacket(receivebuffer, MAX_LEN);
		this.receive(datagram);
		String message=new String(receivebuffer);
		return message;
	}
}

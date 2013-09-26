package com.hyh.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyDatagramSocket  extends DatagramSocket{
	
	static final int MAX_LEN=30;
	public MyDatagramSocket(int portNo) throws SocketException {
		super(portNo);
	}
	
	public void sendMessage(InetAddress receiverHost,int receiverPoet,String message) throws IOException{
		byte[] sendBuffer=message.getBytes();
		DatagramPacket datagram=new DatagramPacket(sendBuffer,sendBuffer.length, receiverHost,receiverPoet);
		this.send(datagram);
	}
	
	public String  receiveMessage() throws IOException{
		byte[] Buffer=new byte[MAX_LEN];
		DatagramPacket datagram=new DatagramPacket(Buffer,MAX_LEN);
		this.receive(datagram);
		return new String(Buffer);
	}
	
	public static void main(String[] args) throws Exception{
		MyDatagramSocket send=new MyDatagramSocket(8080);
		InetAddress host=InetAddress.getByName("localhost");
		send.sendMessage(host, 8080,"heyu");
		
		String message=send.receiveMessage();
		send.close();
		System.out.print("接收的消息:"+message);
	}
}

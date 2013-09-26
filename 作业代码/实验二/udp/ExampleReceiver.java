package com.hyh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ExampleReceiver {
	private static String host="localhost";
	private static String port="8080";
	
	public static void main(String[] args) {
		int hostPort=Integer.parseInt(ExampleReceiver.port);
		final int maxLen=10;
		try{
			DatagramSocket mySocket=new DatagramSocket(hostPort);
			byte[] buffer=new byte[maxLen];
			DatagramPacket datagram=new DatagramPacket(buffer,maxLen);
			mySocket.receive(datagram);
			String message=new String(buffer);
			System.out.println("接收到的消息:"+message);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

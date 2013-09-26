package com.hyh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.hyh.net.DatagramMessage;

public class ExampleSender {
	private static String host="localhost";
	private static String port="8080";
	public static void main(String[] args) throws UnknownHostException {
		InetAddress receiveHost=InetAddress.getByName(ExampleSender.host);
		int receivePort=Integer.parseInt(ExampleSender.port);
		String message;
		System.out.print("");
		Scanner in=new Scanner(System.in);
		message=in.next();
		try {
			DatagramSocket mySocket=new DatagramSocket();
			byte[] buffer=message.getBytes();
			DatagramPacket datagram=new DatagramPacket(buffer, buffer.length,receiveHost,receivePort);
			mySocket.send(datagram);
			mySocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

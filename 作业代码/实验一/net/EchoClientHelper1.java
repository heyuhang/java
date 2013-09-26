package com.hyh.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClientHelper1 {

	private MyClientDatagramSocket socket;
	private InetAddress serverhost;
	private int serverport;
	
	public EchoClientHelper1(String hostname, String portNum) throws SocketException,
	UnknownHostException{
		this.serverhost=InetAddress.getByName(hostname);
		this.serverport=Integer.parseInt(portNum);
		this.socket=new MyClientDatagramSocket();
	}

	public void done() {
		socket.close();
		
	}

	public String getEcho(String message) throws IOException,SocketException{
		String echo="";
		socket.sendMessage(serverhost,serverport,message);
		echo=socket.receiveMessage();
		return echo;
	}
	
	
}

package com.hyh.net;

import java.net.InetAddress;

public class DatagramMessage {
	
	private String message;
	private InetAddress address;
	private int port;
	public InetAddress getAddress() {
	
		return this.address;
	}

	public int getPort() {
		
		return this.port;
	}

	public String getMessage() {
		
		return this.message;
	}

	public void putVal(String message, InetAddress address, int port) {
		this.address=address;
		this.message=message;
		this.port=port;
		
	}

}

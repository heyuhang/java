package com.hyh.udp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import sun.nio.ByteBuffered;

import com.hyh.sax.saxxml;
import com.sun.corba.se.impl.ior.ByteBuffer;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

/**
 * 计算机PC端
 */

public class PC {
	private static String hostname = "localhost";
	//private static String inport = "7777";
	private static String outport = "7778";

	public static void main(String[] args) throws UnknownHostException {
		final int maxLen = 700;
		int len = 0;
		// 获取主机地址
		InetAddress host = InetAddress.getByName(hostname);
		// 把端口转换成整形
		int myport = Integer.parseInt(outport);
		try {
			// 实例化数据报接收socket
			DatagramSocket mySocket = new DatagramSocket(myport);
			// 接收消息
			byte[] buffer = new byte[maxLen];

			byte c = 0;

			DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);

			System.out.println("等待接收数据:");
			mySocket.receive(datagram);

			for (int i = 0; i < buffer.length; i++) {
				if (buffer[i] != c) {
					len++;
				}
			}
			ByteBuffer buffers = new ByteBuffer(len);
			for (int i = 0; i < len; i++) {
				if (buffer[i] != c) {
					buffers.append(buffer[i]);
				}
			}
			byte[] buffere = buffers.toArray();
			InputStream in = new ByteArrayInputStream(buffere);
			// 通过单例模式创建一个SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			try {
				// 通过factory对象的newSAXParser()创建SAXPARser对象
				SAXParser parser = factory.newSAXParser();
				saxxml sax=new saxxml();
				parser.parse(in,sax );
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

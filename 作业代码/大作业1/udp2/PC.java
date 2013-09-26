package com.hyh.udp2;

import java.io.ByteArrayInputStream;
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

import com.hyh.sax.saxxml;
import com.sun.corba.se.impl.ior.ByteBuffer;

/**
 * 计算机PC端,
 */

public class PC {
	private static String hostname = "localhost";
	private static String outport = "7778";
	private static String inport = "7777";

	public static void main(String[] args) throws IOException {
		final int maxLen = 1000;
		int len = 0;
		// 获取主机地址
		InetAddress host = InetAddress.getByName(hostname);
		// 把端口转换成整形
		int hostport = Integer.parseInt(inport);
		int myport = Integer.parseInt(outport);
		DatagramSocket sendsocket = null;
		DatagramSocket mySocket = null;
		DatagramPacket sendpacket = null;
		saxxml sax = null;
		// 接收一条由用户输入的控制命令

		System.out
				.println("收集的数据(输入1复位reset,2激活reader输出端口activate,3测试PC与reader之间的连通test,4设置参数SetParams,5获取参数GetParams):");
		Scanner in = new Scanner(System.in);
		String msg = in.next();
		StringBuffer str = new StringBuffer();
		switch (Integer.parseInt(msg)) {
		case 1:
			str.append("<Elpas>");
			str.append("<Type>Command</Type>");
			str.append("<SlaveId>00:11:11:11:44:55</SlaveId>");
			str.append("<Subtype>Reset</Subtype>");
			str.append("<Param>All</Param>");
			str.append("<RequestId>12345</RequestId>");
			str.append("</Elpas>");
			break;
		case 2:
			str.append("<Elpas>");
			str.append("<Type>Command</Type>");
			str.append("<DeviceId>00:11:11:11:44:55</DeviceId>");
			str.append("<Port>1</Port>");
			str.append("<State>Close</State>");
			str.append("<Duration>3000</Duration>");
			str.append("<RequestId>12345</RequestId>");
			str.append("</Elpas>");
			break;
		case 3:
			str.append("<Elpas>");
			str.append("<Type>Command</Type>");
			str.append("<Subtype>Test</Subtype>");
			str.append("<DeviceId>00:11:11:11:44:55</DeviceId>");
			str.append("<ClearStats>1</ClearStats>");
			str.append("<Repeat>Close</Repeat>");
			str.append("<RequestId>12345</RequestId>");
			str.append("</Elpas>");
			break;
		case 4:
			str.append("<Elpas>");
			str.append("<Type>SetParams</Type>");
			str.append("<SlaveId>00:00:00:04:00:1E</SlaveId>");
			str.append("<RSSIThreshold>20</RSSIThreshold>");
			str.append("<NoiseFilter>255</NoiseFilter>");
			str.append("<Date>mm/dd/yyyy</Date>");
			str.append("<Time>11:22:33</Time>");
			str.append("<ServerIP>127.0.0.101</ServerIP>");
			str.append("<ServerPort>7778</ServerPort>");
			str.append("<BroadcastOutPort>7012</BroadcasrPort>");
			str.append("<EventsOnly>1</EventsOnly>");
			str.append("<BuzzerType>0</BuzzerType>");
			str.append("<RequestId>12345</RequestId>");
			str.append("</Elpas>");
			break;
		case 5:
			str.append("<Elpas>");
			str.append("<Type>GetParams</Type>");
			str.append("<RequestId>12345</RequestId>");
			str.append("<SlaveId>00:00:00:04:00:1E</SlaveId>");
			str.append("</Elpas>");
			break;
		}
		// 获取控制信息的字节数组
		byte[] strs = str.toString().getBytes();
		try {
			// 实例化数据报发送socket
			sendsocket = new DatagramSocket();
			// 实例化数据报接收socket
			// mySocket = new DatagramSocket(myport);
			// 实例化数据包文
			sendpacket = new DatagramPacket(strs, strs.length, host, hostport);
			// 发送
			sendsocket.send(sendpacket);
		} catch (Exception e) {

			e.printStackTrace();
		}

		// 实例化数据报接收socket
		mySocket = new DatagramSocket(myport);
		// 接收消息
		byte[] buffer = new byte[maxLen];

		byte c = 0;

		DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);

		System.out.println("Reader回应:");
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
		String message = new String(buffers.toArray());
		if (!message.contains("<") && !message.contains(">"))
			System.out.println(message);
		else {
			byte[] buffere = buffers.toArray();
			InputStream ins = new ByteArrayInputStream(buffere);
			// 通过单例模式创建一个SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();

			try {
				// 通过factory对象的newSAXParser()创建SAXPARser对象
				SAXParser parser = factory.newSAXParser();
				sax = new saxxml();
				parser.parse(ins, sax);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

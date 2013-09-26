package com.hyh.udp2;

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

/*
 * 计算机PC端
 */
/*
 (1),命令
 Reset
 Activate Output（Relay，beep）
 Test
 (2),改变参数
 Set Date and Time
 Set RSSI Threshold
 Set Noise Limit
 Set Server IP/Port
 Buzzer Style
 RF/IR Receiver sensitivity
 (3),查询参数
 */
public class Reader {
	private static String hostname = "localhost";
	private static String outport = "7777";
	private static String inport = "7778";

	public static void main(String[] args) throws UnknownHostException {
		final int maxLen = 1000;
		int len = 0;
		saxxml sax=null;
		// 获取主机地址
		InetAddress host = InetAddress.getByName(hostname);
		// 把端口转换成整形
		int hostport = Integer.parseInt(inport);
		int myport = Integer.parseInt(outport);
		DatagramSocket sendsocket=null;
		DatagramSocket mySocket=null;
		// //接收一条由用户输入的控制命令
		// System.out.print("请发送控制命令:");
		// Scanner in=new Scanner(System.in);
		// String msg=in.next();
		// //获取控制信息的字节数组
		// byte[ ] str=msg.getBytes();
		try {
			// 实例化数据报发送socket
			sendsocket=new DatagramSocket();
			// 实例化数据报接收socket
			mySocket = new DatagramSocket(myport);
			// 接收消息
			byte[] buffer = new byte[maxLen];

			byte c = 0;

			DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);

			System.out.println("接收数据:");
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
			// String message=new String(buffer);
			// System.out.println("接收到的消息:");
			byte[] buffere = buffers.toArray();
			InputStream in = new ByteArrayInputStream(buffere);
			// 通过单例模式创建一个SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			
			try {
				// 通过factory对象的newSAXParser()创建SAXPARser对象
				SAXParser parser = factory.newSAXParser();
				sax=new saxxml();
				parser.parse(in, sax);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		StringBuffer str = new StringBuffer();
		String type=sax.getCommond();
		if(type.equals("Reset")) {
			str.append("Power up message");
		}else if(type.equals("Activate")){
			str.append("<Elpas>");
			str.append("<Type>Command</Type>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<HostMAC>00:11:11:11:44:55</HostMAC>");
			str.append("<RequestID>12345</RequestID>");
			str.append("</Elpas>");
		}else if(type.equals("Test")){
			str.append("<Elpas>");
			str.append("<Type>Command</Type>");
			str.append("<Subtype>Test</Subtype>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<HostMAC>00:11:11:11:44:55</HostMAC>");
			str.append("<Passed>1000</Passed>");
			str.append("<Failed>0</Failed>");
			str.append("<Voltage>22.32</Voltage>");
			str.append("<RequestID>12345</RequestID>");
			str.append("</Elpas>");
		}else if(type.equals("SetParams")){
			str.append("<Elpas>");
			str.append("<Type>SetParams</Type>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<RequestId>12345</RequestId>");
			str.append("</Elpas>");
		}else if(type.equals("GetParams")){		
			str.append("<Elpas>");
			str.append("<Type>GetParams</Type>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<RequestID>12345</RequestID>");
			str.append("<SoftwareVersion>1.2</SoftwareVersion>");
			str.append("<HostMAC>00:11:11:11:44:55</HostMAC>");
			str.append("<DeviceIP>172.16.30.167</DeviceIP>");
			str.append("<NoiseFilter>255</NoiseFilter>");
			str.append("<RSSIThreshold>0</RSSIThreshold>");
			str.append("<Sensitivity>0</Sensitivity>");
			str.append("<StartupDate>01/01/2009</StartupDate>");
			str.append("<StartupTime>12:30:45</StartupTime>");
			str.append("<UseDHCP>1</UseDHCP>");
			str.append("<Voltage>23.4</Voltage>");
			str.append("<Gateway>172.16.30.1</Gateway>");
			str.append("<GatewayOverride>0</GatewayOverride>");
			str.append("<DeviceIPSubnet>255.255.255.0</DeviceIPSubnet>");
			str.append("<AutoDetectResponsePort>7777</AutoDetectResponsePort>");
			str.append("<AutoDetectPort>7011</AutoDetectPort>");
			str.append("<BuzzerType>0</BuzzerType>");
			str.append("<EventOnly>0</EventOnly>");
			str.append("<Date>06/07/2009</Date>");
			str.append("<Time>16:02:42</Time>");
			str.append("</Elpas>");
		}		
		byte[] back=str.toString().getBytes();
		// 实例化数据包文
		 DatagramPacket sendpacket=new DatagramPacket(back, back.length,
		 host, hostport);
		// 发送
		 try {
			sendsocket.send(sendpacket);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
	}
}

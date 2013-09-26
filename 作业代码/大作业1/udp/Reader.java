package com.hyh.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * ,Controller 读写器
 */
/*
 (1),徽章消息,Controller把接收到的每一条徽章消息发送到PC，此消息是系统中最基本的信息。
 <Elpas>
 <Type>BadgeMessage</Type>
 <DeviceId>00:11:22:33:44:55</DeviceId>
 <HostMAC>00:11:11:11:44:55</HostMAC>
 <Motion>1</Motion>
 <Battery>1</Battery>
 <Buttons>3</Buttons>
 <Id>00D330</Id>
 <RSSI>221</RSSI>
 <Noise>43</Noise>
 <PacketId>4567</PacketId>
 <RawData>DE5394614900</RawData>
 <Group>19</Group>
 <Data>FE</Data>
 </Elpas>
 */
/*
 (2)徽章事件（Badge Events）：与徽章消息相对应的是徽章事件，当以下状态之一发生变化，
 Controller把接收到的徽章事件发送到PC。
 Button press/Button release
 Motion/motionless
 Low Battery
 Badge lost, badge first seen
 */
/*
 (3),系统事件（System Events）
 Supervision(监督)
 Troubles
 */
/*
 (4),反馈（feedbacks）：输入反馈，Open/Close/Open of Resistor/Short of Resistor
 */
public class Reader {
	private static String hostname = "localhost";
	private static String inport = "7778";
	//private static String outport = "7777";

	public static void main(String[] args) throws UnknownHostException {
		final int maxLen = 700;
		// 获取主机地址
		InetAddress host = InetAddress.getByName(hostname);
		// 把端口转换成整形
		int hostport = Integer.parseInt(inport);
		//int myport = Integer.parseInt(outport);
		DatagramSocket sendsocket = null;
		DatagramSocket mySocket = null;
		DatagramPacket sendpacket = null;
		// 接收一条由用户输入的控制命令

		System.out.println("收集的数据(输入1为徽章消息,2为徽章事件,3为系统事件,4为反馈):");
		Scanner in = new Scanner(System.in);
		String msg = in.next();
		StringBuffer str = new StringBuffer();
		switch (Integer.parseInt(msg)) {
		case 1:
			str.append("<Elpas>");
			str.append("<Type>BadgeMessage</Type>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<HostMAC>00:11:11:11:44:55</HostMAC>");
			str.append("<Motion>1</Motion>");
			str.append("<Battery>1</Battery>");
			str.append("<Buttons>3</Buttons>");
			str.append("<Id>00D330</Id>");
			str.append("<RSSI>221</RSSI>");
			str.append("<Noise>43</Noise>");
			str.append("<PacketId>4567</PacketId>");
			str.append("<RawData>DE5394614900</RawData>");
			str.append("<Group>19</Group>");
			str.append("<Data>FE</Data>");
			str.append("</Elpas>");
			break;
		case 2:
			str.append("<Elpas>");
			str.append("<Type>BadgeEvent</Type>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<HostMAC>00:11:11:11:44:55</HostMAC>");
			str.append("<Time>22:10:59</Time>");
			str.append("<Id>00D330</Id>");
			str.append("<EventType>Motion</EventType>");
			str.append("<EventValue>1</EventValue>");
			str.append("<Data>111</Data>");
			str.append("</Elpas>");
			break;
		case 3:
			str.append("<Elpas>");
			str.append("<Type>SystemEvent</Type>");
			str.append("<Subtype>Supervision</Subtype>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<HostMAC>00:11:11:11:44:55</HostMAC>");
			str.append("<Time>18:49:36</Time>");
			str.append("<Tamper>0</Tamper>");
			str.append("<Voltage>0</Voltage>");
			str.append("<DeviceIp>192.168.1.34</DeviceIp>");
			str.append("<Messages>1289</Messages>");
			str.append("<CRCErrors>0</CRCErrors>");
			str.append("<NoAnswer>0</NoAnswer>");
			str.append("</Elpas>");
			break;
		case 4:
			str.append("<Elpas>");
			str.append("<Type>SystemEvent</Type>");
			str.append("<Subtype>Trouble</Subtype>");
			str.append("<DeviceId>00:11:22:33:44:55</DeviceId>");
			str.append("<HostMAC>00:11:11:11:44:55</HostMAC>");
			str.append("<Time>23:45:47</Time>");
			str.append("<EventType>Tamper</EventType>");
			str.append("<EventData>123</EventData>");
			str.append("<EventMessage>Tamper</EventMessage>");
			str.append("</Elpas>");
			break;
		}
		// 获取控制信息的字节数组
		byte[] strs = str.toString().getBytes();
		try {
			// 实例化数据报发送socket
			sendsocket = new DatagramSocket();
			// 实例化数据报接收socket
			//mySocket = new DatagramSocket(myport);
			// 实例化数据包文
			sendpacket = new DatagramPacket(strs, strs.length, host, hostport);
			// 发送
			sendsocket.send(sendpacket);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			sendsocket.close();
		}

	}
}

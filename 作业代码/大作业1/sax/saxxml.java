package com.hyh.sax;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class saxxml extends DefaultHandler{
		//格式化日期
		static DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		private String value;
		private String commond;
		
		
		public String getCommond() {
			return commond;
		}

		public void setCommond(String commond) {
			this.commond = commond;
		}

		//覆盖characters方法，处理元素中的字符
		public void characters(char [] ch,int start,int length) throws SAXException{
			value=new String(ch,start,length);
		}
		
		//覆盖endElement方法，用来处理当前解析到元素的结束标签
		public void endElement(String uri,String localName,String tagame)throws SAXException{
			if(tagame.equals("DeviceId")){
				System.out.println("目标设备DeviceId："+value);
			}else if(tagame.equals("HostMac")){
				System.out.println("主设备HostMac:"+value);
			}else	 if(tagame.equals("SlaveId")){
				System.out.println("从设备："+value);
			}else	 if(tagame.equals("Type")){
				System.out.println("消息类型："+value);
				this.commond=value;
			}else if(tagame.equals("Subtype")){
				System.out.println("额外信息Subtype:"+value);
				this.commond=value;
			}else if(tagame.equals("RequestId")){
				System.out.println("信息确认RequestId:"+value);
			}else if(tagame.equals("PacketId")){
				System.out.println("微章消息编号PacketId:"+value);
			}else if(tagame.equals("Motion")){
				System.out.println("Motion:"+value);
			}else if(tagame.equals("Battery")){
				System.out.println("Battery:"+value);
			}else if(tagame.equals("Buttons")){
				System.out.println("Buttons:"+value);
			}else if(tagame.equals("Id")){
				System.out.println("Id:"+value);
			}else if(tagame.equals("RSSI")){
				System.out.println("RSSI:"+value);
			}else if(tagame.equals("Noise")){
				System.out.println("Noise:"+value);
			}else if(tagame.equals("RacketId")){
				System.out.println("RacketId:"+value);
			}else if(tagame.equals("RawData")){
				System.out.println("RawData:"+value);
			}else if(tagame.equals("Group")){
				System.out.println("Group:"+value);
			}else if(tagame.equals("Data")){
				System.out.println("Data:"+value);
			}else if(tagame.equals("Time")){
				System.out.println("Time:"+value);
			}else if(tagame.equals("EventType")){
				System.out.println("EventType:"+value);
			}else if(tagame.equals("EventValue")){
				System.out.println("EventValue:"+value);
			}else if(tagame.equals("Tamper")){
				System.out.println("Tamper:"+value);
			}else if(tagame.equals("Voltage")){
				System.out.println("Tamper:"+value);
			}else if(tagame.equals("DeviceIp")){
				System.out.println("DeviceIp:"+value);
			}else if(tagame.equals("Messages")){
				System.out.println("Messages:"+value);
			}else if(tagame.equals("CRCErrors")){
				System.out.println("CRCErrors:"+value);
			}else if(tagame.equals("NoAnswer")){
				System.out.println("NoAnswer:"+value);
			}else if(tagame.equals("EventData")){
				System.out.println("EventData:"+value);
			}else if(tagame.equals("EventMessage")){
				System.out.println("EventMessage:"+value);
			}
				
		}
		
		//覆盖startElement，用来处理解析到元素的开始标签
		public void startElement(String uri,String localName,String tagName,Attributes attributes)throws SAXException{
			if(tagName.equals("Elpas"))
				System.out.println("获取的消息:");
		}
		
		public static void main(String[] args) {
			File xmlFile=new File("book.xml");
			//通过单例模式创建一个SAXParserFactory
			SAXParserFactory factory=SAXParserFactory.newInstance();
			try{
				//通过factory对象的newSAXParser()创建SAXPARser对象
				SAXParser parser=factory.newSAXParser();
				parser.parse(xmlFile, new saxxml());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}

package com.hyh.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxText {
	public static void main(String[] args) {
		try{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//创建SAX解析器
			SAXParser saxParser=factory.newSAXParser();
			//创建事件处理器
		//	MyHandler handler=new MyHandler();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

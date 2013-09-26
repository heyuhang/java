package com.hyh.sax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * xml文档的最基本的解析方式有两种，分别是文档对象模型（DOM）
 * xml解析的简单API
 */
public class testxml {
	public static void main(String[] args) {
		File xmlFile=new File("book.xml");
		DocumentBuilder builder=null;
		DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
		
		try{
			builder=builderFactory.newDocumentBuilder();
			Document document=builder.parse(xmlFile);
			
			Element root=document.getDocumentElement();
			System.out.println("XML根元素:"+root.getNodeName());
			
			NodeList childNodes=root.getChildNodes();
			for(int i=0;i<childNodes.getLength();i++){
				Node node=childNodes.item(i);
				if(node.getNodeName().equals("book")){
					System.out.println("\r\n书籍信息:");
					NodeList nodeDetail=node.getChildNodes();
					for(int j=0;j<nodeDetail.getLength();j++){
						Node detail=nodeDetail.item(j);
						if(detail.getNodeName().equals("name"))
							System.out.println("书名:"+detail.getTextContent());
						else if(detail.getNodeName().equals("author"))
							System.out.println("作者:"+detail.getTextContent());
						else if(detail.getNodeName().equals("email"))
							System.out.println("电子邮件:"+detail.getTextContent());
						else if(detail.getNodeName().equals("date"))
							System.out.println("出版日期:"+detail.getTextContent());
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

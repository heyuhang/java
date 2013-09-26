package com.hyh.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EchoClient {
	
	static final String endMessage=".";
	public static void main(String[] args) {
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		try{
			System.out.println("Welcome to echo client!"+
					"what's your host name?");
			String hostname=br.readLine();
			if(hostname.length()==0){
				hostname="localhost";
			}
			System.out.println("what's your host portNum?");
			String portNum=br.readLine();
			if(portNum.length()==0){
				portNum="7";
			}
			EchoClientHelper1 helper=new EchoClientHelper1(hostname,portNum);
			boolean done=false;
			String message,echo;
			while(!done){
				
				System.out.println("Enter a line to receive a echo back from server," +
						"or a single peroid to quit");
				message=br.readLine();
				if( (message.trim()).equals(endMessage)){
					done=true;
					helper.done();
				}else{
					echo=helper.getEcho(message);
					System.out.println(echo);
				}
			}
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

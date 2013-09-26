package com.hyh.net;

public class EchoServer {

	public static void main(String[] args) {
		int serverPort=7;
		if(args.length==1)
			serverPort=Integer.parseInt(args[0]);
		try{
			MyServerDatagramSocket socket=new MyServerDatagramSocket(serverPort);
			System.out.println("Echo server ready");
			while(true){
				
				DatagramMessage request=socket.receiveMessageAndSender();
				System.out.println("Request receive");
				String message=request.getMessage();
				System.out.println("message receive:"+message);
				socket.sendMessage(request.getAddress(),request.getPort(),message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

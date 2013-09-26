package com.hyh.rmi;

import java.rmi.Naming;
import java.util.Scanner;


/**
 * 投票客户端
 * @author heyuhang
 *
 */
public class OpinionClient {
	public static void main(String[] args) {
		try{
			int RMIPort=8080;
			String hostName="localhost";
			String portNum = null;
			String registryURL="rmi://localhost:"+RMIPort+"/opinion";
			OpinionInterface h=(OpinionInterface)Naming.lookup(registryURL);
			System.out.println("1 投票, 2 统计");
			Scanner in = new Scanner(System.in);
			String msg = in.next();
			if(msg.equals("1")){
				System.out.println("投票：1 yes, 2 no,3 don't care");
				String msg2 = in.next();
				switch(Integer.parseInt(msg2)){
				case 1:h.acceptOpinion("yes");break;
				case 2:h.acceptOpinion("no");break;
				case 3:h.acceptOpinion("don't care");break;
				default:System.out.println("投票完成！");
				}
			}else if(msg.equals("2")){
				String message=h.getOpinionCount();//
				System.out.println(message);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

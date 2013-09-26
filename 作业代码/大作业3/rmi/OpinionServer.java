package com.hyh.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * 投票服务器
 * @author heyuhang
 *
 */
public class OpinionServer {
	
	public static void main(String[] args) {
		String portNum="8080",registryURL="localhost";
		try{
			OpinionImpl opinion=new OpinionImpl();
			//startRegistry(RMIPortNum);
			
			startRegistry(Integer.parseInt(portNum));
			registryURL="rmi://localhost:"+portNum+"/opinion";
			Naming.rebind(registryURL, opinion);
			System.out.println("Some server ready");
		}catch(Exception e){
			System.out.println("Exception in someServer.main:"+e);
			e.printStackTrace();
		}
	}
	
	public static void startRegistry(int RMIPortNum) throws RemoteException {
		try{
			Registry registry=LocateRegistry.getRegistry(RMIPortNum);
			registry.list();
		}catch(Exception e){
			System.out.println("RMI registry cannot be located at port"+RMIPortNum);
			Registry registry=LocateRegistry.createRegistry(RMIPortNum);
			System.out.println("RMI registry created at port "+RMIPortNum);
		}
	}
}

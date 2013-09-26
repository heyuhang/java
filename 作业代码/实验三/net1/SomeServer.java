package ccom.hyh.net1;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class SomeServer {
	
	public static void main(String[] args) {
		String portNum="8080",registryURL="localhost";
		try{
			SomeImpl expportedogj=new SomeImpl();
			startRegistry(Integer.parseInt(portNum));
			
			startRegistry(Integer.parseInt(portNum));
			registryURL="rmi://localhost:"+portNum+"/some";
			Naming.rebind(registryURL, expportedogj);
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

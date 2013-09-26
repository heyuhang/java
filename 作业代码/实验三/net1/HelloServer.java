package ccom.hyh.net1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {

	public static void main(String[] args) {
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		String portNum,registryURL;
		try{
			System.out.println("Enter the RMIregistry port number:");
			portNum=(br.readLine()).trim();
			int RMIPortNum=Integer.parseInt(portNum);
			startRegistry(RMIPortNum);
			HelloImpl exportedObj=new HelloImpl();
			registryURL="rmi://localhost:"+portNum+"/hello";
			Naming.rebind(registryURL, exportedObj);
			System.out.println("server registered. resistry currently contains:");
			listRegistry(registryURL);
			System.out.println("Hello Server ready");
		}catch(Exception e){
			System.out.println("Exception int HelloServer.main:"+e);
		}
	}

	private static void listRegistry(String registryURL) throws RemoteException, MalformedURLException{
		System.out.println("Registry "+registryURL+" contains:");
		String [] names=Naming.list(registryURL);
		for(int i=0;i<names.length;i++)
			System.out.println(names[i]);
		
	}

	private static void startRegistry(int RMIPortNum) throws RemoteException{
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

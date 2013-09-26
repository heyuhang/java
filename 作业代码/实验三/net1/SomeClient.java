package ccom.hyh.net1;

import java.rmi.Naming;

public class SomeClient {

	public static void main(String[] args) {
		try{
			int RMIPort=8080;
			String hostName="localhost";
			String portNum = null;
			String registryURL="rmi://localhost:"+RMIPort+"/some";
			SomeInterface h=(SomeInterface)Naming.lookup(registryURL);
			String message=h.someMethod1();//
			System.out.println(message);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

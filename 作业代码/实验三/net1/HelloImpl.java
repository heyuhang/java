package ccom.hyh.net1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloInterface{

	protected HelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String sayHello(String name) throws RemoteException {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello, world!"+name;
	}

}

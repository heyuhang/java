package ccom.hyh.net1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SomeImpl extends UnicastRemoteObject implements SomeInterface{
	
	//construct method
	protected SomeImpl() throws RemoteException {
		super();

	}

	public String someMethod1() throws RemoteException {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "heyuhang";
	}

	public int someMethod2(float someParameter) throws RemoteException {

		return 0;
	}

}

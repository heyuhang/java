package ccom.hyh.net1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote{

	public String sayHello(String name) throws RemoteException;
		
}

package ccom.hyh.net1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SomeInterface extends Remote{

	public String someMethod1() throws RemoteException;
	
	public int someMethod2(float someParameter) throws RemoteException;
}

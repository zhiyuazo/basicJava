package rp_gumball_server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface gumballMachine extends Remote{

	public String getLocation() throws RemoteException;  
	public int getCount() throws RemoteException;  
	
}

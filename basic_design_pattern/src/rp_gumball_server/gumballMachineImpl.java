package rp_gumball_server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class gumballMachineImpl extends UnicastRemoteObject implements gumballMachine{

	protected gumballMachineImpl() throws RemoteException {
		super();
	}

	@Override
	public String getLocation() throws RemoteException {
		return "Beijing Haidian XibeiWang";
	}

	@Override
	public int getCount() throws RemoteException {
		return 99;
	}

	public static void main(String[] args) {
		try {
			gumballMachine service =  new gumballMachineImpl();
			Naming.rebind("gumballMachine01", service);
			System.out.println("gumballMachine is running OK!");
		} catch (Exception e) {
			System.out.println("gumballMachine is running failed!");
			e.printStackTrace();
		}
	}
	
}

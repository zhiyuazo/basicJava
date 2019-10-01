package rp_gumball_client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rp_gumball_server.gumballMachine;

public class gumballClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		gumballMachine service = (gumballMachine) Naming.lookup("rmi://127.0.0.1/gumballMachine01");
		
		String location = service.getLocation();
		int count = service.getCount();
		System.out.printf("%s @ %s have %d gumball remaind..","gumballMachine",location,count);
	}
}

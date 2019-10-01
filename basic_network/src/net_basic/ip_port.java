package net_basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ip_port {
	
	public static void main(String[] args) {
		
		try {
			InetAddress host = InetAddress.getLocalHost();
			String name = host.getHostName();
			String ip = host.getHostAddress();
			System.out.println(name + "  :   " +ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

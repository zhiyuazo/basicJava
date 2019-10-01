package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("Listenning: 8888 port");
		
		Socket s = ss.accept();
		System.out.println("connection request coming "+s);
		
		s.close();
		ss.close();
	}
}

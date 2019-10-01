package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_num {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss =  new ServerSocket(8888);
		System.out.println("Listening :8888");
		Socket s = ss.accept();
		
		InputStream is  = s.getInputStream();
		
		int  msg = is.read();//just 0-255
		System.out.println("Receive  :"+msg);
		is.close();
		s.close();
		ss.close();
	}
}

package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_str {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss =  new ServerSocket(8888);
		System.out.println("Listening :8888");
		Socket s = ss.accept();
		
		InputStream is  = s.getInputStream();
		DataInputStream dis = new DataInputStream(is); //Encapsulate into DataInputStream..
		
		String  msg = dis.readUTF();
		System.out.println("Receive  :"+msg);
		dis.close();
		s.close();
		ss.close();
	}
}

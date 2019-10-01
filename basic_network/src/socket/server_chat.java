package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_chat {
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss =  new ServerSocket(8888);
		System.out.println("Listening :8888");
		Socket s = ss.accept();
	
		InputStream is  = s.getInputStream();
		DataInputStream dis = new DataInputStream(is); //Encapsulate into DataInputStream..
		
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		while(true) {
			String msg = dis.readUTF();
			System.out.println("Receive  :"+msg);
			
			String reply = msg + "_OK";
			dos.writeUTF(reply);
			System.out.println("Send  :"+ reply);
			if(reply.equals("quit_OK")) {
				break;
			}
		}
		dos.close();
		dis.close();
		s.close();
	}
}

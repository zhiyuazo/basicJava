package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client_chat {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		Socket  s = new Socket("127.0.0.1", 8888);
		
		OutputStream  os = s.getOutputStream();
		DataOutputStream dos =  new DataOutputStream(os);
		
		InputStream  is =  s.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			 String c_str = sc.nextLine();
			 dos.writeUTF(c_str);
			 
			 
			 String s_str = dis.readUTF();
			 System.out.println("Receive: "+s_str);
			 if(c_str.equals("c_str")) {
				 break;
			 }
		}
	}
}

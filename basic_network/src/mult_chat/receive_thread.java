package mult_chat;

import java.io.InputStream;
import java.io.DataInputStream;
import java.net.Socket;

public class receive_thread extends Thread {
	
	private Socket s ;
	
	public receive_thread(Socket s) {
		this.s=s;
	}
	public void run() {
		
		try {
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			while(true) {
				String tmp =dis.readUTF();
				System.out.println("Receive: " + tmp);
				if(tmp.equals("quit")) {
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package mult_chat;

import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;

public class server_mult_chat_demo {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("Listening: 8888");
		
		Socket s = ss.accept();
	
		new send_thread(s).start();
		new receive_thread(s).start();
	}
}

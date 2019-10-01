package mult_chat;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class send_thread extends Thread{
	private Socket s ;
	public send_thread(Socket s) {
		this.s = s;		
	}
	
	public void run() {
		try {
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			Scanner sc = new Scanner(System.in);
			String tmp;
			while(true) {
				if(sc.hasNext()) {
					tmp = sc.nextLine();
					dos.writeUTF(tmp+"_OK");
					System.out.println("Send: " + tmp);
					if(tmp.equals("quit")) {
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

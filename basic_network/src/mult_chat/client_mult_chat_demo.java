package mult_chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client_mult_chat_demo {
	public static void main(String[] args) {
		 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            // 启动发送消息线程
            new send_thread(s).start();
            // 启动接受消息线程
            new receive_thread(s).start();
 
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

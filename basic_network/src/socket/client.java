package socket;
  
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
   
public class client {
   
    public static void main(String[] args)  {
           
        try {
            //���ӵ�������8888�˿�
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);
            s.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
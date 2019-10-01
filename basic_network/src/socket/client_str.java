package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.xml.validation.SchemaFactoryConfigurationError;

public class client_str {
	public static void main(String[] args) {
		 
        try {
            Socket s = new Socket("127.0.0.1", 8888);
 
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            //--------
            Scanner  sc = new Scanner(System.in);
            String str = sc.nextLine();
            
            //Ê¹ÓÃwriteUTF·¢ËÍ×Ö·û´®
            dos.writeUTF(str);
            dos.close();
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

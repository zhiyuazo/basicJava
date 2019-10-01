package test ;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.*;

public class test_gui {
	  public static void main(String[] args) {
	        // Button component.. 
	        JButton b = new JButton("KO! other...");
	        	b.setBounds(50, 50, 280, 30);

	        // Major-frame component..
	        JFrame f = new JFrame("Hello-gui");
	        	f.setSize(400, 300);
	        	//----
	        	point p = getpointfromlocationfile();
	        	if(p!=null)
	        		f.setLocation(p.x, p.y);
	        	else
	        		f.setLocation(200, 200);
	            //----
	        	f.setLayout(null);
	        	f.add(b);
	        	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        	f.setVisible(true);  //must place this at end.  
	        new savepostionthread(f).start();
	    }
	  	
	  	static class point{
	  		int x;
	  		int y;
	  	}
	  	
	  	public static point getpointfromlocationfile() {
	  		File file = new File("location.txt");
	  		point p = null;
	  		try(FileInputStream fis = new FileInputStream(file); DataInputStream dis = new DataInputStream(fis);){
	  			int x = dis.readInt();
	  			int y = dis.readInt();
	  			p = new point();
	  			p.x=x;
	  			p.y=y;
	  		}catch(FileNotFoundException e) {
	  			
	  		}catch(IOException e1) {
	  			e1.printStackTrace();
	  		}
	  		return p;
	  	}
}

class savepostionthread extends Thread {
	
	private JFrame f; 
	File file = new File("location.txt");
    
	savepostionthread(JFrame f){
		this.f =f ; 
	}
	
	public void run() {
		while(true) {
			int x = f.getX();
			int y = f.getY();
			
			try(FileOutputStream fos = new FileOutputStream(file);
				DataOutputStream dos = new DataOutputStream(fos);){
				dos.writeInt(x);
				dos.writeInt(y);				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
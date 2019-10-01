package component;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
public class c_progressbar {
	
	public static void main(String[] args) {
		
		JProgressBar pb = new JProgressBar();
			pb.setMaximum(100);
			for(int i=0;i<100;i++) {
				pb.setValue(i);
				//pb.setStringPainted(true);
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			pb.setStringPainted(true);
			
			
		JFrame f = new JFrame("test");
			f.setSize(400, 100);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(new FlowLayout());
			f.add(pb);
			f.setVisible(true);
	}

}

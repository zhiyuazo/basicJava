package panel;

import javax.swing.*;
import java.awt.*;


public class scrollpane {

	public static void main(String[] args) {
		
		
		JTextArea ta = new JTextArea();
		for(int i = 0 ; i<1000;i++) {
			ta.append(String.valueOf(i));
		}
			ta.setLineWrap(true);	
		
		JScrollPane scrp = new JScrollPane(ta);
	
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.setContentPane(scrp);
			//f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
}

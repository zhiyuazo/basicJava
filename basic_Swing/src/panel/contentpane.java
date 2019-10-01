package panel;

import javax.swing.*;
import java.awt.*;

public class contentpane {
	
	public static void main(String[] args) {
		
		// there is a ContentPane on JFrame 
		//Usually, JFrame.add() is actually add component into ContentPane 
		JButton b1 = new JButton("hero-1");
		JButton b2 = new JButton("hero-2");
		
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.setLayout(new FlowLayout());
			f.add(b1);  // ==  f.getContentPane().add(b2);  
			f.getContentPane().add(b2);
			System.out.println(b1.getParent());
			System.out.println(b2.getParent());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
}

package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.*;

public class basicpanel {

	public static void main(String[] args) {
		
		JButton b1 = new JButton("hero-1");
		JButton b2 = new JButton("hero-2");
		JButton b3 = new JButton("hero-3");
		JButton b4 = new JButton("hero-4");
		JButton b5 = new JButton("hero-5");
		JButton b6 = new JButton("hero-6");
		
		JPanel p1 = new JPanel();
			p1.setBounds(50,50,300,40);
			p1.setBackground(Color.RED);
			p1.setLayout(new FlowLayout());
			p1.add(b1);
			p1.add(b2);
			p1.add(b3);
			
		JPanel p2 = new JPanel();
			p2.setBounds(80,200,300,40);
			p2.setBackground(Color.BLUE);
			//p2.setLayout(null);
			p2.add(b4);
			p2.add(b5);
			p2.add(b6);
			
		
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.setLayout(null);
			f.add(p1);
			f.add(p2);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		
	}
	
	
}

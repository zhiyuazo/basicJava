package component;

import javax.swing.*;
import java.awt.*;


public class c_button {

	public static void main(String[] args) {
		
		JButton b = new JButton("Default");
			b.setBounds(0,0,80,60);
		
		JFrame f = new JFrame("leart_button");
			f.setSize(400, 400);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(null);
			f.add(b);
			f.setVisible(true);
	}
}

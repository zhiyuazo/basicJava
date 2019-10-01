package component;

import javax.swing.*;
import java.awt.*;

public class c_checkbox {

	public static void main(String[] args) {
		
		JCheckBox bcheck = new JCheckBox("love");
			bcheck.setBounds(0,0,100,30);
			bcheck.setSelected(true);
			
		JCheckBox bcheck1 = new JCheckBox("like");
			bcheck1.setBounds(0,35,100,30);
			bcheck1.setSelected(false);
			System.out.println(bcheck1.isSelected());
			
		ButtonGroup bg = new ButtonGroup();
			bg.add(bcheck);
			bg.add(bcheck1);
			
		JFrame f = new JFrame("learn_checkbox");
			f.setSize(400, 400);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			f.add(bcheck);
			f.add(bcheck1);
			f.setLayout(null);
			f.setVisible(true);
	}
	
}

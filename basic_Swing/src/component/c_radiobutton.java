package component;

import javax.swing.*;
import java.awt.*;

public class c_radiobutton {

	public static void main(String[] args) {
		
		JRadioButton bradio = new JRadioButton("love");
			bradio.setBounds(0,0,100,30);
			bradio.setSelected(false);
		
		JRadioButton bradio1 = new JRadioButton("like");
			bradio1.setBounds(0,35,100,30);
			bradio1.setSelected(false);
			
		ButtonGroup bg = new ButtonGroup();
			bg.add(bradio);
			bg.add(bradio1); //group the 2 button as one group, 
			
		JFrame f =new JFrame("learn_radiobox");
			f.setSize(400, 400);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(null);
			f.add(bradio);
			f.add(bradio1);   // still need add the 2 button into JFrame one by one
			f.setVisible(true);
			
			
		
	}
}

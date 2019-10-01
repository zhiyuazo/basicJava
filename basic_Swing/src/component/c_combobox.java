package component;

import javax.swing.*;
import java.awt.*;

public class c_combobox {

	public static void main(String[] args) {
		
		String[] dream = new String[] {"Home","Goodwife","Money","power","ladies","Motocycle"};
		JComboBox cb = new JComboBox(dream);
			cb.setBounds(0,0,80,60);
		
		JFrame f =new JFrame("learn_combobox");
			f.setSize(400, 400);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(null);
			f.add(cb);
			f.setVisible(true);
	}
	
}

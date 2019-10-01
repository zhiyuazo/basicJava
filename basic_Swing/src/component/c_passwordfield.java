package component;

import javax.swing.*;
import java.awt.*;

public class c_passwordfield {
	
	public static void main(String[] args) {
		
		JLabel l = new JLabel("PASSWORD:");
		
		JPasswordField pf = new JPasswordField("");
			pf.setText("&48kdh4@#");
			//pf.setPreferredSize(new Dimension(80,30));
		
		
		JFrame f =new JFrame("learn_combobox");
			f.setSize(400, 100);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(new GridLayout(2,1));
			f.add(l);
			f.add(pf);
			f.setVisible(true);	
	}

}

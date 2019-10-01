package component;


import javax.swing.*;
import java.awt.*;
public class c_textfield {
	
	public static void main(String[] args) {
		
		JLabel lname = new JLabel("NAME");
		JTextField tfname = new JTextField("");
			tfname.setText("admin");
			//tfname.setPreferredSize(new Dimension(80,30));
		
		JLabel lpassword = new JLabel("PASSWORD");
		JTextField tfpassword = new JTextField("");
			tfpassword.setText("password");
			//tfpassword.setPreferredSize(new Dimension(80,30));
		
		JFrame f =new JFrame("learn_combobox");
			f.setSize(400, 100);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(new GridLayout(2,1));
			
			f.add(lname);
			f.add(tfname);
			f.add(lpassword);
			f.add(tfpassword);
			f.setVisible(true);	
		
	}
	
}

package comprehensive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class check_password {

	public static void main(String[] args) {
		
		String name = "zhiyuan";
		char[] password = {'1','2','3','4','5','6'};
		
		JButton b = new JButton("Login");
		
		JTextField  tf = new JTextField("username");
			tf.setPreferredSize(new Dimension(80,30));
			
		JPasswordField  pf = new JPasswordField("password");
			pf.setPreferredSize(new Dimension(80,30));
			
		JLabel ln = new JLabel("account: ");
		JLabel lp = new JLabel("password");
		
			
		JPanel p_up = new JPanel();
			p_up.setLayout(new FlowLayout());
			p_up.add(ln);
			p_up.add(tf);
			p_up.add(lp);
			p_up.add(pf); 
			 
			
		JPanel p_down = new JPanel();
			p_down.add(b);
		
		
		
		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setLocationRelativeTo(null);
			f.setLayout(new BorderLayout());
			f.add(p_up,BorderLayout.NORTH);
			f.add(p_down,BorderLayout.CENTER);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			
			
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(pf.getPassword() instanceof char[]);
				if(tf.getText().equals(name)) {
					if(new String(pf.getPassword()).equals(new String(password))) {
						JOptionPane.showMessageDialog(f, "Login Successfully..");
					}else {
						JOptionPane.showMessageDialog(f, "Username or password is incorrect..");
					}
				}else {
					JOptionPane.showMessageDialog(f, "Username or password is incorrect..");
				}
			}
		});
	}
}

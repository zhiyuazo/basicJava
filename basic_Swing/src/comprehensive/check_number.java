package comprehensive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class check_number {
	
	public static void main(String[] args) {
		
		JButton b = new JButton("Check..");
		JTextField txf =  new JTextField();
			txf.setPreferredSize(new Dimension(80,30));

		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setLocationRelativeTo(null);
			f.setLayout(new FlowLayout());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(txf);
			f.add(b);
			f.setVisible(true);
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String tmp = txf.getText();
				try{
					//Integer.parseInt(String s)
					Integer.valueOf(tmp);
					JOptionPane.showMessageDialog(f, "Integer value is: "+tmp);
				}catch(Exception e1) {
					if(tmp.length() == 0) {
						JOptionPane.showMessageDialog(f, "Empty...");
					}else {
						JOptionPane.showMessageDialog(f, "not Integer-value...");
						txf.grabFocus();
					}
				}
			}
		});
	}
}

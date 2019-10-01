package comprehensive;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
public class practice_combine {
	
	
	public static void main(String[] args) {
		
		JButton b = new JButton("Generate");
			b.setPreferredSize(new Dimension(200,30));
		
		JLabel l1 = new JLabel("Location");
		JLabel l2 = new JLabel("Inc_type");
		JLabel l3 = new JLabel("Inc_name");
		JLabel l4 = new JLabel("Boss");
		JLabel l5 = new JLabel("Debt");
		JLabel l6 = new JLabel("Product");
		JLabel l7 = new JLabel("Unit_price");
		
		JTextField  tf_address = new JTextField("Beijing");
			tf_address.setSize(new Dimension(80,30));
		JTextField  tf_Inc_type = new JTextField("IT");
			tf_Inc_type.setSize(new Dimension(80,30));
		JTextField  tf_Inc_name = new JTextField("NOKIA");
			tf_address.setSize(new Dimension(80,30));
		JTextField  tf_Boss = new JTextField("cherry");
			tf_Boss.setSize(new Dimension(80,30));
		JTextField  tf_Debt = new JTextField("10000");
			tf_Debt.setSize(new Dimension(80,30));
		JTextField  tf_Product = new JTextField("conmucation");
			tf_Product.setSize(new Dimension(80,30));
		JTextField  tf_Unit_price = new JTextField("3");
			tf_Unit_price.setSize(new Dimension(80,30));
		
		JTextArea   ta = new JTextArea();
			String display = String.format("%s,%s,%s,%s,%s,%s,%s",tf_address.getText(),tf_Inc_type.getText(),tf_Inc_name.getText(),tf_Boss.getText(),tf_Debt.getText(),tf_Product.getText(),tf_Unit_price.getText());
			ta.setEditable(true);
			ta.setText(display);
			ta.setLineWrap(true);
			ta.setBounds(10,200,400,150);

		JPanel p_up = new JPanel();
			p_up.setLayout(new GridLayout(4,3,10,10));
			p_up.add(l1);
			p_up.add(tf_address);
			p_up.add(l2);
			p_up.add(tf_Inc_type);
			p_up.add(l3);
			p_up.add(tf_Inc_name);
			p_up.add(l4);
			p_up.add(tf_Boss);
			p_up.add(l5);
			p_up.add(tf_Debt);
			p_up.add(l6);
			p_up.add(tf_Product);
			p_up.add(l7);
			p_up.add(tf_Unit_price);
			
		JPanel p_mid = new JPanel();
			p_mid.setSize(new Dimension(80,40));
			p_mid.add(b);
			
		JPanel p_down = new JPanel();
			p_down.add(ta);
			p_mid.setSize(new Dimension(200,200));
			
		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setLayout(new GridLayout(3,1));
			f.add(p_up);
			f.add(p_mid);
			f.add(p_down);
			//f.add(p_up,BorderLayout.NORTH);
			//f.add(p_mid,BorderLayout.CENTER);
			//f.add(p_down,BorderLayout.SOUTH);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			b.grabFocus();
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String display = String.format("%s,%s,%s,%s,%s,%s,%s",tf_address.getText(),tf_Inc_type.getText(),tf_Inc_name.getText(),tf_Boss.getText(),tf_Debt.getText(),tf_Product.getText(),tf_Unit_price.getText());
				ta.setText(display);
				tf_address.grabFocus();
			}			
		});
	}
}

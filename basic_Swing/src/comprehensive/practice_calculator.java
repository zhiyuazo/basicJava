package comprehensive;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;


public class practice_calculator {
	
	public static void main(String[] args) {
		
		JButton b = new JButton("Calculate");
		
		int gap = 5;
		//------------------------------
		JLabel l1 = new JLabel("MONEY/init(￥)");
		JLabel l2 = new JLabel("rate/year(%)");
		JLabel l3 = new JLabel("total/years(year)");
		JLabel l4 = new JLabel("increase/year(￥)");
		
		JTextField  tf1 =new JTextField();
			tf1.setSize(new Dimension(80,30));
			tf1.setName("tf1");
		JTextField  tf2 =new JTextField();
			tf2.setSize(new Dimension(80,30));
			tf2.setName("tf2");
		JTextField  tf3 =new JTextField();
			tf3.setSize(new Dimension(80,30));
			tf3.setName("tf3");
		JTextField  tf4 =new JTextField();
			tf4.setSize(new Dimension(80,30));
			tf4.setName("tf4");
		//------------------------------------	
		JLabel l5 = new JLabel("total/capita(￥)");
		JLabel l6 = new JLabel("total/interest(￥)");
		JLabel l7 = new JLabel("total(￥)");
			
		JTextField  tf5 =new JTextField();
			tf5.setSize(new Dimension(80,50));
		JTextField  tf6 =new JTextField();
			tf6.setSize(new Dimension(80,50));
		JTextField  tf7 =new JTextField();
			tf7.setSize(new Dimension(80,50));

			
		JPanel p_up = new JPanel();
			p_up.setLayout(new GridLayout(4,2,gap,gap));
			p_up.add(l1);
			p_up.add(tf1);
			p_up.add(l2);
			p_up.add(tf2);
			p_up.add(l3);
			p_up.add(tf3);
			p_up.add(l4);
			p_up.add(tf4);
			p_up.setVisible(true);
			
		JPanel p_down = new JPanel();
			p_down.setLayout(new GridLayout(3,2,gap,gap));
			p_down.add(l5);
			p_down.add(tf5);
			p_down.add(l6);
			p_down.add(tf6);
			p_down.add(l7);
			p_down.add(tf7);
			p_down.setVisible(true);
		
		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setLocationRelativeTo(null);
			f.setLayout(new BorderLayout());
			f.add(p_up,BorderLayout.NORTH);
			f.add(b,BorderLayout.CENTER);
			f.add(p_down,BorderLayout.SOUTH);
			//f.add(p_down,BorderLayout.CENTER);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(checkfiled(tf1) && checkfiled(tf2)&&checkfiled(tf3)&&checkfiled(tf4))) {
					JOptionPane.showMessageDialog(f, "Please Fill conrrect parameter into fields..");
				}
				
				int benjin = Integer.parseInt(tf1.getText());
				double rate   = Double.parseDouble(tf2.getText());
				int years  = Integer.parseInt(tf3.getText());
				int step   = Integer.parseInt(tf4.getText());
				
				tf5.setText(String.valueOf(benjin + step*years));
				
				//-----------------------------
				double result=0;
				for(int i = years ; i>0 ; i-- ) {
					int tmp ;
					if(i == years) {
						tmp = benjin;
					}else {
						tmp = step;
					}
					
					result += summary(tmp,rate,i) - tmp;
				}
				tf6.setText(String.valueOf(result));
				//------------------------------------
				tf7.setText(String.valueOf(Integer.parseInt(tf5.getText())+ Double.parseDouble(tf6.getText())));
			}			
		});
	}
	
	private static Double summary(Integer init, Double rate, Integer years) {	
		double sum = init * Math.pow((1+rate/100), years);
		return sum;
	}
	
	private static boolean checkfiled(JTextField tf) {
		try {
			if(tf.getName().equals("tf2")) {
				Double.parseDouble(tf.getText());
				
			}else {
				Integer.parseInt(tf.getText());
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	
}

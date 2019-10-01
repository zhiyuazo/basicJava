package component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class c_lable {
	
	public static void main(String[] agrs) {
	
		ImageIcon img = new ImageIcon("daoxianghu.jpg");
		JLabel l0 = new JLabel();   
		l0.setIcon(img);
		l0.setBounds(50,50,img.getIconWidth(),img.getIconHeight());
		
		JLabel l = new JLabel("Zhiyaun will be powerful man..");   
			l.setBounds(50,50,280,30);
			l.setForeground(Color.red);
		
			
		JFrame f = new JFrame("learn_label");
			f.setSize(400,400);
			f.setLocation(200,200);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(l);
			f.add(l0);
			f.setLayout(new GridLayout(2,1));
			f.setVisible(true);
	}
}

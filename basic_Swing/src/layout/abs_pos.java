package layout;
import javax.swing.*;
import java.awt.event.*;

public class abs_pos {
	
	public static void main(String[] args) {
		JButton b0 = new JButton("1-money");
			b0.setBounds(50,50,80,30);
		JButton b1 = new JButton("2-live");
			b1.setBounds(150,50,80,30);
		JButton b2 = new JButton("3-right");
			b2.setBounds(250,50,80,30);
		JButton b3 = new JButton("4-reputation"); 
			//b3.setBounds(350,50,80,30); //if the position and size not be configured, this button will not be displayed in Frame..
		
		JFrame f = new JFrame("abs_pos");
			f.add(b0);
			f.add(b1);
			f.add(b2);
			f.add(b3);
			f.setSize(400, 200);
			f.setLocation(50, 50);
			f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
}

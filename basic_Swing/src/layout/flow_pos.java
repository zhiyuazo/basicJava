package layout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;


//!! In flow layout, not need to set the pos and size for buttons...
public class flow_pos {
	
	public static void main(String[] args) {
		JButton b0 = new JButton("1-money");
			//b0.setBounds(50,50,80,30);
		JButton b1 = new JButton("2-live");
			//b1.setBounds(150,50,80,30);
		JButton b2 = new JButton("3-right");
			//b2.setBounds(250,50,80,30);
		JButton b3 = new JButton("4-reputation");
		
		JFrame f = new JFrame("flow_pos");
			f.add(b0);
			f.add(b1);
			f.add(b2);
			f.add(b3);
			f.setSize(400, 200);
			f.setLocation(50, 50);
			f.setLayout(new FlowLayout());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
}

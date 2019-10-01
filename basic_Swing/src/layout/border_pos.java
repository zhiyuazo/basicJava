package layout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;


//!! In flow layout, not need to set the pos and size for buttons...
public class border_pos {
	
	public static void main(String[] args) {
		JButton b0 = new JButton("南帝");
			//b0.setBounds(50,50,80,30);
		JButton b1 = new JButton("北丐");
			//b1.setBounds(150,50,80,30);
		JButton b2 = new JButton("东邪");
			//b2.setBounds(250,50,80,30);
		JButton b3 = new JButton("西毒");
		JButton b4 = new JButton("中神通");
		
		JFrame f = new JFrame("border_pos");
			f.setLayout(new BorderLayout()); //must pre than add function	
			f.add(b0,BorderLayout.SOUTH);
			f.add(b1,BorderLayout.NORTH);
			f.add(b2,BorderLayout.EAST);
			f.add(b3,BorderLayout.WEST);
			f.add(b4,BorderLayout.CENTER);
			f.setSize(400, 400);
			f.setLocation(50, 50);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
}

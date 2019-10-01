package panel;

import javax.swing.*;
import java.awt.*;

public class tabbedpanel {
	
	public static void main(String[] args) {
		
		JButton b1 = new JButton("liubei");
		JButton b2 = new JButton("guanyu");
		JButton b3 = new JButton("zhangfei");
		JButton b4 = new JButton("caomengde");
		JButton b5 = new JButton("guofengxiao");
		JButton b6 = new JButton("xunyu");
		ImageIcon i = new ImageIcon("4baby.png");
		
		JPanel p1 = new JPanel();
			p1.setBounds(50,50,300,60);
			p1.setBackground(Color.BLUE);
			p1.setLayout(new FlowLayout());
			p1.add(b1);
			p1.add(b2);
			p1.add(b3);
			
		JPanel p2 = new JPanel();
			p2.setBounds(50,50,300,60);
			p2.setBackground(Color.ORANGE);
			//p2.setLayout(new FlowLayout());
			p2.add(b4);
			p2.add(b5);
			p2.add(b6);
			
		JTabbedPane  tp = new JTabbedPane();
			tp.add(p1);
			tp.add(p2);
			tp.setTitleAt(0, "red");
			tp.setTitleAt(1, "blue");
			tp.setIconAt(0,i);
			tp.setIconAt(1,i);
			
		
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.setContentPane(tp);
			//f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}

}

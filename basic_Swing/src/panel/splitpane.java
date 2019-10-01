package panel;

import javax.swing.*;
import java.awt.*;

public class splitpane {
	
	public static void main(String[] args) {
		
		JButton b1 = new JButton("liubei");
		JButton b2 = new JButton("guanyu");
		JButton b3 = new JButton("zhangfei");
		JButton b4 = new JButton("caomengde");
		JButton b5 = new JButton("guofengxiao");
		JButton b6 = new JButton("xunyu");
		
		JPanel pleft = new JPanel();
			pleft.setBounds(50,50,300,60);
			pleft.setBackground(Color.RED);
			pleft.setLayout(new FlowLayout());
			pleft.add(b1);
			pleft.add(b2);
			pleft.add(b3);
		JPanel pright = new JPanel();
			pright.setBounds(10,150,300,60);
			pright.setBackground(Color.GREEN);
			//pright.setLayout(new FlowLayout());
			pright.add(b4);
			pright.add(b5);
			pright.add(b6);
			
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pleft,pright);
			sp.setDividerLocation(80);
				
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.setContentPane(sp);
			//f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		
	}

}

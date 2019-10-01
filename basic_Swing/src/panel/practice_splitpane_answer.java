package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class practice_splitpane_answer {
	
	
	public static void main(String[] args) {
		
		JButton b1 = new JButton("memory1");
		JButton b2 = new JButton("memory2");
		JButton b3 = new JButton("memory3");
		
		JLabel l = new JLabel();
		
		JPanel pleft = new JPanel();
			pleft.add(b1);
			pleft.add(b2);
			pleft.add(b3);
			pleft.setBackground(Color.CYAN);
			
		JPanel pright = new JPanel(new CardLayout());
			pright.add(l);
			pright.setBackground(Color.ORANGE);
		
				
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pleft,pright);
			sp.setDividerLocation(80);
		
		
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.setContentPane(sp);
			//f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocationRelativeTo(null);
			f.setVisible(true);	
			switchpic(b1,"test1.jpg",l);
			switchpic(b2,"test2.jpg",l);
			switchpic(b3,"test3.jpg",l);
			
	}
		
		private static void switchpic(JButton b, String filename, JLabel l) {
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tmp = e.getActionCommand().replaceAll("memory", "test");
					ImageIcon i = new ImageIcon(tmp+".jpg");
					l.setIcon(i);	
			}});
		}
}

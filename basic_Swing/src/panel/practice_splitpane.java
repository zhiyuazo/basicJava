package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class practice_splitpane {
	
	public static void main(String[] args) {
		
		JButton b1 = new JButton("memory1");
		JButton b2 = new JButton("memory2");
		JButton b3 = new JButton("memory3");
		
		
		ImageIcon i1 = new ImageIcon("test1.jpg");
		ImageIcon i2 = new ImageIcon("test2.jpg");
		ImageIcon i3 = new ImageIcon("test3.jpg");
		
		JLabel l1 = new JLabel();
			l1.setIcon(i1);
			l1.setBounds(50,50,i1.getIconWidth(),i1.getIconHeight());
			
		JLabel l2 = new JLabel();
			l2.setIcon(i2);
			l2.setBounds(50,50,i2.getIconWidth(),i2.getIconHeight());
	
		JLabel l3 = new JLabel();
			l3.setIcon(i3);
			l3.setBounds(50,50,i3.getIconWidth()/10,i3.getIconHeight()/10);
		
		
		JPanel pleft = new JPanel();
			pleft.add(b1);
			pleft.add(b2);
			pleft.add(b3);
			
		
		JPanel pr1 = new JPanel();
			pr1.setBackground(Color.BLUE);
			pr1.add(l1);
		JPanel pr2 = new JPanel();
			pr2.setBackground(Color.RED);
			pr2.add(l2);
		JPanel pr3 = new JPanel();
			pr3.setBackground(Color.GREEN);
			pr3.add(l3);
		
		JPanel pright = new JPanel(new CardLayout());
			pright.add(pr1,"memory1");
			pright.add(pr2,"memory2");
			pright.add(pr3,"memory3");
				
		
				
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
		
		b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cl = (CardLayout) (pright.getLayout());
					cl.show(pright,(String) e.getActionCommand());

				}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (pright.getLayout());
				cl.show(pright,(String) e.getActionCommand());

			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (pright.getLayout());
				cl.show(pright,(String) e.getActionCommand());

			}
		});
	}
}

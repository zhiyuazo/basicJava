package container;

import java.awt.event.*;
import javax.swing.*;
public class con_practise {
	public static void main(String[] args) {

		JFrame f = new JFrame("outside-frame");
			f.setSize(500, 500);
			f.setLocation(100,100);
			f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);		
			
		JButton b = new JButton("Open Dialog");
			b.setBounds(50,50,280,30);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog d = new JDialog(f);
						JButton bb = new JButton("Lock");
					 	bb.setBounds(50,50,280,30);
					 	bb.addActionListener(new ActionListener() {
					 		public void actionPerformed(ActionEvent e) {
					 			if(d.isResizable() == false) {
					 				d.setResizable(true);
					 				bb.setText("Lock");
					 			}else {
					 				d.setResizable(false);
					 				bb.setText("UnLock");
					 			}
					 		}
					 	});
						d.setModal(true);
						d.setTitle("modal-dialog");
						d.setSize(400,300);
						//d.setResizable(false);
						d.setLocation(200,200);
						d.setLayout(null);
						d.add(bb);
						d.setVisible(true);
				}
			});
		f.add(b);
	}
}

package container;

import java.awt.event.*;
import javax.swing.*;
public class dialog_jframe {
	public static void main(String[] args) {
		JButton b = new JButton("Open Dialog");
			b.setBounds(50,50,280,30);
		
		JButton bb = new JButton("Lock the Dialog?");
			bb.setBounds(50,50,280,30);
		
		JFrame f = new JFrame("outside-frame");
			f.setSize(400, 200);
			f.setLocation(100,100);
			f.setLayout(null);
			f.add(b);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);		
			
		JDialog d = new JDialog(f);
			d.setModal(true);
			d.setTitle("modal-dialog");
			d.setSize(400,300);
			d.setResizable(false);
			d.setLocation(500,300);
			d.setLayout(null);
			d.add(bb);
			d.setVisible(true);
	
	}
}

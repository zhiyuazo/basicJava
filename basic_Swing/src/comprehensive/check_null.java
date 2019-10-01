package comprehensive;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class check_null {

	public static void main(String[] args) {
		
		JButton b1 = new JButton("Check1..");
		JButton b2 = new JButton("Check2..");
		
		JTextField tf = new JTextField();
			tf.setPreferredSize(new Dimension(80,30));
			
		//what's difference between textfield and textArea??? 
			//JTextField : single line input...
			//JTextArea  : multi-line input...
		JTextArea txa = new JTextArea();
			txa.setEditable(true);
			txa.setLineWrap(true);
			txa.setBounds(200,200,100,30);
		
		
		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setLocationRelativeTo(null);
			f.setLayout(new FlowLayout());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(tf);
			f.add(b1);
			f.add(b2);
			f.setVisible(true);
			
		b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tf.getText().length() == 0) {
						JTextField txf = new JTextField();
							txf.setText("Warning..");
							txf.setEditable(false);
						JDialog d = new JDialog(f);
							d.setTitle("Warning..");
							d.setModal(true);
							d.setSize(100,100);
							d.setLocation(200, 200);
							d.setLocationRelativeTo(f);
							d.add(txf);
							d.setVisible(true);
					}
				}
			});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf.getText().length() == 0) {
					JOptionPane.showMessageDialog(f, "Is Empty..");
					tf.grabFocus();
				}
			}
		});
	}
	
}

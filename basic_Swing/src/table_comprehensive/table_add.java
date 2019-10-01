package table_comprehensive;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

import table_comprehensive.person_table_model;

public class table_add {

	static person_table_model ptm = new person_table_model();
	static JTable t = new JTable(ptm);
	public static void main(String[] args) {
		t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		t.getSelectionModel().setSelectionInterval(0, 0);
		JScrollPane p_up = new JScrollPane(t);
		
		JButton b = new JButton("Add");
		JPanel p_down = new JPanel();
			p_down.add(b);
		
		JFrame f = new JFrame("table_comprehensive_add");
			f.setSize(500,500);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocation(200,200);
			f.setLayout(new FlowLayout());
			f.add(p_up);
			f.add(p_down);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new add_dialog(f).setVisible(true);;
			}
		});			
	}
	
	static class add_dialog extends JDialog{
		JLabel l_id =  new JLabel("Id: ");
		JLabel l_name = new JLabel("Name: ");
		JLabel l_hp =  new JLabel("Hp: ");
		JLabel l_age =  new JLabel("Age: ");
		JTextField t_id = new JTextField("");
		JTextField t_name = new JTextField("");
		JTextField t_hp = new JTextField("");
		JTextField t_age = new JTextField("");
		JButton b = new JButton("Ok..");
			
		
		public add_dialog(JFrame f) {
			super(f);
			//b.setEnabled(false);
			
			JPanel p_up = new JPanel();
					p_up.setLayout(new GridLayout(4,2));
					p_up.add(l_id);p_up.add(t_id);p_up.add(l_name);p_up.add(t_name);p_up.add(l_hp);p_up.add(t_hp);p_up.add(l_age);p_up.add(t_age);
			JPanel p_down = new JPanel();
				p_down.add(b);
			
			this.setLayout(new FlowLayout());
			this.add(p_up);
			this.add(p_down);
			this.setSize(300, 200);
			this.setLocationRelativeTo(f);
			
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(check_empty(t_id,"ID") && check_empty(t_name,"name") &&check_empty(t_hp,"HP") &&check_empty(t_age,"AGE") ) {
						ptm.add(new String[] {t_id.getText(),t_name.getText(),t_hp.getText(),t_age.getText()});
						update_table();
						add_dialog.this.setVisible(false);// Why this fromat???????					
						}
					}
			});
		}
	}
	public static void update_table() {
		t.updateUI();
	}
	
	private static boolean check_empty(JTextField tf,String title) {
		if(tf.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, title+"  can not be empty..");
			tf.grabFocus();
			return false;
		}
		return true;
	}
}

package table_comprehensive;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import table_comprehensive.table_add.add_dialog;

public class table_remove {
	static person_table_model ptm = new person_table_model();
	static JTable t = new JTable(ptm);
	public static void main(String[] args) {
		t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		t.getSelectionModel().setSelectionInterval(0, 0);
		JScrollPane p_up = new JScrollPane(t);
		
		JButton b1 = new JButton("Add");
		JButton b2 = new JButton("Remove");
		JPanel p_down = new JPanel();
			p_down.add(b1);
			p_down.add(b2);
		
		JFrame f = new JFrame("table_comprehensive_add");
			f.setSize(500,500);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocation(200,200);
			f.setLayout(new FlowLayout());
			f.add(p_up);
			f.add(p_down);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				new add_dialog(f).setVisible(true);;
			}
		});			
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int index = t.getSelectedRow();
				if(-1 == index ) {
					JOptionPane.showMessageDialog(f, "Must select one-line..");
				}
				if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(f, "MakeSure Delete?")) {
					return;
				}
				ptm.delete(index);
				update_table();
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

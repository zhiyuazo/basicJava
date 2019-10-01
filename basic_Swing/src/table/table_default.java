package table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class table_default {
	public  static void main(String[] args) {
		//---up
		JLabel l = new JLabel();
			l.setText("none selected!");
		JPanel p_up = new JPanel();
			p_up.add(l);
			
		//---middle
		person_table_model ptm = new person_table_model();
		JTable t = new JTable(ptm);
			t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Can only select 1 line...
			t.getSelectionModel().setSelectionInterval(0, 0); // select the last Line...
			t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					e.getFirstIndex();
					e.getLastIndex();
					int row = t.getSelectedRow();
					int col = t.getSelectedColumn();
					l.setText("current selected is "+ptm.getColumnName(col) + ":"+ ptm.getValueAt(row, col));
				}	
			});
		
		JScrollPane p_mid = new JScrollPane(t);
		
		//---down
		JButton b = new JButton("UPDATE");
		JLabel l_id = new JLabel("ID");
		JTextField t_id = new JTextField("9");
				t_id.setPreferredSize(new Dimension(80,30));
		JLabel l_name = new JLabel("NAME");
		JTextField t_name = new JTextField("zzy");
				t_name.setPreferredSize(new Dimension(80,30));
		JLabel l_hp = new JLabel("HP");
		JTextField t_hp = new JTextField("999");
				t_hp.setPreferredSize(new Dimension(80,30));
			JLabel l_age = new JLabel("AGE");
		JTextField t_age = new JTextField("28");
				t_age.setPreferredSize(new Dimension(80,30));
		JPanel p_down = new JPanel();
			p_down.add(l_id);p_down.add(t_id);p_down.add(l_name);p_down.add(t_name);p_down.add(l_hp);p_down.add(t_hp);p_down.add(l_age);p_down.add(t_age);
			p_down.add(b);
		JFrame f = new JFrame("test_table_update");
			f.setSize(800,800);
			f.setLocation(200,200);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(new BorderLayout());
			f.add(p_up,BorderLayout.NORTH);
			f.add(p_mid,BorderLayout.CENTER);
			f.add(p_down,BorderLayout.SOUTH);
			
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(t_id.getText().length() == 0) {
					JOptionPane.showMessageDialog(f, "Account ID should not be Empty..");
					t_id.grabFocus();
					return;
				}
				if(t_name.getText().length() == 0) {
					JOptionPane.showMessageDialog(f, "Account NAME should not be Empty..");
					t_name.grabFocus();
					return;
				}
				if(t_hp.getText().length() == 0) {
					JOptionPane.showMessageDialog(f, "Account HP should not be Empty..");
					t_hp.grabFocus();
					return;
				}
				if(t_age.getText().length() == 0) {
					JOptionPane.showMessageDialog(f, "Account AGE should not be Empty..");
					t_age.grabFocus();
					return;
				}	
				
				String[] bundle = {t_id.getText(),t_name.getText(),t_hp.getText(),t_age.getText()};
				ptm.add(bundle);   //add person in the head position..
				t.updateUI();//Must Invoke this function to display the latest Added data...
				t.getSelectionModel().setSelectionInterval(0, 0); // select the last Line...
				System.out.println("UPDATED...");	
			}
		});
	}
}

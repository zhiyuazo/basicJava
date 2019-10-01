package table;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import table.person_table_model;

public class table_selectionmode {

	public static void main(String[] args) {
		person_table_model pt = new person_table_model();
		JTable table =  new JTable(pt);
		JScrollPane  sp = new JScrollPane(table); //Can not Use add function???
	
		JLabel l = new JLabel("no item selected..");
		JPanel p = new JPanel();
			p.add(l);
			
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e ) {
					int row = table.getSelectedRow();
					int col = table.getSelectedColumn();
					l.setText("current selected is "+pt.getColumnName(col) + ":"+ pt.getValueAt(row, col));
				}
			});
				
		JFrame f = new JFrame("test_table_model");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p,BorderLayout.NORTH);
		f.add(sp,BorderLayout.CENTER);
	}
}


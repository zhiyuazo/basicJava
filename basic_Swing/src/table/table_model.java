package table;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import table.person_table_model;

public class table_model {
	public static void main(String[] args) {
		
	
		person_table_model pt = new person_table_model();
		
		JTable table =  new JTable(pt);
			table.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		JScrollPane  sp = new JScrollPane(table); //Can not Use add function???
		
		JFrame f = new JFrame("test_table_model");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLocation(200, 200);
		//f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(sp);

	}
}




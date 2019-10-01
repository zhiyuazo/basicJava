package table;

import javax.swing.*;
import javax.swing.plaf.ScrollPaneUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;

import java.awt.*;
import java.io.*;
import test.base_package;;


public class table_base {
	public static void main(String[] args) {
	
		String[] head = new String[] {"id","name","hp","age"};
		String[][] person = new String[][] {
			{"cv0038178","zhiyuan","500","29"},
			{"cv0038179","lijing","400","35"},
			{"cv0038180","zhaoquan","300","30"}
		};
		
		JTable table =  new JTable(person,head);
		
		JTextArea ta = new JTextArea();
			ta.setEditable(true);
			ta.setVisible(true);
			ta.setLineWrap(true);;
		
		JScrollPane  sp = new JScrollPane(table); //Can not Use add function???
		
		JFrame f = new JFrame("test_table");
		f.setSize(500, 500);
		f.setVisible(true);
		f.setLocation(200, 200);
		//f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(sp);

	}
}

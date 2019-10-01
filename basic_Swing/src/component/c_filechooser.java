package component;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class c_filechooser {
	
	public static void main(String[] args) {
		
		JFrame f = new JFrame("test");
		f.setLayout(new FlowLayout());
		//-----------------------------
		JFileChooser fc = new JFileChooser();
			fc.setFileFilter(new FileFilter() {
				
				public String getDescription() {
					return ".txt";
				}
				public boolean accept(File f) {
					return f.getName().toLowerCase().endsWith(".txt");					
				}
			});
		
		
		JButton bopen = new JButton("Open");
			bopen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int returnval = fc.showOpenDialog(f);
					File file = fc.getSelectedFile();
					if(returnval == JFileChooser.APPROVE_OPTION) {
						JOptionPane.showMessageDialog(f, "Plan to Open: " + file.getAbsolutePath());
					}	
				}	
			});
			
		JButton bsave = new JButton("Save");
			bsave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int returnval = fc.showSaveDialog(f);
					File file = fc.getSelectedFile();
					if(returnval == JFileChooser.APPROVE_OPTION) {
						JOptionPane.showMessageDialog(f, "Plan to Save: " + file.getAbsolutePath());
					}	
				}
			});
			
			
		//JFrame f = new JFrame("test");
			f.setSize(400, 100);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocationRelativeTo(null);
			f.add(bopen);
			f.add(bsave);
			f.setVisible(true);
		
	}

}

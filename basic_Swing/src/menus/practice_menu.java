package menus;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.*;


public class practice_menu {
	
	public static void main(String[] args) {
		
		
		
		JMenu m_File = new JMenu("File");
			m_File.add(new JMenuItem("New"));
			m_File.add(new JMenuItem("Open"));
			m_File.add(new JMenuItem("Save"));
			m_File.add(new JMenuItem("Save As"));
			m_File.addSeparator();
			m_File.add(new JMenuItem("Page Setup"));
			m_File.add(new JMenuItem("Print"));
			m_File.addSeparator();
			m_File.add(new JMenuItem("Exit"));
			
		JMenu m_Edit = new JMenu("Edit");
		JMenu m_Format = new JMenu("Format");
		JMenu m_View = new JMenu("View");
		JMenu m_Help = new JMenu("Help");
		
		
		JMenuBar mb = new JMenuBar();
			mb.add(m_File);
			mb.add(m_Edit);
			mb.add(m_Format);
			mb.add(m_View);
			mb.add(m_Help);
		
		JTextArea ta = new JTextArea();
			ta.setEditable(true);
			ta.setLineWrap(true);
			
			
		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setJMenuBar(mb); // User SET not Add
			f.setContentPane(ta); 
			f.setLocationRelativeTo(null);
			f.setLayout(new FlowLayout());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		
	}
	
}

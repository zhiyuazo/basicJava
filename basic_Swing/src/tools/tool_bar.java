package tools;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class tool_bar {
	
	public static void main(String[] args) {
			
			
			JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			add_menu(f);
			
			JToolBar tb = new JToolBar();
				JButton b1 = new JButton(new ImageIcon("test1.jpg"));
				JButton b2 = new JButton(new ImageIcon("test2.jpg"));
				JButton b3 = new JButton(new ImageIcon("test3.jpg"));
				tb.add(b1);	
				tb.add(b2);	
				tb.add(b3);	
				tb.setPreferredSize(new Dimension(500,200));;
			
			JTextArea ta = new JTextArea();
				ta.setEditable(true);
				ta.setLineWrap(true);
				ta.setPreferredSize(new Dimension(500,300));
				
			JPanel p_down = new JPanel();
				p_down.add(ta);
			
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setLayout(new BorderLayout());
			f.add(tb,BorderLayout.NORTH);
			f.add(p_down,BorderLayout.SOUTH); 
			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			
		}
	
	public static void add_menu(JFrame f) {
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
		f.setJMenuBar(mb);	
	}
	
}

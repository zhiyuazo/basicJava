package menus;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.*;

public class menu_column {

	public static void main(String[] args) {
		
		
		
		JMenu m_hero = new JMenu("Hero");
			m_hero.add(new JMenuItem("zhanshi"));
			m_hero.add(new JMenuItem("mushi"));
			m_hero.add(new JMenuItem("fashi"));
			m_hero.add(new JMenuItem("shengqishi"));
			m_hero.add(new JMenuItem("shushi"));
			m_hero.add(new JMenuItem("deluyi"));
			m_hero.addSeparator();
			m_hero.add(new JMenuItem("All"));
			
		JMenu m_item = new JMenu("tools");
		JMenu m_word = new JMenu("tattoo");
		JMenu m_summon = new JMenu("adasda");
		JMenu m_talent = new JMenu("gift");
		
		
		JMenuBar mb = new JMenuBar();
			mb.add(m_hero);
			mb.add(m_item);
			mb.add(m_word);
			mb.add(m_summon);
			mb.add(m_talent);
			mb.setVisible(true);
		
		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setJMenuBar(mb); // User SET not Add
			f.setLocationRelativeTo(null);
			f.setLayout(new FlowLayout());
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
	
}

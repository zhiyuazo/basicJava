package virtual_proxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class test {
	ImageComponent imageComponent ; 
	
	JFrame f = new JFrame("CD view ") ; 
	JMenuBar menuBar ; 
	JMenu  menu ; 
	Hashtable cds = new Hashtable();
	
	public  void run() throws MalformedURLException {
		cds.put("a", "http://images.amazon.com/images/P/B000003S2K.01.LZZZZZZZ.jpg");
		cds.put("b", "http://pic.pptbz.com/pptpic/201203/2012031220134655_S.jpg");
	
		menuBar = new  JMenuBar();
		menu    = new JMenu("Favorite CDs");
		menuBar.add(menu);
		f.setJMenuBar(menuBar);
		for(Enumeration e = cds.keys(); e.hasMoreElements();) {
			String name = (String)e.nextElement();
			JMenuItem menuitem = new JMenuItem(name);
			menu.add(menuitem);
			
			menuitem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					imageComponent.setIcon(new ImageProxy(getCDUrl(e.getActionCommand())));
					f.repaint();
				}
			});
		}
		
		URL initURL = new URL((String) cds.get("a"));
		Icon icon = new ImageProxy(initURL);
		imageComponent = new ImageComponent(icon);
		f.getContentPane().add(imageComponent);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,600);
		f.setVisible(true);
	}
	
	URL getCDUrl (String name ) {
		try {
			return new URL((String) cds.get(name));
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) throws MalformedURLException {
		test t = new test();
		t.run();
	}
	
	
	
	
	
	
	
	

}

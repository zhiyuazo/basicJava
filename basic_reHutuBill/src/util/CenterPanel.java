package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

public class CenterPanel extends JPanel{
	
	private JComponent c ; 
	private boolean strech  = true; 
	private  double rate = 0.1f ;
	
	public CenterPanel( ){
		this.setLayout(null);
	}
	
	public void repaint() {
		
		if(null != c ) {
			Dimension container_size = this.getSize();
			Dimension component_size = c.getPreferredSize();
			if(strech) {
				c.setSize((int)(container_size.width*rate),(int)(container_size.height*rate));
			}else {
				c.setSize(component_size);
			}
			c.setLocation(container_size.width/2 - c.getSize().width/2 , container_size.height/2 - c.getSize().height/2);
		}
		super.repaint();
	}
	
	public void show(JComponent p ,double rate) {
		this.c = p;
		this.rate = rate;
		Component[] cs = getComponents();
		for(Component i : cs) {
			remove(i);
		}
		add(c);
		if(c instanceof WorkingPanel)
			((WorkingPanel) c).updateDate();
		this.updateUI();
	}
}

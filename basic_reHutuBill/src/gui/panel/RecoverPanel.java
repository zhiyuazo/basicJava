package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecoverPanelListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel  extends WorkingPanel{

	JButton b = new JButton("»Ö¸´");
	public static RecoverPanel instance = new RecoverPanel();
	
	private RecoverPanel(){
		GUIUtil.setColor(ColorUtil.blueColor,ColorUtil.fgbg.FG , b);
		this.add(b);
		addListener();
	}

	@Override
	public void addListener() {
		RecoverPanelListener l = new RecoverPanelListener();
		b.addActionListener(l);
	}

	@Override
	public void updateDate() {
		
	}
	
}

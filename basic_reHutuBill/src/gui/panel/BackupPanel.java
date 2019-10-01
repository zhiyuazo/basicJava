package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.BackupPanelListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel  extends WorkingPanel{

	JButton b = new JButton("±¸·Ý");
	public static BackupPanel instance = new BackupPanel();
	
	private BackupPanel(){
		GUIUtil.setColor(ColorUtil.blueColor,ColorUtil.fgbg.FG , b);
		this.add(b);
		addListener();
	}

	@Override
	public void addListener() {
		BackupPanelListener l = new BackupPanelListener();
		b.addActionListener(l);
	}

	@Override
	public void updateDate() {
		
	}
	
}

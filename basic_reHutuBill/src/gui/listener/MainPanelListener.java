package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.BackupPanel;
import gui.panel.CategoryPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.RecoverPanel;
import gui.panel.ReportPanel;
import gui.panel.SpendPanel;

public class MainPanelListener  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		MainPanel  p = MainPanel.instance;
		JButton b = (JButton) e.getSource();
		double rate = 0.9;
		if(b == p.b_spend) 
			p.working_panel.show(SpendPanel.instance,rate);
		
		if(b == p.b_record) 
			p.working_panel.show(RecordPanel.instance,rate);
		
		if(b == p.b_category) 
			p.working_panel.show(CategoryPanel.instance,rate);
		
		if(b == p.b_report) 
			p.working_panel.show(ReportPanel.instance,rate);
		
		if(b == p.b_config) 
			p.working_panel.show(ConfigPanel.instance,rate);
		
		if(b == p.b_backup) 
			p.working_panel.show(BackupPanel.instance,rate);
		
		if(b == p.b_recover) 
			p.working_panel.show(RecoverPanel.instance,rate);
	}
	
}

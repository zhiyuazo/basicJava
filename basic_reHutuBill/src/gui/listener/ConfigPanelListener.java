package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Config;
import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigPanelListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		ConfigPanel  p =  ConfigPanel.instance;
		GUIUtil.checkNumber(p.tf1, "预算");
		
		String budget_v = p.tf1.getText();
		String mysql_v = p.tf2.getText();
		ConfigService  cfg_svc = new ConfigService();  
		if(budget_v.equals(cfg_svc.get("budget"))||mysql_v.equals(cfg_svc.get("mysql_path"))) {
			int opt = JOptionPane.showConfirmDialog(null, "一些参数未曾更改，是否更新？");
			if(JOptionPane.OK_CANCEL_OPTION == opt) {
				p.tf1.grabFocus();
				return ;
			}
			if(JOptionPane.YES_NO_CANCEL_OPTION == opt) {
				p.tf1.grabFocus();
				return ;
			}
			
		}
		cfg_svc.update(cfg_svc.budget,budget_v);
		cfg_svc.update(cfg_svc.mysql,mysql_v);
		JOptionPane.showMessageDialog(p, "设置修改成功");
		
	}

}

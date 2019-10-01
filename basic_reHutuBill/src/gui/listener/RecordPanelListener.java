package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import entity.Record;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.CategoryService;
import service.RecordService;
import util.DateUtil;
import util.GUIUtil;

public class RecordPanelListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		RecordPanel  p = RecordPanel.instance;
		if(0 == p.ccbm.getSize()) {
			JOptionPane.showMessageDialog(p, "暂无消费分类，前往添加...");
			MainPanel.instance.working_panel.show(CategoryPanel.instance,0.95);
			return;
		}
		if(!GUIUtil.checkZero(p.tf1, "金额")) {
			return;
		}
		
		int spend = Integer.parseInt(p.tf1.getText());
		Category  c = p.getSelectedCategory();
		String comment = p.tf2.getText();
		Date d = p.datepicker.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(p, "添加数据成功...");
		
		////----更新category面板数据
		c.number +=1;
		new CategoryService().update(c);
		MainPanel.instance.working_panel.show(SpendPanel.instance,0.95);
		
	}
	
	

}

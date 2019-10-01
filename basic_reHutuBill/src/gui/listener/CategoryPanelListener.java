package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.RecordPanel;
import service.CategoryService;
import util.GUIUtil;

public class CategoryPanelListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryService cs = new CategoryService();
		CategoryPanel p = CategoryPanel.instance;
		
		if(e.getSource() == p.b1) {
			String s = JOptionPane.showInputDialog(p, "添加类名称");
			if(!( s instanceof String) ) 
				return;
			if(0 == s.length()) {
				JOptionPane.showMessageDialog(p, "分类名称不能为空..");
				return;
			}
			cs.add(s);
		}
		
		if(e.getSource() == p.b2) {
			Category Selected = p.getSelectedCategory();
			String s = JOptionPane.showInputDialog(p, "修改类名称",Selected.name);
			if(!( s instanceof String) ) 
				return;
			if(0 == s.length()) {
				JOptionPane.showMessageDialog(p, "分类名称不能为空..");
				return;
			}
			Category c = new Category();
			c.setId(Selected.id);
			c.setName(s);
			c.setNumber(Selected.number);
			cs.update(c);
		}
		
		if(e.getSource() == p.b3) {
			Category Selected = p.getSelectedCategory();
			if(Selected.number != 0) {
				JOptionPane.showMessageDialog(p, "当前分类下有数据，不可删除...");
				return;
			}
			int opt = JOptionPane.showConfirmDialog(p, "确定删除分类：" + Selected.name);
			if(JOptionPane.OK_OPTION != opt) {
				return ;
			}
			cs.delete(Selected.id);
		}
		//-----
		p.updateDate();
	}
	
}

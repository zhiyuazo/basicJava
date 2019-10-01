package gui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import gui.listener.CategoryPanelListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends WorkingPanel {

	public JButton b1 = new JButton("Ôö¼Ó");
	public JButton b2 = new JButton("±à¼­");
	public JButton b3 = new JButton("É¾³ý");
	CategoryTableModel  ctm = new CategoryTableModel();
	public JTable  t = new JTable(ctm);
	
	public static CategoryPanel instance = new CategoryPanel();
	
	private CategoryPanel() {
		GUIUtil.setColor(ColorUtil.blueColor,ColorUtil.fgbg.FG , b1,b2,b3);
		if(ctm.data.size() == 0) {
			b2.setEnabled(false);
			b3.setEnabled(false);
		}else {
			b2.setEnabled(true);
			b3.setEnabled(true);
		}
		t.getSelectionModel().setSelectionInterval(0, 0);
		t.setSelectionBackground(ColorUtil.blueColor);
		JScrollPane sp = new JScrollPane(t);
		JPanel p = new JPanel();
			p.setLayout(new FlowLayout());
			p.add(b1);	
			p.add(b2);	
			p.add(b3);	
		this.setLayout(new BorderLayout());
		this.add(sp,BorderLayout.CENTER);
		this.add(p,BorderLayout.SOUTH);
		addListener();
	}
	
	public Category getSelectedCategory() {
		int index = t.getSelectedRow();
		return ctm.data.get(index); 
	}
	@Override
	public void addListener() {
		CategoryPanelListener l = new CategoryPanelListener();
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
	}
	public void updateDate() {
		ctm.data = new CategoryService().listAll();
		t.updateUI();
		if(ctm.data.size() == 0) {
			b2.setEnabled(false);
			b3.setEnabled(false);
		}else {
			b2.setEnabled(true);
			b3.setEnabled(true);
		}
		t.getSelectionModel().setSelectionInterval(2, 2);
	}

}

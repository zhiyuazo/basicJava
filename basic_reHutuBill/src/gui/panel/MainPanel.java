package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.MainPanelListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel{
	
	static {
		GUIUtil.setSkin();
	}
	public JToolBar tb = new JToolBar();
	public JButton  b_spend = new JButton();
	public JButton  b_record = new JButton();
	public JButton  b_category = new JButton();
	public JButton  b_report = new JButton();
	public JButton  b_config = new JButton();
	public JButton  b_backup = new JButton();
	public JButton  b_recover = new JButton();
	public CenterPanel  working_panel ; 
	
	private MainPanel() {
		GUIUtil.setImageIcon(b_spend, "home.png", "消费一览");
		GUIUtil.setImageIcon(b_record, "record.png", "记一笔");
		GUIUtil.setImageIcon(b_category, "category2.png", "消费分类");
		GUIUtil.setImageIcon(b_report, "report.png", "消费报表");
		GUIUtil.setImageIcon(b_config, "config.png", "配置");
		GUIUtil.setImageIcon(b_backup, "backup.png", "备份");
		GUIUtil.setImageIcon(b_recover, "restore.png", "恢复");
		tb.add(b_spend);
		tb.add(b_record);
		tb.add(b_category);
		tb.add(b_report);
		tb.add(b_config);
		tb.add(b_backup);
		tb.add(b_recover);
		tb.setFloatable(false);
		
		working_panel = new CenterPanel();
		this.setLayout(new BorderLayout());
		this.add(tb,BorderLayout.NORTH);
		this.add(working_panel,BorderLayout.CENTER);
		
		//add action listener....
		MainPanelListener l = new MainPanelListener();
		b_spend.addActionListener(l);
		b_record.addActionListener(l);
		b_category.addActionListener(l);
		b_report.addActionListener(l);
		b_config.addActionListener(l);
		b_backup.addActionListener(l);
		b_recover.addActionListener(l);
	}
	
	public static MainPanel instance = new MainPanel();
	
	
}

package gui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigPanelListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel{

	public JLabel l1 = new JLabel("本月预算￥");
	public JTextField tf1 = new JTextField("0");
	
	public JLabel l2 = new JLabel("MySql安装目录");
	public JTextField tf2 = new JTextField("");
	
	public JButton b = new JButton("更新");
	
	
	public static ConfigPanel instance = new ConfigPanel();
	
	private ConfigPanel(){
		
		GUIUtil.setColor(ColorUtil.grayColor, ColorUtil.fgbg.FG, l1,l2);
		GUIUtil.setColor(ColorUtil.blueColor, ColorUtil.fgbg.FG, b);
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1,40,40));
		
		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf2);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.add(b);
		this.setLayout(new BorderLayout());
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.CENTER);
		addListener();
	}

	@Override
	public void addListener() {
		ConfigPanelListener l = new ConfigPanelListener();
		b.addActionListener(l);
	}

	@Override
	public void updateDate() {
		ConfigService  cfg_svc = new ConfigService();
		tf1.setText(cfg_svc.get("budget"));
		tf2.setText(cfg_svc.get("mysql_path"));
	}
}

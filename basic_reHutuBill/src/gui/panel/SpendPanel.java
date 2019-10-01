package gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;
import util.ShowUtil;

public class SpendPanel extends WorkingPanel  {
	//---north 
	JLabel  l_n1 = new JLabel("本月消费");
	JLabel  l_n2 = new JLabel("$--");
	JLabel  l_n3 = new JLabel("今日消费");
	JLabel  l_n4 = new JLabel("$--");
	CircleProgressBar  cpb ;
	//--south
	JLabel  l_s1 = new JLabel("日均消费");
	JLabel  l_s2 = new JLabel("本月剩余");
	JLabel  l_s3 = new JLabel("日均可用");
	JLabel  l_s4 = new JLabel("距离月末");
	JLabel  l_s5 = new JLabel("$--");
	JLabel  l_s6 = new JLabel("$--");
	JLabel  l_s7 = new JLabel("$--");
	JLabel  l_s8 = new JLabel("$--");
	
	public static  SpendPanel instance  = new SpendPanel();
	private JPanel center() {
		JPanel p_west = new JPanel();
			p_west.setLayout(new GridLayout(4,1));
			p_west.add(l_n1);
			p_west.add(l_n2);
			p_west.add(l_n3);
			p_west.add(l_n4);
		
		JPanel  p =  new JPanel();
		p.setLayout(new BorderLayout());
		p.add(p_west,BorderLayout.WEST);
		p.add(cpb,BorderLayout.CENTER);
		return p;
	}
	
	private  JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,4));
		p.add(l_s1);
		p.add(l_s2);
		p.add(l_s3);
		p.add(l_s4);
		p.add(l_s5);
		p.add(l_s6);
		p.add(l_s7);
		p.add(l_s8);
		return p;
	}
	
	private SpendPanel() {
		cpb = new CircleProgressBar();
		cpb.setForeground(ColorUtil.blueColor);
		GUIUtil.setColor(ColorUtil.grayColor, ColorUtil.fgbg.FG, l_s1,l_s2,l_s3,l_s4,l_s5,l_s6,l_s7,l_s8);
		GUIUtil.setColor(ColorUtil.grayColor, ColorUtil.fgbg.FG, l_n1,l_n3);
		GUIUtil.setColor(ColorUtil.blueColor, ColorUtil.fgbg.FG, l_n2,l_n4);
		l_n2.setFont(new Font("微软雅黑", Font.BOLD, 23));
		l_n4.setFont(new Font("微软雅黑", Font.BOLD, 23));
		JPanel p_south = south();
		JPanel p_center = center();
		this.setLayout(new BorderLayout());
		this.add(p_south , BorderLayout.SOUTH);
		this.add(p_center , BorderLayout.CENTER);
	}
	
	public void updateDate() {
		SpendService ss = new SpendService();
		SpendPage sp = ss.getSpendPage();
		l_n2.setText(sp.monthSpend);
		l_n4.setText(sp.todaySpend);
		cpb.setProgress(sp.usePercent);
		cpb.setForeground(ColorUtil.getByPercentage(sp.usePercent));
		l_s5.setText(sp.dayAvgSpend);
		l_s6.setText(sp.monthRest);
		l_s7.setText(sp.dayAvgRest);
		l_s8.setText(sp.monthEnd);
		
	}

	@Override
	public void addListener() {
	}
}

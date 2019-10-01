package gui.panel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.ReportService;
import util.ChartUtil;

public class ReportPanel extends WorkingPanel{
	
	JLabel l = new JLabel(); 
	public static ReportPanel instance = new ReportPanel();
	private ReportPanel(){
		Image img = ChartUtil.getImage(350, 350,new ReportService().eachDaySpendInThisMonth());
		ImageIcon icon = new ImageIcon(img);
		l.setIcon(icon);
		this.add(l);
	}
	
	public void updateDate() {
		Image img = ChartUtil.getImage(350, 350,new ReportService().eachDaySpendInThisMonth());
		ImageIcon icon = new ImageIcon(img);
		l.setIcon(icon);
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}
	
}

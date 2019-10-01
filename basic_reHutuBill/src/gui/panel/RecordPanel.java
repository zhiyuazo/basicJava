package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import gui.listener.RecordPanelListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.CenterPanel;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel {
	static {GUIUtil.setSkin();}
	JLabel l_1 = new JLabel("花费￥");
	JLabel l_2 = new JLabel("分类");
	JLabel l_3 = new JLabel("备注");
	JLabel l_4 = new JLabel("日期");
	//--
	public JTextField tf1 = new JTextField("0");
	public CategoryComboBoxModel ccbm = new CategoryComboBoxModel();
	public JComboBox<Category> cb = new JComboBox<>(ccbm);
	public JTextField tf2 = new JTextField("");
	public JXDatePicker datepicker;
	//--
	JButton b = new JButton("记一笔");
	
	public static RecordPanel instance = new RecordPanel();
	private RecordPanel() {
		datepicker = new JXDatePicker(new Date());
		GUIUtil.setColor(ColorUtil.grayColor,ColorUtil.fgbg.FG , l_1,l_2,l_3,l_4);
		GUIUtil.setColor(ColorUtil.blueColor,ColorUtil.fgbg.FG , b);
		tf1.setEditable(true);tf1.setPreferredSize(new Dimension(20,20));
		tf2.setEditable(true);
		JPanel p_center = new JPanel();
			p_center.setLayout(new GridLayout(4,2,40,40));
			p_center.add(l_1);p_center.add(tf1);
			p_center.add(l_2);p_center.add(cb);
			p_center.add(l_3);p_center.add(tf2);
			p_center.add(l_4);p_center.add(datepicker);
		
		CenterPanel p_south = new CenterPanel();
//			p_south.setLayout(new FlowLayout());
			p_south.show(b,0.6);
		this.setLayout(new BorderLayout());
		this.add(p_center,BorderLayout.NORTH);
		this.add(p_south,BorderLayout.CENTER);
		addListener() ;
	}
	
	public Category getSelectedCategory() {
		System.out.println(cb.getSelectedItem() instanceof String );
		System.out.println(cb.getSelectedItem() instanceof Category );
		return (Category) cb.getSelectedItem();
	}
	
	@Override
	public void addListener() {
		RecordPanelListener l = new RecordPanelListener();
		b.addActionListener(l);
	}

	@Override
	public void updateDate() {
		ccbm.cs = new CategoryService().listAll();
		cb.updateUI();
		//-----
		tf1.setText("0");
		tf2.setText("");
		if(0!= ccbm.cs.size()) {
			cb.setSelectedIndex(0);
		}
		datepicker.setDate(new Date());
	}
}

package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class GUIUtil {

	private static String imgs  =  "E:\\reJAVA\\reHutuBill\\img"; 
	
	public static boolean  checkEmpty(JTextField tf , String input) {
		String text = tf.getText().trim();
		if(0 == text.length()) {
			JOptionPane.showMessageDialog(null, input + " 不能为空。。");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public static boolean  checkNumber(JTextField tf , String input) {
		if(!checkEmpty(tf, input)) {
			return false;
		}
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		}catch(Exception e ) {
			JOptionPane.showMessageDialog(null, input + " 必须为整数。。");
			tf.grabFocus();
			return false;
		}
	}
	
	public static boolean  checkZero(JTextField tf , String input) {
		if(!checkNumber(tf, input)) {
			return false;
		}
		String text = tf.getText().trim();
		if(0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + " 不能为0。。");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public int getInt(JTextField tf ) {
		return Integer.parseInt(tf.getText());
	}
	
	public static void setSkin() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setColor(Color color , ColorUtil.fgbg t, JComponent... cs ) {
		
		switch(t) {
		case FG:
			for(JComponent c : cs) {
				c.setForeground(color);
			}
			break;
		case BG:
			for(JComponent c : cs) {
				c.setBackground(color);
			}
			break;
		}
			
		for(JComponent c : cs) {
//			c.setForeground(color);
			c.setBackground(color);
		}
	}
	
	public static void setImageIcon(JButton b, String Filename , String tip) {
		ImageIcon i = new ImageIcon(new File(imgs,Filename).getAbsolutePath());
		b.setIcon(i);
		b.setToolTipText(tip);
		b.setPreferredSize(new Dimension(60,80));
		b.setVerticalTextPosition(JButton.VERTICAL);
		b.setHorizontalTextPosition(JButton.CENTER);
	}
}



package util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class ShowUtil { //usefull tool when DEVing
	
	public static void run(JComponent c, double rate) {
		GUIUtil.setSkin();
		CenterPanel  cp = new CenterPanel();
		JFrame  f = new JFrame();
		f.setLayout(null);
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(cp);
		f.setVisible(true);
		cp.show(c,rate);
	}

	public static void main(String[] args) {
		JButton  b = new JButton("Hello");
		ShowUtil.run(b,0.8);
	}
}

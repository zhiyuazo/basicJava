package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;

public class MainFrame extends JFrame {
	private MainFrame() {
		this.setTitle("reÒ»±¾ºýÍ¿ÕË");
		this.setContentPane(MainPanel.instance);
		this.setSize(500,500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static MainFrame instance = new MainFrame();
}

package startup;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.RecoverPanel;
import gui.panel.SpendPanel;

public class BootStrap {
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				MainFrame.instance.setVisible(true);
				MainPanel.instance.working_panel.show(SpendPanel.instance,0.95);
			}
		});
	}
}

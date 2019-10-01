package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecoverPanel;
import service.ConfigService;
import util.MysqlUtil;

public class RecoverPanelListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
			RecoverPanel p = RecoverPanel.instance;
			if(new ConfigService().get("mysql_path").length()==0) {
				JOptionPane.showMessageDialog(null, "没有配置mysql路径，请前往配置..");
				MainPanel.instance.working_panel.show(ConfigPanel.instance,0.95);
				ConfigPanel.instance.tf2.grabFocus();
				return;
			}
			//----
			JFileChooser  fc = new JFileChooser();
			fc.setSelectedFile(new File("hutubill.backup.sql"));
			fc.setFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return ".sql";
				}
				@Override
				public boolean accept(File f) {
					return f.getName().toLowerCase().endsWith(".sql");
				}
			});
			
			int opt = fc.showOpenDialog(p);
			File f = fc.getSelectedFile();
			if(opt == JFileChooser.APPROVE_OPTION) {
				try {
					MysqlUtil.recover(new ConfigService().get("mysql_path"),f.getAbsolutePath());
					JOptionPane.showMessageDialog(null, "恢复完成..");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}

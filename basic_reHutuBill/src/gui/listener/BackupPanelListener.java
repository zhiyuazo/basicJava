package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class BackupPanelListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BackupPanel p= BackupPanel.instance;
		if(new ConfigService().get("mysql_path").length() == 0) {
			JOptionPane.showMessageDialog(null, "没有配置mysql路径，请前往配置..");
			MainPanel.instance.working_panel.show(ConfigPanel.instance,0.95);
			ConfigPanel.instance.tf2.grabFocus();
			return;
		}
		//-----
		
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("hutubill.backup"));
		fc.setFileFilter(new FileFilter(){
			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".sql");
			}
			@Override
			public String getDescription() {
				return ".sql";
			}
		});
		
		int opt = fc.showSaveDialog(null) ;
		File f = fc.getSelectedFile();
		if(opt == JFileChooser.APPROVE_OPTION) {
			if(! f.getName().toLowerCase().endsWith(".sql")) {
				f = new File(f.getParent(),f.getName()+".sql");
			}
			try {
				MysqlUtil.backup(new ConfigService().get("mysql_path"),f.getAbsolutePath());
				JOptionPane.showMessageDialog(null, "备份于：" + f.getAbsolutePath() + "OK..");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

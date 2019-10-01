package comprehensive;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.*;
public class pratice_filecopy {
	
	static int all_file_size = 0;
	static long now_copy_size = 0;
	public static void main(String[] args) {
		int gap = 5;
		JLabel src_addr = new JLabel("source_address: ");
		JTextField tf1  = new JTextField("D:\\srcJAVA\\how2j\\how2j");
					//tf1.setPreferredSize(new Dimension(100,30));
					//tf1.setSize(new Dimension(300,30));
		
		JLabel dst_addr = new JLabel("destin_address: ");
		JTextField tf2  = new JTextField("D:\\srcJAVA\\test_copy");
					//tf2.setPreferredSize(new Dimension(100,30));
					//tf2.setSize(new Dimension(300,30));
		
		JLabel copy_status = new JLabel("file_copy_status: ");
		JProgressBar  pb = new JProgressBar();
						pb.setMaximum(100);
						pb.setStringPainted(true);
						pb.setValue(0);
						pb.setVisible(true);
						pb.setSize(new Dimension(200,30));

		JButton b = new JButton("Start_copying");
		
						
		
		JFrame f = new JFrame("test-frame");
		f.setSize(500, 500);
		f.setLocation(200, 200);
		f.setLocationRelativeTo(null);
		f.setLayout(new FlowLayout());
		f.add(src_addr);
		f.add(tf1);
		f.add(dst_addr);
		f.add(tf2);
		f.add(b);
		f.add(copy_status);
		f.add(pb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		String fssrc = tf1.getText();
		File folder = new File(fssrc);
		cal_file_size(folder);
		
		b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						    String fssrc = tf1.getText();
							String fsdst = tf2.getText();
							new Thread(()-> copyfolder(fssrc,fsdst)).start(); //this format....
							b.setEnabled(false);
				}
				
				public void copyfolder(String src_path, String dst_path) {
					File srcfolder = new File(src_path);
					File dstfolder = new File(dst_path);
							
					if(!srcfolder.exists())
							return;
					if(!srcfolder.isDirectory())
							return;
					if(dstfolder.isFile())
							return;
					if(!dstfolder.exists()) {
							dstfolder.mkdirs();
					}
							
					File[] fs = srcfolder.listFiles();
						for(File fi: fs) {
							if(!fi.isDirectory()) {
									File new_dstfile = new File(dstfolder,fi.getName());
									copyfile(fi.getAbsolutePath(),new_dstfile.getAbsolutePath());
									now_copy_size += fi.length();
									double current = (double)now_copy_size/(double)all_file_size;
									int progress = (int) current * 100;
									pb.setValue(progress);
									if(progress == 100) {
										JOptionPane.showMessageDialog(f, "Copy Done..");
										b.setEnabled(true);
									}
								}
								
								if(fi.isDirectory()) {
									File new_dstfolder = new File(dstfolder,fi.getName());
									copyfolder(fi.getAbsolutePath(),new_dstfolder.getAbsolutePath());
								}
							}
					}
							
					public void copyfile(String src_path, String dst_path) {
							File srcfile = new File(src_path);
							File dstfile = new File(dst_path);
							byte[] buffer = new byte[1024];
							try (FileInputStream fis = new FileInputStream(srcfile); 
								FileOutputStream fos = new FileOutputStream(dstfile);){
								while(true) {
									int actually_read = fis.read(buffer);
									if(-1 == actually_read)
										break;
									fos.write(buffer,0,actually_read);
									fos.flush();
								}
							}catch(Exception e) {
								e.printStackTrace();
							}
						}
				});
	}
	
		public static void cal_file_size(File f) {
			if(f.isFile()) {
				all_file_size += f.length();
			}
			if(f.isDirectory()) {
				File[] fs = f.listFiles();
				for(File i:fs) {
					cal_file_size(i);
				}
			}
		}
}

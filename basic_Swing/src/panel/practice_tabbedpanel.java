package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class practice_tabbedpanel {
	
	
	
	public static void main(String[] args) {
	
		
		File folder = new File("D:\\srcJAVA\\how2j\\how2j\\src\\panel");
		File[] fs = folder.listFiles();
		
		ImageIcon i = new ImageIcon("4baby.png");
	
		JTabbedPane tp = new JTabbedPane();
		for(int j=0;j<fs.length;j++) {
			
			JavaFilePane jfp = new JavaFilePane(fs[j]);
			tp.add(jfp);
			tp.setTitleAt(j, fs[j].getName());
		}		
		
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.setContentPane(tp);
			//f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
	}
	
	public static class JavaFilePane extends JPanel {
		
		public JavaFilePane(File f){
			this.setLayout(new BorderLayout());
			String filecontent = getFileContent(f);
			JTextArea txa = new JTextArea();
			txa.setText(filecontent);
			this.add(txa);
		}
		
		private String getFileContent(File f) {
			String result = null; 
			
			try(FileReader fr = new FileReader(f)){
				char[] all = new char[(int) f.length()];
				fr.read(all);
				result = new String(all);
			}catch(Exception e ) {
				e.printStackTrace();
			}
			return result;
		}
	}
}

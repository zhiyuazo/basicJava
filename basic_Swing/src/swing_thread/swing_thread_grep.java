package swing_thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class swing_thread_grep {
	
	static List<File> result = new ArrayList<>(); 
	
	public static void main(String[] args) {
		JLabel l = new JLabel("search_directory:");
		JTextField tf_directory = new JTextField("D:\\srcJAVA\\how2j\\how2j");
				tf_directory.setPreferredSize(new Dimension(150,20));
		JLabel l1 = new JLabel("search_string:");
			JTextField tf_search = new JTextField("zhiyuan&zhangping");
				tf_search.setPreferredSize(new Dimension(150,20));
		JButton b1 = new JButton("Just_Play");
		JButton b2 = new JButton("Searching");
		JButton b3 = new JButton("Clear");
		JPanel p_up = new JPanel(new GridLayout(4,2));
			p_up.add(l);
			p_up.add(tf_directory);
			p_up.add(l1);
			p_up.add(tf_search);
			p_up.add(b1);
			p_up.add(b2);
			p_up.add(b3);
		
		JTextArea ta_result = new JTextArea();
			ta_result.setEditable(false);
			ta_result.setLineWrap(true);
			ta_result.setPreferredSize(new Dimension(450,400));
			ta_result.setText("");
		JScrollPane p_down = new JScrollPane(ta_result);
					p_down.setSize(500,400);
		
		
		
		JFrame f = new JFrame("test_longtime_thread");
				f.setSize(500, 600);
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setLocation(200,200);
				f.setLayout(new FlowLayout());
				f.add(p_up);
				f.add(p_down);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_result.append("love:love: " + Thread.currentThread().getName() +"\r\n");
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta_result.setText("");
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingWorker worker = new SwingWorker() {
					protected Object doInBackground() throws InterruptedException {
						if( tf_directory.getText().length() == 0) {
							JOptionPane.showMessageDialog(f, "Search-String required...!");
							tf_directory.grabFocus();
						}
						File now_file = new File(tf_directory.getText());
						allfile(now_file);
						for(int i=0;i<result.size();i++) {
							if(result.get(i).getName().toLowerCase().endsWith(".java")) {
								String pool = readfile(result.get(i));
								if(pool.contains(tf_search.getText())) {
									ta_result.append(result.get(i).getName()+": "+Thread.currentThread().getName()+"\r\n");
								}
							}
							TimeUnit.MICROSECONDS.sleep(3000);
						}
						return null;
					}
				};
				worker.execute();
			}
		});
	}
	
	public static void allfile(File ff) {
		if(ff.isFile()) {
			result.add(ff);
		}
		if(ff.isDirectory()) {
			File[] tmp = ff.listFiles();
			for(File i:tmp) {
				allfile(i);
			}
		}
	}
	
	public static String readfile(File file) {
		try(FileReader fr = new FileReader(file)){
			char[] all = new char[(int) file.length()];
			fr.read(all);
			return new String(all);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}

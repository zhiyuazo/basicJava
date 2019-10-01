package date_component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

public class date_practice {
	
	static List<File> result = new ArrayList<>(); 
	
	public  static void main(String[] args) {
		
		Date d = new Date();
		JXDatePicker dp = new JXDatePicker();
			dp.setDate(d);
		JButton b = new JButton("Search_files");
		JPanel p_up = new JPanel();
			p_up.add(dp);
			p_up.add(b);
	
		JLabel  l = new JLabel("Seach_Path");
		JTextField tf = new JTextField("D:\\srcJAVA\\how2j\\how2j");
					tf.setPreferredSize(new Dimension(300,20));
		JPanel p_mid = new JPanel(new FlowLayout());
			p_mid.add(l);
			p_mid.add(tf);
			
		JTextArea ta = new JTextArea();
				ta.setLineWrap(true);
				ta.setEditable(false);
				ta.setVisible(true);
				ta.setPreferredSize(new Dimension(300,380));
				ta.setText("The suitable file whose lasted modify time < the current time will be displayed here..");
		JScrollPane p_down = new JScrollPane(ta);
				p_down.setPreferredSize(new Dimension(400,400));

		JFrame f = new JFrame("Test_data_component");
			f.setSize(500,500);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocation(200,200);
			f.setLayout(new BorderLayout());
			f.add(p_up,BorderLayout.NORTH);
			f.add(p_mid,BorderLayout.CENTER);
			f.add(p_down,BorderLayout.SOUTH);
			
			
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//dp.getDate();
				File ff = new File(tf.getText());
				getall(ff);
				ta.setText("");
				for(int j = 0;j<result.size();j++) {
					long tmp_time = result.get(j).lastModified();
					if(tmp_time < dp.getDate().getTime() ) {
						ta.append(result.get(j).getAbsolutePath() + "    :    " + new Date(tmp_time).toString() +"  \r\n");
					}
				}
			}
		});	
	}
	
	public static void getall(File ff) {
		if(ff.isFile()) {
			result.add(ff);
		}
		if(ff.isDirectory()) {
			File[] tmp = ff.listFiles();
			for(File i: tmp) {
				getall(i);
			}
		}
	}
}

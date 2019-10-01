package date_component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import com.eltima.components.ui.DatePicker;

public class date_picker {
	
	public  static void main(String[] args) {
	
		DatePicker dp = getdp();
		
		JButton b = new JButton("Get Time");
	
		JFrame f = new JFrame("Test_data_component");
			f.setSize(500,500);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocation(200,200);
			f.setLayout(new FlowLayout());
			f.add(dp);
			f.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(f, "get time: "+dp.getValue());
				System.out.println(dp.getValue());
			}
		});	
	}
	
	public static DatePicker getdp() {
		DatePicker dp;
		
		String defaultformat = "yyyy-MM-dd HH:mm:ss";
		Date d = new Date();
		Font font = new Font("Times New Roman", Font.BOLD, 14);
		Dimension dimension = new Dimension(177,24);
		int[] hilightday = {1,3,5,7};
		int[] disableday = {2,4,6,9};
		
		dp = new DatePicker(d,defaultformat,font,dimension);
			dp.setLocation(140,80);
			dp.setBounds(137,83,177,24);
			dp.setHightlightdays(hilightday, Color.RED);
			dp.setDisableddays(disableday);
			dp.setLocale(Locale.CHINA);
			dp.setTimePanleVisible(true);
			
		return dp; 
	}
	

}

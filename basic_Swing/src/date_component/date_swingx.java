package date_component;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jdesktop.swingx.*;
import com.eltima.components.ui.DatePicker;

public class date_swingx {
	
	public  static void main(String[] args) {
		
		Date d = new Date();
		JXDatePicker dp = new JXDatePicker();
			dp.setDate(d);
		
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
				JOptionPane.showMessageDialog(f, "get time: "+dp.getDate());
				System.out.println(dp.getDate());
			}
		});	
	}

}

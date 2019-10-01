package comprehensive;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.*;
public class practice_progressbar {
	
	public static void main(String[] args) {
		int gap = 5;
		JButton b = new JButton("Install");
		
		
		JProgressBar pb = new JProgressBar();
			pb.setMaximum(1000);
			pb.setValue(0);
			pb.setSize(new Dimension(200,30));
			pb.setForeground(Color.BLUE);
			pb.setVisible(true);
			pb.setStringPainted(true);
			
		JFrame f = new JFrame("test-frame");
			f.setSize(500, 500);
			f.setLocation(200, 200);
			f.setLocationRelativeTo(null);
			f.setLayout(new GridLayout(2,1,gap,gap));
			
			f.add(pb);
			f.add(b);
			
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pb.setVisible(true);
				new Thread() {
					public void run() {
						int t;
						for(int i=0;i<1000;i++) {
							t = new Random().nextInt(150)-50;
							pb.setValue(i+1);
							try {
								System.out.println(t);
								TimeUnit.MILLISECONDS.sleep(t);
							}catch(Exception e) {
								e.printStackTrace();
							}
						}
					}
				}.start();
			}			
		});
	}
}

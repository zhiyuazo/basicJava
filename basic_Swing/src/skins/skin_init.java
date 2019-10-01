package skins;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.*;

public class skin_init {
	
	public static void main(String[] args) {
		
		set_ui();
		JTextArea ta = new JTextArea();
				ta.setEditable(false);
				ta.setLineWrap(true);
				ta.setPreferredSize(new Dimension(400,400));
		JScrollPane  p_up = new JScrollPane(ta);
				
		JButton b = new JButton("Display...");
		JFrame f = new JFrame("test_skin");
			f.setSize(500, 600);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocation(200,200);
			f.setLayout(new FlowLayout());
			f.add(p_up);
			f.add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				for(int i = 0;i <500; i++) {
					ta.append(String.valueOf(i));
					if(i!=0 && i%10 == 0) {
						ta.append("\r\n");
					}
				}
			}
		});
	}
	
	private static void set_ui() {
		
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

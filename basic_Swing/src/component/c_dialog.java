package component;

import javax.swing.*;
import java.awt.*;
public class c_dialog {
	
	public static void main(String[] args) {
		
		JFrame f =new JFrame("learn_combobox");
			f.setSize(400, 400);
			f.setLocation(100, 100);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLayout(null);
			f.setVisible(true);	
			
		int option = JOptionPane.showConfirmDialog(f, "Love ZhangPing??");
		if(JOptionPane.OK_OPTION == option) {
			String answer = JOptionPane.showInputDialog(f,"Input Yes, to indicate your heart");
			if("yes".equals(answer)) {
				JOptionPane.showMessageDialog(f, "You get marry with zhangping");
			}
		}else {
			JOptionPane.showMessageDialog(f, "You give up Zhangping as your wife");
		}
	}
}

package abandon;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class prototype {
	public static void main(String[] args) {
		
		//no.1 part
		JToolBar tb = new JToolBar();
			JButton b1 = new JButton("����һ��");
			JButton b2 = new JButton("��һ��");
			JButton b3 = new JButton("���ѷ���");
			JButton b4 = new JButton("�����ѱ���");
			JButton b5 = new JButton("����");
			JButton b6 = new JButton("����");
			JButton b7 = new JButton("�ָ�");
		tb.add(b1);	
		tb.add(b2);	
		tb.add(b3);	
		tb.add(b4);	
		tb.add(b5);	
		tb.add(b6);	
		tb.add(b7);	
		
		//no.2 part
		JPanel p_display = new JPanel();
		
		JFrame f  = new JFrame();
		f.setLayout(new BorderLayout());
		f.setSize(500,500);
		f.setLocation(200,200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(tb,BorderLayout.NORTH);
		f.add(p_display,BorderLayout.CENTER);
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				JOptionPane.showConfirmDialog(f, "Is Worked?");
			}
		});
	}
}

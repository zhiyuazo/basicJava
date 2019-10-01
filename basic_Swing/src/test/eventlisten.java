package test ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;  

public class eventlisten {
	public static void main(String[] args) {

		ImageIcon i = new ImageIcon("test1.jpg");
		
		final JLabel l = new JLabel();
			l.setIcon(i);
			l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
			
		JButton b = new JButton("Hide..");
			b.setBounds(50,200,150,30);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(b.getText().equals("Hide..")) {
						l.setVisible(false);
						b.setText("Display..");
					}else {
						l.setVisible(true);
						b.setText("Hide..");
					}
				}
			});
			
		JFrame f = new JFrame("LOL");
			f.setSize(400,300);
			f.setLocation(580, 200);
			f.setLayout(null);
			/*
			l.addMouseListener(new MouseListener(){
				public void mouseReleased(MouseEvent e) {
					
				}
				
				public void mousePressed(MouseEvent e) {
					
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					Random r = new Random();
					int x = r.nextInt(f.getWidth() - l.getWidth());
					int y = r.nextInt(f.getHeight() - l.getHeight());
					l.setLocation(x,y);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			MouseAdapter instead of MouseListener, because listen must implements all the method
			*/
			l.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent e) {
					Random r = new Random();
					int x = r.nextInt(f.getWidth() - l.getWidth());
					int y = r.nextInt(f.getHeight() - l.getHeight());
					l.setLocation(x,y);					
				}
			});
			
			
			f.addKeyListener(new KeyListener() { //not worked???!!!!
				public void keyReleased(KeyEvent e) {
					//
				}
				
				public void keyTyped(KeyEvent e) {
					//
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					if(e.getKeyCode()== 37) {
						l.setLocation(l.getX() - 10,l.getY());
					}else if(e.getKeyCode()== 39) {
						l.setLocation(l.getX() + 10,l.getY());
					}else if(e.getKeyCode()== 40) {
						l.setLocation(l.getX(),l.getY()+10);
					}else if(e.getKeyCode()== 38) {
						l.setLocation(l.getX(),l.getY()-10);
					}
				
				}		
			});
			
			f.add(l);
			f.add(b);

			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.setFocusable(true);
			f.requestFocus();    //button and key-listener can not co-exists, remove button, the key-listener can work well.. 
			// this issue should root@ JFrame 's focus problem , will know it later...
	}
}

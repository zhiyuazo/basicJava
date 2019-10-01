package layout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;


//!! In flow layout, not need to set the pos and size for buttons...
public class setpreferredsize_pos {
	
	public static void main(String[] args) {
		int gap = 0;
        JPanel middlePanel = new JPanel();
        	middlePanel.setBounds(gap, gap, 300, 225);
        	middlePanel.setLayout(new GridLayout(4, 5,gap,gap));
	        middlePanel.add(new JButton("7"));
	        middlePanel.add(new JButton("8"));
	        middlePanel.add(new JButton("9"));
	        middlePanel.add(new JButton("/"));
	        middlePanel.add(new JButton("sq"));
	        middlePanel.add(new JButton("4"));
	        middlePanel.add(new JButton("5"));
	        middlePanel.add(new JButton("6"));
	        middlePanel.add(new JButton("*"));
	        middlePanel.add(new JButton("%"));
	        middlePanel.add(new JButton("1"));
	        middlePanel.add(new JButton("2"));
	        middlePanel.add(new JButton("3"));
	        middlePanel.add(new JButton("-"));
	        middlePanel.add(new JButton("1/x"));
	        middlePanel.add(new JButton("0"));
	        middlePanel.add(new JButton("+/-"));
	        middlePanel.add(new JButton("."));
	        middlePanel.add(new JButton("+"));
	        middlePanel.add(new JButton("="));
		JFrame f = new JFrame("Calculator");
	        f.setSize(322, 272);
	        f.setLocation(200, 200);
	        f.setLayout(null);
	        f.add(middlePanel);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setVisible(true);
	}
}

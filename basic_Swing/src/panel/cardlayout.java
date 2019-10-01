package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class cardlayout {

	
	public static void main(String[] args) {
		
		JButton b1 = new JButton("liubei");
		JButton b2 = new JButton("guanyu");
		JButton b3 = new JButton("zhangfei");
		JButton b4 = new JButton("caomengde");
		JButton b5 = new JButton("guofengxiao");
		JButton b6 = new JButton("xunyu");
		//----
		
		String comboboxitems[] = {"button-panel","input-panel"};
		JComboBox<String> cb = new JComboBox<>(comboboxitems);
		JPanel comboboxpane = new JPanel();
			comboboxpane.add(cb);
			comboboxpane.setBackground(Color.orange);
		//----	
		JPanel card1 = new JPanel();
			card1.add(b1);
			card1.add(b2);
			card1.add(b3);
			card1.setBackground(Color.GREEN);
		
		JPanel card2 = new JPanel();
			card2.add(new JTextField("input-field",20));
			card1.setBackground(Color.BLUE);
			
		JPanel cards; 
			cards = new JPanel(new CardLayout());
			cards.add(card1,"button-panel");
			cards.add(card2,"input-panel");
			cards.setBackground(Color.YELLOW);
			
			
		JFrame f = new JFrame("test-panel");
			f.setSize(400,400);
			f.setLocation(200, 200);
			f.add(comboboxpane,BorderLayout.NORTH);
			f.add(cards,BorderLayout.CENTER);
			//f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setLocationRelativeTo(null);
			f.setVisible(true);	
			
		//this is very important...
	
		cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				cl.show(cards,(String) evt.getItem());
			}
		});
	}
}

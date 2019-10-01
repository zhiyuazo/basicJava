package swing_thread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.*;
import java.awt.event.*;

import swing_thread.swing_init_thread.test_frame;

public class swing_eventdispatch_thread {
	
	public static void main(String[] args) {
		// invoke in Init-thread
		new test_frame();       
		
		//invoke in Event-dispatch-thread
		SwingUtilities.invokeLater(new Runnable() { 
			public void run() {
				new test_frame();
			}
		});
	}
		
	static class test_frame extends JFrame {	
		public test_frame() {
			JButton b = new JButton("test_button");
          		b.setBounds(50, 50, 280, 30);
          		b.addActionListener(new ActionListener() {
          			public void actionPerformed(ActionEvent e) {
          				String prompt = SwingUtilities.isEventDispatchThread()?"Run in Event-dispatch-thread":"Run in Init_thread";
          				System.out.println("button is " + prompt);
          			}
          		});
			setTitle("test_swing_thread_init");
	        setSize(400, 300);
	        setLocation(200, 200);
	        setLayout(null);
	        add(b);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
	        setVisible(true);   
	        String prompt = SwingUtilities.isEventDispatchThread()?"Run in Event-dispatch-thread":"Run in Init_thread";
	        System.out.println("test-frame is " + prompt);
	        
	        
	        
		}
	}

}

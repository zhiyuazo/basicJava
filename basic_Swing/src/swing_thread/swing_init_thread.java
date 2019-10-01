package swing_thread;


import javax.swing.*;
import java.awt.*;


//new test_frame() create the JFrame and UI 
//If the UI very simple , is OK, create it at main method. 
//When the UI is very complicated, the JFrame and JButton will be invoked by 2 Thread respectively. will introduced Thread-problem.
//So, the create/display UI should handled by EventDispatchThread.... 

public class swing_init_thread {
	
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
			setTitle("test_swing_thread_init");
	        setSize(400, 300);
	        setLocation(200, 200);
	        setLayout(null);
	        add(b);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 
	        setVisible(true);   
	        String prompt = SwingUtilities.isEventDispatchThread()?"Run in Event-dispatch-thread":"Run in Init_thread";
	        System.out.println(prompt);
		}
	}
	
}

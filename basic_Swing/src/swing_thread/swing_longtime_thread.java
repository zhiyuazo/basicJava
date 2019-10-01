package swing_thread;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class swing_longtime_thread {

	public static void main(String[] args) {
		
		JTextArea ta = new JTextArea();
				ta.setEditable(false);
				ta.setLineWrap(true);
				ta.setPreferredSize(new Dimension(450,300));
				ta.setText("");
				
		JButton b1 = new JButton("less_time_action");
		JButton b2 = new JButton("more_time_action_event_dispatch_thread");
		JButton b3 = new JButton("more_time_action_long_time_thread");
		
		
		JFrame f = new JFrame("test_longtime_thread");
				f.setSize(500, 600);
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setLocation(200,200);
				f.setLayout(new FlowLayout());
				f.add(ta);
				f.add(b1);
				f.add(b2);
				f.add(b3);
		b1.addActionListener(new ActionListener() {
          			public void actionPerformed(ActionEvent e) {
          				String prompt = SwingUtilities.isEventDispatchThread()?"Event-dispatch-thread":"Init-thread";
          				ta.append("b1 is handled by Thread: " + Thread.currentThread().getName() +"  belong to:" + prompt +"\r\n");
          			}
          		});
		//After b2 click, the UI will stuck due to the 120seconds delay, because the Event-dispatch-thread's single thread..
		b2.addActionListener(new ActionListener() { 
  			public void actionPerformed(ActionEvent e){
  				
  				String prompt = SwingUtilities.isEventDispatchThread()?"Event-dispatch-thread":"Init-thread";
					try {
						TimeUnit.SECONDS.sleep(15);
						ta.append("b2 is handled by Thread: " + Thread.currentThread().getName() +"  belong to:" + prompt+"\r\n");
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
  			}
  		});
		
		b3.addActionListener(new ActionListener() { 
  			public void actionPerformed(ActionEvent e) {
  				
  				SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>(){
  					protected Void doInBackground() {
  						String prompt = SwingUtilities.isEventDispatchThread()?"Event-dispatch-thread":"Init_thread";
  						try {
							TimeUnit.SECONDS.sleep(15);
							ta.append("b3 is handled by Thread: " + Thread.currentThread().getName() +"  belong to:" + prompt+"\r\n");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
  						return null;
  					}
  				};
  				worker.execute();
  			}
  		});
	}
}

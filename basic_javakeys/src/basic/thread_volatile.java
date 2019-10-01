package basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class cat {
	volatile boolean flag = false; 
	public void changeStatus(boolean b) {
		flag = b;
	}
	public void cry() {
		if(flag) {
			System.out.println("\tHappyHappyHappyHappyHappy");
		}else {
			System.out.println("\tSadSadSadSadSadSadSadSadSad");
		}
	}
}
public class thread_volatile {
	
	public static void main(String[] args) throws InterruptedException {
		cat c = new cat();
		Thread[] tschg = new Thread[10];
		Thread[] tscry = new Thread[10];
		Thread ttt = new Thread("cat_change_thread") {
			public void run() {
				for(int i = 0 ; i < 100 ; i++) {
						if(i%2==0) {
							c.changeStatus(true);
							System.out.println(this.getName() + " change status to TRUE...");
						}else {
							c.changeStatus(false);
							System.out.println(this.getName() + " change status to FALSE...");
						}
						try {
							TimeUnit.MILLISECONDS.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
			}
		};
		ttt.start();
		TimeUnit.MILLISECONDS.sleep(10);
		
		for(int i = 0; i < tscry.length; i++ ) {
			Thread t = new Thread("cry_" + i) {
				public void run() {
					for(int i=0 ; i < 100 ; i++) {
						System.out.println(this.getName()  + " cry: ");
						c.cry();
						try {
							TimeUnit.MILLISECONDS.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
			t.start();
			tscry[i] = t;
		}
		
		ttt.join();
		for(Thread t : tscry) {
			t.join();
		}
	}
}

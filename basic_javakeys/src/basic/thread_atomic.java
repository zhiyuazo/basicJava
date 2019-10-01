package basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class dog {
	volatile int age = 0; //age++ 是复合操作，不具备原子性，即使加上volatile满足了可见性，也是不行的.
	AtomicInteger hp = new AtomicInteger(0); //保证了原子操作....
}

public class thread_atomic {
	
	public static void main(String[] args) throws InterruptedException {
		dog d = new dog();
		System.out.println("d.age=" + d.age);
		System.out.println("d.hp=" + d.hp);
		Thread[] ts = new Thread[30];
		for (int i = 0; i < 30; i++) {
			Thread t = new Thread("thread-" + i) {
				public void run() {
					for(int i = 0 ; i < 1000 ; i ++) {
						d.age++ ; 
						d.hp.incrementAndGet();
					}
				}
			};
			t.start();
			ts[i] = t;
		}
		for(Thread t : ts) {
			t.join();
		}
		
		System.out.println("d.age=" + d.age);
		System.out.println("d.hp=" + d.hp);
	}
}

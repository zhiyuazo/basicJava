package class_obj;

import java.util.concurrent.TimeUnit;

public class sync_method {
	
	public static void main(String[] args) throws InterruptedException {
		//thread-1
		Thread t1 =new Thread() {
			public void run() {
				try {
					sync_method.method1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.setName("1st-thread");
		t1.start();
		//Thread.sleep(1000);
		
		//thread-2
		Thread t2 = new Thread() {
			public void run() {
				try {
					sync_method.method2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t2.setName("2nd-thread");
		t2.start();
	}
	
	public static void method1() throws InterruptedException {
		
		synchronized(sync_method.class) {
			System.out.println(Thread.currentThread().getName() + ",Entry into method1..running 3 seconds..");	
			TimeUnit.SECONDS.sleep(3);
		}
	}
	// Use "synchronized" decorate a static-function , the sync-object is the current Object..
	public static synchronized void method2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + ",Entry into method2..running 3 seconds..");	
		TimeUnit.SECONDS.sleep(3);
	}
}

package basic;

import java.util.BitSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class A9 {
	int age = 0 ;
	Lock lock = new ReentrantLock();
	public void add() {
		lock.lock(); //lock可以用在数据类中，不一定非得再匿名类中....
		try {
			age++;
		}catch (Exception e) {
			System.out.println("/terror..");
		}finally {
			lock.unlock();
		}
	}
	public void add1() {
			age++;
	}
}
public class thread_lock2 {
	public static void main(String[] args) {
		
//		A9 a9 = new A9(); 
//		System.out.println("age=" + a9.age);
//		Thread[] ts_add = new Thread[10];
//		for (int i = 0; i < ts_add.length; i++) {
//			Thread t = new Thread() {
//				public void run() {
//					for (int j = 0; j < 1000; j++) {
//						a9.add();
//					}
//				}
//			};
//			t.start();
//			ts_add[i] = t;
//		}
//		
//		while(Thread.activeCount() > 1 ) {
//			Thread.yield();
//		}
//		System.out.println("age=" + a9.age);
	}
}

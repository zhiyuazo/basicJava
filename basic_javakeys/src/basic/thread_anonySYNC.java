package basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class thread_anonySYNC {
	@Rule
	public TestName  name = new TestName();
	
	@Before
	public void before() {
		System.out.println(  "_______" +  name.getMethodName() +"_______");
	}
	@After
	public void after() {
		System.out.println("______________________");
		
	}
	
	//volatile int var = 0;  //jdk1.7 后不需声明为final
	int var = 0;
	int totle = 10000 * 10000;
	@Test
	public void trynosync() throws InterruptedException {
		AAA aaa = new AAA();
		System.out.println(aaa.age);
		int totle = 100* 10000;
		Thread[] tsadd = new Thread[1]; 
		Thread[] tssub = new Thread[1]; 
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
							aaa.add();;
					}
				}
			};
			t.start();
			tsadd[i] = t;
		}
		for (int i = 0; i < tssub.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
							aaa.sub();;
					}
				}
			};
			t.start();
			tssub[i] = t;
		}
		for(Thread t : tsadd ) {
			t.join();
		}
		for(Thread t : tssub ) {
			t.join();
		}
	
		System.out.println(aaa.age);
		System.out.println("in Thread: " + Thread.currentThread().getName());
	}
	
	@Test
	public void trysync() throws InterruptedException {
		AAA aaa = new AAA();
		System.out.println(aaa.age);
		int totle = 100* 10000;
		Object lc = new Object();
		Thread[] tsadd = new Thread[1]; 
		Thread[] tssub = new Thread[1]; 
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
						synchronized (lc) {
							aaa.add();;
						}
					}
				}
			};
			t.start();
			tsadd[i] = t;
		}
		for (int i = 0; i < tssub.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
						synchronized (lc) {
							aaa.sub();;
						}
					}
				}
			};
			t.start();
			tssub[i] = t;
		}
		for(Thread t : tsadd ) {
			t.join();
		}
		for(Thread t : tssub ) {
			t.join();
		}
	
		System.out.println(aaa.age);
		System.out.println("in Thread: " + Thread.currentThread().getName());
	}
	
	
	@Test
	public void tryfuncsync() throws InterruptedException {
		AAA aaa = new AAA();
		System.out.println(aaa.age);
		int totle = 100* 10000;
		Object lc = new Object();
		Thread[] tsadd = new Thread[1]; 
		Thread[] tssub = new Thread[1]; 
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
							aaa.addsync();;
					}
				}
			};
			t.start();
			tsadd[i] = t;
		}
		for (int i = 0; i < tssub.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
							aaa.subsync();;
					}
				}
			};
			t.start();
			tssub[i] = t;
		}
		for(Thread t : tsadd ) {
			t.join();
		}
		for(Thread t : tssub ) {
			t.join();
		}
	
		System.out.println(aaa.age);
		System.out.println("in Thread: " + Thread.currentThread().getName());
	}
	
	@Test
	public void trystaticsync() throws InterruptedException {
		System.out.println(AAA.age_static);
		int totle = 100* 10000;
		Object lc = new Object();
		Thread[] tsadd = new Thread[1]; 
		Thread[] tssub = new Thread[1]; 
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
							AAA.addstatic();;
					}
				}
			};
			t.start();
			tsadd[i] = t;
		}
		for (int i = 0; i < tssub.length; i++) {
			Thread t = new Thread() {
				public void run() {
					for (int i = 0; i < totle; i++) {
							AAA.substatic();
					}
				}
			};
			t.start();
			tssub[i] = t;
		}
		for(Thread t : tsadd ) {
			t.join();
		}
		for(Thread t : tssub ) {
			t.join();
		}
	
		System.out.println(AAA.age_static);
		System.out.println("in Thread: " + Thread.currentThread().getName());
	}
}

class AAA {
	public int age = 0;
	public static int age_static = 0;
	public  void add() {
		age++;
	}
	public  void sub() {
		age--;
	}
	public synchronized  void addsync() {
		age++;
	}
	public synchronized void subsync() {
		age--;
	}
	
	
	public static synchronized  void addstatic() {
		age_static++;
	}
	public static synchronized void substatic() {
		age_static--;
	}
}








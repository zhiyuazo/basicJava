package basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import basic.bean.B3;
import basic.bean.BBB;

public class thread_runableSYNC {
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
		//实现runable 接口，这个类变为一个线程，操纵的是别人的数据，而不是自己的数据，切记切记
		//否则 概念很零乱,此类中别的数据为B3的实例
		//匿名类多线程操纵的也是别的数据，而不是自己的数据....
		//别的数据体里面进行Sync关键词
		B3 b3 = new B3(); 
		System.out.println(b3.age);
		
		Thread[] tsadd = new Thread[2];
		Thread[] tssub = new Thread[2];
		
		//++线程
		BBB b3add = new BBB();
		b3add.setDate(b3);
		b3add.setMethod("add");
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread(b3add);
			t.setName("add-"+i);
			tsadd[i] = t;
			t.start();
		}
		
		//--线程
		BBB b3sub = new BBB();
		b3sub.setDate(b3);
		b3sub.setMethod("sub");
		for (int i = 0; i < tssub.length; i++) {
			Thread t = new Thread(b3sub);
			t.setName("sub-"+i);
			tssub[i] = t;
			t.start();
		}
		
		for(Thread t : tsadd) {
			t.join();
		}
		for(Thread t : tssub) {
			t.join();
		}
		System.out.println(b3.age);
		System.out.println("in Thread: " + Thread.currentThread().getName());
	}
	
	@Test
	public void trysync() throws InterruptedException {
		B3 b3 = new B3(); 
		System.out.println(b3.age);
		
		Thread[] tsadd = new Thread[2];
		Thread[] tssub = new Thread[2];
		
		//++线程
		BBB b3add = new BBB();
		b3add.setDate(b3);
		b3add.setMethod("addsync");
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread(b3add);
			t.setName("add-"+i);
			tsadd[i] = t;
			t.start();
		}
		
		//--线程
		BBB b3sub = new BBB();
		b3sub.setDate(b3);
		b3sub.setMethod("subsync");
		for (int i = 0; i < tssub.length; i++) {
			Thread t = new Thread(b3sub);
			t.setName("sub-"+i);
			tssub[i] = t;
			t.start();
		}
		
		for(Thread t : tsadd) {
			t.join();
		}
		for(Thread t : tssub) {
			t.join();
		}
		System.out.println(b3.age);
		System.out.println("in Thread: " + Thread.currentThread().getName());
	}
}

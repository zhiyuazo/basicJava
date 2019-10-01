package basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import cn.hutool.core.date.DateUtil;


public class list_speed {
	@Rule 
	public TestName name = new TestName();
	
	ArrayList al = new ArrayList<>();
	LinkedList ll = new LinkedList<>();
	int head = 0;
	int mid = 50 * 1000;
	int tail = 100*1000 -1;
	int size = 100 * 1000;
	long start;
	long end ;
	
	@Before
	public void before() {
		System.out.println(  "_______" +  name.getMethodName() +"_______");
		start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			al.add(i);
			ll.add(i);
		}
	}
	@After
	public void after() {
		end = System.currentTimeMillis();
		System.out.println("___________________cost:" + (end-start) );
		
	}
	
	@Test
	public void insert_head() throws InterruptedException {
		System.out.println("size= " + al.size() + " : " + ll.size());
		Thread t1 = new Thread() {
			public void run() {
				long s = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					al.add(head, i);
				}
				long e = System.currentTimeMillis();
				System.out.println("al: " + (e-s));
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				long s = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					ll.addFirst(i);
				}
				long e = System.currentTimeMillis();
				System.out.println("ll: " + (e-s));
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	
	@Test
	public void insert_mid() throws InterruptedException{
		System.out.println("size= " + al.size() + " : " + ll.size());
		Thread t3 = new Thread() {
			public void run() {
				long s = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					al.add(mid, i);
				}
				long e = System.currentTimeMillis();
				System.out.println("al: " + (e-s));
			}
		};
		Thread t4 = new Thread() {
			public void run() {
				long s = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					ll.add(mid, i);;
				}
				long e = System.currentTimeMillis();
				System.out.println("ll: " + (e-s));
			}
		};
		t3.start();
		t4.start();
		t3.join();
		t4.join();
	}
	
	@Test
	public void insert_tail() throws InterruptedException  {
		System.out.println("size= " + al.size() + " : " + ll.size());
		Thread t5 = new Thread() {
			public void run() {
				long s = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					al.add(i);
				}
				long e = System.currentTimeMillis();
				System.out.println("al: " + (e-s));
			}
		};
		Thread t6 = new Thread() {
			public void run() {
				long s = System.currentTimeMillis();
				for (int i = 0; i < size; i++) {
					ll.addLast(i);
				}
				long e = System.currentTimeMillis();
				System.out.println("ll: " + (e-s));
			}
		};
		t5.start();
		t6.start();
		t5.join();
		t6.join();
	}
}

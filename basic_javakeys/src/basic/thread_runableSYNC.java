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
	
	//volatile int var = 0;  //jdk1.7 ��������Ϊfinal
	int var = 0;
	int totle = 10000 * 10000;
	@Test
	public void trynosync() throws InterruptedException {
		//ʵ��runable �ӿڣ�������Ϊһ���̣߳����ݵ��Ǳ��˵����ݣ��������Լ������ݣ��м��м�
		//���� ���������,�����б������ΪB3��ʵ��
		//��������̲߳��ݵ�Ҳ�Ǳ�����ݣ��������Լ�������....
		//����������������Sync�ؼ���
		B3 b3 = new B3(); 
		System.out.println(b3.age);
		
		Thread[] tsadd = new Thread[2];
		Thread[] tssub = new Thread[2];
		
		//++�߳�
		BBB b3add = new BBB();
		b3add.setDate(b3);
		b3add.setMethod("add");
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread(b3add);
			t.setName("add-"+i);
			tsadd[i] = t;
			t.start();
		}
		
		//--�߳�
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
		
		//++�߳�
		BBB b3add = new BBB();
		b3add.setDate(b3);
		b3add.setMethod("addsync");
		for (int i = 0; i < tsadd.length; i++) {
			Thread t = new Thread(b3add);
			t.setName("add-"+i);
			tsadd[i] = t;
			t.start();
		}
		
		//--�߳�
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

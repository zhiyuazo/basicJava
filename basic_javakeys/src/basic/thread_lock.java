package basic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class thread_lock {
	public static void main(String[] args) throws InterruptedException {
		Lock  lock = new ReentrantLock();
		Thread  t1 = new Thread("thread-t1") {
			public void run() {
				try {
					System.out.println(this.getName() + " �߳�����...");
					System.out.println(this.getName() + " ��ͼռ��lock-obj...");
					lock.lock();
					System.out.println(this.getName() + " ռ��lock-obj...");
					System.out.println(this.getName() + " ����5 seconds...");
					Thread.sleep(5000);
				}catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(this.getName() + " �ͷ�lock-obj...");
					lock.unlock();
				}
				System.out.println(this.getName() + " Over...");
			}
		};
		
		Thread  t2 = new Thread("thread-t2") {
			public void run() {
				boolean flag = true; 
				try {
					System.out.println(this.getName() + " �߳�����...");
					System.out.println(this.getName() + " ��ͼռ��lock-obj...");
					//flag = lock.tryLock(2,TimeUnit.SECONDS);
					lock.lock();
					if(flag) {
						System.out.println(this.getName() + " ռ��lock-obj...");
						System.out.println(this.getName() + " ����5 seconds...");
						Thread.sleep(5000);
					}else {
						System.out.println(this.getName() + " ����ռ��lock-obj...");
					}
				}catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(this.getName() + " �ͷ�lock-obj...");
					if(flag) {
						lock.unlock();
					}
				}
				System.out.println(this.getName() + " Over...");
			}
		};
		
		t1.start();
		TimeUnit.SECONDS.sleep(1);
		t2.start();
		t1.join();
		t2.join();
	}
	
	
}
package basic;

public class thread_notify {
	public static void main(String[] args) throws InterruptedException {
		Killer zzy = new Killer();
		
		Thread t_add = new Thread() {
			public void run() {
				while(true) {
					try {
						zzy.recover(1);
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t_sub = new Thread() {
			public void run() {
				while(true) {
					try {
						zzy.hurt(1);
						sleep(600);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t_add.start();
		t_sub.start();
		t_add.join();
		t_sub.join();
		System.out.println(zzy.hp);
		System.out.println("in main thread...");
	}
}

class Killer {
	String name;
	int hp = 0;
	public synchronized void  recover(int v) throws InterruptedException {
		if(hp>=10) {
			System.out.println("add thread hp>=30 waiting sub thread..");
			this.wait();
		}
		hp += v;
		System.out.println("add thread hp=" + hp);
		this.notify();
	}
	public synchronized void  hurt(int v) throws InterruptedException {
		if(hp<= 1) {
			System.out.println("sub thread hp<=1 waiting add thread..");
			this.wait();
		}
		hp -= v;
		System.out.println("sub thread hp=" + hp);
//		this.notifyAll();
	}
}




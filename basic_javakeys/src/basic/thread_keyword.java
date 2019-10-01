package basic;

public class thread_keyword {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					if(i%20 ==0) {
						try {
//							System.out.println(this.getName() + " sleep...2-SECs");
							System.out.println(this.getName() + " yield..");
							//Thread.sleep(2000);
							Thread.yield();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						System.out.println(this.getName() + " execute");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					if(i%30 ==0) {
						try {
//							System.out.println(this.getName() + " sleep...2-SECs");
							System.out.println(this.getName() + " yield..");
//							Thread.sleep(2000);
							Thread.yield();
							Thread.yield();
							Thread.yield();
							Thread.yield();
							Thread.yield();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						System.out.println(this.getName() + " execute");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}

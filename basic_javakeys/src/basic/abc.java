package basic;


class thread_try implements Runnable{
	public void run() {
		System.out.println("实现Runnable接口方法");
	}
}
public class abc {
	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			public void run() {
				System.out.println("匿名类方法");
			}
		}.start();
	}
}

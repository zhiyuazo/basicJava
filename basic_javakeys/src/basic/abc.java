package basic;


class thread_try implements Runnable{
	public void run() {
		System.out.println("ʵ��Runnable�ӿڷ���");
	}
}
public class abc {
	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			public void run() {
				System.out.println("�����෽��");
			}
		}.start();
	}
}

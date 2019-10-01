package basic.bean;

public class B3 {
	public int age =0;
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
}

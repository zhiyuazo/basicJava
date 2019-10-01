package basic.bean;

public class BBB implements Runnable {
	String method;
	B3 data ;
	public void setMethod(String m) {
		this.method = m;
	}
	public void setDate(B3 b3) {
		this.data = b3;
	}
	
	@Override
	public void run() {
		int totle = 100 * 10000;
//		System.out.println("method=" +method);
		switch (method) {
		case "add":
			for (int i = 0; i < totle; i++) {
				data.add();
			}
			break;
		case "sub":
			for (int i = 0; i < totle; i++) {
				data.sub();
			}
			break;
		case "addsync":
			for (int i = 0; i < totle; i++) {
				data.addsync();
			}
			break;
		case "subsync":
			for (int i = 0; i < totle; i++) {
				data.subsync();
			}
			break;

		default:
			break;
		}
		
	}
}

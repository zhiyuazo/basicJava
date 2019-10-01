package Question;

public abstract class fangzhengTry {
	public static void main(String[] args) {
		p c = new c();
		c.echo();
		c.echo2();
		System.out.println(c.i);
		//---
		System.out.println("-------");
		c c2 = new c();
		c2.echo();
		c2.echo2();
		System.out.println(c2.i);
		
	
	}
}

class p {
	public int i = 3;
	public void echo() {
		System.out.println(i);
	}
	public void echo2() {
		System.out.println(i);
	}
}


class c extends p{
	public int i = 6 ;
	public void echo2() {
		System.out.println(i);
	}
}

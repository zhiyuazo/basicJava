package basic;

class ccc  {
	int age ;
	String name ;
}
public class hashcode {
	public static void main(String[] args) {
		ccc c = new ccc();
		c.age= 10;
		c.name =  "zhiyuan";
		System.out.println(c.hashCode());
		
	}
}

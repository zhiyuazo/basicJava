package eg_class;

public class hero {

	public String name;
	public int    hp;
	private int age = 0;
	
	public static String flag = "default";
	static {
		System.out.println("static initializing ");
		flag = "pass";
	}
	
	public hero () {
		this.name = null;
		this.hp   = 0;
	}
	public hero (String n,int h) {
		this.name = n;
		this.hp   = h;
	}
	
	public String getname() {
		return name;	
	}
	
	public void setname(String s) {
		name =s;
	}
	
	
	public int gethp() {
		return hp;
	}
	
	public void  sethp(int h) {
		hp =h ;
	}
	
	public int getage() {
		return age;
	}
	
	public void  setage(int a) {
		hp =a ;
	}
	
    @Override
    public String toString() {
        return "Hero [name=" + name + "]";
    }
    public boolean isDead() {
        // TODO Auto-generated method stub
        return false;
    }
    public void attackHero(hero h2) {
        System.out.println(this.name+ " ÕýÔÚ¹¥»÷ " + h2.getname());
        System.out.println(this.hp+ ":" + h2.hp);
    }
	
}

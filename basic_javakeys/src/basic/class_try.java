package basic;

import java.util.Comparator;

import basic.bean.Hero;

public class class_try {
	
	public static void main(String[] args) {
		parent p = new parent("zhiyuan","xiaoer");
		
		System.out.println("-----");
		//演示值传递
		child zzy = new child(100);  
		zzy.hp = zzy.hp - 50;
		//revive(Hero h) h引用接受到zzy, 则h指向zzy
		//方法中，h又指向了一个新对象，对zzy无影响...
		//h引用也随着方法的结束而消亡
		//因此 zzy 还是50
		zzy.revive(zzy); 
		System.out.println(zzy.hp);
	}
	
}

class child {
	//此类原本用于演示 子类父类初始化顺序，已了然不需要
	//现用于演示JAVA值传递,没有引用传递
	int hp ; 
	public child(int h ){
		hp = h; 
	}
	public int getHp() {
		return hp;
	}
	public void revive (child h) {
		h = new child(100);
	}
}
class parent {
	
	static String name = setstatic();   
	String alias = setnormal() ;
	
	static {
		name = "abc";
		System.out.println("static block set name=abc..");
	}
	
	{
		System.out.println("static normal set name=abc..");
		alias = "dagou";
	}
	
	
	public static String setstatic(){
		System.out.println("static init set name=123..");
		return "123"; 
	}
	
	public String setnormal(){
		System.out.println("normal init set alias=xiaoming..");
		return "xiaoming"; 
	}
	
	public parent(String s , String a) {
		parent.name = s;
		alias = a ; 
		System.out.printf("construct set name = %s alias=%s" , s,a);
	}
}


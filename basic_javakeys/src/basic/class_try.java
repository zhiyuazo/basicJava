package basic;

import java.util.Comparator;

import basic.bean.Hero;

public class class_try {
	
	public static void main(String[] args) {
		parent p = new parent("zhiyuan","xiaoer");
		
		System.out.println("-----");
		//��ʾֵ����
		child zzy = new child(100);  
		zzy.hp = zzy.hp - 50;
		//revive(Hero h) h���ý��ܵ�zzy, ��hָ��zzy
		//�����У�h��ָ����һ���¶��󣬶�zzy��Ӱ��...
		//h����Ҳ���ŷ����Ľ���������
		//��� zzy ����50
		zzy.revive(zzy); 
		System.out.println(zzy.hp);
	}
	
}

class child {
	//����ԭ��������ʾ ���ุ���ʼ��˳������Ȼ����Ҫ
	//��������ʾJAVAֵ����,û�����ô���
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


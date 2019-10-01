package sort;

import java.io.BufferedReader;
import java.io.File;

public class initSequence {
	public static void main(String[] args){
		new shushi();
	}
}


class  hero {
	String name = setName();
	static String alias = setStaticName();
	
	{name = "b"; System.out.println("parent_init_block");};
	static {alias = "b"; System.out.println("parent_init_static_block");};
	
	hero(){
		name = "b";
		System.out.println("parent_construct..");
	}
	
	public String setName() {
		System.out.println("parent_statement-init..");
		return "a";
	}
	
	public static String setStaticName() {
		System.out.println("parent_statement-init-static..");
		return "a";
	}
}


class shushi extends hero {
	String id = setId();
	static String iq = setStaticId();
	
	{id = "123"; System.out.println("child_init_block");};
	static {iq = "123"; System.out.println("child_init_static_block");};
	
	
	shushi(){
		id = "123";
		System.out.println("child_construct..");
		
	}
	
	
	public  String setId() {
		System.out.println("child_statement_init..");
		return "123";
	}
	
	public static String setStaticId() {
		System.out.println("child_statement_init_static..");
		return "123";
	}
	
}




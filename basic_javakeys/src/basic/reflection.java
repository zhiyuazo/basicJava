package basic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class reflection {
	@Rule
	public TestName  name = new TestName();
	
	@Before
	public void before() {
		System.out.println(  "_______" +  name.getMethodName() +"_______");
	}
	@After
	public void after() {
		System.out.println("______________________");
		
	}
	@Test
	public void getobj() throws ClassNotFoundException {
		Class obj1 = Class.forName("basic.Person");
		Class obj2 = new Person().getClass();
		Class obj3 = Person.class;
		System.out.println(obj1==obj2);
		System.out.println(obj1==obj3);
	}

	@Test
	public void createobj() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class obj1 = Person.class;
		Person p1 = (Person) obj1.newInstance();
		Person p2 = (Person) obj1.getConstructor().newInstance();
		System.out.println(p1.getAge());
		System.out.println(p2.getAge());
		Person p3 = (Person) obj1.getConstructor(String.class,int.class).newInstance("zhiyuan",30);
		System.out.println(p3.getAge());
	}

	@Test
	public void fieldobj() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class obj1 = Person.class;
		Person p1 = (Person)obj1.getConstructor(String.class,int.class).newInstance("zhiyuan",30);
		System.out.println("current p1 [ " + p1.getName() + " : " + p1.getAge() + " ]");
		Field f = obj1.getDeclaredField("name");
		f.set(p1, "kkndm");
		System.out.println("now p1 [ " + p1.getName() + " : " + p1.getAge() + " ]");
		Field[] fs = obj1.getDeclaredFields();
		System.out.println("自己的所有 不包括继承：");
		for(Field fi : fs) {
			System.out.println("\t" + fi.getName());
		}
		Field[] fs1 = obj1.getFields();
		System.out.println("自己的public 包括继承来的：");
		for(Field fi1 : fs1) {
			System.out.println("\t" + fi1.getName());
		}
	}
	
	@Test
	public void methodobj() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class obj1 = Person.class;
		Person p1 = (Person)obj1.getConstructor(String.class,int.class).newInstance("zhiyuan",30);
		System.out.println("current p1 [ " + p1.getName() + " : " + p1.getAge() + " ]");
		Method m = obj1.getMethod("setName", String.class);
		m.invoke(p1, "kkndm");
		System.out.println("now p1 [ " + p1.getName() + " : " + p1.getAge() + " ]");
		Method[] ms = obj1.getDeclaredMethods();
		System.out.println("自己的所有 不包括继承：");
		for(Method mi : ms) {
			System.out.println("\t" + mi.getName());
		}
		Method[] ms1 = obj1.getMethods();
		System.out.println("自己的public 包括继承来的：");
		for(Method mi1 : ms1) {
			System.out.println("\t" + mi1.getName());
		}
	}
}
class man{
	public String kind = "yellow";
	public void trytest() {};
}
class Person extends man{
	static String flag  = setStatic();
			
	public static String setStatic() {
		System.out.println("static init invoked...");
		return "a";
	}
	
	static {
		flag = "b";
		System.out.println("static block invoked...flag=" + flag);
	}
	
	
	String name;  
	int age ;
	
	public Person() {
		
	}
	public Person(String s, int a) {
		this.name = s;
		this.age = a;
	}
	
	public void setName(String s ) {
		this.name = s;
	}
	
	public void setAge(int a  ) {
		this.age = a;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
}


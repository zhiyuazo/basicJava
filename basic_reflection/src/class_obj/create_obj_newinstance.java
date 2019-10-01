package class_obj;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import eg_class.hero;

public class create_obj_newinstance {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// normal way to create a object....
		hero h1 = new hero("lijing",100);
		System.out.println(h1.getname());
		
		
		Class h_class = Class.forName("eg_class.hero");
		
		//reflection way-1 to create a object
		hero h4 = (hero) h_class.newInstance(); // this can only invoke none-parameters constructor..
		System.out.println(h4.getname());
		
		//reflection way-2 to create a object
		Constructor h_c_none = h_class.getConstructor();//get the none-parameters constructor	
		hero h2 =(hero) h_c_none.newInstance(); //this newInstance() only invoke none-parameters constructor..
		System.out.println(h2.getname());
		
		//reflection way-3 to create a object
		Constructor h_c_has = h_class.getConstructor(String.class,int.class);//get the has-parameters constructor
		hero h3 =(hero) h_c_has.newInstance("zhiyuan",100); //this newInstance() can invokeparameters constructor..
		System.out.println(h3.getname());
		
	}
}

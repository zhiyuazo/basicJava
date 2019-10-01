package class_obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

import eg_class.hero;

public class get_class_obj {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class class_obj_1 = Class.forName("eg_class.hero");//Will initialize the static parameter...
		Class class_obj_2 = hero.class;  	//This will not initialize the static parameter or function...
		Class class_obj_3 = new hero("zhiyuan",100).getClass(); //will initialize the static parameter...
		
		System.out.println("class_obj_1=2? " + (class_obj_1 == class_obj_2));
		System.out.println("class_obj_1=3? " + (class_obj_1 == class_obj_3));
		System.out.println(class_obj_1.getName());
		System.out.println(Arrays.toString(class_obj_1.getMethods()));
		
		//testing
		hero zzy = new hero("zhiyuan",100);
		System.out.println(zzy.getname()+ ": " +zzy.gethp());
		
		File springConfigFile = new File("e:\\project\\j2se\\src\\spring.txt");
	    Properties springConfig= new Properties();
	    springConfig.load(new FileInputStream(springConfigFile));
	    String className = (String) springConfig.get("class");
	    String methodName = (String) springConfig.get("method");
	    Class clazz = Class.forName(className);
	    Method m = clazz.getMethod(methodName);
	    Constructor c = clazz.getConstructor();
	    Object service = c.newInstance();
	    m.invoke(service);
		
	}
	
}



class service1 {
	public void doservice1(){
		System.out.println("this is 1");
	}
}
class service2 {
	public void doservice2(){
		System.out.println("this is 2");
	}
}


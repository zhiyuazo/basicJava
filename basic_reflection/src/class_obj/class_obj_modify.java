package class_obj;
import java.lang.reflect.Field;

import eg_class.hero;

public class class_obj_modify {

	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		hero h1 =new hero("zhiyuan",1000);
		System.out.println(h1.name);
		System.out.println(h1.hp);
		System.out.println(h1.getage());
		System.out.println("----------------------------------");
		//-----
		try {
			Class class_obj =  Class.forName("eg_class.hero");
			
			//Field f1 = class_obj.getField("name|hp|age") //only public-variable can be get, include from parent..
			//Field f1 = class_obj.getDeclaredField("name"); //can get all-variable in this class, Not-include from parent
			Field f1 = class_obj.getDeclaredField("name"); //name is public , can be modified.
			Field f2 = class_obj.getDeclaredField("hp");   //hp is public,can be modified.
			Field f3 = class_obj.getDeclaredField("age");  //age is private, only can read, not write
			f1.set(h1,"wukong");
			f2.set(h1,999);
			f3.setAccessible(true); f3.set(h1, 777); //if setAccessible=true, can modified...
			System.out.println(h1.name);
			System.out.println(h1.hp);
			System.out.println(h1.getage());
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}



class person {
	
	private int life;
	public  int age;
	
}


class zzy extends person {
	public String name ;
	private int   hight;
}






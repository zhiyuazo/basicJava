package class_obj;

import java.lang.reflect.Method;
import java.util.Properties;

import eg_class.hero;

public class class_obj_invoke {
	
	public static void main(String[] args) {
		
		hero h = new hero("lucent" , 888 );
		try {
			Class class_obj =  h.getClass();
			Method m_setname = class_obj.getMethod("setname", String.class);
			m_setname.invoke(h, "Nokia");
			System.out.println(h.getname());
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	
	}
}

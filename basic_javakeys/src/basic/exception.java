package basic;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import cn.hutool.core.util.NumberUtil;


public class exception {
	@Rule 
	public TestName name = new TestName();	
	
	
	
	
	@Before
	public void before() {
		System.out.println(  "_______" +  name.getMethodName() +"_______");
	}
	@After
	public void after() {
		System.out.println("");
	}
	
	@Test
	public void try1() {
		try{
			System.out.println("\tbefore exception...");
			int[] a = new int[5];
			int b= a[5];
			System.out.println("\tafter exception...");
		}catch (Exception e) {
			System.out.println("\thandle exception...");
		}finally {
			System.out.println("\tfinally exception...");
		}
	}
	
	@Test
	public void try2() throws FileNotFoundException {
		int flag = 0; 
		try{
			System.out.println("\tbefore exception...");
			int[] a = new int[5];
			int b= a[5];
			System.out.println("\tafter exception...");
			flag = 1;
		}catch (Exception e) {
			System.out.println("\thandle handle exception...");
			flag = 2;
			throw new FileNotFoundException("lll");
		}finally {
			System.out.println("\tfinally exception...");
			flag = 3;
			System.out.println("\tin finally " + flag);
		}
		
		System.out.println("\t"+flag);
	}
	
	@Test
	public void try3()  {
		int flag = 0; 
		try{
			System.out.println("\tbefore exception...");
			int[] a = new int[5];
			int b= a[5];
			System.out.println("\tafter exception...");
			flag = 1;
		}catch (Exception e) {
			System.out.println("\thandle handle exception...");
			flag = 2;
		}finally {
			System.out.println("\tfinally exception...");
			flag = 3;
		}
		System.out.println("\t"+flag);
		System.out.println("\tdo other service...below..");
	}

	//try4
	public  int  t1() {
		int flag = 0;
		try{
			flag =1;
			System.out.println("\ttry set flag =1");
			return 11;
		}catch (Exception e) {
			flag =2;
			System.out.println("\tcatch set flag =2");
			return 22;
		}finally {
			flag =3;
			System.out.println("\tfinally set flag =3");
		}
	}
	@Test
	public void try4()  {
		int res = t1();
		System.out.println("try¿é -return ºÍ finally-return " + res);
	}
	
	//try5
	public  int t2() {
		int flag = 0;
		try{
			flag =1;
			int[] a = new int[1];
			System.out.println("\ttry set flag =1");
			int b = a[2];
			return 11;
		}catch (Exception e) {
			flag =2;
			System.out.println("\tcatch set flag =2");
			return 22;
		}finally {
			flag =3;
			System.out.println("\tfinally set flag =3");
		}
	}
	@Test
	public void try5()  {
		int res = t2();
		System.out.println("try¿é -return ºÍ catch¿é-return " + res);
	}
	@Test
	public void try6()  {
	}
}

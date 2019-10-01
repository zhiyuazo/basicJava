package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import basic.bean.Hero;
import basic.bean.Hero2;
import basic.bean.Hero3;
import cn.hutool.core.util.RandomUtil;


public class set_frame {
	@Rule 
	public TestName name = new TestName();	
	
	
	@Test
	public void trytry() {
		List<Hero> al = new ArrayList<>();
		al.add(new Hero("top hero",100));
		al.add(new Hero2("no2 hero",100));
		al.add(new Hero3("no3 hero",100));
		
		Hero h = al.get(2);
		System.out.println(h.name);
		
		
	}
	
	
	@Before
	public void before() {
		System.out.println(  "_______" +  name.getMethodName() +"_______");
	}
	@After
	public void after() {
		System.out.println("");
	}
	
	@Test
	public void try_treemap() { //��С˳��(���ݼ�ֵ����), ��k�����ظ���k,v������Ϊnull 
		Map<String,String> tm = new TreeMap<>();
		for(int i = 0 ; i <= 100 ; i++)
			tm.put(String.valueOf(i),RandomUtil.randomString(3));
		for(Map.Entry<String, String> entry : tm.entrySet()) {
			String ss = String.format("%s:%s,", entry.getKey(),entry.getValue());
			System.out.print(ss);
		}
		System.out.println();
		System.out.printf("%s,%s%n",tm.containsKey(null),tm.containsValue(null));
	}
	
	@Test
	public void try_hashmap() { //����, k�����ظ���k,v����Ϊnull����k��Ψһ
		Map<String,String> hm = new HashMap<>();
		hm.put(null,null);
		hm.put(null,null);
		for(int i = 0 ; i <= 100 ; i++)
			hm.put(String.valueOf(i),RandomUtil.randomString(3));
		for(Map.Entry<String, String> entry : hm.entrySet()) {
			String ss = String.format("%s:%s,", entry.getKey(),entry.getValue());
			System.out.print(ss);
		}
		System.out.println();
		System.out.printf("%s,%s%n",hm.containsKey(null),hm.containsValue(null));
	}
	
	@Test
	public void try_linkedhashmap() { //����˳��k�����ظ�, k,v����Ϊnull����k��Ψһ
		Map<String,String> lhm = new LinkedHashMap<>();
		lhm.put(null,null);
		lhm.put(null,null);
		for(int i = 0 ; i <= 100 ; i++)
			lhm.put(String.valueOf(i),RandomUtil.randomString(3));
		for(Map.Entry<String, String> entry : lhm.entrySet()) {
			String ss = String.format("%s:%s,", entry.getKey(),entry.getValue());
			System.out.print(ss);
		}
		System.out.println();
		System.out.printf("%s,%s%n",lhm.containsKey(null),lhm.containsValue(null));
	}
	
	@Test
	public void try_hashset() { //���򣬲����ظ�, ֵ����Ϊnull
		Set<String> hs = new HashSet<>();
		hs.add(null);
		for(int i = 0 ; i <= 100 ; i++)
			hs.add(String.valueOf(i));
		for(String s : hs) {
			String ss = String.format(",%s", s);
			System.out.print(ss);
		}
		System.out.println();
		System.out.println(hs.contains(null));
		hs.stream().filter(s-> s!=null && Integer.parseInt(s)>90 ).forEach(s->System.out.println(s));
	}

	@Test
	public void try_linkedhashset() { //Ԫ�ز������򣬲����ظ���ֵ����Ϊnull
		Set<String> lhs = new LinkedHashSet<>();
		for(int i = 0 ; i <= 100 ; i++)
			lhs.add(String.valueOf(i));
		for(String s : lhs) {
			String ss = String.format(",%s", s);
			System.out.print(ss);
		}
		System.out.println();
		lhs.add(null);
		System.out.println(lhs.contains(null));
	}
	
	@Test
	public void try_treeset() {   //Ԫ�ش�С˳��ʵ��Comparable�ӿڣ��������ظ��� ֵ������Ϊnull,���null����ռ���
		Set<String> ts = new TreeSet<>();
		for(int i = 0 ; i <= 100 ; i++)
			ts.add(RandomUtil.randomString(3));
		for(String s : ts) {
			String ss = String.format(",%s", s);
			System.out.print(ss);
		}
		System.out.println();
		System.out.println(ts.size());
	}
	
	@Test
	public void try_arrlist() {   //Ԫ�ز���˳��,���ظ��� ����Ϊnull
		List<String> al = new ArrayList<>();
		al.add(new Integer(99).toString());
		al.add(null);
		al.add(null);
		for(int i = 0 ; i <= 100 ; i++)
			al.add(String.valueOf(RandomUtil.randomInt(1,10)));
		for(String s : al) {
			String ss = String.format(",%s", s);
			System.out.print(ss);
		}
		System.out.println();
		System.out.println(al.size());
	}
	
	@Test
	public void try_linkedlist() {   //Ԫ�ز���˳��,���ظ��� ����Ϊnull
		List<String> ll = new LinkedList<>();
		ll.add(new Integer(99).toString());
		ll.add(null);
		ll.add(null);
		for(int i = 0 ; i <= 100 ; i++)
			ll.add(String.valueOf(RandomUtil.randomInt(1,10)));
		for(String s : ll) {
			String ss = String.format(",%s", s);
			System.out.print(ss);
		}
		System.out.println();
		System.out.println(ll.size());
	}
	
	@Test
	public void try_vector() {   //Ԫ�ز���˳��,���ظ��� ����Ϊnull
		List<String> v = new Vector<>();
		v.add(new Integer(99).toString());
		v.add(null);
		v.add(null);
		for(int i = 0 ; i <= 100 ; i++)
			v.add(String.valueOf(RandomUtil.randomInt(1,10)));
		for(String s : v) {
			String ss = String.format(",%s", s);
			System.out.print(ss);
		}
		System.out.println();
		System.out.println(v.size());
	}
}

package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.StyleSheet.BoxPainter;

import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;


//Define the data type is key-value
class Entry{
	public Object key = null;
	public Object value = null;
	
	public Entry(Object key,Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String toString() {
		return new String("key is " + key + " Value is " + value);
	}
}
// Define the interface 
interface IHashMap{
	public void put(String key, Object obj);
	public Object get(String key);
}

//The Implementation for MyHashMap
public class MyHashMap implements IHashMap {
	
	private ArrayList<Entry>[]  box = new ArrayList[2000];
	
	public  MyHashMap() {
	
	}
	
	public void put(String key, Object obj) {
		int code = this.getHashCode(key);
		ArrayList<Entry> al = box[code];
		
		if(null == al) {
			al  = new ArrayList<>();
			box[code]= al;
		}
		
		boolean found = false;
		for(Entry e : al) {
			if(key.equals(e.key) ) {
				e.value = obj;
				found = true;
				break;
			}
		}
		
		if(!found) {
			al.add(new Entry(key, obj));
		}
	}
	
	public Entry get(String key) {
		int code = this.getHashCode(key);
		ArrayList<Entry> al = box[code];
		Entry res = null;
		if(null == al) {
			System.out.println("Not found Entry key= "+key);
		}else {
			for(Entry e : al) {
				if(key.equals(e.key)) {
					res = e;
					break;
				}
			}
		}
		return res;
	}
	
	public  int getHashCode(String s ) {
		int res=0;  
		for(char a : s.toCharArray()) {
			short tmp = (short)a;
			int val = (int) Math.abs(Math.pow(tmp, 2)-500);
			res += val;
		}
		res%=2000;
		return res;
	}
	
	public static  String rnds(int n) {
		String pool = new String();
		char char_tmp;
		for(short i ='0'; i<= '9'; i++) {
			char_tmp = (char)i;
			pool += char_tmp;
		}
		for(short i ='A'; i<= 'Z'; i++) {
			char_tmp = (char)i;
			pool += char_tmp;
		}
		for(short i ='a' ;i<= 'z'; i++) {
			char_tmp = (char)i;
			pool += char_tmp;
		}
		char[]  res = new char[n];
		for(int i = 0 ; i< n ;i++) {
			int ind = (int)(Math.random()*pool.length());
			res[i] = pool.charAt(ind);
		}
		return new String(res);
	}
	
	//Test MyHashMap
	public static void main(String[] args ) {
			MyHashMap mhp = new MyHashMap();
			ArrayList<Entry> al = new ArrayList<>();
			
			for(int i = 0 ; i <100 * 10000;i++) {
				String tmp = mhp.rnds(6);
				mhp.put(tmp, i);
				al.add(new Entry(tmp,i));
			}
			mhp.put("zhiyuan", 5);
			al.add(new Entry("zhiyuan",5));
			
			long start=System.currentTimeMillis();
			System.out.println(mhp.get("zhiyuan"));
			long end=System.currentTimeMillis();
			System.out.println("MyHashMap cost: " + (end-start));
		
			long start1=System.currentTimeMillis();
			for(Entry e : al) {
				if("zhiyuan".equals(e.key)) {
					System.out.println(e);
					break;
				}
			}
			long end1=System.currentTimeMillis();
			System.out.println("ArrayList cost: " + (end1-start1));
	}
}



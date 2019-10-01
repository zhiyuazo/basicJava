package test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;



public class test_base {
	
	public static void main(String[] args )  {
		
		
		ArrayList<hero>  al = new ArrayList<>();
		for(int i = 0 ; i< al.size();i++) {
			hero res = al.get(i);
			System.out.println(res);
		}
		
		LinkedList<hero> ll = new LinkedList<>();
		BitSet bs = new BitSet(2);
		System.out.println(bs.get(0));
		
	
	}
}


package sort;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		ArrayList<ArrayList> as = new ArrayList<>();
		as.get(0).add(0);
		as.get(0).add(1);
		as.get(0).add(2);
		as.get(0).add(3);
		as.get(0).forEach(e->System.out.println(e));
		System.out.println(as.get(0).size());
		
		
	}
}

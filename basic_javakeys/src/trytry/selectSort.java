package trytry;

import java.util.Arrays;
import java.util.Random;

public class selectSort {
	
	public static void main(String[] args) {
		int size = 10;
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		System.out.println(Arrays.toString(a));
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[j]<a[i]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}

package trytry;

import java.util.Arrays;
import java.util.Random;

public class bubbleSort {
	
	public static void main(String[] args) {
		int size = 10;
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		System.out.println(Arrays.toString(a));
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if (a[j+1]<a[j]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}

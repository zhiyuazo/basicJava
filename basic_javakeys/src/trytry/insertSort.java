package trytry;

import java.util.Arrays;
import java.util.Random;

public class insertSort {
	
	public static void main(String[] args) {
		int size = 10;
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Random().nextInt(100);
		}
		System.out.println(Arrays.toString(a));
		
		for (int i = 1; i < a.length; i++) {
			int base = a[i];
			int j = i;
			while(j>0 && a[j-1]>base) {
				a[j]=a[j-1];
				j--;
			}
			a[j] = base;
		}
		System.out.println(Arrays.toString(a));
	}

}

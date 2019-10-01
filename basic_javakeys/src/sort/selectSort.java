package sort;

import java.util.Arrays;
import java.util.Random;

public class selectSort {
	public static void main(String[] args) {
		
		Random rd = new Random();
		int all = 10;
		int[] src = new int[all];
		for(int i = 0 ; i <all ; i ++ ) {
			src[i] = rd.nextInt(100);
		}
		System.out.println(Arrays.toString(src));
	
		for(int i = 0 ; i < all ; i ++) {
			for(int j = i+1 ; j < all; j ++) {
				if(src[i]>src[j]) {
					int tmp = 0; 
					tmp = src[i];
					src[i] = src[j];
					src[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(src));
	}
}

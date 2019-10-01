package sort;

import java.util.Arrays;
import java.util.Random;

public class bubbleSort {

	public static void main(String[] args) {
		Random rd = new Random();
		int all = 10;
		int[] src = new int[all];
		for(int i = 0 ; i <all ; i ++ ) {
			src[i] = rd.nextInt(100);
		}
		System.out.println(Arrays.toString(src));
		
		for(int j = 0 ; j < src.length ; j++) {
			for(int i = 0 ;i < src.length-1 - j ; i++) {
				if(src[i]> src[i+1]) {
					int tmp = src[i];
					src[i] = src[i+1];
					src[i+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(src));
	}
}

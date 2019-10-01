package sort;

import java.util.Arrays;
import java.util.Random;

public class insertSort {

	public static void main(String[] args) {
		
		Random rd = new Random();
		int all = 10;
		int[] src = new int[all];
		for(int i = 0 ; i <all ; i ++ ) {
			src[i] = rd.nextInt(100);
		}
		System.out.println(Arrays.toString(src));
		
		
		for(int i = 1 ; i < src.length ; i++) {
			int target = src[i];
			int j = i;
			while(j>0 && src[j-1]> target) {
				src[j] = src[j-1];
				j--;
			}
			src[j] = target;
		}
		
		System.out.println(Arrays.toString(src));
		
		
		
		
	}
	
	
}

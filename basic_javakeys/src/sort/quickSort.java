package sort;

import java.util.Arrays;
import java.util.Random;

public class quickSort {
	
	
	public static void main(String[] args) {
		Random rd = new Random();
		int all = 10;
		int[] src = new int[all];
		for(int i = 0 ; i <all ; i ++ ) {
			src[i] = rd.nextInt(100);
		}
		System.out.println(Arrays.toString(src));
		quickSort(src,0,src.length-1);
		System.out.println(Arrays.toString(src));
	}
	
	
	
	
	public static void quickSort(int[] arr, int start , int end) {
		if(start > end) {
			return ;
		}
		int i = start ; 
		int j = end; 
		int target = arr[i];
		while(i<j) {
			while( arr[j]>=target && i<j) { //Must have = , else, error.. 
				j--;
			}
			while(arr[i]<=target && i<j) {
				i++;
			}
			if(i<j) {
				int tmp = arr[i];
				arr[i] = arr[j] ; 
				arr[j] = tmp;
			}
		}
		arr[start] = arr[i];
		arr[i] = target;
		quickSort(arr,start,j-1);
		quickSort(arr,j+1,end);
	}
}

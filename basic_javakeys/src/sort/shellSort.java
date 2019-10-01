package sort;

import java.util.Arrays;
import java.util.Random;

public class shellSort {
	
	public static void shellSort_1(int[] a) {
		
		for(int gap=a.length/2; gap> 0; gap/=2 ) {
			
			for(int i = 0; i < gap ; i++) {
				for(int j = i+gap;j<a.length; j+=gap) {
					if(a[j] < a[j-gap]) {
						int tmp = a[j];
						int k = j - gap; 
						while(k>=0&&a[k] > tmp) {
							a[k+gap]=a[k];
							k=k-gap;
						}
						a[k+gap] =tmp ;
					}
				}
			}
		}
	}
	
	public static void shellSort_2(int[] a) {
		//body
        for (int step = a.length / 2; step > 0; step /= 2) {
        	
            for (int i = step; i < a.length; i++) {
                int j = i;
                int temp = a[j];
                while (j - step >= 0 && a[j - step] > temp) {
                    a[j] = a[j - step];
                    j = j - step;
                }
                a[j] = temp;
            }
            
        }
		//--end
        
	}
	
	public static void main(String[] args) {
		Random rd = new Random();
		int all = 10;
		int[] src = new int[all];
		for(int i = 0 ; i <all ; i ++ ) {
			src[i] = rd.nextInt(100);
		}
		
		System.out.println(Arrays.toString(src));
		shellSort_1(src);
		System.out.println(Arrays.toString(src));
		
		
		
		
	}
	
}

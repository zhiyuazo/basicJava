package sort;

import java.util.Arrays;
import java.util.Random;

public class mergeSort {
	
	 public static  void merge(int []a,int left,int mid,int right){
	        int[] tmp=new int[a.length];
	        int l=left;
	        int r=mid+1;
	        int k=left;

	        while(l<=mid && r<=right){
	            if(a[l]<=a[r])
	                tmp[k++]=a[l++];
	            else
	                tmp[k++]=a[r++];
	        }

	        while(l<=mid) {
	        	tmp[k++]=a[l++];
	        }
	        
	        while(r<=right) {
	        	tmp[k++]=a[r++];
	        }
	        
	        for (int i = left; i <=right; i++) {
	            a[i]=tmp[i];
	        }
	    }

	    public static void  mergeSort(int [] a,int start,int end){
	        if(start<end){
	            int mid=(start+end)/2;  
	            mergeSort(a, start, mid);  
	            mergeSort(a, mid+1, end); 
	            merge(a, start, mid, end); 
	        }
	    }

	public static void main(String[] args) {
		Random rd = new Random();
		int all = 10;
		int[] src = new int[all];
		for(int i = 0 ; i <all ; i ++ ) {
			src[i] = rd.nextInt(100);
		}
		
		src = new int[] {32,12};
		
		System.out.println(Arrays.toString(src));
		mergeSort(src,0,src.length-1);
		System.out.println(Arrays.toString(src));
	}
	
	
}

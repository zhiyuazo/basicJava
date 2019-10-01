package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SortDiff {

	public static ArrayList<Integer> RNDI(int n ) {
		//source data...
		ArrayList<Integer> ali = new ArrayList<Integer>();
		Random r = new Random();	
		for(int i = 0; i< n;i++) {
			int tmp = r.nextInt(1000);
			ali.add(tmp);
		}
		return ali;
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
		
		ArrayList<Integer>  source = RNDI(10*1000);
		
		//Arrays.sort optimized-fast-sort method
		//---------------------------------------------------------------------------
		int[] fsa = new int[source.size()];
		for(int i = 0 ; i< source.size();i++) {
			fsa[i] = source.get(i);
		}
		long s0 = System.currentTimeMillis();
		Arrays.sort(fsa);
		long e0 = System.currentTimeMillis();
		System.out.println("JAVA-arraysort cost: \t" + (e0-s0) + " \t" );//+ Arrays.toString(fsa));
		
		
		//Selection sort
		//---------------------------------------------------------------------------
		int[] ssa = new int[source.size()];
		for(int i = 0 ; i< source.size();i++) {
			ssa[i] = source.get(i);
		}
		long s1 = System.currentTimeMillis();
		for(int i = 0 ; i < ssa.length ;i++) {
			for(int j = i+1; j<ssa.length ; j++ ) {
				int tmp = 0;
				if(ssa[i]>ssa[j]) {
					tmp = ssa[i];
					ssa[i] = ssa[j];
					ssa[j] = tmp;
				}
			}
		}
		long e1 = System.currentTimeMillis();
		System.out.println("Select Sort cost: \t" + (e1-s1) + " \t" );//+ Arrays.toString(ssa));
		
		
		//Pop sort
		//---------------------------------------------------------------------------
		int[] psa = new int[source.size()];
		for(int i = 0 ; i< source.size();i++) {
			psa[i] = source.get(i);
		}
		long s2 = System.currentTimeMillis();
		for(int i = 0 ; i < psa.length ;i++) {
			for(int j = 0; j<psa.length-1-i ; j++ ) {
				int tmp = 0;
				if(psa[j+1]< psa[j]) {
					tmp = psa[j];
					psa[j] = psa[j+1];
					psa[j+1] = tmp;
				}
			}
		}
		long e2 = System.currentTimeMillis();
		System.out.println("Pop Sort cost : \t" + (e2-s2)+ " \t");// + Arrays.toString(psa));
		
		//insert sort
		//---------------------------------------------------------------------------
		int[] isa = new int[source.size()];
		for(int i = 0 ; i< source.size();i++) {
			isa[i] = source.get(i);
		}
		long s3 = System.currentTimeMillis();
		for(int i = 1 ; i < isa.length ; i++) {
			int target = isa[i];
			int j = i;
			while(j>0 && isa[j-1]> target) {
				isa[j] = isa[j-1];
				j--;
			}
			isa[j] = target;
		}
		long e3 = System.currentTimeMillis();
		System.out.println("Insert Sort cost: \t" + (e3-s3) + " \t" );//+ Arrays.toString(isa));
		
		//merge sort
		//---------------------------------------------------------------------------
		int[] msa = new int[source.size()];
		for(int i = 0 ; i< source.size();i++) {
			msa[i] = source.get(i);
		}
		long s4 = System.currentTimeMillis();
		mergeSort(msa,0,msa.length-1);
		long e4 = System.currentTimeMillis();
		System.out.println("Merge Sort cost: \t" + (e4-s4) + " \t" );//+ Arrays.toString(isa));
		
		//quick sort
		//---------------------------------------------------------------------------
		int[] qsa = new int[source.size()];
		for(int i = 0 ; i< source.size();i++) {
			qsa[i] = source.get(i);
		}
		long s5 = System.currentTimeMillis();
		quickSort(psa,0,psa.length-1);
		long e5 = System.currentTimeMillis();
		System.out.println("Quick Sort cost: \t" + (e5-s5) + " \t" );//+ Arrays.toString(isa));
		
		//Shell sort
		//---------------------------------------------------------------------------
		int[] shsa = new int[source.size()];
		for(int i = 0 ; i< source.size();i++) {
			shsa[i] = source.get(i);
		}
		long s6 = System.currentTimeMillis();
		shellSort_2(shsa);
		long e6 = System.currentTimeMillis();
		System.out.println("Shell Sort cost: \t" + (e6-s6) + " \t" );//+ Arrays.toString(isa));
		
		//dual-tree sort
		//---------------------------------------------------------------------------
		Node<Integer> root = new Node<>();
		for(Iterator<Integer> it = source.iterator(); it.hasNext();) {
			root.add(it.next());
		}
		long s7 = System.currentTimeMillis();
		List<Integer> res_node = root.medSort();
		long e7 = System.currentTimeMillis();
		System.out.println("Dual-Tree Sort cost: \t" + (e7-s7) +" \t");// + res_node);
		
		//treeSet sort
		//---------------------------------------------------------------------------
		Set<Integer>  ts = new TreeSet<>();
		for(Iterator<Integer> it = source.iterator(); it.hasNext();) {
			ts.add(it.next());
		}
		System.out.println("TreeSet Sort cost: \t" +"0\t");// + ts);
		
	}
}


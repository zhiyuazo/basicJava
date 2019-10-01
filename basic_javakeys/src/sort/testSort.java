package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import cn.hutool.core.util.ArrayUtil;



public class testSort {
	@Rule
	public TestName  name = new TestName();
	long s;
	long e;
	
	@Before
	public void before () {
		System.out.println("Start: " + name.getMethodName());
		s = System.currentTimeMillis() ;
		Thread.currentThread().setName("AAAAABBBBBCCCC");
		
	}
	
	@After
	public void after () {
		e = System.currentTimeMillis();
		System.out.println("________________________:cost:" + (e-s) + "_");
	}

	
	static int total = 10000 * 50;
	static int[] srcArray = new int[total];
	static {
		for(int i = 0 ; i < total ; i ++) {
			int tmp =  new Random().nextInt(total) + 1 ;
			srcArray[i] = tmp;
		}
	}
	
	//选择排序类
	@Test
	public void selectSort() {
		int[] selectRes = srcArray;
		for(int i = 0 ; i <selectRes.length; i++ ) {
			for(int j = i+1; j<selectRes.length;j++) {
				if(selectRes[i] > selectRes[j]) {
					int tmp ; 
					tmp = selectRes[i];
					selectRes[i]= selectRes[j];
					selectRes[j] = tmp; 
				}
			}
		}
	}
	
	//冒泡排序类-----------------------------------
	@Test
	public void bubbleSort() {
		int[] bubbleRes = srcArray;
		for (int i = 0; i < bubbleRes.length; i++) {
			for (int j = 0; j < bubbleRes.length-1-i; j++) {
				if(bubbleRes[j]>bubbleRes[j+1]) {
					int tmp ; 
					tmp = bubbleRes[j];
					bubbleRes[j]= bubbleRes[j+1];
					bubbleRes[j+1] = tmp; 
				}
			}
		}
	}
	
	@Test
	public void quickSort() {
		int[] quickRes = srcArray;
		qs(quickRes,0,quickRes.length-1);
	}
	
	public void qs(int[] a , int low, int high) {
		if(low>high) {
			return;
		}
		int i = low;
		int j = high;
		int base = a[low];
		while(i<j) {
			while(i<j && a[j]>base) {
				j--;
			}
			while(i<j && a[i]<=base) {
				i++;
			}
			if(i<j) {
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		//调整base的位置 进行下一轮迭代
		int p = a[i];
		a[i] = a[low];
		a[low] = p;
		qs(a,low,i-1);
		qs(a,i+1,high);
	}
	
	
	
	//插入排序----------------------------------
	@Test
	public void insertSort() {
		int[] insertRes = srcArray;
		for (int i = 1; i < insertRes.length; i++) {
			int target = insertRes[i];
			int j = i ; 
			while( j>0 && insertRes[j-1]>target) {
				insertRes[j] = insertRes[j-1];
				j--;
			}
			insertRes[j] = target;
		}
	}
	
	@Test
	public void shellSort() {
		int[] shellRes = srcArray;
		for (int step = shellRes.length/2 ; step > 0; step= step /2 ) {
			for (int i = step; i < shellRes.length; i++) {
				int j = i;
				int tmp = shellRes[j];
				while(j-step>=0 && shellRes[j-step] > tmp) {
					shellRes[j] = shellRes[j-step];
					j = j - step; 
				}
				shellRes[j] = tmp;
			}
		}
	}
	
	
	@Test
	public void tree2Sort() {
		int[] treeRes = srcArray;
		treeNode root = new treeNode();
		for (int i = 0; i < treeRes.length; i++) {
			root.add(treeRes[i]);
		}
	}
	
	@Test
	public void countSort() {
		int[] countRes = srcArray;
		
		int maxV = ArrayUtil.max(countRes);
		int[] countArray = new int[maxV+1];//+1是因为有0
		for(int a : countRes) {
			countArray[a]++;
		}
		int index = 0;
		for(int i =0 ; i < countArray.length;i++) {
			while(countArray[i]>0) {
				countRes[index] = i;
				index ++ ; 
				countArray[i]--;
			}
		}
	}
	
	@Test
	public void bucketSort() {
		int[] bucketRes = srcArray;
		
		int maxV = ArrayUtil.max(bucketRes);
		int minV = ArrayUtil.min(bucketRes);
		int bsize = 5;
		int bnum = (int) Math.floor((maxV - minV) / bsize) + 1;
		ArrayList<ArrayList>  bs = new ArrayList<>();
		for (int i = 0; i < bnum; i++) {
			bs.add(new ArrayList());
		}
		for (int i = 0; i < bucketRes.length; i++) {
			int index = (int) Math.floor((bucketRes[i] - minV) / bsize);
			bs.get(index).add(bucketRes[i]);
		}
		int ind = 0;
		for(ArrayList b : bs ) {
			if(b.size() == 0) {
				continue;
			}
			Collections.sort(b);
			for (Object v : b) {
				Integer vv = (Integer) v;
				bucketRes[ind] =vv ;
				ind++;
			}
		}
	}
}

class treeNode<T extends Comparable<T>> {
	treeNode lNode ; 
	treeNode rNode ; 
	T v ; 
	
	public void add(T a) {
		if(null == v ) {
			v = a;
		}else {
			if(a.compareTo(v) < 0) {
				if(null == lNode) {
					lNode = new treeNode();
				}
				lNode.add(a);
			}else {
				if(null == rNode) {
					rNode = new treeNode();
				}
				rNode.add(a);
			}
		}
	}
	
	public List<T> list(){
		List<T> res = new ArrayList<>();
		if(null != lNode) {
			res.addAll(lNode.list());
		}
		res.add(v);
		if(null != rNode) {
			res.addAll(rNode.list());
		}
		return res;
	}
}





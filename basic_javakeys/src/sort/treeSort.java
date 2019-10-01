package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class treeSort {
	public static void main(String[] args) {
		//-------------------------------
		Random rd = new Random();
		int[] org = new int[10];
		for(int i=0 ; i <org.length; i ++ ) {
			org[i] = rd.nextInt(100)+1;
		}
		//-------------------------------
		Node<Integer> root = new Node<>();
		for(int i : org) {
			root.add(i);
		}
		System.out.println(root.medSort());
	}
}



class Node<T extends Comparable<T>> {
	Node<T> leftNode;
	Node<T> rightNode;
	T value;
	public void add(T v) {
		if(null == value) {
			value = v;
		}else {
			if(value.compareTo(v) > 0 ) {
				if(null == leftNode) {
					leftNode = new Node<T>();
				}
				leftNode.add(v);
			}else {
				if(null ==  rightNode) {
					rightNode = new Node<T>();
				}
				rightNode.add(v);
			}
		}
	}
	
	public List<T> medSort() {
		List<T> res = new ArrayList<>();
		if(null != leftNode) {
			res.addAll(leftNode.medSort());
		}
		res.add(value);
		
		if(null != rightNode) {
			res.addAll(rightNode.medSort());
		}
		
		return res;
	}
	
}
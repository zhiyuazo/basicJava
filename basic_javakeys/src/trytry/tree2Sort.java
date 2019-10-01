package trytry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class tree2Sort {
	public static void main(String[] args) {
		Node root = new Node();
		for (int i = 0; i < 10; i++) {
			int tmp = new Random().nextInt(100);
			System.out.print(tmp + ",");
			root.add(tmp);
		}
		System.out.println();
		System.out.println(Arrays.toString(root.list().toArray()));
	}
}






class Node<T extends Comparable<T>> {
	Node<T> leftNode;
	Node<T> rightNode;
	T value;
	public void add(T v) {
		if(null == value ) {
			value = v;
		}else {
			if(value.compareTo(v) > 0) {
				if(null == leftNode) {
					leftNode = new Node<T>();
				}
				leftNode.add(v);
			}else {
				if(null == rightNode) {
					rightNode = new Node<T>();
				}
				rightNode.add(v);
			}
		}
	}
	
	
	public List<T> list(){
		List<T> l = new ArrayList<T>();
		if(null != leftNode ) {
			l.addAll(leftNode.list());
		}
		l.add(value);
		if(null != rightNode ) {
			l.addAll(rightNode.list());
		}
		return l;
	}
}

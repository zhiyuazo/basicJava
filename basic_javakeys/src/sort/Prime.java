package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Prime {

	
	public static boolean isPrime(int n) {
		for(int i =2 ;i < Math.sqrt(n+0.5);i++) {
			if(n == 2) {
				return true;
			}
			if(n%i == 0) {
				return false;
			}
		}
		return true ;
	}
	
	public static void main(String[] args) {
		
		int totle = 10000*10000;
		//normal way to find prime 
		ArrayList<Integer> res = new ArrayList<>();
		Long s = System.currentTimeMillis();
		for(int i = 2 ; i < totle+1;i++) {
			if(isPrime(i)) {
				res.add(i);
			}
		}
		Long e = System.currentTimeMillis();
		System.out.printf("normalway: cost %d millseconds find %d primes from 1-%d...\n",(int) (e-s),res.size(),totle);
		
		//Bit way to find prime
		int[] bitgroup = new int[totle+1]; 
		int count = 0;
		Long s1 = System.currentTimeMillis();
		for(int i = 2 ; i <Math.sqrt(totle+0.5);i++) {
			if(bitgroup[i] == 0 ) {
				for(int j=i*i; j <totle+1 ; j+=i) {
					bitgroup[j] = 1;
				}
			}
		}
		bitgroup[0] =1;
		bitgroup[1] =1;
		bitgroup[2] =0;
		for(int i : bitgroup) {
			if(i == 0) {
				count += 1;
			}
		}
		Long e1 = System.currentTimeMillis();
		System.out.printf("bitWay:  cost %d millseconds find %d primes from 1-%d...\n",(int) (e1-s1),count,totle);
		
		//Java BitSet way to find prime
		// not the best to find prime 
		// also not the best way to benchmark a system 
		//just a popular way to testing benchmark or bit operators...
		BitSet bs = new BitSet(totle + 1);
		int count1 = 0 ;
		 //Set all bits with "On" status,assume all bit are Prime
		Long s2 = System.currentTimeMillis();
		for(int i = 2 ; i < Math.sqrt(totle) + 0.5; i++) {
			if(!bs.get(i)) {
				for(int j =i*i ; j < totle+1; j+=i){
					bs.set(j);
				}
			}
		}
		bs.set(0);
		bs.set(1);
		int i = 0 ;
		while(i<totle+1) {
			if(!bs.get(i)) {
				count1++ ;
			}
			i++;
		}
		Long e2 = System.currentTimeMillis();
		System.out.printf("JAVA-bitSet:  cost %d millseconds find %d primes from 1-%d...\n",(int) (e2-s2),count1,totle);
	
	}
	
	
}

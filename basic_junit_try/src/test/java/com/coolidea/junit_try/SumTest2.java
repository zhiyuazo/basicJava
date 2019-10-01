package com.coolidea.junit_try;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class SumTest2 {
	@Before
	public void before() {
		System.out.println("start to test @2...");
	}
	@After
	public void after() {
		System.out.println("end to test @2...");
	}
	@Test
	public void test1() { 
		int res = SumUtil.sum2(1, 2);
		Assert.assertEquals(res, 3);
	}
	
	@Test
	public void test2() { 
		int res = SumUtil.sum3(1, 2,3);
		Assert.assertEquals(res, 4);
	}
}

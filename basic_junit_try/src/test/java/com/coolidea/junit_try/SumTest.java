package com.coolidea.junit_try;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;


public class SumTest extends TestCase{
	@Before
	public void before() {
		System.out.println("start to test @1...");
	}
	
	@After
	public void after() {
		System.out.println("end to test @1...");
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

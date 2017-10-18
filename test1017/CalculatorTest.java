package com.edu.test1017junit;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class CalculatorTest {
	
	Calculator cal =null;
	@BeforeClass
	public static void test1(){
		System.out.println("@BeforeClass");
	}
	@Before
	public void beforeMethod(){
		System.out.println("beforeMethod");
		cal = new Calculator();
	}
	
	@After
	public void afterMethod(){
		System.out.println("afterMethod");
		cal=null;
	}
	@Test
	public void testadd(){
		
		int result = cal.add(1, 2);
	  Assert.assertThat(result,is(3));
		
		assertEquals(3,result);
		
		}
	
	@Test
	public void testMul(){
		int result = cal.mul(3, 1);
		assertEquals(2,result);
		System.out.println("testMul");
	}
	
	@Test(timeout=200)
	public void testTimeout() throws InterruptedException{
		Thread.sleep(100);
	}
	
	
	@Test(expected=ArithmeticException.class)
	public void testDiv ()throws ArithmeticException{
		int result = cal.div(1, 1);
	    System.out.println();
	
	}

}

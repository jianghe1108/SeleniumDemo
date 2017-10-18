package com.edu.test1018testng;

import org.testng.annotations.Test;

public class Demo3 {
	

	@Test
	public void test31(){
		long i=Thread.currentThread().getId();
		System.out.println("test31------"+i);
	}

	@Test
	public void test32(){
		long i=Thread.currentThread().getId();
		System.out.println("test32------"+i);
	}
	
	@Test
	public void test33(){
		long i=Thread.currentThread().getId();
		System.out.println("test33------"+i);
	}
}

package com.edu.test1017junit;

import org.junit.Test;

public class Demo1 {
	@Test
	public void test1(){
	long i=	Thread.currentThread().getId();
	System.out.println("test1----"+i);
	}

}

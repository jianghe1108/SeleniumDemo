package com.edu.test1017junit;

import org.junit.Test;

public class Demo2 {
	@Test
	public void test2(){
		
	long i=	Thread.currentThread().getId();
	System.out.println("test2-----"+i);
	}

}

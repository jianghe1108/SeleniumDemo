package com.edu.test1018testng;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups="animal")
	public void dog(){

		long i= Thread.currentThread().getId();
		System.out.println("dog����������----"+i);
	}
	
	@Test(groups="animal")
	public void cat(){
		long i= Thread.currentThread().getId();
		System.out.println("cat����������----"+i);
	}
	
	@Test(groups="person")
	public void student(){
		long i= Thread.currentThread().getId();
		System.out.println("student����������---"+i);
	}
	
	@Test(groups="person")
	public void teacher(){
		System.out.println("teacher����������");
	}

}

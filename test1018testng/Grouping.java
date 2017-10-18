package com.edu.test1018testng;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups="animal")
	public void dog(){

		long i= Thread.currentThread().getId();
		System.out.println("dog方法被调用----"+i);
	}
	
	@Test(groups="animal")
	public void cat(){
		long i= Thread.currentThread().getId();
		System.out.println("cat方法被调用----"+i);
	}
	
	@Test(groups="person")
	public void student(){
		long i= Thread.currentThread().getId();
		System.out.println("student方法被调用---"+i);
	}
	
	@Test(groups="person")
	public void teacher(){
		System.out.println("teacher方法被调用");
	}

}

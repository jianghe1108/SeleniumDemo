package com.edu.test1018testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 {
	
//	@BeforeSuite
//	public void bsuite(){
//		long i=Thread.currentThread().getId();
//		System.out.println("@BeforeSuite------"+i);
//	}
	@BeforeTest
	public void btest(){
		long i=Thread.currentThread().getId();
		System.out.println("@BeforeTest------"+i);
	}
	@BeforeClass
	public void bclass(){
		long i=Thread.currentThread().getId();
		System.out.println("@BeforeClass------"+i);
	}
	@BeforeMethod
	public void before(){
		long i=Thread.currentThread().getId();
		System.out.println("@BeforeMethod------"+i);
	}
	@Test
	public void test21(){
		long i=Thread.currentThread().getId();
		System.out.println("test21------"+i);
	}

	@Test
	public void test22(){
		long i=Thread.currentThread().getId();
		System.out.println("test22------"+i);
	}
	
	@Test
	public void test23(){
		long i=Thread.currentThread().getId();
		System.out.println("test23------"+i);
	}
}

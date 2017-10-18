package com.edu.test1018testng;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 {
	@BeforeClass
	public void bc(){
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	public void bm(){
		System.out.println("@BeforeMethod");
	}
	@Test(priority=1)
	public void test1(){
		
		System.out.println("test1");
		//assertTrue(false);
	}
   //priority属性可以设置测试方法的执行顺序
	
	@Test(enabled=false)
	public void test2(){
		System.out.println("test2");
	}
	//test2 被忽略，不执行
	
	@Test(dependsOnMethods="test1")
	public void test3(){
		System.out.println("test3");
	}
	//结果skips的数字，被依赖的测试方法执行失败，当前方法不再执行
	//test3依赖与test1，test1执行失败，test3不会执行
	
	@Test(priority=0)
	public void test4(){
		long i= Thread.currentThread().getId();
		System.out.println("test4-----"+i);
	}
}

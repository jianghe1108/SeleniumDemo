package com.edu.test1018testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo4 {
	public Demo4(){
		System.out.println("Demo4�Ĺ��췽��");
	}

	@Test
	public void test41(){
		long i=Thread.currentThread().getId();
		System.out.println("test41------"+i);
	    Reporter.log("hello");
	}

	@Test
	public void test42(){
		long i=Thread.currentThread().getId();
		System.out.println("test42------"+i);
	}
	//threadPoolSize�߳�������3��
	//invocationCount ִ�д�����6
	//timeout��ʱ500ms
	
	@Test(threadPoolSize=3,invocationCount=6,timeOut=500) 
	public void test44(){
		long i=Thread.currentThread().getId();
		System.out.println("test44------"+i);
	}
}

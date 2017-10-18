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
   //priority���Կ������ò��Է�����ִ��˳��
	
	@Test(enabled=false)
	public void test2(){
		System.out.println("test2");
	}
	//test2 �����ԣ���ִ��
	
	@Test(dependsOnMethods="test1")
	public void test3(){
		System.out.println("test3");
	}
	//���skips�����֣��������Ĳ��Է���ִ��ʧ�ܣ���ǰ��������ִ��
	//test3������test1��test1ִ��ʧ�ܣ�test3����ִ��
	
	@Test(priority=0)
	public void test4(){
		long i= Thread.currentThread().getId();
		System.out.println("test4-----"+i);
	}
}

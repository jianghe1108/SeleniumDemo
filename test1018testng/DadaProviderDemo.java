package com.edu.test1018testng;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DadaProviderDemo {
	
	@DataProvider(name="tom")
	public Object[][] getData(){
		 Object[][] obj={{2,1,1},{3,2,1}};
		 return obj;
	}
	
	@Test(dataProvider="tom" )
	public void testAdd(int a1,int a2,int a3){
		System.out.println(a1);
		System.out.println(a2);	
	}
	
	@Test
	@Parameters("browser")
	public void testBrowser(String b,String c){
		System.out.println(b);
		
	}
	
	

}

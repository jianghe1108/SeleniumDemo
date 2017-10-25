package com.edu.test1025Table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.edu.webDriverApi2.BaseTest;

public class TableTest extends BaseTest{
	
	@Test
	public void test1() throws InterruptedException{
		wd.get("http://localhost:8032/test/table.html");
		WebElement element =wd.findElement(By.id("table1"));
		Table t1 =new Table(element);
		System.out.println(t1.getRowsSize());
		System.out.println(t1.getColsSize());
		System.out.println(t1.getCell(2, 3));
		WebElement element1=t1.getCellBy(2, 1, By.tagName("input"));
	   element1.sendKeys("hello");
	   Thread.sleep(5000);
	}
	
	

}

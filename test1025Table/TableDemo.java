package com.edu.test1025Table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.edu.webDriverApi2.BaseTest;

public class TableDemo extends BaseTest{
	
	@Test
	public void test1(){
		//遍历所有的表格内的文本
	 wd.get("http://localhost:8032/test/table.html");
	 WebElement t1 = wd.findElement(By.id("table1"));
	 List<WebElement> rows=t1.findElements(By.tagName("tr"));
	 System.out.println("当前表格的行数是："+rows.size());
	 for(WebElement row : rows){
		 List<WebElement> cols=row.findElements(By.tagName("td"));
		 for(WebElement cell : cols){
			 System.out.print(cell.getText()+"\t");
		 }
		 System.out.println();
	 }
	//打印第三行，第二列
	 List<WebElement> cols1= rows.get(2).
			 findElements(By.tagName("td"));
	System.out.println(cols1.get(1).getText()); 
	 
		
	}
	

}

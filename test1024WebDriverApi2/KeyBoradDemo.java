package com.edu.webDriverApi2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KeyBoradDemo extends BaseTest{
	
	@Test
	
	public void test1() throws InterruptedException{
		wd.get("http://localhost:8032/MyMovie/");
       wd.findElement(By.name("key" )).click();
		this.setCtrovClipBoardData("ÈÃ×Óµ¯·É");
		this.pressEnter();
		Thread.sleep(5000);
	}

}

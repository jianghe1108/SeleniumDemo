package com.edu.webDriverApi2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OtherControlTest extends BaseTest {
	
	
	@Test
	public void testUpFile() throws InterruptedException{
		wd.get("http://localhost:8032/test/0702.html");
		wd.findElement(By.name("file")).sendKeys("D:\\demo\\0801.html");
		wd.findElement(By.id("filesubmit")).click();
		Thread.sleep(3000);
		
	}
	
	@Test
	public void testScreenShot(){
		try{
		wd.get("http://localhost:8032/test/0701.html");
		WebElement element=wd.findElement(By.id("uid1"));
		assertTrue(element.isDisplayed()); 
		}catch(NoSuchElementException e)
		{
			this.screenShot();
			e.toString();
		}
	
				
				
	}
}

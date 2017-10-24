package com.edu.webDriverApi2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavascriptExecutorDemo extends BaseTest {
	
	//使用JavascriptExecutor实现点击
	@Test
	public void testClick() throws InterruptedException{
		wd.get("http://localhost:8032/MyMovie/");
		Thread.sleep(3000);
		WebElement loginLink=wd.findElement(By.linkText("登录"));
		this.jsClick(loginLink);	
		Thread.sleep(3000);
	}
	
	@Test
	public void testHignLign() throws InterruptedException{
		wd.get("http://localhost:8032/MyMovie/");
		Thread.sleep(3000);
		WebElement loginLink=wd.findElement(By.name("key"));
		this.HighLignt(loginLink);
		Thread.sleep(3000);
	}
	
	@Test
	public void testSetAttibute() throws InterruptedException{
//		wd.get("http://localhost:8032/test/0701.html");
//		Thread.sleep(3000);
//		WebElement loginLink=wd.findElement(By.id("uid"));
//		this.setAttribute(loginLink, "size", "10");
//		this.setAttribute(loginLink, "value", "星期二");
//		Thread.sleep(3000);
	
		wd.get("http://localhost:8032/test/AddRecord.html");
		WebElement upImage = wd.findElement(By.id("1upload_preview"));
		this.setAttribute(upImage, "style", "display: block");
		upImage.sendKeys("D:\\demo\\a.jpg");
		Thread.sleep(5000);
	
	
	}

}

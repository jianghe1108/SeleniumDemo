package com.edu.webDriverApi2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@DataProvider(name="uname")
	public Object[][] getUsername(){
		return new Object[][]{{"tom01","123456"}};
	}
	@Test(dataProvider="uname")
	public void testloginSucess(String username,String password) throws InterruptedException{
		wd.get("http://localhost:8032/MyMovie/");
		Thread.sleep(5000);
		//判断页面是不是有退出
		boolean flag=wd.getPageSource().contains("退出");
		if(flag){
			wd.findElement(By.linkText("退出")).click();
			Thread.sleep(3000);
		}
		wd.findElement(By.linkText("登录")).click();
		Thread.sleep(3000);
		wd.findElement(By.name("username")).sendKeys(username);
		wd.findElement(By.name("password")).sendKeys(password);
		wd.findElement(By.xpath("//input[@value='马上登录']")).click();
		assertTrue(wd.getPageSource().contains("退出"));
	}

}

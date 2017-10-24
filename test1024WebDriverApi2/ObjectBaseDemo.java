package com.edu.webDriverApi2;

import org.testng.annotations.Test;

public class ObjectBaseDemo extends BaseTest {
	
	@Test
	public void login() throws Exception{
		wd.get("http://localhost:8032/MyMovie/");
		wd.findElement(obj.getlocator("mainpage.login")).click();
		Thread.sleep(3000);
		wd.findElement(obj.getlocator("login.username")).sendKeys("tom01");
		wd.findElement(obj.getlocator("login.password")).sendKeys("tom01");
		wd.findElement(obj.getlocator("login.submit")).sendKeys("tom01");
		Thread.sleep(3000);
	}

}

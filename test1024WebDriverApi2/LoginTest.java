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
		//�ж�ҳ���ǲ������˳�
		boolean flag=wd.getPageSource().contains("�˳�");
		if(flag){
			wd.findElement(By.linkText("�˳�")).click();
			Thread.sleep(3000);
		}
		wd.findElement(By.linkText("��¼")).click();
		Thread.sleep(3000);
		wd.findElement(By.name("username")).sendKeys(username);
		wd.findElement(By.name("password")).sendKeys(password);
		wd.findElement(By.xpath("//input[@value='���ϵ�¼']")).click();
		assertTrue(wd.getPageSource().contains("�˳�"));
	}

}

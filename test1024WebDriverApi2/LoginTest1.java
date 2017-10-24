package com.edu.webDriverApi2;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest1 extends BaseTest {

	@DataProvider(name = "uname")
	public Object[][] getUsername() {
		return new Object[][] { { "tom01", "123456" }, { "tom02", "123456" } };
	}

	public void login(String username, String password) throws InterruptedException {
		wd.get("http://localhost:8032/MyMovie/");
		Thread.sleep(5000);
		// �ж�ҳ���ǲ������˳�
		boolean flag = wd.getPageSource().contains("�˳�");
		if (flag) {
			wd.findElement(By.linkText("�˳�")).click();
			Thread.sleep(3000);
		}
		wd.findElement(By.linkText("��¼")).click();
		Thread.sleep(3000);
		wd.findElement(By.name("username")).sendKeys(username);
		wd.findElement(By.name("password")).sendKeys(password);
		wd.findElement(By.xpath("//input[@value='���ϵ�¼']")).click();

	}

	@Test(dataProvider = "uname")
	public void testAddMessage1(String username, String password) throws InterruptedException {
		login(username, password);
		wd.get("http://localhost:8032/MyMovie/index.php/Detail/index/id/39");
		for (int i = 0; i < 10; i++) {
			wd.findElement(By.id("js_message_textarea")).sendKeys(username+"�����Ӱֵ��һ�����ܲ���"+i);
			wd.findElement(By.id("message_button")).click();
		}

	}

}

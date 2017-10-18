package com.edu.test1018testng;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChromeDemo {
	String url="http://localhost:8032/MyMovie";
	
	@Parameters("browser")
	@Test
	public void testMultiBrowser(String brow) throws InterruptedException{
		WebDriver wd=null;
		if(brow.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			 wd = new FirefoxDriver();
		}else if(brow.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",
					"D:\\demo\\SeleniumDemo\\chromedriver.exe");
			 wd = new ChromeDriver();
		}else
		{
			return ;
		}
		wd.get(this.url);
		wd.findElement(By.linkText("��¼")).click();;
		Thread.sleep(3000);
		wd.findElement(By.name("username")).sendKeys("tom01");
		wd.findElement(By.name("password")).sendKeys("123456");
		wd.findElement(By.xpath("//input[@value='���ϵ�¼']")).click();
		Thread.sleep(3000);
		WebElement quitLink = wd.findElement(By.linkText("�˳�"));
		assertTrue(quitLink.isEnabled());
		wd.quit();
		
	}
//	@Test
//	public void testChromeBrowser() throws InterruptedException{
//		
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\demo\\SeleniumDemo\\chromedriver.exe");
//		WebDriver wd = new ChromeDriver();
//		wd.get(this.url);
//		wd.findElement(By.linkText("��¼")).click();;
//		Thread.sleep(3000);
//		wd.findElement(By.name("username")).sendKeys("tom01");
//		wd.findElement(By.name("password")).sendKeys("123456");
//		wd.findElement(By.xpath("//input[@value='���ϵ�¼']")).click();
//		Thread.sleep(3000);
//		WebElement quitLink = wd.findElement(By.linkText("�˳�"));
//		assertTrue(quitLink.isEnabled());
//		wd.quit();
//	}
//	
//	@Test
//	public void testFFBrowser() throws InterruptedException{
//		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
//		// ����ff�İ�װλ��
//		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//		WebDriver wd = new FirefoxDriver();
//		wd.get(this.url);
//		wd.findElement(By.linkText("��¼")).click();;
//		Thread.sleep(3000);
//		wd.findElement(By.name("username")).sendKeys("tom01");
//		wd.findElement(By.name("password")).sendKeys("123456");
//		wd.findElement(By.xpath("//input[@value='���ϵ�¼']")).click();
//		Thread.sleep(3000);
//		WebElement quitLink = wd.findElement(By.linkText("�˳�"));
//		assertTrue(quitLink.isEnabled());
//		wd.quit();
//	}

}

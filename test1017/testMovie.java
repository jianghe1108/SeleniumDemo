package com.edu.test1017junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class testMovie {
	public testMovie(){
		System.out.println("testMovie");
	}
	static WebDriver wd =null;
	@BeforeClass
	public static void initFf(){
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	     wd = new FirefoxDriver();
	}
	//@Before
	public void initBrowser(){
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	     wd = new FirefoxDriver();
			}
	@Test
	public void testFrontLogin() throws InterruptedException{
		wd.get("http://localhost:8032/MyMovie");

       //中间登录部分需要大家完成
		Boolean isLogin=wd.getPageSource().
				contains("退出");
		assertTrue(isLogin);
		Thread.sleep(5000);
	}
	@Test
	public void testBackLogin() throws InterruptedException{
		wd.get("http://localhost:8032/MyMovie/admin.php/");
		Thread.sleep(5000);	
	}
	//@After
	public void quitBrowser(){
		wd.quit();
		}

}

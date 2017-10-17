package com.edu.test1013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo2 {

	public static void main(String[] args) {
		// 加载ff驱动
				System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
								System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				WebDriver wd = new FirefoxDriver();
				wd.get("https://www.baidu.com");
				//定位失败，是因为有重名的登录出现
				//wd.findElement(By.linkText("登录")).click();
				//输入用户名，密码，点击登录
				wd.findElement(By.xpath(".//*[@id='u1']/a[7]")).click();
							
			    wd.quit();

	}

}

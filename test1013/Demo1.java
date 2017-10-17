package com.edu.test1013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {
	public static void main(String arg[]) {

		// 加载ff驱动
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		// 设置ff的安装位置
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		// 1.创建WebDriber对象（就是启动哪个浏览器）
		WebDriver wd = new FirefoxDriver();

		// 2.打开测试页面
		wd.get("https://www.baidu.com");
		// 3.定位元素，赋值给变量
		WebElement keyword = wd.findElement(By.id("kw"));
		keyword.sendKeys("taobao");

		WebElement searchButton = wd.findElement(By.id("su"));
		searchButton.click();
		wd.findElement(By.linkText("登录")).click();
		System.out.println(wd.getTitle());
		wd.quit();
		
	}
}

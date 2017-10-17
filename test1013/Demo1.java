package com.edu.test1013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {
	public static void main(String arg[]) {

		// ����ff����
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		// ����ff�İ�װλ��
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		// 1.����WebDriber���󣨾��������ĸ��������
		WebDriver wd = new FirefoxDriver();

		// 2.�򿪲���ҳ��
		wd.get("https://www.baidu.com");
		// 3.��λԪ�أ���ֵ������
		WebElement keyword = wd.findElement(By.id("kw"));
		keyword.sendKeys("taobao");

		WebElement searchButton = wd.findElement(By.id("su"));
		searchButton.click();
		wd.findElement(By.linkText("��¼")).click();
		System.out.println(wd.getTitle());
		wd.quit();
		
	}
}

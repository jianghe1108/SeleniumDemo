package com.edu.test1013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo2 {

	public static void main(String[] args) {
		// ����ff����
				System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
								System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				WebDriver wd = new FirefoxDriver();
				wd.get("https://www.baidu.com");
				//��λʧ�ܣ�����Ϊ�������ĵ�¼����
				//wd.findElement(By.linkText("��¼")).click();
				//�����û��������룬�����¼
				wd.findElement(By.xpath(".//*[@id='u1']/a[7]")).click();
							
			    wd.quit();

	}

}

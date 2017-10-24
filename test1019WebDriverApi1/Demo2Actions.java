package com.edu.webdriveApi1;

import static org.testng.Assert.assertEquals;

import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo2Actions {

	WebDriver wd = null;
	Actions action = null;

	@BeforeClass
	public void startUpBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\demo\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		wd = new FirefoxDriver();
		action = new Actions(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testKeyBorads() {
		wd.get("http://localhost:8032/MyMovie/");
		action.click(wd.findElement(By.name("key"))).perform();
		action.keyDown(Keys.SHIFT).sendKeys("abcd").perform();
	}

	@Test
	public void testMouse() {
		wd.get("http://localhost:8032/test/06Actions.html");
		action.moveToElement(wd.findElement(By.id("div2")));

	}

	@Test
	public void testClickandHold() {
		wd.get("http://localhost:8032/test/06Actions.html");
		WebElement e = wd.findElement(By.id("div3"));
		action.clickAndHold(e).perform();
		action.release(e).perform();
	}


	

	@Test
	public void testAccptAlert() {
		wd.get("http://localhost:8032/test/06Alert.html");
		wd.findElement(By.id("btn1")).click();
		Alert alert = wd.switchTo().alert();
		String str = alert.getText();
		alert.accept();
		assertEquals(str, "这是一个alert弹出框");
		alert.dismiss();

	}

	@Test
	public void exlictWait() {
		wd.get("http://localhost:8032/test/06Alert.html");
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("注册")));

	}

	@Test
	public void exlictWait1() {
		wd.get("http://localhost:8032/test/06Alert.html");
		WebElement register = (new WebDriverWait(wd, 10)).until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return null;
			}

		});

	}

}

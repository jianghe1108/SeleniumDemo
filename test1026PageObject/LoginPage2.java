package com.edu.test1026PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	public WebDriver _driver;
	String url = "http://localhost:8032/MyMovie/admin.php";

	@FindBy(name = "username")
	public WebElement inputUserName;

	@FindBy(name = "password")
	public WebElement inputPassword;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement btnSubmit;
	
	@FindBy(linkText="ÍË³ö")
	public WebElement linkQuit;

	public LoginPage2(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void open() {
		this._driver.get(url);
	}

	public void loginSuccss() throws InterruptedException {
		boolean flag = this._driver.
				getPageSource().contains("ÍË³ö");
		if(flag){
			this.linkQuit.click();
			Thread.sleep(3000);
		}
		this.inputUserName.sendKeys("admin");
		this.inputPassword.sendKeys("admin");
		this.btnSubmit.click();
		Thread.sleep(3000);
	}

	public void loginFail() throws InterruptedException {
		boolean flag = this._driver.
				getPageSource().contains("ÍË³ö");
		if(flag){
			this.linkQuit.click();
			Thread.sleep(3000);
		}
		this.inputUserName.sendKeys("admin");
		this.inputPassword.sendKeys("admin1");
		this.btnSubmit.click();
	
	}
}

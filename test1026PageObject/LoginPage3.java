package com.edu.test1026PO;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage3 extends LoadableComponent<LoginPage3> {
	public WebDriver _driver;
	String url = "http://localhost:8032/MyMovie/admin.php";

	@FindBy(name = "username")
	public WebElement inputUserName;

	@FindBy(name = "password")
	public WebElement inputPassword;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement btnSubmit;
	
	@FindBy(linkText="退出")
	public WebElement linkQuit;

	public LoginPage3(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void open() {
//		this._driver.get(url);
//	}

	public void loginSuccss(String uName,String uPassword) throws InterruptedException {
		boolean flag = this._driver.
				getPageSource().contains("退出");
		if(flag){
			this.linkQuit.click();
			Thread.sleep(3000);
		}
		this.inputUserName.sendKeys(uName);
		this.inputPassword.sendKeys(uPassword);
		this.btnSubmit.click();
		Thread.sleep(3000);
	}

	public void loginFail() throws InterruptedException {
		boolean flag = this._driver.
				getPageSource().contains("退出");
		if(flag){
			this.linkQuit.click();
			Thread.sleep(3000);
		}
		this.inputUserName.sendKeys("admin");
		this.inputPassword.sendKeys("admin1");
		this.btnSubmit.click();
	
	}

	@Override
	protected void isLoaded() throws Error {
		//assertTrue(this._driver.getTitle().contains("CRM 系统"));
		
	}

	@Override
	protected void load() {
		
		this._driver.get(url);
	}
}

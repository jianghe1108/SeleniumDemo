package com.edu.test1026PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name="username")
	public WebElement inputUserName;
	
	@FindBy(name="password")
	public WebElement inputPassword;

	@FindBy(xpath="//input[@type='submit']")
	public WebElement btnSubmit;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

}

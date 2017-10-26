package com.edu.test1026PO;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.edu.webDriverApi2.BaseTest;

public class LoginPageTest2  extends BaseTest{
	
	
	@Test
	public void testLoginSuccess() throws InterruptedException{
		LoginPage2 loginPage = new LoginPage2(wd);
		loginPage.open();
		loginPage.loginSuccss();
		assertTrue(wd.getPageSource().contains("ÍË³ö"));
	}
	
	@Test
	public void testLoginFail() throws InterruptedException{
		LoginPage2 loginPage = new LoginPage2(wd);
		loginPage.open();
		loginPage.loginFail();
		assertTrue(wd.getPageSource().contains("ÕÊºÅ»òÃÜÂë´íÎó£¡"));
	}
}

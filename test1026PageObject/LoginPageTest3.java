package com.edu.test1026PO;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.edu.webDriverApi2.BaseTest;

public class LoginPageTest3 extends BaseTest{
	
	
	@Test(dataProvider="")
	public void testLoginSuccess(String name,String password) throws InterruptedException{
		LoginPage3 loginPage = new LoginPage3(wd);
//		loginPage.load();
		loginPage.get();
		loginPage.loginSuccss(name,password);
		assertTrue(wd.getPageSource().contains("ÕÀ≥ˆ"));
	}
	
	@Test
	public void testLoginFail() throws InterruptedException{
		LoginPage2 loginPage = new LoginPage2(wd);
		loginPage.open();
		loginPage.loginFail();
		assertTrue(wd.getPageSource().contains("’ ∫≈ªÚ√‹¬Î¥ÌŒÛ£°"));
	}
}

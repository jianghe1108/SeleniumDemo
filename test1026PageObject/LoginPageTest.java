package com.edu.test1026PO;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.edu.webDriverApi2.BaseTest;

public class LoginPageTest  extends BaseTest{
	
	@Test
	public void testLogin(){
		wd.get("http://localhost:8032/MyMovie/admin.php");
		LoginPage loginPage = new LoginPage(wd);
		loginPage.inputUserName.sendKeys("admin");
		loginPage.inputPassword.sendKeys("admin");
		loginPage.btnSubmit.click();
		assertTrue(wd.getPageSource().contains("ÍË³ö"));
	}
}

package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL Opened .......");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.clearUserName();
		logger.info("User cleared .......");
		
		lp.clearPassword();
		logger.info("Password cleared .......");
		
		lp.setUser(username);
		logger.info("User entered .......");
		
		lp.setPassword(password);
		logger.info("Password entered .......");
		
		lp.clickSignin();		
		logger.info("Signin Successfully.......");
		
		Thread.sleep(3000);		
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Test Passed .......");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.fail();
			logger.info("Test Failed .......");
		}
	}	
}

package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		
		driver.get(baseURL);
		logger.info("URL Opened .......");
		
		LoginPage lp = new LoginPage(driver);
				
		lp.clearUserName();
		logger.info("User cleared .......");
		
		lp.clearPassword();
		logger.info("Password cleared .......");
		
		Thread.sleep(3000);	
		
		lp.setUser(username);
		logger.info("User entered .......");
		
		lp.setPassword(password);
		logger.info("Password entered .......");
		
		Thread.sleep(3000);	
		
		lp.clickSignin();		
		logger.info("Signin Successfully.......");
		
		Thread.sleep(3000);		
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			lp.clickLogout();
			Assert.assertTrue(true);
					
		} else {
			captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}

	}
		
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testdata/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;		
	}

}

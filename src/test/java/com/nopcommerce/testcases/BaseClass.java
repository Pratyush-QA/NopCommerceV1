package com.nopcommerce.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;


public class BaseClass {
	
    ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
	public static WebDriver driver;

	public Logger logger;
	
	@Parameters("Browsers")
	@BeforeClass
	public void setup(String browser) {
		
		logger=Logger.getLogger("nopCommerce");
	    PropertyConfigurator.configure("log4j.properties");
	    
	    if(browser.equalsIgnoreCase("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver=new ChromeDriver();
	    }
	    else if(browser.equalsIgnoreCase("firefox")) {
	    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver=new FirefoxDriver();
	    }
	    else if(browser.equalsIgnoreCase("edge")) {
	    	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//Drivers//msedgedriver.exe");
			driver=new EdgeDriver();
	    }
		driver.manage().window().maximize();		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}

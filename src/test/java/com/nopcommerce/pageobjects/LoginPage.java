package com.nopcommerce.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "Email")
	WebElement emailtxt;
	
	@FindBy(name = "Password")
	WebElement pwdtxt;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement signinBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;
	
	public void clearUserName() {
		emailtxt.clear();
	}
	
	public void clearPassword() {
		pwdtxt.clear();
	}
	
	public void setUser(String emailid) {
		emailtxt.sendKeys(emailid);
	}
	
	public void setPassword(String password) {
		pwdtxt.sendKeys(password);
	}
	
	public void clickSignin() {
		signinBtn.click();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
}

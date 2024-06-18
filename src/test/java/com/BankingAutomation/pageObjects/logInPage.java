package com.BankingAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logInPage {
	
	WebDriver ldriver;
	
	public logInPage(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="(//a[normalize-space()='Log out'])")
	WebElement btnlogout;
		
	//action method for username to enter username
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	//action method for password to enter password
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
		
	//action method for click submit method
	public void clickSubmit() {
		btnLogin.click();
	}	

	public void clicklogOut() {
		btnlogout.click();
	}

}

package com.BankingAutomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	WebDriver ldriver;
	
	public DeleteCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how = How.XPATH, using="html/body/div[3]//ul[@class='menusubnav']/li[4]/a")
	@CacheLookup
	WebElement LnkDeleteCust;
	
	@FindBy(how = How.NAME, using="cusid")
	@CacheLookup
	WebElement EnterCustId;
	
	@FindBy(how = How.NAME, using="AccSubmit")
	@CacheLookup
	WebElement submit;	
	
	@FindBy(how = How.NAME, using="res")
	@CacheLookup
	WebElement reset;	
	
	public void deletecustomerLink() {
		LnkDeleteCust.click();
	}
	
	
	public void enterCustID(String val) {
		EnterCustId.sendKeys(val);
	}
	
	public void clickSubmit() {
		submit.click();
	} 
	public void clickreset() {
		reset.click();
	} 
}

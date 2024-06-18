package com.BankingAutomation.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how = How.XPATH, using ="html/body/div[3]//ul[@class='menusubnav']/li[2]/a")
	@CacheLookup
	WebElement LnkAddNewCustomer;
	
	@FindBy(how = How.XPATH, using ="//input[@name='name']")
	@CacheLookup
	WebElement customerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement customerGender;
	
	@FindBy(how = How.ID, using = "dob")
	@CacheLookup
	WebElement customerDOB;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement customerAdd;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement customerCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement customerState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement customerPin;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement customerPhoneNo;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement customerEmailID;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement customerSubmit;
	
	@FindBy(how = How.NAME, using = "res")
	@CacheLookup
	WebElement customerReset;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement customerPassword;
	
	public void newCustomerClick() {
		LnkAddNewCustomer.click();
	}
	
	public void custNameInput(String cName) {
		if(customerName.isDisplayed()) {
		customerName.sendKeys(cName);
		}
		else
		{
			System.out.println("Object not visible");
		}
	}
	
	public void custGender(String cGender) {
		customerGender.click();
	}
	
	public void custdob(String mm,String dd,String yy) {
		customerDOB.sendKeys(mm);
		customerDOB.sendKeys(dd);
		customerDOB.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		customerAdd.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		customerCity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		customerState.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		customerPin.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		customerPhoneNo.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		customerEmailID.sendKeys(cemailid);
	}

	public void custPassword(String pwd) {
		customerPassword.sendKeys(pwd);
	}
	
	public void custsubmit() {
		customerSubmit.click();
	}
	
	public void custReset() {
		customerReset.click();
	}
		
}

package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(linkText="New Customer")
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name")
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	WebElement rdGender;
	
	@FindBy(name="dob")
	WebElement txtDob;
	
	@FindBy(name="addr")
	WebElement txtAddress;
	
	@FindBy(name="city")
	WebElement txtCityName;
	 
	@FindBy(name="state")
	WebElement txtStateName;
	
	@FindBy(name="pinno")
	WebElement txtPinNum;
	
	@FindBy(name="telephoneno")
	WebElement txtPhoneNum;
	
	@FindBy(name="emailid")
	WebElement txtEmail;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	public void custGender(String cgender) {
		rdGender.click();
	}
	public void custDob(String mm,String dd,String yy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	public void custAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	public void custCity(String ccity) {
		txtCityName.sendKeys(ccity);
	}
	public void custState(String cstate) {
		txtStateName.sendKeys(cstate);
	}
	public void custZipcode(int czipCode) {
		txtPinNum.sendKeys(String.valueOf(czipCode));
	}
	public void custPhone(String ctelephoneNum) {
		txtPhoneNum.sendKeys(ctelephoneNum);
	}
	public void custEmail(String cemailid) {
		txtEmail.sendKeys(cemailid);
	}
	public void custSubmit() {
		btnSubmit.click();
	}


}

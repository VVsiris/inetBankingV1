package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends Base {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage Lp = new LoginPage(driver);
		
		Lp.setUserName(username);
		log.info("Entered the username");
		
		Lp.setPassword(password);
		log.info("Enterend the Password");
		
		Lp.clickSubmit();
		log.info("Successfully entered the application");
		
		Thread.sleep(2000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		log.info("Clicked on new Customer link");
		
		addcust.custName("Sirisha");
		log.info("Entered Customenr Name");
		
		addcust.custGender("Female");
		log.info("Clicked on the gender");
		
		addcust.custDob("05","11","1994");
		log.info("Entered the data of birth");
		
		Thread.sleep(5000);
		
		addcust.custAddress("India");
		log.info("Entered the customer address");
		
		addcust.custCity("VJY");
		log.info("Enterd the customer city");
		
		addcust.custState("AP");
		log.info("Entered the Customer state");
		
		addcust.custZipcode(5000123);
		log.info("Entered the ZipCode of the customer");
		
		addcust.custPhone("9876869279");
		log.info("Entered the phone number of the customer");
		
		String email = randomstring()+"@gmail.com";	
		addcust.custEmail(email);
		log.info("Entered the Email");
		
		addcust.custSubmit();
		log.info("Clicked on the submit button");
		
		Thread.sleep(2000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			
			Assert.assertTrue(true);
			log.info("Test is passed");
		}else {
			
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			log.info("Test is failed");
		}
	}
	
}

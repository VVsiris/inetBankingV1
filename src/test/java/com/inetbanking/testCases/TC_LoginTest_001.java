package com.inetbanking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Base{
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
//		driver.get(baseURL);
//		log.debug("Application is Opened");
	
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		log.info("Entered the username");
		
		lp.setPassword(password);
		log.info("Entered the password");
		
		lp.clickSubmit();
		log.info("Clicked on submit");
		
		if(driver.getTitle().contains("GTPL Bank Manager HomePage")){
			Assert.assertTrue(true);
			log.info("Login test is passed");
		}else{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			log.info("Login test is failed");
		}
		
	}

}

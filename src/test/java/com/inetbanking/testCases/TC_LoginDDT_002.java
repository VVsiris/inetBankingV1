package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends Base{
	
	//@SuppressWarnings("deprecation")
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		log.info("Entered the username");
		
		lp.setPassword(pwd);
		log.info("Entered the Password");
		
		lp.clickSubmit();
		log.info("Clicked on submit");
		
		Thread.sleep(2000);
		
		if(isAlertPresent()==true) 
		{
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent(); //switch to login page
			Assert.assertTrue(false);
			log.warn("logging failed");
		}else {
			Assert.assertTrue(true);
			log.info("Login passed");
			Thread.sleep(3000);
			lp.clickLogout();
			driver.switchTo().alert().accept();  //close the alert
			driver.switchTo().defaultContent();  //switch to login page
		}
		
	}
	
	
	public boolean isAlertPresent() { //User defined method created to check alert is present or not
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		String path =System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cellnum = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String Logindata[][]= new String[rownum][cellnum];
		
		for(int i=1;i<=rownum;i++) 
		{
			for(int j=0;j<cellnum;j++)
			{
				Logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
	return Logindata;
	}
	
	

}

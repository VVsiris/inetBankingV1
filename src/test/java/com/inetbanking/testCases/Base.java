package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Base {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
//	public String name = readconfig.getcustName();
//	public String gender = readconfig.getcustGender();
//	public String month = readconfig.getmonth();
//	public String day = readconfig.getday();
//	public String year = readconfig.getyear();
//	public String address = readconfig.getaddress();
//	public String cityname = readconfig.getcity();
//	public String statename = readconfig.getstate();
//	public String zipcode = readconfig.getzipcode();
//	public String telephone = readconfig.gettelephone();
	
	
	public static WebDriver driver;
	public static Logger log;

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) {

		// System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());

		log = LogManager.getLogger(TC_LoginTest_001.class.getName());

		if (br.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (br.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (br.equals("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
	}
	public String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}
	public static String rondomNum() {
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return (generatedNumber);
	}

}

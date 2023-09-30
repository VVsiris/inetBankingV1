package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{

	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	public void onStart(ITestContext textContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent = new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "srisha");
		
		sparkReporter.config().setDocumentTitle("InetBanking test project");//Title of the report
		sparkReporter.config().setReportName("Functional Test Report"); //name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		}
	public void onTestSuccess(ITestResult tr) {
		logger =extent.createTest(tr.getName()); //Create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//Send the passed information
		
	}
	
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+"//Screenshots//"+tr.getName()+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists()) {
			logger.fail("screenshot is below : "+logger.addScreenCaptureFromPath(screenshotPath));
		}
	}
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
}

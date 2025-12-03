package com.Utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listeners extends BaseClass implements ITestListener{

	ExtentReports extent=ExtendReportGenerator.getReports();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		Library.test=extent.createTest(result.getClass().getName()+"=="+result.getMethod().getMethodName());
		extenttest.set(Library.test);
		Library.test.addScreenCaptureFromBase64String(getscreenshot());
	}

	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Test case is pass");
		Library.test.addScreenCaptureFromBase64String(getscreenshot());

	}

	public void onTestFailure(ITestResult result) {
		extenttest.get().log(Status.FAIL, "Test case is failed");
		Library.test.addScreenCaptureFromBase64String(getscreenshot());

		
	}

	public void onTestSkipped(ITestResult result) {
		extenttest.get().log(Status.SKIP, "Test case is skipped");
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	public static String getscreenshot () {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);
		
	}
	
	
	

}

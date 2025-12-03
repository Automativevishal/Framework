package com.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportGenerator {
	
	public static ExtentReports extent;
	public static ExtentReports getReports() {

	String reportpath="D:\\Java Student\\Hybrid_Framework\\Reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
	reporter.config().setDocumentTitle("U2C");
	reporter.config().setReportName("Facebook_Login");
	reporter.config().setTheme(Theme.DARK);
	
	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Project Name", "Social Media");
	extent.setSystemInfo("Tester Name", "Vishal");
	return extent;
	
	
	
	
	}
	

}

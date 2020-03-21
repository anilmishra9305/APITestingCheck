package com.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener
{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/myReport.html");//specify location of the report
				
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Rest API Testing Report"); // name of the report
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name","Employee Database API");
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Anil");
			
	}
	
	public void onTestSuccess(ITestResult result)
	{
		//test=extent.createTest(result.getClass().getName());
		//test.createNode(result.getName());
		System.out.println("STestName ===> "+result.getTestName());
		System.out.println("SMethod Name ==> "+result.getMethod());
		System.out.println("SName ==> "+result.getName());
		test=extent.createTest(result.getName()); // create new entry in th report
				
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("FTestName ===> "+result.getTestName());
		System.out.println("FMethod Name ==> "+result.getMethod());
		System.out.println("FName ==> "+result.getName());
		test=extent.createTest(result.getName()); // create new entry in th report
		
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
	
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	}

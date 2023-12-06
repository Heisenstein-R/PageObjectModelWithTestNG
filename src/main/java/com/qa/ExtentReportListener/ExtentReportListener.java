package com.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements IReporter {

	 private ExtentReports extentReports;

	    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(outputDirectory + "/Extent.html");
	        sparkReporter.config().setTheme(Theme.DARK);
	        sparkReporter.config().setDocumentTitle("FreeCRMTest Suite");
	        sparkReporter.config().setReportName("Results of FreeCRMTest");
	        extentReports = new ExtentReports();
	        extentReports.attachReporter(sparkReporter);
	        

	        for (ISuite suite : suites) {
	            Map<String, ISuiteResult> suiteResults = suite.getResults();
	            for (ISuiteResult suiteResult : suiteResults.values()) {
	                ITestContext testContext = suiteResult.getTestContext();
	                buildTestNodes(testContext.getPassedTests(), Status.PASS);
	                buildTestNodes(testContext.getFailedTests(), Status.FAIL);
	                buildTestNodes(testContext.getSkippedTests(), Status.SKIP);
	            }
	        }

	        extentReports.flush();
	    }

	    private void buildTestNodes(IResultMap results, Status status) {
	        ExtentTest test;

	        if (results.size() > 0) {
	            for (ITestResult result : results.getAllResults()) {
	                test = extentReports.createTest(result.getMethod().getMethodName());
	                test.getModel().setStartTime(getTime(result.getStartMillis()));
	                test.getModel().setEndTime(getTime(result.getStartMillis()));
	              

	                for (String group : result.getMethod().getGroups()) {
	                    test.assignCategory(group);
	                }

	                String message = "Test " + status.toString().toLowerCase() + "ed";
	                if (result.getThrowable() != null) {
	                    message += " with exception: " + result.getThrowable();
	                    test.addScreenCaptureFromPath("C:\\Users\\91938\\eclipse-workspace\\POMTesting\\Screenshots\\"+result.getName()+".png");
	                }

	                test.log(status, message);
	                
	            }
	        }
	    }

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}

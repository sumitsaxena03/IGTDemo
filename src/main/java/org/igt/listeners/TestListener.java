package org.igt.listeners;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.elk.SendResultToElastic;
import org.igt.reports.ExtentLogger;
import org.igt.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import static org.igt.enums.LogType.PASS;
import static org.igt.reports.FrameworkLogger.log;

import java.io.IOException;

/**
 * Testng Listener class to derive the status of test execution as well as inititae/flush extent report.
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExtentReport
 * @see ExtentLogger
 */
public class TestListener implements ITestListener, ISuiteListener {	
	/**
	 * Method to create Extent report object to initialize the report creation.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to execute Extent Report flush operation to create the report.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.tearDownReport();
	}

	/**
	 * Create Extent report to log the data in Extent HTML report and pass the test case description.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 */
	@Override
	public  void onTestStart(ITestResult result) {
		/*
		 * In case we want to print desc from execet sheet in extent report rather than desc from test annotation.		 	
             String description =result.getMethod().getDescription();
		 */		
		String description =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
		ExtentReport.createTest(description);
		/*
		 * In case we want to print actual method name in report.		 	
	            ExtentReport.createTest(result.getName());
		 */	
	}

	/**
	 * Log the data in Extent Report for passed test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestSuccess(ITestResult result) {		
		log(PASS,result.getMethod().getMethodName() +" is passed");
		String[] authors =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthors(authors);
		String[] categories =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
		String method =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).methodType();
		ExtentReport.addMethod(method);
		SendResultToElastic.sendstatustoelastic(result.getMethod().getDescription(), "PASS");
	}

	/**
	 * Log the data in Extent Report for failed test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
		ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
		String[] authors =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthors(authors);
		String[] categories =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
		String method =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).methodType();
		ExtentReport.addMethod(method);
		SendResultToElastic.sendstatustoelastic(result.getMethod().getDescription(), "FAIL");
	}

	/**
	 * Log the data in Extent Report for skipped test and pass the annotated values from test case.
	 * @author Mandeep Sheoran
	 * @see ExtentReport
	 * @see SendResultToElastic
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		String[] authors =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
		ExtentReport.addAuthors(authors);
		String[] categories =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
		ExtentReport.addCategory(categories);
		String method =result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).methodType();
		ExtentReport.addMethod(method);
		SendResultToElastic.sendstatustoelastic(result.getMethod().getDescription(), "Skip");

	}
	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}

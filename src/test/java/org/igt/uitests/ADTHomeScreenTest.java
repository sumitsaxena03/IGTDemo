package org.igt.uitests;


import org.igt.annotations.FrameworkAnnotations;
import org.igt.drivers.Driver;
import org.igt.drivers.DriverManager;
import org.igt.enums.LogType;
import org.igt.enums.PropertiesType;
import org.igt.factories.ExplicitWaitFactory;
import org.igt.pompages.ADTHomeScreen;
import org.igt.reports.ExtentLogger;
import org.igt.utils.DateFormatUtils;
import org.igt.utils.PropertyUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.igt.reports.FrameworkLogger.log;


/**
 * May 11, 2023
 * @author Saikiran Vajrapu
 * @version 1.0
 * @see ExplicitWaitFactory
 * @see FrameworkLogger
 * @see ExtentLogger
 * @see DriverManager
 * @see LoginPage
 */
public class ADTHomeScreenTest {
	
	ADTHomeScreen adtHomeScreen;

	
	
	protected ADTHomeScreenTest() {	}	
	
	/** Method to setup the driver initialization with specific browser requirement before executing any method.
	  *	May 11, 2023
	  * @author Saikiran Vajrapu **/
	@BeforeClass
	protected void setUp() {  
		Driver.initdriver("firefox","115");
	}
	
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "Test started: " + result.getMethod().getMethodName() + " at ["+ DateFormatUtils.currentASIADateTimeFormat() +"]");
	}
	
	

	
	
	@Test(description="ADT.COM Official Site.", priority=1)
	@FrameworkAnnotations(author="Saikiran", category="Smoke", methodType="ADT.com")
    public void AdtpageTitle() {
		ADTHomeScreen adtPageTitle = new ADTHomeScreen(DriverManager.getDriver());
		adtPageTitle.pageTitle();
	}
	
	
	@AfterMethod 
	protected void afterTest(ITestResult result) {
		log(LogType.CONSOLE, "Test completed: " + result.getMethod().getMethodName() + " at ["+ DateFormatUtils.currentASIADateTimeFormat() +"]");
		Driver.quitdriver();
	}

	 
	 /** Method to tear down the driver initialization after executing all the methods.
	   * May 11, 2023
	   * @author Sumit.Saxena **/
	@AfterClass
	protected void tearDown() {
		Driver.quitdriver();
	}
		
	
	
}


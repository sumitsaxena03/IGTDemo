package org.igt.uitests;


import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.datasource.dataProviderSource;
import org.igt.drivers.Driver;
import org.igt.drivers.DriverManager;
import org.igt.enums.LogType;
import org.igt.enums.WaitMethods;
import org.igt.factories.ExplicitWaitFactory;
import org.igt.pompages.HomePage;
import org.igt.pompages.LoginPage;
import org.igt.reports.ExtentLogger;
import org.igt.testrail.TestRailManager;
import org.igt.utils.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.igt.enums.LogType.*;
import static org.igt.reports.FrameworkLogger.log;

import java.awt.Color;
import java.awt.color.*;
import java.io.IOException;


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
public class LoginTest {
	
	LoginPage loginPage;
	private String testrailTestCaseId = "239169";
	
	
	protected LoginTest() {	}	
	
	/** Method to setup the driver initialization with specific browser requirement before executing any method.
	  *	May 11, 2023
	  * @author Saikiran Vajrapu **/
	@BeforeClass
	protected void setUp() {  
		Driver.initdriver("chrome","112");
	}
	
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "Test started: " + result.getMethod().getMethodName() + " at ["+ DateFormatUtils.currentASIADateTimeFormat() +"]");
	}
	
	
	@Test(description="Office.com Login.", priority=1)
		@FrameworkAnnotations(author="Sumit", category="Regression", methodType="LoginViaMicrosoftAuthentication")
	    public void loginViaMicrosoftAuthentication() throws Exception   {
			LoginPage loginPage = new LoginPage(DriverManager.getDriver());
	        loginPage.logintoMistralUAT();
	  }
	
	@Test(description="Office.com Login.", priority=1)
	@FrameworkAnnotations(author="Sumit", category="Smoke", methodType="LoginViaMicrosoftAuthentication")
    public void loginViaMicrosoftAuthenticationTest() throws Exception   {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.logintoMistralUAT();
  }
	
	
	@Test(description="Office.com Login", priority=1)
	@FrameworkAnnotations(author="Saikiran", category="Regression", methodType="Login")
    public void login() throws IOException, InterruptedException   {
		LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.logintoMistral();
	}
	
	
	@AfterMethod 
	protected void afterTest(ITestResult result) {
		log(LogType.CONSOLE, "Test completed: " + result.getMethod().getMethodName() + " at ["+ DateFormatUtils.currentASIADateTimeFormat() +"]");
		if (result.getStatus() == ITestResult.SUCCESS) {
			TestRailManager.sendResultsToTestrail(testrailTestCaseId, TestRailManager.TEST_CASE_PASS_STATUS, "PASSED");
        } else if (result.getStatus() == ITestResult.FAILURE) {
        	TestRailManager.sendResultsToTestrail(testrailTestCaseId, TestRailManager.TEST_CASE_FAIL_STATUS, "FAILED \n ERROR: " +String.valueOf(result.getThrowable()));
        } else if (result.getStatus() == ITestResult.SKIP) {
        	TestRailManager.sendResultsToTestrail(testrailTestCaseId, TestRailManager.TEST_CASE_SKIP_STATUS, "SKIPPED");
        }

		Driver.quitdriver();
	}

	 
	 /** Method to tear down the driver initialization after executing all the methods.
	   * May 11, 2023
	   * @author Saikiran Vajrapu **/
	@AfterClass
	protected void tearDown() {
		Driver.quitdriver();
	}
		
	
	
}


package org.igt.pompages;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.drivers.Driver;
import org.igt.drivers.DriverManager;
import org.igt.enums.LogType;
import org.igt.enums.WaitMethods;
import org.igt.factories.ExplicitWaitFactory;
import org.igt.reports.ExtentLogger;
import org.igt.utils.DateFormatUtils;
import org.igt.utils.SeleniumUtil;
import org.igt.utils.SynchronisationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.igt.enums.LogType.*;
import static org.igt.reports.FrameworkLogger.log;

import java.io.IOException;
import java.time.Duration;


/**
 * Class to maintain methods for element interactions.
 * May 4, 2022
 * @author Saikiran Vajrapu
 * @version 1.0
 * @see ExplicitWaitFactory
 * @see FrameworkLogger
 * @see ExtentLogger
 * @see DriverManager
 */
public class HomePage {
	
	private WebDriver driver;
	
	/** Xpath for appSidebarMinimizer */
    @FindBy(xpath = "//app-dashboard/div[1]/app-sidebar/app-sidebar-minimizer")
    private WebElement appSidebarMinimizer;
    
    /** Xpath for cmAdmin */
    @FindBy(xpath = "//*[@id=\"sidebarMenu\"]/ul/app-ngeng-sidebar-nav-item[3]/li/a")
    private WebElement cmAdmin;
    
    /** Xpath for Planning */
    @FindBy(xpath = "//*[@id=\"sidebarMenu\"]/ul/app-ngeng-sidebar-nav-item[4]/li/a")
    private WebElement planning;
        
    /** Xpath for Home button */
    @FindBy(xpath = "//app-header/a[1]/img[1]")
    private WebElement homeButton;
    
    /** Xpath for recruiting page */
    @FindBy(xpath = "//app-sidebar[1]/app-ngeng-sidebar-nav[1]/ul[1]/app-ngeng-sidebar-nav-item[8]")
    private WebElement recruitingButton;
  
    /** Xpath for homePageCarnivalImage */
    @FindBy(xpath = "//img[@src='assets/img/brand/HomePageCarnival.jpg']")
    private WebElement homePageCarnivalImage;
    
   

	public HomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }   

	

	public void navigateToApplicantPage() throws IOException, InterruptedException {
		SynchronisationUtil.synchroniseUntilTheElementIsDisplayedEnabledAndClickable(driver, appSidebarMinimizer);
	    SeleniumUtil.clickElementNoAssert(appSidebarMinimizer);
	    SeleniumUtil.clickElementAssert(appSidebarMinimizer, driver);
	    log(CONSOLEANDEXTENTINFO, "Clicked side bar");
	    SynchronisationUtil.synchroniseUntilTheElementIsVisible(driver, cmAdmin);
	    SeleniumUtil.clickElementNoAssert(cmAdmin);
	    log(CONSOLEANDEXTENTINFO, "Clicked CM admin menu");
       		
	}
	
	public void navigateToPlanningPage() throws IOException, InterruptedException {
		SynchronisationUtil.synchroniseUntilTheElementIsDisplayedEnabledAndClickable(driver, appSidebarMinimizer);
	    SeleniumUtil.clickElementNoAssert(appSidebarMinimizer);
	    SeleniumUtil.clickElementAssert(appSidebarMinimizer, driver);
	    log(CONSOLEANDEXTENTINFO, "Clicked side bar");
	    SynchronisationUtil.synchroniseUntilTheElementIsVisible(driver, planning);
	    SeleniumUtil.clickElementNoAssert(planning);
	    log(CONSOLEANDEXTENTINFO, "Clicked planning menu");
       		
	}
	
	
	public void navigateToRecruitingPage() throws IOException, InterruptedException {
		SynchronisationUtil.synchroniseUntilTheElementIsDisplayedEnabledAndClickable(driver,recruitingButton );
	    SeleniumUtil.clickElementNoAssert(recruitingButton);
	    log(CONSOLEANDEXTENTINFO, "Clicked recruiting menu");
       		
	}
	
	
	public void navigateToHomePage() throws IOException, InterruptedException {
		SynchronisationUtil.synchroniseUntilTheElementIsDisplayedEnabledAndClickable(driver,homeButton );
	    SeleniumUtil.clickElementNoAssert(homeButton);
	    SynchronisationUtil.synchroniseUntilTheElementIsVisible(driver, homePageCarnivalImage);
    	SeleniumUtil.isElementExists(homePageCarnivalImage);
    	log(CONSOLEANDEXTENTINFO, "Navigated to homepage successfully"); 
    	
       		
	}	
}
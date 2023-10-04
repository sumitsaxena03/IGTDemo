package org.igt.pompages;

import org.apache.commons.io.FileUtils;
import org.igt.drivers.DriverManager;
import org.igt.enums.PropertiesType;
import org.igt.factories.ExplicitWaitFactory;
import org.igt.reports.ExtentLogger;
import org.igt.utils.IWaitTimeConstants;
import org.igt.utils.PropertyUtils;
import org.igt.utils.SeleniumUtil;
import org.igt.utils.SynchronisationUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.igt.enums.LogType.*;
import static org.igt.reports.FrameworkLogger.log;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;


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
public class ADTHomeScreen extends BasePage {
	
	private WebDriver driver;
	private int timeout=IWaitTimeConstants.GLOBAL_WAIT_TIME_TEN_SEC_IN_MS;
	private int waitTime=IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_IN_MS;
	

    
    /** Xpath for homePageCarnivalImage */
    @FindBy(xpath = "//a[@class='sub-nav-brand-logo']//img[@alt='ADT Security Systems']")
    private WebElement adtLogo;
	
		

	public ADTHomeScreen(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }   


	public void pageTitle() {		
		log(CONSOLEANDEXTENTINFO, "ADT Test Case initiated"); 	
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(50000));
		DriverManager.getDriver().manage().window().maximize();
		SynchronisationUtil.waitUntilTheElementIsRefreshedAndClickable(driver, timeout, adtLogo);
		String title= driver.getTitle();
		log(CONSOLEANDEXTENTINFO, "ADT Page Title: " + title);		
    	
 	}
	
	
	
	
}

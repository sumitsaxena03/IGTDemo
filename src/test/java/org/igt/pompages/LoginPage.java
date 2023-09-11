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
public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private int timeout=IWaitTimeConstants.GLOBAL_WAIT_TIME_THIRTY_SEC_IN_MS;
	private int waitTime=IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_IN_MS;
	
	/** Xpath for homePageCarnivalImage */
    @FindBy(xpath = "//button[@aria-label='Home']")
    private WebElement homePageCarnivalImage;
    
    /** Xpath for username text field */
	@FindBy(xpath = "//*[@name='loginfmt']")
	private WebElement usernameTextfield;
	
	/** Xpath for next button */
	@FindBy(xpath = "//*[@class='win-button button_primary button ext-button primary ext-primary']")
	private WebElement nextButton;
	
	/** Xpath for passord text field */
	@FindBy(xpath = "//*[@name='passwd']")
	private WebElement passwordTextfield;
	
	/** Xpath for sign in button */
	@FindBy(xpath = "//*[@class='win-button button_primary button ext-button primary ext-primary']")
	private WebElement signInButton;
	
	/** Xpath for sign in button */
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signInLinkOffice;
	
	/** Xpath for homePageCarnivalImage */
    @FindBy(xpath = "//*[@id='idSIButton9']")
    private WebElement staySignedInButton;
    
    /** Xpath for homePageCarnivalImage */
    @FindBy(xpath = "//a[@id='hero-banner-sign-in-to-office-365-link']")
    private WebElement signInBUtton;
	
		

	public LoginPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }   

	/* UAT login */
	public void logintoMistralUAT() throws IOException, InterruptedException, NoSuchElementException, TimeoutException, StaleElementReferenceException, Exception {
		
		log(CONSOLEANDEXTENTINFO, "Login initiated"); 	
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(50000));
		DriverManager.getDriver().manage().window().maximize();
		SynchronisationUtil.waitUntilTheElementIsRefreshedAndClickable(driver, timeout, signInBUtton);
		SeleniumUtil.clickElementNoAssert(signInBUtton); 
		SynchronisationUtil.waitUntilTheElementIsRefreshedAndClickable(driver, timeout, usernameTextfield);
    	SeleniumUtil.typeValuesInATextBox(usernameTextfield,PropertyUtils.getValue(String.valueOf(PropertiesType.PORTALUSERNAME)), driver); 
    	log(CONSOLEANDEXTENTINFO, "Entered userName"); 
    	SeleniumUtil.clickElementNoAssert(nextButton); 
    	log(CONSOLEANDEXTENTINFO, "Login button clicked"); 
    	SynchronisationUtil.waitUntilTheElementIsRefreshedAndClickable(driver, timeout, passwordTextfield);
    	SeleniumUtil.typeValuesInATextBox(passwordTextfield,PropertyUtils.getValue(String.valueOf(PropertiesType.PORTALPASSWORD)), driver); 
    	log(CONSOLEANDEXTENTINFO, "Entered password"); 
    	SeleniumUtil.clickElementNoAssert(signInButton); 
    	log(CONSOLEANDEXTENTINFO, "Sign in button clicked");
    	
    	//Thread.sleep(15000);
    	
		SeleniumUtil.waitForSpecificTime(timeout);	
		  if(SeleniumUtil.isElementExists(staySignedInButton)) {
		  SeleniumUtil.clickElementNoAssert(staySignedInButton);
		  log(CONSOLEANDEXTENTINFO, "Stay sign in button clicked"); }
		 
    	
		SynchronisationUtil.synchroniseUntilTheElementIsVisible(driver, homePageCarnivalImage);
    	SeleniumUtil.isElementExists(homePageCarnivalImage);
    	log(CONSOLEANDEXTENTINFO, "Login successful"); 
    	
 	}
	
	
	/* Pre prod login */
	public void logintoMistral() throws IOException, InterruptedException {
		
		log(CONSOLEANDEXTENTINFO, "Login initiated"); 
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(50000));
		DriverManager.getDriver().manage().window().maximize();
		Thread.sleep(3000);
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/test/resources/executables/Mistral_SK_Login.exe");
        log(CONSOLEANDEXTENTINFO, "Entered credentials"); 
        SynchronisationUtil.synchroniseUntilTheElementIsVisible(driver, homePageCarnivalImage);
    	SeleniumUtil.isElementExists(homePageCarnivalImage);
    	log(CONSOLEANDEXTENTINFO, "Login successful"); 
    	
 	}
	
}
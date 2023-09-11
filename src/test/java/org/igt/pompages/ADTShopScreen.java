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
public class ADTShopScreen extends BasePage {
	
	private WebDriver driver;
	private int timeout=IWaitTimeConstants.GLOBAL_WAIT_TIME_TEN_SEC_IN_MS;
	private int waitTime=IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_IN_MS;
	

    
    /** Xpath */
    @FindBy(xpath = "//a[@class='sub-nav-brand-logo']//img[@alt='ADT Security Systems']")
    private WebElement adtLogo;
    
    /** Xpath */
    @FindBy(xpath = "//a[@title='ADT Security Systems ']")
    private WebElement adtLogo1;
    
    /** Xpath */
    @FindBy(xpath = "//a[@href='https://www.adt.com/shop']")
    private WebElement shopLink;
    
    /** Xpath */
    @FindBy(xpath = "//div[@class='text-center d-none d-md-block']//a[@class='btn btn-primary'][normalize-space()='Choose a Package']")
    private WebElement chooseAPackage;
    
    /** Xpath */
    @FindBy(xpath = "(//a[@href='/shop/packages/build-your-own.html'][normalize-space()='START CUSTOMIZING'])[1]")
    private WebElement startCustomizeBuildYourOwn;
    
    /** Xpath */
    @FindBy(xpath = "//div[contains(@data-prodname,'Google Nest Cam with floodlight<sup>^^</sup>')]//div//input[contains(@value,'+')]")
    private WebElement googleNestCam;
    
    /** Xpath */
    @FindBy(xpath = "//button[normalize-space()='ADD TO CART']")
    private WebElement addToCart;
    
    /** Xpath */
    @FindBy(xpath = "//div[normalize-space()='Change payment option']")
    private WebElement changepaymentOption;
    
    /** Xpath */
    @FindBy(xpath = "//label[@for='payInFullToday']")
    private WebElement payInToday;
    
    /** Xpath */
    @FindBy(xpath = "//button[normalize-space()='UPDATE CART']")
    private WebElement updateCart;
    
    /** Xpath */
    @FindBy(xpath = "//a[normalize-space()='CONTINUE TO SECURE CHECKOUT']")
    private WebElement continueToSecureCheckout;
    
    /** Xpath */
    @FindBy(xpath = "//input[@placeholder='Email*']")
    private WebElement emailField;
    
    /** Xpath */
    @FindBy(xpath = "//input[@placeholder='First Name*']")
    private WebElement firstName;
    
    /** Xpath */
    @FindBy(xpath = "//input[@placeholder='Last Name*']")
    private WebElement lastName;
    
    /** Xpath */
    @FindBy(xpath = "//input[@placeholder='Phone Number*']")
    private WebElement phoneNumber;
    /** Xpath */
    @FindBy(xpath = "//span[normalize-space()='Own']")
    private WebElement own;
    
    /** Xpath */
    @FindBy(xpath = "//input[@placeholder='Street Address*']")
    private WebElement streetAddress;
    
    
    /** Xpath */
    @FindBy(xpath = "//input[@placeholder='City*']")
    private WebElement city;
    
    /** Xpath */
    @FindBy(xpath = "//select[@name='dwfrm_serviceInformation_serviceInformation_serviceAddressFields_states_stateCode']")
    private WebElement countyDropdown;
    
    /** Xpath */
    @FindBy(xpath = "//input[@placeholder='ZIP*']")
    private WebElement zip;
    
    /** Xpath */
    @FindBy(xpath = "//button[@name='submit']")
    private WebElement submitButton;
    
    /** Xpath */
    @FindBy(xpath = "//button[@name='unVerifiedAddressSelected']")
    private WebElement useRecomended;
    

	
		

	public ADTShopScreen(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }   


	public void shopScreen() {		
		log(CONSOLEANDEXTENTINFO, "ADT Test Case initiated"); 	
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofMillis(50000));
		DriverManager.getDriver().manage().window().maximize();
		SynchronisationUtil.waitUntilTheElementIsRefreshedAndClickable(driver, timeout, adtLogo);
		String title= driver.getTitle();
		log(CONSOLEANDEXTENTINFO, "ADT Page Title: " + title);	
		SeleniumUtil.clickElementAssert(shopLink, driver);
		log(CONSOLEANDEXTENTINFO, "ShopLink Clicked");	
		SynchronisationUtil.waitUntilTheElementIsRefreshedAndClickable(driver, timeout, chooseAPackage);
		SeleniumUtil.clickElementAssert(chooseAPackage, driver);
		log(CONSOLEANDEXTENTINFO, "Choose a Package Clicked");
		SeleniumUtil.waitForSpecificTime(waitTime);
		//SeleniumUtil.scrollIntoView(startCustomizeBuildYourOwn, driver);
		SeleniumUtil.clickElementNoAssert(startCustomizeBuildYourOwn);
		log(CONSOLEANDEXTENTINFO, "Start Customize Build Your Own Clicked");
		SynchronisationUtil.waitUntilTheElementIsRefreshedAndClickable(driver, timeout, adtLogo1);
		//SeleniumUtil.waitForSpecificTime(timeout);
		SeleniumUtil.waitForSpecificTime(waitTime);
		SeleniumUtil.clickElementAssert(googleNestCam, driver);
		log(CONSOLEANDEXTENTINFO, "Google Nest Cam is Added to Cart");
		SeleniumUtil.clickElementAssert(addToCart, driver);
		log(CONSOLEANDEXTENTINFO, "Add to Cart is Clicked");
		/*
		 * SeleniumUtil.clickElementAssert(changepaymentOption, driver);
		 * log(CONSOLEANDEXTENTINFO, "Change payment Option is Clicked");
		 * SeleniumUtil.waitForSpecificTime(waitTime);
		 * SeleniumUtil.clickElementAssert(payInToday, driver);
		 * log(CONSOLEANDEXTENTINFO, "Pay in Today Option is Clicked");
		 * SeleniumUtil.clickElementAssert(updateCart, driver);
		 * log(CONSOLEANDEXTENTINFO, "Update Cart is Clicked");
		 */
		SeleniumUtil.waitForSpecificTime(waitTime);
		SeleniumUtil.clickElementAssert(continueToSecureCheckout, driver);
		log(CONSOLEANDEXTENTINFO, "Continue to Secure CheckOut is Clicked");
		SeleniumUtil.typeValuesInATextBox(emailField, "test@test.com", driver);
		log(CONSOLEANDEXTENTINFO, "First Name is Passed");
		SeleniumUtil.typeValuesInATextBox(firstName, "Andrew", driver);
		log(CONSOLEANDEXTENTINFO, "First Name is Passed");
		SeleniumUtil.typeValuesInATextBox(lastName, "Stuart", driver);
		log(CONSOLEANDEXTENTINFO, "Last Name is Passed");
		SeleniumUtil.typeValuesInATextBox(phoneNumber, "4567878678", driver);
		log(CONSOLEANDEXTENTINFO, "Phone Number is Passed");
		SeleniumUtil.clickElementAssert(own, driver);
		log(CONSOLEANDEXTENTINFO, "OWN is selected as Service Address");
		SeleniumUtil.typeValuesInATextBox(streetAddress, "17 17 Mile Dr", driver);
		log(CONSOLEANDEXTENTINFO, "Street Address is provided");
		SeleniumUtil.typeValuesInATextBox(city, "Pacific Grove", driver);
		log(CONSOLEANDEXTENTINFO, "Street Address is provided");
		
		//DropDown
		SeleniumUtil.clickElementAssert(countyDropdown, driver);
		click(driver, "//option[@value='CA']");			
		log(CONSOLEANDEXTENTINFO, "Street Address is provided");
		SeleniumUtil.typeValuesInATextBox(zip, "93950-2152", driver);
		log(CONSOLEANDEXTENTINFO, "Street Address is provided");		
		SeleniumUtil.clickElementAssert(submitButton, driver);
		log(CONSOLEANDEXTENTINFO, "Continue Button is clicked");

		if (SeleniumUtil.isElementExists(useRecomended)) {
			SeleniumUtil.clickElementAssert(useRecomended, driver);
			log(CONSOLEANDEXTENTINFO, "Use Recomended is clicked");
			
		}
		SeleniumUtil.waitForSpecificTime(timeout);
		String title1 = driver.getTitle();
		log(CONSOLEANDEXTENTINFO, title1);
		title1.contains("Credit Check");
		
		
    	
 	}
	
	/**
     * Click.
     *
     * @param driver the driver
     * @param elementToClick the element to click
     */
    public static void click(final WebDriver driver, final String elementToClick) {
        WebElement element = driver.findElement(By.xpath(elementToClick));
        element.click();
    }
	
	
}
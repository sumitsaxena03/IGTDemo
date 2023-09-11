package org.igt.pompages;


import java.util.ArrayList;
import java.util.function.Consumer;

import org.igt.drivers.DriverManager;
import org.igt.enums.WaitMethods;
import org.igt.factories.ExplicitWaitFactory;
import org.igt.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.igt.enums.LogType.*;
import static org.igt.reports.FrameworkLogger.log;

import java.awt.Color;
import java.awt.color.*;


/**
 * Class to maintain methods for element interactions.
 * Apr 4, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExplicitWaitFactory
 * @see FrameworkLogger
 * @see ExtentLogger
 * @see DriverManager
 */
public class BasePage {

	/**
	 * Method to provide button click functionality using WebDriver click method.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void click(By by, WaitMethods waitmethod, String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitmethod, by).click();
		log(CONSOLEANDEXTENTINFO, elementname+ " is clicked"); 
	}

	/**
	 * Method to provide button click functionality using Action class click method.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void actionClassClick(By by, WaitMethods waitmethod, String elementname) {
		Actions action = new Actions(DriverManager.getDriver());
		action.moveToElement(ExplicitWaitFactory.performExplicitWait(waitmethod, by)).click().perform();
		log(CONSOLEANDEXTENTINFO, elementname+ " is clicked"); 
	}
	/**
	 * Method to provide button click functionality using Tab and Action class click method.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void tabAndClick(By by, WaitMethods waitmethod, String elementname) {
		Actions action = new Actions(DriverManager.getDriver());
		action.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).build().perform();
		log(CONSOLEANDEXTENTINFO, elementname+ " is clicked"); 
	}
	/**
	 * Method to provide button click functionality using JavaScriptExecutor click method.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void jsExecuteClick(By by, WaitMethods waitmethod, String elementname) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click();",ExplicitWaitFactory.performExplicitWait(waitmethod, by));
		log(CONSOLEANDEXTENTINFO, elementname+ " is clicked"); 
	}
	/**
	 * Method to provide enter text functionality using WebDriver sendkeys method.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void sendkeys(By by, String textbox, WaitMethods waitmethod, String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitmethod, by).sendKeys(textbox);
		log(INFO, textbox +" is entered sucessfully in " +elementname); 
	}
	/**
	 * Method to provide enter text functionality using Tab and action class sendkeys method.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void tabAndSendKeys(By by, String textbox, WaitMethods waitmethod, String elementname) {
		Actions action = new Actions(DriverManager.getDriver());
		action.sendKeys(Keys.TAB).sendKeys(textbox).sendKeys(Keys.TAB).build().perform();
	}
	/**
	 * Method to provide enter text functionality using Action class sendkeys method.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void actionClassSendKeys(By by, String textbox, WaitMethods waitmethod, String elementname) {
		Actions action = new Actions(DriverManager.getDriver());
		action.moveToElement(ExplicitWaitFactory.performExplicitWait(waitmethod, by)).click().sendKeys(textbox).perform();
		log(INFO, textbox +" is entered sucessfully in " +elementname); 
	}
	/**
	 * Method to provide enter text functionality using JavaScriptExecuter method..
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void jsExecuteSendKeys(By by, String textbox, WaitMethods waitmethod, String elementname) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].value='dttestuser'",ExplicitWaitFactory.performExplicitWait(waitmethod, by));
		log(CONSOLEANDEXTENTINFO, textbox +" is entered sucessfully in " +elementname); 
	}
	/**
	 * Method to get page title from browser.
	 * @return
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	/**
	 * Method to provide enter text functionality.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	protected String getText(By by, WaitMethods waitmethod, String elementname) {
		return ExplicitWaitFactory.performExplicitWait(waitmethod, by).getText();

	}

	/**
	 * Method to provide browser navigation functionality.
	 * @param url
	 * @throws InterruptedException 
	 */
	public static void navigateToURL(String url) throws InterruptedException {
		DriverManager.getDriver().navigate().to(url);
		Thread.sleep(3000);
	}

	/**
	 * This method will help to check if the particular element exist or not.
	 * @param elementkey
	 * @return Boolean
	 */
	public static boolean isElementExists(By element, String elementname) {
		if (element == null) {
			log(CONSOLEANDEXTENTINFO, elementname+ " is not available"); 
			return false;
		}
		int count = DriverManager.getDriver().findElements(element).size();
		log(CONSOLEANDEXTENTINFO, "Element availability is : "+ count); 
		if (count == 0) { 
			return false;
		} else {
			log(CONSOLEANDEXTENTINFO, elementname+ " is visible"); 
			return true;
		}
	}

	/**
	 * This method will help to check if the particular element is enabled on UI.
	 * @param element
	 * @return Boolean
	 */
	protected static boolean isElementEnabled(By element, String ButtonName) {
		if (element != null) {
			boolean bFound = ((WebElement) element).isEnabled();
			if (bFound == false) {
				log(CONSOLEANDEXTENTINFO, (ButtonName+ " is not enabled on screen")); 
				return false;
			}
		} else { 
			throw new NullPointerException("Element cannot be null");
		}
		return true;
	}

	/**
	 * Method to get color of the text or button in hex format.<p> We have to use hex as normal getCssValue method used to return RBG format.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	protected Color getTextColor(By by, WaitMethods waitmethod, String status) {
		String textcolor =ExplicitWaitFactory.performExplicitWait(waitmethod, by).getCssValue("color");
		org.openqa.selenium.support.Color selcolor = new org.openqa.selenium.support.Color(1,1,1,1.2);
		String hexformatcolor = selcolor.fromString(textcolor).asHex();
		//	log(INFO,(status + " color is : "+ hexformatcolor)); 
		java.awt.Color  c = new java.awt.Color(1);
		Color textformatcolor = c.decode(hexformatcolor);
		return textformatcolor;

	}

	/**
	 * Method to check if new tab is opened in same browser window.<p> If opened, switch back to main window.
	 * @see DriverManager
	 */
	protected static boolean isNewTabOpened() {
		int windowCount = 0;
		ArrayList<String> tabsList = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
		windowCount = tabsList.size();
		log(CONSOLEANDEXTENTINFO,"Total opened window size is : " + windowCount); 
		if(windowCount>1) {
			log(CONSOLEANDEXTENTINFO,"New tab is opened"); 
			DriverManager.getDriver().switchTo().window(tabsList.get(0));
			//	DriverManager.getDriver().close();
			return true;
		} else {
			log(CONSOLEANDEXTENTFAIL,"No new tab opened after latest action in root tab"); 
			return false;
		}
	}

	/**
	 * Method to select values from dropdown using index, value, visibletext.
	 * @see Select
	 */

	public static void selectDropDownUsingConsumerInterface(Consumer<Select> consumer, By by, WaitMethods waitmethod, String elementname) {
		Select select = new Select(ExplicitWaitFactory.performExplicitWait(waitmethod, by));
		consumer.accept(select);
		log(CONSOLEANDEXTENTINFO, elementname+ " is clicked"); 
	}
}


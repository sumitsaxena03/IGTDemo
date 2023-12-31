package org.igt.utils;

import org.igt.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Provide screenshot functionality during execution.
 * Apr 1, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */
public final class ScreenShotUtils {
	
private ScreenShotUtils() {}
/**
 * Take screenshot using driver method and change it from Base64 to String format.
 * @return screenshot
 */
public static String getBase64Image() {
	return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
}
}
 
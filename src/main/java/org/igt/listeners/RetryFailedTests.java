package org.igt.listeners;

import org.igt.enums.PropertiesType;
import org.igt.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This will control the retry mechanism of failed test cases.<p>
 * By default we are using only one retry on failed cases.<p>
 * Mar 31, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see PropertyUtils
 */
public class RetryFailedTests implements IRetryAnalyzer {
	int count =0;
	int maxretry =1;
	@Override
	public boolean retry(ITestResult result) {
		boolean run = false;
			if(PropertyUtils.getValue((String.valueOf(PropertiesType.FAILEDRETRYTESTS))).equalsIgnoreCase("yes")) {
			 run = count< maxretry;
			count++;
			return run;
         }		
		return run;
    }
}

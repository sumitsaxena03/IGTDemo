package org.igt.reports;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.igt.constants.FrameworkConstants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Class to implement Extent Report implementation for framework.
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see ExtentReports
 * @see ExtentSparkReporter
 * @see ExtentManager
 */
public final class ExtentReport {

	private ExtentReport() {};
	private static ExtentReports extent;
	private static ExtentTest extest;

	/**
	 * Method to invoke Extent report to provide the path of report generation.<p> We can add either Report name or Company logo a at time as they don't have place for both.
	 * @author Mandeep Sheoran
	 * @throws IOException 
	 * @see ExtentReports
	 */
	public static void initReport() throws IOException {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfilepath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ADT ExtentReport");
		spark.config().setReportName("ADT test report");
		//	spark.loadXMLConfig(new File(FrameworkConstants.extentconfigFilePath));		
	}

	/**
	 * Tear down method to call the flush method of ExtentReport class. <p> This will help us to generate the report.
	 * @author Mandeep Sheoran
	 */
	public static void tearDownReport() {
		extent.flush();
	//	if(Objects.nonNull(extent)) {
	//		extent.flush();
	//		}
		//	ExtentManager.unload();
	}

	/**
	 * Method to create the test in Extent Report. Method name will be called from TestListener.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void createTest(String testname) {
		extest = extent.createTest(testname);
		ExtentManager.setExtent(extest);
	}

	/**
	 * Add author in report which will be passed through custom annotations used in Tests.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void addAuthors(String[] authors) {
		for(String author: authors) {
			ExtentManager.getExtenttest().assignAuthor(author);
		}
	}

	/**
	 * Add Category in report which will be passed through custom annotations used in Tests.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void addCategory(String[] categories) {
		ExtentManager.getExtenttest().assignCategory(categories);
	//	for(String category: categories) {
		//	ExtentManager.getExtenttest().assignCategory(category);
	//	}
	}
	
	/**
	 * Add Method Type in report which will be passed through custom annotations used in Tests.
	 * @author Mandeep Sheoran
	 * @see ExtentManager
	 */
	public static void addMethod(String methodtype) {
		ExtentManager.getExtenttest().assignDevice(methodtype);
	}
}

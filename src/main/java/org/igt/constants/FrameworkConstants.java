package org.igt.constants;


import org.aeonbits.owner.ConfigFactory;
import org.igt.enums.PropertiesType;
import org.igt.utils.PropertyUtilOwnerLib;
import org.igt.utils.PropertyUtils;

import lombok.Getter;

/**
 * Class to store all resource path required to GET/POST data, browser driver path and extent report paths.
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	public static @Getter final String requestjsonfolderpath = System.getProperty("user.dir")+"/src/test/resources/json/";
	public static @Getter final String responsejsonfolderpath = System.getProperty("user.dir")+"/JsonOutput/";
	public static final String  configFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
	public static final String  extentconfigFilePath = System.getProperty("user.dir")+"/src/test/resources/extentconfig.xml";	
	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static @Getter final String CHROMEDRIVERPATH = RESOURCEPATH + "/drivers/chromedriver.exe";
	private static @Getter final String GECKODRIVERPATH = RESOURCEPATH + "/drivers/geckodriver.exe";
	private static @Getter final String IEDRIVERPATH = RESOURCEPATH + "/drivers/IEDriverServer.exe";
	private static final String EXCELPATH = RESOURCEPATH + "/Excel/testdata.xlsx";
	private static @Getter final String TESTCASESHEET = "TestMethods";
	private static @Getter final String TESTDATASHEET = "TestData";
	private static final String EXTENTREPORTFOLDERPATH =System.getProperty("user.dir") + "/ExtentTest-Output/";
	private static String extentreportfilepath="";
	private static final int EXPLICITWAITTIME = 30;
	public static @Getter final String logincredent = System.getProperty("user.dir")+"/src/test/resources/login/";
	public static @Getter final String datasource = System.getProperty("user.dir")+"/src/test/resources/Excel/";
		
	public static int getExplicitwaittime() {
		return EXPLICITWAITTIME;
	}
	public static String getExcelpath() {
		return EXCELPATH;
	}
	public static String getExtentreportfilepath() {
		if(extentreportfilepath.isEmpty()) { 
			extentreportfilepath = createExtentReportPath();
		}
		return extentreportfilepath;
	}	
	private static String createExtentReportPath()  {
		if(PropertyUtils.getValue(String.valueOf(PropertiesType.OVERRIDEREPORTS)).equalsIgnoreCase("no")) {
			//return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/index.html";
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH + "/index.html";
		}
	}
	public static String getTESTDATASHEET() {
		// TODO Auto-generated method stub
		return TESTDATASHEET;
	}
	public static String getTESTCASESHEET() {
		// TODO Auto-generated method stub
		return TESTCASESHEET;
	}
}

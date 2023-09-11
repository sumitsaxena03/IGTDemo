package org.igt.dataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Class to get data from excel sheet
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class DataProviderWithExcel {
	
	@Test(dataProvider="excelReader")
	public void samplegetdata(Map<String,String> map) {
		System.out.println(map.get("project"));
	}
	
	/**
	 * Method to read the excel file and return the data
	 * @return excel sheet data
	 * @throws IOException
	 */
	@DataProvider
	public Object[] excelReader() throws IOException {
		Object[] exldata =null;
		try(FileInputStream fs = new FileInputStream(System.getProperty("user.dir") +"/Excel/ExcelData.xlsx")) {
		XSSFWorkbook workbook = new XSSFWorkbook(fs); 
		XSSFSheet sheet = workbook.getSheet("igt");
		int rownum = sheet.getLastRowNum();
		int columnnum = sheet.getRow(0).getLastCellNum();
		 exldata = new Object[rownum];
		Map<String,String> map;
		for(int i=1;i<=rownum;i++) {
			map = new HashMap<>();
			for(int j=0;j<columnnum;j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				exldata[i-1] = map;
			}
		}
	} catch (Exception e) {
		e.getStackTrace();
	}
		return exldata;
	}
	}


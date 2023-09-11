package org.igt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.sun.tools.sjavac.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.igt.constants.FrameworkConstants;
import org.igt.exceptions.FrameworkException;
import org.igt.exceptions.InvalidExcelFilePathException;

/**
 * Class having methods to extract test data from external sheet.
 * Apr 1, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class ExcelUtils {
	/**
     * Path to the spreadsheet.
     */
    private String path;

    /**
     * Stream to read the spreadsheet.
     */
    private FileInputStream fis = null;

    /**
     * Access to the spreadsheet.
     */
    private XSSFWorkbook workbook = null;

    /**
     * Work sheet in the current file.
     */
    private XSSFSheet sheet = null;

    /**
     * Row within the current sheet.
     */
    private XSSFRow row = null;

    /**
     * Cell within the current sheet.
     */
    private XSSFCell cell = null;

    /**
     * Stream to write the spreadsheet.
     */
    private FileOutputStream fileOut = null;

    /** Constants */
    /**
     * unable to open spread sheet.
     */
    private static final String UNABLE_TO_OPEN = "Unable to open spreadsheet ";

    /**
     * unable to open spread sheet as the path is null.
     */
    private static final String NULL_PATH = "Unable to open spreadsheet as path is null";

    /**
     * " from workbook" constant.
     */
    private static final String FROM_WBOOK = "\" from workbook \"";
    /**
     * SLF4J Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SeleniumUtil.class);

	private ExcelUtils() {		
	}	
	/**
	 * Method to read complete data from excel sheet using apache POI and return a list of this test data.
	 * @param sheetname
	 * @return
	 */
	public static List<Map<String,String>> getTestDetails(String sheetname){
		List<Map<String,String>> list = null;
		try(FileInputStream fs= new FileInputStream(FrameworkConstants.getExcelpath())) {	
			XSSFWorkbook workbook = new XSSFWorkbook(fs);		
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int rownum = sheet.getLastRowNum();
			int colmncount = sheet.getRow(0).getLastCellNum();
			Map<String,String> map = null;
			list = new ArrayList<>();
			for(int i=1;i<=rownum;i++) { 
				map = new HashMap<>();
				for(int j=0;j<colmncount;j++) {
					String key= sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key,value);					 					 
				}
				list.add(map);
			}			 
		} catch (FileNotFoundException  e) {
			StackTraceElement[] exc = e.getStackTrace();
			exc[0] = new StackTraceElement("org.igt.demo.utils.ExcelUtils", "getTestDetails", "ExcelUtils.java", 24);
			e.setStackTrace(exc);
			throw new InvalidExcelFilePathException("Error while reading the excel file", e);
		} catch (IOException e) {		
			throw new FrameworkException("Input output exception while reading the file", e);
		}
		return list;			
	}
	
	/**
     * ExcelReader(String path, String SheetName) constructor accepts the path
     * of the Excel sheet with its Name and the workSheetName.
     *
     * @param path
     *            - Name & path of the Excel spreadsheet
     * @param sheetName
     *            - Name of the workSheet
     * @author Sumit.Saxena
     **/

    public ExcelUtils(final String path, final String sheetName) {
        if (path == null && sheetName == null) {
            return;
        }

        this.setPath(path);

        if (this.getPath() != null) {
            try {
                setFis(new FileInputStream(path));

                if (this.getFis() != null) {
                    XSSFWorkbook xssfWB = new XSSFWorkbook(getFis());

                    if (xssfWB != null) {
                        setWorkbook(xssfWB);

                        if (this.getWorkbook() != null) {
                            this.setSheet(getWorkbook().getSheet(sheetName));
                            if (this.getSheet() == null) {
                                Log.warn("Unable to retrieve worksheet \""
                                        + sheetName + FROM_WBOOK + path + "\"");
                            }
                        }
                    }
                }
            } catch (FileNotFoundException fe) {
                LOG.warn(UNABLE_TO_OPEN +"{0}", fe);
            } catch (IOException ie) {
            	LOG.warn(UNABLE_TO_OPEN + "{0}", ie);
            } finally {
                if (getFis() != null) {
                    try {
                        getFis().close();
                    } catch (IOException e) {
                        LOG.error("IOException",e);
                    }
                }
            }

        } else {
        	Log.warn(NULL_PATH);
        }
    }
    
    /**
     * This method returns the String value of the cell content which matches
     * for the specified row number and column number.
     *
     * @param row
     *            - Row Number
     * @param col
     *            - column Number
     * @return String Note: Row number and column numbers start from index 0.
     * @author Sumit.Saxena
     **/
    public String getCellValue(final int row, final int col) {
        Row rows = getSheet().getRow(row - 1);
        if (rows == null) {
            LOG.warn("Attempt to read data from cell in undefined row " + "["
                    + row + "," + col + "] on sheet \""
                    + getSheet().getSheetName() + "\"");
            return "";
        } else {
            Cell aCell;
            try {
                aCell = rows.getCell(col);
            } catch (IllegalArgumentException ex) {
                LOG.warn("Attempt to read data from undefined cell " + "[" + row
                        + "," + col + "] on sheet \""
                        + getSheet().getSheetName() + "\"");
                throw ex;
            }
            if (aCell == null) {
                // Treat cells that don't exist as empty because Excel generally
                // only creates the
                // cells that have values or styles
                return "";
            } else if (aCell.getCellType() == CellType.STRING) {
                return aCell.getStringCellValue();
            } else if (aCell.getCellType() == CellType.NUMERIC) {
                return new java.text.DecimalFormat("0")
                        .format(aCell.getNumericCellValue());
            } else {
                return aCell.getStringCellValue();
            }
        }
    }
    
    /**
     * This method returns the number of usedRows present in a worksheet.
     *
     * @return integer
     * @author Sumit.Saxena
     **/

    public int getRowCount() {
        if (getSheet() != null) {
            int rowCount = getSheet().getLastRowNum();
            return rowCount + 1;
        } else {
            LOG.warn("Sheet not found");
            return 0;
        }
    }
    /**
     * This method returns the number of columns present in a particular
     * worksheet for the specified rownumber.
     *
     * @return integer
     * @author Sumit.Saxena
     **/
    public int getColumnCount() {
        if (getSheet() != null) {
            Row rowNum = getSheet().getRow(0);
            return rowNum.getLastCellNum();
        } else {
            LOG.warn("Sheet not found");
            return 0;
        }
    }
    
    /**
     * This overloaded method returns the String value of the cell content which
     * matches for the specified SheetName, column number and row number.
     *
     * @param sheetName
     *            - String value of the workSheetName
     * @param row
     *            - Row Number
     * @param col
     *            - column Number
     * @return String Note: column numbers start from index 0.
     * @author Sumit.Saxena
     **/
    public String getCellValue(final String sheetName, final int row,
            final int col) {
        setSheet(getWorkbook().getSheet(sheetName));
        if (getSheet() != null) {
            Row rows = getSheet().getRow(row - 1);
            Cell aCell = rows.getCell(col);

            if (aCell == null) {
                return "";
            } else if (aCell.getCellType() == CellType.STRING) {
                return aCell.getStringCellValue();
            } else if (aCell.getCellType() == CellType.NUMERIC) {
                return new java.text.DecimalFormat("0")
                        .format(aCell.getNumericCellValue());
            } else {
                return aCell.getStringCellValue();
            }
        } else {
            LOG.warn("Unable to retrieve sheet \"" + sheetName + FROM_WBOOK
                    + getPath() + "\"");
            return null;
        }
    }
    
    /**
     * Getter.
     *
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * Setter.
     *
     * @param path
     *            the path to set
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Getter.
     *
     * @return the fis
     */
    public FileInputStream getFis() {
        return fis;
    }

    /**
     * Setter.
     *
     * @param fis
     *            the fis to set
     */
    public void setFis(final FileInputStream fis) {
        this.fis = fis;
    }
    /**
     * Getter.
     *
     * @return the sheet
     */
    public XSSFSheet getSheet() {
        return sheet;
    }

    /**
     * Setter.
     *
     * @param sheet
     *            the sheet to set
     */
    public void setSheet(final XSSFSheet sheet) {
        this.sheet = sheet;
    }

    /**
     * Getter.
     *
     * @return the row
     */
    public XSSFRow getRow() {
        return row;
    }

    /**
     * Setter.
     *
     * @param row
     *            the row to set
     */
    public void setRow(final XSSFRow row) {
        this.row = row;
    }

    /**
     * Getter.
     *
     * @return the cell
     */
    public XSSFCell getCell() {
        return cell;
    }

    /**
     * Setter.
     *
     * @param cell
     *            the cell to set
     */
    public void setCell(final XSSFCell cell) {
        this.cell = cell;
    }

    /**
     * Getter.
     *
     * @return the fileOut
     */
    public FileOutputStream getFileOut() {
        return fileOut;
    }

    /**
     * Setter.
     *
     * @param fileOut
     *            the fileOut to set
     */
    public void setFileOut(final FileOutputStream fileOut) {
        this.fileOut = fileOut;
    }
    /**
     * Getter.
     *
     * @return the workbook
     */
    public XSSFWorkbook getWorkbook() {
        return workbook;
    }

    /**
     * Setter.
     *
     * @param workbook
     *            the workbook to set
     */
    public void setWorkbook(final XSSFWorkbook workbook) {
        this.workbook = workbook;
    }


}

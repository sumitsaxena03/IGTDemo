package org.igt.datasource;

import java.util.HashMap;
import java.util.Map;

import org.igt.utils.ExcelUtils;
import org.testng.annotations.DataProvider;


public class dataProviderSource {
	
	/** The Constant datatablepath. */
    private static final String datatablepath = System.getProperty("user.dir")+"/src/test/resources/Excel/";
    
    @DataProvider(name = "TestData1")
    public static final Object[][] getData1() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Create_Concessionaire");
    }
    
    /** Create New Hire */

    @DataProvider(name = "TestData2")
    public static final Object[][] getData2() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Create_New_Hire");
    }

    
    /** Create New Hire */

    @DataProvider(name = "TestData3")
    public static final Object[][] getData3() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "HR_Service_Medical");
    }

   
    /** Hr Services - Add certification */
    @DataProvider(name = "TestData4")
    public static final Object[][] getData4() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "HR_Services_Add_Certification");
    }
    
    /** embarkDisembarkCloseMovement */
    @DataProvider(name = "TestData5")
    public static final Object[][] getData5() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Embark_Disembark_Close_Movement");
    }
    
   
    /** Concessionaire Create Plan  */

    @DataProvider(name = "TestData6")
    public static final Object[][] getData6() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Concessionaire_Create_Plan");
    }
    
    
    /** Create Subdivide And Paypoint Change  */

    @DataProvider(name = "TestData7")
    public static final Object[][] getData7() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "HR_SubdivideAndPaypoint_Change");
    }
    /** Create Subdivide And Paypoint Change  */

    @DataProvider(name = "TestData8")
    public static final Object[][] getData8() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Crew_Member_EditPlan_ChangeShip");
    }
    
    
    /** Create new hire add contract  */

    @DataProvider(name = "TestData9")
    public static final Object[][] getData9() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "New_Hire_Add_Contract");
    }
    

    /** Create new hire create plan  */

    @DataProvider(name = "TestData10")
    public static final Object[][] getData10() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "New_Hire_Create_Plan");
    }

    /** Create new hire create plan  */

    @DataProvider(name = "TestData11")
    public static final Object[][] getData11() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Crew_Member_Fix_Planning");
    }

//    /** Login page   */
//
//    @DataProvider(name = "TestData12")
//    public static final Object[][] getData12() {
//        return getMapDataFromSpreadSheet(
//                datatablepath + "ExcelData.xlsx", "Login");
//    }
    
    /** Test Data for Delete Subdivide */

    @DataProvider(name = "TestData13")
    public static final Object[][] getData13() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Crew_Member_Delete_Subdivide");
    }
   
    /** Test Data for CM Update Leave */

    @DataProvider(name = "TestData14")
    public static final Object[][] getData14() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Crew_Member_Update_Leave");
    }

    /** Test Data for Crew Member personal data update  */

    @DataProvider(name = "TestData15")
    public static final Object[][] getData15() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Crew_Member_PersonalData_Update");
    }

    
    /** Test Data for Cintra To Mistral Salary Query  */

    @DataProvider(name = "TestData16")
    public static final Object[][] getData16() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Cintra_To_Mistral_Salary_Query");
    }

    /** Test Data for Training Compliance Close Movement Ship  */

    @DataProvider(name = "TestData17")
    public static final Object[][] getData17() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Close_Movement_Ship");
    }
    
    /** Test Data for Training Compliance - Embark, disembark 'Training' ship  */

    @DataProvider(name = "TestData18")
    public static final Object[][] getData18() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Training_Compliance_Embark_Dis");
    }

    @DataProvider(name = "TestData19")
    public static final Object[][] getData19() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "HRS_Residential_Document");
    }
   
    @DataProvider(name = "TestData20")
    public static final Object[][] getData20() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Concessionaire_Edit_Plan");
    }

    @DataProvider(name = "TestData21")
    public static final Object[][] getData21() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Concessionaire_Confirm_Fix_Plan");
    }
    

    @DataProvider(name = "TestData22")
    public static final Object[][] getData22() {
        return getMapDataFromSpreadSheet(
                datatablepath + "ExcelData.xlsx", "Crew_Member_SetEmbark_ToPlanned");
    }



    
    /**
     * This method will read an excel work sheet data and return the contents as
     * Map.
     *
     * @param worksheetPath - path to the worksheet you want to read data from.
     * @param worksheetName - worksheet's name.
     * @return Object[][] - a multi dimensional object array whose elements are
     * Map<String, String>
     * @author Sumit.Saxena
     *
     */
    public static Object[][] getMapDataFromSpreadSheet(
            final String worksheetPath, final String worksheetName) {

    	ExcelUtils datatable = new ExcelUtils(worksheetPath, worksheetName);

        Map<String, String> datamap;

        int rowCount = datatable.getRowCount();
        int colCount = datatable.getColumnCount();
        Object[][] data = new Object[rowCount - 1][1];
        for (int row = 0; row < rowCount - 1; row++) {
            datamap = new HashMap<>();
            for (int col = 0; col < colCount; col++) {
                datamap.put(datatable.getCellValue(1, col),
                        datatable.getCellValue(row + 2, col));
            }
            data[row][0] = datamap;
        }
        return data;
    }

}

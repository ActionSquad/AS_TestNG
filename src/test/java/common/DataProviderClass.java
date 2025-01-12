package common;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

   
  //  private static ThreadLocal<Object[][]> threadLocalData = new ThreadLocal<>();
	
	    private static ThreadLocal<Object[][]> loginData = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> homeData = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> homegetstdData = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> registerData = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> tryeditorDataTree = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> tryeditorDataLinked = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> tryeditorDataQueue = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> tryeditorDataArray = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> tryeditorDataDS = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> tryeditorDataGraph = new ThreadLocal<>();
	    private static ThreadLocal<Object[][]> tryeditorDataStack = new ThreadLocal<>();


    public static void initializeData() throws IOException {
      
    	loginData.set(getExcelData("login"));
    	homeData.set(getExcelData("home"));
    	homegetstdData.set(getExcelData("homegetstd"));
    	registerData.set(getExcelData("register"));
    	tryeditorDataTree.set(getExcelData("tryeditor"));
    	tryeditorDataLinked.set(getExcelData("tryeditor"));
    	tryeditorDataQueue.set(getExcelData("tryeditor"));
    	tryeditorDataArray.set(getExcelData("tryeditor"));
    	tryeditorDataDS.set(getExcelData("tryeditor"));
    	tryeditorDataGraph.set(getExcelData("tryeditor"));
    	tryeditorDataStack.set(getExcelData("tryeditor"));
    		
           }

    @DataProvider(name = "loginData")
    public Object[][] getDataLogin() throws IOException {
        if (loginData.get() == null) {
            loginData.set(getExcelData("login"));
        }
        return loginData.get();
    }

    @DataProvider(name = "homedrpData")
    public Object[][] getDataDrpHome() throws IOException {
        if (homeData.get() == null) {
            homeData.set(getExcelData("home"));
        }
        return homeData.get();
    }

    @DataProvider(name = "homegetstdData")
    public Object[][] getDataHomeGetstd() throws IOException {
        if (homegetstdData.get() == null) {
            homegetstdData.set(getExcelData("homegetstd"));
        }
        return homegetstdData.get();
    }

    @DataProvider(name = "RegisterData")
    public Object[][] getDataRegister() throws IOException {
        if (registerData.get() == null) {
            registerData.set(getExcelData("register"));
        }
        return registerData.get();
    }

    @DataProvider(name = "tryeditorDataTree")
    public Object[][] getDataTryeditorTree() throws IOException {
        if (tryeditorDataTree.get() == null) {
            tryeditorDataTree.set(getExcelData("tryeditor"));
        }
        return tryeditorDataTree.get();
    }

    @DataProvider(name = "tryeditorDataLinked")
    public Object[][] getDataTryeditorLinked() throws IOException {
        if (tryeditorDataLinked.get() == null) {
            tryeditorDataLinked.set(getExcelData("tryeditor"));
        }
        return tryeditorDataLinked.get();
    }

    @DataProvider(name = "tryeditorDataQueue")
    public Object[][] getDataTryeditorQueue() throws IOException {
        if (tryeditorDataQueue.get() == null) {
            tryeditorDataQueue.set(getExcelData("tryeditor"));
        }
        return tryeditorDataQueue.get();
    }

    @DataProvider(name = "tryeditorDataArray")
    public Object[][] getDataTryeditorArray() throws IOException {
        if (tryeditorDataArray.get() == null) {
            tryeditorDataArray.set(getExcelData("tryeditor"));
        }
        return tryeditorDataArray.get();
    }

    @DataProvider(name = "tryeditorDataDS")
    public Object[][] getDataTryeditorDS() throws IOException {
        if (tryeditorDataDS.get() == null) {
            tryeditorDataDS.set(getExcelData("tryeditor"));
        }
        return tryeditorDataDS.get();
    }

    @DataProvider(name = "tryeditorDataGraph")
    public Object[][] getDataTryeditorGraph() throws IOException {
        if (tryeditorDataGraph.get() == null) {
            tryeditorDataGraph.set(getExcelData("tryeditor"));
        }
        return tryeditorDataGraph.get();
    }

    @DataProvider(name = "tryeditorDataStack")
    public Object[][] getDataTryeditorStack() throws IOException {
        if (tryeditorDataStack.get() == null) {
            tryeditorDataStack.set(getExcelData("tryeditor"));
        }
        return tryeditorDataStack.get();
    }
  
   

    //*****************************************************************************************************************************

    public static Object[][] getExcelData(String sheetName) throws IOException {
        FileInputStream excel = null;
        XSSFWorkbook workbook = null;
        Object[][] data = null;

        try {
            excel = new FileInputStream("src/test/resources/TestData/dataprovider.xlsx");
            workbook = new XSSFWorkbook(excel);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new IllegalArgumentException("Sheet \"" + sheetName + "\" does not exist in the workbook.");
            }

            int totalRows = sheet.getPhysicalNumberOfRows();
            int totalCols = sheet.getRow(0).getLastCellNum();

            data = new Object[totalRows - 1][totalCols];

            int rowIndex = 0;
            for (int i = 1; i < totalRows; i++) {
                XSSFRow row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                for (int j = 0; j < totalCols; j++) {
                    XSSFCell cell = row.getCell(j);

                    // Handle null cells
                    if (cell == null) {
                        data[rowIndex][j] = "";
                    } else {
                        // Handle different cell types
                        switch (cell.getCellType()) {
                            case STRING:
                                data[rowIndex][j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                data[rowIndex][j] = Integer.toString((int) cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                data[rowIndex][j] = cell.getBooleanCellValue();
                                break;
                            case BLANK:
                                data[rowIndex][j] = "";
                                break;
                            default:
                                data[rowIndex][j] = "";
                                break;
                        }
                    }
                }
                rowIndex++;
            }
        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (excel != null) {
                excel.close();
            }
        }

        return data;
    }
}

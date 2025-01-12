package Base;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import common.ConfigReader;
import common.DataProviderClass;
import common.ExcelReader;
import common.LoggerLoad;
import driverFactory.DriverConfig;


public class BaseTest {
 //   public WebDriver driver;

    public static List<Map<String, String>> Login;
    public static List<Map<String, String>> Code;
    public static List<Map<String, String>> Python;

    private ExcelReader excelReader;
    /*
     @BeforeClass
		public void driverSetup(){
		DriverConfig.getdriver(ConfigReader.getProperty("Browser"));
    } 
    */
//****************************************************************************************************************************   
  //To Run the Test cases in TestNg xml  
    @BeforeClass
     @Parameters({"browser"})
      public  void AsetUpDriver(String browser) {
        DriverConfig.getdriver(browser);
        LoggerLoad.info(browser + " is opened");
           
       }   
//******************************************************************************************************************************    

    
    @BeforeClass
    public void setupExcel() throws IOException {
        try {
            String path = "src/test/resources/TestData/ExcelData.xlsx";
            LoggerLoad.info("Initializing Excel Reader with path: " + path);
            excelReader = new ExcelReader();
            Login = excelReader.getData(path, "login");
            Code = excelReader.getData(path, "code");
            Python = excelReader.getData(path, "python");
        } catch (Exception e) {
        	 LoggerLoad.error("Error initializing Excel data: " + e.getMessage());
            throw new RuntimeException("Excel initialization failed", e);
        }
        DataProviderClass.initializeData();
         }
      

    @AfterClass
    public void tearDown() {
    	  LoggerLoad.info("Closing the WebDriver and Excel Reader");
                 ExcelReader.closeAllWorkbooks();
				DriverConfig.quitdriver();
       
        }
    
   
    }




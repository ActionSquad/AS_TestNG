package listenerDsalgo;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import common.CaptureScreenshot;
import driverFactory.DriverConfig;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class TestListener implements ITestListener{
	WebDriver driver = DriverConfig.getDriverInstance();
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	 @Attachment(value = "Screenshot of {0}", type = "image/png")
	    public static byte[] getScreenShot(WebDriver driver) {
		 	driver = DriverConfig.getDriverInstance();
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }
	
		
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter("./target/extent-reports/extent-report.html");
		sparkReporter.config().setDocumentTitle("DSAlgo");	
		sparkReporter.config().setReportName("ActionSquad DSAlgo");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
			
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Action Squad");
		extent.setSystemInfo("Browser name", "CrossBrowser");
		
		}
	
	public void onTestSuccess(ITestResult result) {	
		extent.createTest(result.getName())
		.log(Status.PASS, "Test case passed: "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		
		String ScreenshotName = result.getMethod().getMethodName().replace(" ", "_") + ".png";
		String ScreenshotDir = "\\screenshots\\";
		String path = System.getProperty("user.dir")+ ScreenshotDir +ScreenshotName;

		// Take Screenshot for Failed @Test & save in Screenshots folder
		CaptureScreenshot.takeScreenshot(ScreenshotName);
		
		//Add Screenshot failed @Test in Testng Report
		Reporter.log("<a href='"+path + "'> <img src='"+ path + "' height='100' width='100'/> </a>");
		
		// Add Screenshot for failed @Test in allure report 
    	getScreenShot(driver);
     	Allure.addAttachment(ScreenshotName, new ByteArrayInputStream(getScreenShot(driver)));
    	
       // Add Screenshot for failed @Test in Extent report    		
		extent.createTest(result.getName())
		.log(Status.FAIL, "Test case Failed: "+result.getName())
		.log(Status.FAIL, "Test case Failed Reason: "+result.getThrowable())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());

	}
	
	public void onTestSkipped(ITestResult result) {
		extent.createTest(result.getName())
		.log(Status.SKIP, "Retry Test case: "+result.getName());
	}
    
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}		
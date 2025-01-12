package listenerDsalgo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import driverFactory.DriverConfig;

public class ScreenshotListener implements ITestListener {
	
	
@Override	
public void onTestFailure(ITestResult result) {
		 String testName = result.getMethod().getMethodName();
	           ScreenshotListener.takeScreenshot(testName);
	}
		
	 public static void takeScreenshot(String testName) {
        WebDriver driver = DriverConfig.getDriverInstance();
        if (driver == null) {
            System.out.println("WebDriver instance is null. Cannot take screenshot.");
            return;
        }
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
            
            String screenshotName = testName.replace(" ", "_") + ".png";
          //  String screenshotName = result.getName() + "_failed.png";


            File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots/");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }

            File destinationFile = new File(screenshotsDir, screenshotName);
            try {
                FileUtils.copyFile(screenshot, destinationFile);
                Reporter.log("Screenshot saved at: " + destinationFile.getAbsolutePath(), true);
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver does not support taking screenshots.");
        }
    }
}

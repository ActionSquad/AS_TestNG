package common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import driverFactory.DriverConfig;

public class CaptureScreenshot {
	
	public static void takeScreenshot(String testName) {
		 WebDriver driver = DriverConfig.getDriverInstance();
	        if (driver == null) {
	        	LoggerLoad.info("WebDriver instance is null. Cannot take screenshot.");
	            return;
	        }
	        if (driver instanceof TakesScreenshot) {
	            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
	            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
	            String screenshotName = testName.replace(" ", "_");
	         
	            File screenshotsDir = new File("./screenshots/");
	            if (!screenshotsDir.exists()) {
	                screenshotsDir.mkdirs();
	            }

	            File destinationFile = new File(screenshotsDir, screenshotName);
	            try {
	                FileUtils.copyFile(screenshot, destinationFile);
	                Reporter.log("Screenshot saved at: " + destinationFile.getAbsolutePath(), true);
	            } catch (IOException e) {
	            	LoggerLoad.error("Failed to save screenshot: " + e.getMessage());
	                
	                e.printStackTrace();
	            }
	        } else {
	        	LoggerLoad.error("Driver does not support taking screenshots.");
	        }
	    }

}

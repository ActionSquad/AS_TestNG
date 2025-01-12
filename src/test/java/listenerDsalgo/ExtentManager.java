package listenerDsalgo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
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
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed: "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed: "+result.getName());	
		test.log(Status.FAIL, "Test case Failed Reason: "+result.getThrowable());	
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case Skipped: "+result.getName());
	}
    
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	

}

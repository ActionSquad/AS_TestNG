package pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;
import common.LoggerLoad;

public class Queue_Page {
WebDriver driver;
WebDriverWait wait;
List<Map<String, String>> Login = BaseTest.Login;
	
	@FindBy(xpath = "//a[text()='Implementation of Queue in Python']") public WebElement ImpQue;	
	@FindBy(xpath = "//a[text()='Implementation using collections.deque']") public WebElement ImpColl;	
	@FindBy(xpath = "//a[text()='Implementation using array']") public WebElement ImpArry;	
	@FindBy(xpath = "//a[text()='Queue Operations']") public WebElement QueOpr;	
	@FindBy(xpath="//button[text()='Run']") WebElement runButton; 
	@FindBy(id= "output")WebElement outputField;
	@FindBy(xpath ="//div[@class='input']/div/div/textarea") WebElement txteditorField;
	@FindBy(xpath = "//a[text()='Practice Questions']") public  WebElement PracticeQues;
	@FindBy(xpath = "//a[text()='Try here>>>']") public WebElement TryHere;
	@FindBy(linkText ="Sign out")WebElement signoutButton;
	
	
	public Queue_Page(WebDriver driver) {	 
		this.driver = driver;
	    this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	    PageFactory.initElements(driver, this);
    }
	
	public String PageTitle() {
		return driver.getTitle();	
	}
	
	public void ImpQueueLink() {
		ImpQue.click();
	}
	
	public void ImpCollLink() {
		ImpColl.click();
	}
	
	public void ImpArryLink() {
		ImpArry.click();
	}
	
	public void QueueOprLink() {
		QueOpr.click();
	}
	
	public void PracticeQuestion() {
		PracticeQues.click();
	}
	
	public void Tryhere() {
		TryHere.click();
	}
	 public void LogOut() {
		  signoutButton.click();
	}
	public void BrowserBack() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.history.back();");
		//driver.navigate().back();
	}
	 public void SignOut() {
		 signoutButton.click();
		 driver.get(common.ConfigReader.getProperty("URL"));
	}
	 public void ValidTextEditor() {
	    String code = Login.get(0).get("code");
	      {String text=code;
	      ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','"+text+"')", txteditorField);
	      txteditorField.sendKeys(code);	
	    }
	  }
	 public void RunBtn() {
		
		 runButton.click();
	 }
	 
     public String OutputTxtEditorField() {
	      String output = Login.get(0).get("output");
	      wait.until(ExpectedConditions.textToBePresentInElement(outputField,output));
	      return outputField.getText();
	    }
     
     public void TextEditor(String code) {
     	
     	{	String text=code;
     	
     ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','"+text+"')", txteditorField);
     txteditorField.sendKeys(code);
     	}
     	}
     
     public void AcceptAlert() {
         try {
             wait.until(ExpectedConditions.alertIsPresent());
             Alert alert = driver.switchTo().alert();
             alert.accept();
             System.out.println("Alert accepted successfully.");
         
         } catch (UnhandledAlertException e) {
             LoggerLoad.error("An unexpected alert handling issue occurred. Exception: " + e.getMessage());
         }
     }

     public  boolean IsAlertPresent() {
  	 try {
  	 wait.until(ExpectedConditions.alertIsPresent());
  	 return true;
    }catch (NoAlertPresentException e) {
  	return false;
  }
  }
     public String AlertText() {
     	if(IsAlertPresent()) {
     		wait.until(ExpectedConditions.alertIsPresent());
     		Alert alert = driver.switchTo().alert();
     		return alert.getText();
     	}else {
     		System.out.println("Alert is not present");
     	}
 		return null;
     }
     public Alert AssertAlert() {
         Alert alert = driver.switchTo().alert();
 		return alert;
     }

}

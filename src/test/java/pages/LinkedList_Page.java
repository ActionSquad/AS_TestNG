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

public class LinkedList_Page {

	WebDriver driver;
	WebDriverWait wait;
	List<Map<String, String>> Login = BaseTest.Login;
	
	@FindBy(xpath = "//a[text()='Introduction']") public WebElement LLIntro;	
	@FindBy(xpath = "//a[text()='Creating Linked LIst']") public WebElement LLCreateLL;	
	@FindBy(xpath = "//a[text()='Types of Linked List']") public WebElement TypeOfLL;	
	@FindBy(xpath = "//a[text()='Implement Linked List in Python']") public WebElement ImpLL;	
	@FindBy(xpath = "//a[text()='Traversal']") public WebElement LLTraversal;	
	@FindBy(xpath = "//a[text()='Insertion']") public WebElement LLInsertion;	
	@FindBy(xpath = "//a[text()='Deletion']") public WebElement LLDeletion;	
	@FindBy(xpath="//button[text()='Run']") public WebElement runButton; 
	@FindBy(id= "output")public WebElement outputField;
	@FindBy(xpath ="//div[@class='input']/div/div/textarea") public WebElement txteditorField;
	@FindBy(xpath = "//a[text()='Practice Questions']") public WebElement PracticeQues;	
	@FindBy(xpath = "//a[text()='Try here>>>']")public WebElement TryHere;
	@FindBy(xpath = "//a[text()='Sign out']")public WebElement SignOut;
	
	
	public LinkedList_Page(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
	
	public String PageTitle() {
		return driver.getTitle();	
	}
	
	public void LLIntroLink() {
		LLIntro.click();
	}
	
	public void LLCreateLLlink() {
		LLCreateLL.click();
	}
	
	public void TypeOfLLlink() {
		TypeOfLL.click();
	}
	
	public void ImpLLlink() {
		ImpLL.click();
	}
	
	public void LLTraversallink() {
		LLTraversal.click();
	}
	public void LLInsertionlink() {
		LLInsertion.click();
	}
	
	public void LLDeletionlink() {
		LLDeletion.click();
	}
	
	public void LLPracticeQues() {
		PracticeQues.click();
	}
	
	public void TryHereButton() {
		TryHere.click();
	}
	public void LogOut() {
		SignOut.click();	
	}
	public void BrowserBack() {
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
    //	js.executeScript("window.history.back();");
		driver.navigate().back();
	}
	public void SignOut() {
		 SignOut.click();
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
			// wait.until(ExpectedConditions.elementToBeClickable(runButton));
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
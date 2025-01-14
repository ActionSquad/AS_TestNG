package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverConfig;

public class Home_Page {
WebDriver driver;
WebDriverWait wait;
	
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']") public WebElement dropdownmenu;
	@FindBy(xpath = "//div[@class ='alert alert-primary']") public WebElement LoggedOutAlert;
	@FindBy(linkText ="Sign out")WebElement signoutButton;
	@FindBy(xpath = "//a[@href='linked-list']") public WebElement LinkLstGetStartedButton;
	@FindBy(xpath = "//a[@href='queue']") public WebElement QueueGetStartedButton;

	
	
	
	
	public Home_Page(WebDriver driver) {
		this.driver = driver;
		 this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
    }
	
	 public void OpenDropDown() {
			dropdownmenu.click();
		}
		
	public void clickOptionDrpdwn(String value) {
	    WebElement optionDrpdwn = driver.findElement(By.xpath("//a[text()='"+ value +"']"));
	    optionDrpdwn.click();
		    }
		 
	 public void clickOptionGetstd(String value) {
		  WebElement optionGetstd = driver.findElement(By.xpath("//a[@href='"+ value +"']"));
		  optionGetstd.click();
				    }
	 public String HomePgTitle()
			{
				return driver.getTitle();
			}

	 public void DriverNavigation() {
		// wait.until(ExpectedConditions.alertIsPresent());
		    	driver.navigate().back();  	
		    }
	 public void SignOut() {
			  signoutButton.click();
			  String url = common.ConfigReader.getProperty("URL");
			   driver.get(url);
		  }
	 
	 public void QueueBtn() {
		 QueueGetStartedButton.click();
	 	}
	 
	 public void LinkedListBtn() {
		 LinkLstGetStartedButton.click();
	 	}
	 public String LoggedOutAlert() {
			return LoggedOutAlert.getText();
		}

	 
	 
	
}  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	/*
	 	@FindBy(xpath = "//a[@href='data-structures-introduction']") public WebElement DSIntroGetStartedButton;	
	@FindBy(xpath = "//a[@href='array']") public WebElement ArrayGetStartedButton;	
	@FindBy(xpath = "//a[@href='linked-list']") public WebElement LinkLstGetStartedButton;	
	@FindBy(xpath = "//a[@href='stack']") public WebElement StackGetStartedButton;	
	@FindBy(xpath = "//a[@href='queue']") public WebElement QueueGetStartedButton;	
	@FindBy(xpath = "//a[@href='tree']") public WebElement TreeGetStartedButton;	
	@FindBy(xpath = "//a[@href='graph']") public WebElement GraphGetStartedButton;	
	@FindBy(xpath = "//a[text()='Arrays']") public WebElement Arraydrpdwn;
	@FindBy(xpath = "//a[text()='Linked List']") public WebElement LinkListdrpdwn;
	@FindBy(xpath = "//a[text()='Stack']") public WebElement Stackdrpdwn;
	@FindBy(xpath = "//a[text()='Queue']") public WebElement Queuedrpdwn;
	@FindBy(xpath = "//a[text()='Tree']") public WebElement Treedrpdwn;
	@FindBy(xpath = "//a[text()='Graph']") public WebElement Graphdrpdwn;

	  
	 */
		  
		  
		  
		  
		  
		
		//  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionGetstd);


	


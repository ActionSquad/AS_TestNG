package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import common.DataProviderClass;
import driverFactory.DriverConfig;
import pages.Home_Page;
import pages.Login_Page;
import pages.Queue_Page;

public class Queue_TestCase extends BaseTest {
	
	Queue_Page queue_page;
	Login_Page login_page;
	Home_Page home_page;
	
	@BeforeMethod
	public void setup() throws IOException {
		queue_page = new Queue_Page(DriverConfig.getDriverInstance());
		login_page = new Login_Page(DriverConfig.getDriverInstance());
		home_page = new Home_Page(DriverConfig.getDriverInstance());
	
		 
		login_page.LoginValid();
		home_page.QueueBtn();	 
	}
	
	@AfterMethod
	public void closeup() {
		queue_page.SignOut();
	}
	
	@Test
	public void queue2Impqueue(){
		queue_page.ImpQueueLink();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(25).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void queue2ImpCollection(){
		queue_page.ImpCollLink();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(26).get("title");
		Assert.assertEquals(actualTitle, expectedTitle); 
		
	}
	@Test
	public void queue2Imparray(){
		queue_page.ImpArryLink();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(27).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void queue2queueOperation(){
		queue_page.QueueOprLink();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(28).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}	
	@Test
	public void Impqueue2tryeditor(){
		queue_page.ImpQueueLink();
		queue_page.Tryhere();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		queue_page.BrowserBack();
		
	}
	
	 @Test
	    public void ImpqueueValidTryHereFunc() {
		queue_page.ImpQueueLink();
		queue_page.Tryhere();
		queue_page.ValidTextEditor();
		queue_page.RunBtn();
		String actualcode = queue_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		queue_page.BrowserBack();
		
	    }
	 
	@Test(dataProvider = "tryeditorDataQueue", dataProviderClass = DataProviderClass.class)
		public void ImpqueueInValidTryHereFunc(String Code, String alert, String error) {
		  queue_page.ImpQueueLink();
		  queue_page.Tryhere();
		  queue_page.TextEditor(Code);
		  queue_page.RunBtn();
		  if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = queue_page.AlertText();
				Assert.assertTrue(actualalert.contains(expectedalert));
			}
		  else {
			String expectedalert = alert;
			String actualalert = queue_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
				}
			queue_page.AcceptAlert();
			queue_page.BrowserBack();
			
			}
	 
	@Test
	public void ImpCollection2tryeditor() {
		queue_page.ImpCollLink();
		queue_page.Tryhere();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		queue_page.BrowserBack();	
		
	}
	
	@Test
    public void ImpCollValidTryHereFunc() {
		queue_page.ImpCollLink();
		queue_page.Tryhere();
		queue_page.ValidTextEditor();
		queue_page.RunBtn();
		String actualcode = queue_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		queue_page.BrowserBack();
		
    }
 
	@Test(dataProvider = "tryeditorDataQueue", dataProviderClass = DataProviderClass.class)
	public void ImpCollInValidTryHereFunc(String Code, String alert, String error) {
	  queue_page.ImpCollLink();
	  queue_page.Tryhere();
	  queue_page.TextEditor(Code);
	  queue_page.RunBtn();
	  if(error== "syntax") {
		String expectedalert = alert;
		String actualalert = queue_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
	  else {
		String expectedalert = alert;
		String actualalert = queue_page.AlertText();
		Assert.assertTrue(actualalert.contains(expectedalert));	
			}
		queue_page.AcceptAlert();
		queue_page.BrowserBack();
		
		}
 	
	@Test
	public void Imparray2tryeditor() {
		queue_page.ImpArryLink();
		queue_page.Tryhere();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		queue_page.BrowserBack();	
		
	}
	
	@Test
    public void ImpArrayValidTryHereFunc() {
		queue_page.ImpArryLink();
		queue_page.Tryhere();
		queue_page.ValidTextEditor();
		queue_page.RunBtn();
		String actualcode = queue_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		queue_page.BrowserBack();
		
    }
 
	@Test(dataProvider = "tryeditorDataQueue", dataProviderClass = DataProviderClass.class)
	public void ImpArrayInValidTryHereFunc(String Code, String alert, String error) {
	  queue_page.ImpArryLink();
	  queue_page.Tryhere();
	  queue_page.TextEditor(Code);
	  queue_page.RunBtn();
	  if(error== "syntax") {
		String expectedalert = alert;
		String actualalert = queue_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
	  else {
		String expectedalert = alert;
		String actualalert = queue_page.AlertText();
		Assert.assertTrue(actualalert.contains(expectedalert));	
			}
		queue_page.AcceptAlert();
		queue_page.BrowserBack();
		
		}
	
	@Test
	public void queueOpr2tryeditor() {
		queue_page.QueueOprLink();
		queue_page.Tryhere();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		queue_page.BrowserBack();	
		
	}
	
	@Test
    public void QueueOprValidTryHereFunc() {
		queue_page.QueueOprLink();
		queue_page.Tryhere();
		queue_page.ValidTextEditor();
		queue_page.RunBtn();
		String actualcode = queue_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		queue_page.BrowserBack();
		
    }
 
	@Test(dataProvider = "tryeditorDataQueue", dataProviderClass = DataProviderClass.class)
	public void QueueOprInValidTryHereFunc(String Code, String alert, String error) {
		queue_page.QueueOprLink();
		queue_page.Tryhere();
		queue_page.TextEditor(Code);
		queue_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = queue_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = queue_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		queue_page.AcceptAlert();
		queue_page.BrowserBack();
		
		}	
	@Test
	public void Impqueue2PrctQues() {
		queue_page.ImpQueueLink();
		queue_page.PracticeQuestion();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(43).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void queue2signout() {
		queue_page.LogOut();
		String actualTitle = queue_page.PageTitle();
		String expectedTitle = Login.get(0).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
		String actualAlert = home_page.LoggedOutAlert();
		String expectedAlert = Login.get(4).get("alert");
		Assert.assertEquals(actualAlert,expectedAlert);
		login_page.LoginValid();
		
	}	
}
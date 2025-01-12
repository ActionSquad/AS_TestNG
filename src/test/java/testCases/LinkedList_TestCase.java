package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import common.DataProviderClass;
import driverFactory.DriverConfig;
import pages.Home_Page;
import pages.LinkedList_Page;
import pages.Login_Page;


public class LinkedList_TestCase extends BaseTest {
	LinkedList_Page linkedlist_page;
	Login_Page login_page;
	Home_Page home_page;
	
	@BeforeMethod
	public void setup() throws IOException {
		linkedlist_page = new LinkedList_Page(DriverConfig.getDriverInstance());
		login_page = new Login_Page(DriverConfig.getDriverInstance());
		home_page = new Home_Page(DriverConfig.getDriverInstance());
	
		 
		login_page.LoginValid();
		home_page.LinkedListBtn();
	}
	
	
	@AfterMethod
	public void closeup(ITestResult result) {
		
	    if ("LLlogout".equals(result.getMethod().getMethodName())) {
	        return;
	    }
	    linkedlist_page.SignOut(); 
	    }
	
	@Test
	public void LL2Intro() {
		linkedlist_page.LLIntroLink();	
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(13).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LL2CreateLL() {
		linkedlist_page.LLCreateLLlink();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(14).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LL2TypesLL() {
		linkedlist_page.TypeOfLLlink();	
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(15).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LL2ImpLL() {
		linkedlist_page.ImpLLlink();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(16).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LL2Traversal() {
		linkedlist_page.LLTraversallink();	
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(17).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LL2Insertion() {
		linkedlist_page.LLInsertionlink();	
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(18).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LL2Deletion() {
		linkedlist_page.LLDeletionlink();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(19).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LLIntro2TryEditor() {
		linkedlist_page.LLIntroLink();	
		linkedlist_page.TryHereButton();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		linkedlist_page.BrowserBack();
		
	}

	@Test
    public void LLIntroValidTryHereFunc() {
		linkedlist_page.LLIntroLink();	
		linkedlist_page.TryHereButton();
		linkedlist_page.ValidTextEditor();
		linkedlist_page.RunBtn();
		String actualcode = linkedlist_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		linkedlist_page.BrowserBack();
		
    }
 
	  @Test(dataProvider = "tryeditorDataLinked", dataProviderClass = DataProviderClass.class)
	public void LLIntroInValidTryHereFunc(String Code, String alert, String error) {
		linkedlist_page.LLIntroLink();	
		linkedlist_page.TryHereButton();
		linkedlist_page.TextEditor(Code);
		linkedlist_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		linkedlist_page.AcceptAlert();
		linkedlist_page.BrowserBack();
		
		}	

	@Test
	public void CreateLL2TryEditor() {
		linkedlist_page.LLCreateLLlink();	
		linkedlist_page.TryHereButton();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		linkedlist_page.BrowserBack();
		
	}

	@Test
    public void CreateLLValidTryHereFunc() {
		linkedlist_page.LLCreateLLlink();	
		linkedlist_page.TryHereButton();
		linkedlist_page.ValidTextEditor();
		linkedlist_page.RunBtn();
		String actualcode = linkedlist_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		linkedlist_page.BrowserBack();	
		
    }
 
	   @Test(dataProvider = "tryeditorDataLinked", dataProviderClass = DataProviderClass.class)
	public void CreateLLInValidTryHereFunc(String Code, String alert, String error) {
		linkedlist_page.LLCreateLLlink();	
		linkedlist_page.TryHereButton();
		linkedlist_page.TextEditor(Code);
		linkedlist_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		linkedlist_page.AcceptAlert();
		linkedlist_page.BrowserBack();
		
		}	

	@Test
	public void TypesLL2TryEditor() {
		linkedlist_page.TypeOfLLlink();	
		linkedlist_page.TryHereButton();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		linkedlist_page.BrowserBack();
		
	}

	@Test
    public void TypesLLValidTryHereFunc() {
		linkedlist_page.TypeOfLLlink();		
		linkedlist_page.TryHereButton();
		linkedlist_page.ValidTextEditor();
		linkedlist_page.RunBtn();
		String actualcode = linkedlist_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		linkedlist_page.BrowserBack();
		
    }
 
	   @Test(dataProvider = "tryeditorDataLinked", dataProviderClass = DataProviderClass.class)
	public void TypesLLInValidTryHereFunc(String Code, String alert, String error) {
		linkedlist_page.TypeOfLLlink();		
		linkedlist_page.TryHereButton();
		linkedlist_page.TextEditor(Code);
		linkedlist_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		linkedlist_page.AcceptAlert();
		linkedlist_page.BrowserBack();
		
		}	

	@Test
	public void ImpLL2TryEditor() {
		linkedlist_page.ImpLLlink();
		linkedlist_page.TryHereButton();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		linkedlist_page.BrowserBack();	
		
	}

	@Test
    public void ImpLLValidTryHereFunc() {
		linkedlist_page.ImpLLlink();	
		linkedlist_page.TryHereButton();
		linkedlist_page.ValidTextEditor();
		linkedlist_page.RunBtn();
		String actualcode = linkedlist_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		linkedlist_page.BrowserBack();	
		
    }
 
	   @Test(dataProvider = "tryeditorDataLinked", dataProviderClass = DataProviderClass.class)
	public void ImpLLInValidTryHereFunc(String Code, String alert, String error) {
		linkedlist_page.ImpLLlink();		
		linkedlist_page.TryHereButton();
		linkedlist_page.TextEditor(Code);
		linkedlist_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		linkedlist_page.AcceptAlert();
		linkedlist_page.BrowserBack();
		
		}	


	@Test
	public void Traversal2TryEditor() {
		linkedlist_page.LLTraversallink();	
		linkedlist_page.TryHereButton();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		linkedlist_page.BrowserBack();
		
	}
	
	@Test
    public void TraversalValidTryHereFunc() {
		linkedlist_page.LLTraversallink();		
		linkedlist_page.TryHereButton();
		linkedlist_page.ValidTextEditor();
		linkedlist_page.RunBtn();
		String actualcode = linkedlist_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		linkedlist_page.BrowserBack();
		
    }
 
	   @Test(dataProvider = "tryeditorDataLinked", dataProviderClass = DataProviderClass.class)
	public void TraversalInValidTryHereFunc(String Code, String alert, String error) {
		linkedlist_page.LLTraversallink();			
		linkedlist_page.TryHereButton();
		linkedlist_page.TextEditor(Code);
		linkedlist_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		linkedlist_page.AcceptAlert();
		linkedlist_page.BrowserBack();
		
		}	

	@Test
	public void Insertion2TryEditor() {
		linkedlist_page.LLInsertionlink();	
		linkedlist_page.TryHereButton();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		linkedlist_page.BrowserBack();
		
	}
	
	@Test
    public void InsertionValidTryHereFunc() {
		linkedlist_page.LLInsertionlink();			
		linkedlist_page.TryHereButton();
		linkedlist_page.ValidTextEditor();
		linkedlist_page.RunBtn();
		String actualcode = linkedlist_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		linkedlist_page.BrowserBack();
		
    }
 
	   @Test(dataProvider = "tryeditorDataLinked", dataProviderClass = DataProviderClass.class)
	public void InsertionInValidTryHereFunc(String Code, String alert, String error) {
		linkedlist_page.LLInsertionlink();				
		linkedlist_page.TryHereButton();
		linkedlist_page.TextEditor(Code);
		linkedlist_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		linkedlist_page.AcceptAlert();
		linkedlist_page.BrowserBack();
		
		}	

	@Test
	public void Deletion2TryEditor() {
		linkedlist_page.LLDeletionlink();	
		linkedlist_page.TryHereButton();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		linkedlist_page.BrowserBack();
		
	}

	@Test
    public void DeletionValidTryHereFunc() {
		linkedlist_page.LLDeletionlink();			
		linkedlist_page.TryHereButton();
		linkedlist_page.ValidTextEditor();
		linkedlist_page.RunBtn();
		String actualcode = linkedlist_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		linkedlist_page.BrowserBack();	
		
    }
 
	   @Test(dataProvider = "tryeditorDataLinked", dataProviderClass = DataProviderClass.class)
	public void DeletionInValidTryHereFunc(String Code, String alert, String error) {
		linkedlist_page.LLDeletionlink();			
		linkedlist_page.TryHereButton();
		linkedlist_page.TextEditor(Code);
		linkedlist_page.RunBtn();
		if(error== "syntax") {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = linkedlist_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		linkedlist_page.AcceptAlert();
		linkedlist_page.BrowserBack();
		
		}	

	@Test
	public void LLIntro2PracticeQues() {
		linkedlist_page.LLIntroLink();	
		linkedlist_page.LLPracticeQues();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(43).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void LLlogout() {
		linkedlist_page.LogOut();
		String actualTitle = linkedlist_page.PageTitle();
		String expectedTitle = Login.get(0).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);	
	}
	
	
}
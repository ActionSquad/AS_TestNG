package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.BaseTest;
import common.DataProviderClass;
import driverFactory.DriverConfig;
import pages.Login_Page;

public class Login_TestCase extends BaseTest {
	
	Login_Page login_page ;
	
	@BeforeMethod
	public void setup() throws IOException
	{	
		 login_page = new Login_Page(DriverConfig.getDriverInstance());

		 login_page.SignInPage();
		
	}
	@AfterMethod
	public void closeup() {
		login_page.NumpyNinja();
	}
	
	  @Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class)
		
	  public void InvalidLogin(String username, String Password, String ExpectedAlert, String Group) {
		  
		 login_page.Credentials(username, Password);
		 login_page.LoginButton();  
		 
		 if("Inspectable".equals(Group)) {
	            	String actualAlert = login_page.ValidandInvalidcredAlert();
	            	String expectedAlert = ExpectedAlert.trim();
	                Assert.assertEquals(actualAlert, expectedAlert);   
	        } else if("useralert".equals(Group)) {
		            String actualAlert = login_page.errmsg(login_page.usernameField);
		            Assert.assertEquals(actualAlert, ExpectedAlert);
		           
	        } else if("passalert".equals(Group)) {      
	    		     String actualAlert = login_page.errmsg(login_page.passwordField);
	    		     Assert.assertEquals(actualAlert, ExpectedAlert);
	        	 }
	        }
	  @Test
	  public void ValidLogin() {
		  login_page.SignInwithCred();
		  String actualAlert = login_page.ValidandInvalidcredAlert();
		  String expectedAlert = Login.get(2).get("alert"); 
		  Assert.assertEquals(expectedAlert, actualAlert); 
	  }
	  @Test
	  public void ToRegPage() {
		  login_page.RegisterButton();
		  String actualAlert = login_page.PageTitle();
		  String expectedAlert = Login.get(45).get("title");
		  Assert.assertEquals(expectedAlert, actualAlert);
		  
	  }
	  @Test
	  public void SignOut() {
		  login_page.SignInwithCred();
		  login_page.LogoutButton();
		  String actualAlert = login_page.ValidandInvalidcredAlert();
		  String expectedAlert = Login.get(4).get("alert");
		  Assert.assertEquals(expectedAlert, actualAlert);
	  }
	      
}




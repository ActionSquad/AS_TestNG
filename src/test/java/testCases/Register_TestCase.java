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
import pages.Register_Page;


public class Register_TestCase extends BaseTest {
	
	Register_Page register_page ;
	Login_Page login_page ;
	
	@BeforeMethod
	public void setup() throws IOException {
		 register_page = new Register_Page(DriverConfig.getDriverInstance());
		 login_page = new Login_Page(DriverConfig.getDriverInstance());
	
		  login_page.GetstdButton();
		  register_page.RegMainBtn(); 
	}
	@AfterMethod
	public void closeup() {
		login_page.NumpyNinja();
	}
	  @Test(dataProvider = "RegisterData", dataProviderClass = DataProviderClass.class)
	public void InvalidRegister(String username, String Password, String confpassword, String expectedalert, String error) {
		  register_page.Credentials(username, Password, confpassword);
		  register_page.RegisterBtn();
		  
		  if("Invaliduser".equals(error)) {
			  String actualalert = register_page.RegAlert();
			  Assert.assertEquals(expectedalert,actualalert);
		  }
		  else if("existing".equals(error)) {
			  String actualalert = register_page.RegAlert();
			  Assert.assertEquals(expectedalert,actualalert);	  	  
		  }
		  else if("emptyuser".equals(error)) {
			  String actualalert = login_page.errmsg(register_page.usernameField);
			  Assert.assertEquals(expectedalert,actualalert);
		  }
		  else if("Invalidpass".equals(error)) {
			  String actualalert = register_page.RegAlert();
			  Assert.assertEquals(expectedalert,actualalert);  
          }
		  else if("emptypass".equals(error)) {
			  String actualalert = login_page.errmsg(register_page.passwordField);
			  Assert.assertEquals(expectedalert,actualalert);  
          }
		  else if("mismatch".equals(error)) {
			  String actualalert = register_page.RegAlert();
			  Assert.assertTrue(actualalert.contains(expectedalert));  
          }	  
		  else if("emptyconfpass".equals(error)) {
		    String actualalert = login_page.errmsg(register_page.confirmpassField);
			Assert.assertEquals(expectedalert, actualalert); 		  
      }
	  }	  
	  @Test
	  public void ToLogin()
	  {
		  register_page.LoginLinkBtn();
		  String actualTitle = login_page.PageTitle();
		  String expectedTitle = Login.get(44).get("title"); 
		  Assert.assertEquals(actualTitle, expectedTitle);
	  }
}	  
	  
	  
	  
	  
	  
	  
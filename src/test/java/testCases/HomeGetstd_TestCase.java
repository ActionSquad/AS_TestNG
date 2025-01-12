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

public class HomeGetstd_TestCase extends BaseTest{

	Home_Page home_page;
	Login_Page login_page;
	
	@BeforeMethod
	public void setup() throws IOException {
		 login_page = new Login_Page(DriverConfig.getDriverInstance());
		 home_page = new Home_Page(DriverConfig.getDriverInstance());
	
		 
		 login_page.LoginValid();
	}
	@AfterMethod
	public void closeup() {
		home_page.SignOut();
	}
	
	
	 @Test(dataProvider = "homegetstdData", dataProviderClass = DataProviderClass.class)
		public void HomeGetstd(String values, String title) {
		
			home_page.clickOptionGetstd(values);

			 if("Array".equals(title)) {
		         	String actualAlert = home_page.HomePgTitle();
		            Assert.assertEquals(actualAlert, title);   
		            
		     } else if("Linked List".equals(title)) {
		         	String actualAlert = home_page.HomePgTitle();
		            Assert.assertEquals(actualAlert, title);
			           
		     }else if("Stack".equals(title)) {
		      	String actualAlert = home_page.HomePgTitle();
		        Assert.assertEquals(actualAlert, title);
				 
			 }else if("Graph".equals(title)) {
			      	String actualAlert = home_page.HomePgTitle();
			        Assert.assertEquals(actualAlert, title);
			 
		     }else if("Queue".equals(title)) {
		        	String actualAlert = home_page.HomePgTitle();
		           Assert.assertEquals(actualAlert, title);
		     
		     }else if("Tree".equals(title)) {
		  	String actualAlert = home_page.HomePgTitle();
		    Assert.assertEquals(actualAlert, title);
			 
	         }else if("DataStructures-Introduction".equals(title)) {
		  	String actualAlert = home_page.HomePgTitle();
		    Assert.assertEquals(actualAlert, title);
			}
			
			}
	 

	
}

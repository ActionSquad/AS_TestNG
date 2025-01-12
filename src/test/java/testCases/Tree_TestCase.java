package testCases;


import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.BaseTest;
import common.DataProviderClass;
import driverFactory.DriverConfig;
import listenerDsalgo.RetryAnalyzer;
import pages.Home_Page;
import pages.Login_Page;
import pages.Tree_Page;



public class Tree_TestCase extends BaseTest {
	Tree_Page tree_page;
	Login_Page login_page;
	Home_Page home_page;
	
	
	@BeforeMethod
 
	public void setup() throws IOException {

		login_page = new Login_Page(DriverConfig.getDriverInstance());
		 tree_page = new Tree_Page(DriverConfig.getDriverInstance());
		 home_page = new Home_Page(DriverConfig.getDriverInstance());
		
		
		 login_page.LoginValid();
		 tree_page.GetStdButton();
		
	}
	
	@AfterMethod
	public void closeup(ITestResult result) {
		
	    if ("LogOut".equals(result.getMethod().getMethodName())) {
	        return;
	    }
	      home_page.SignOut(); 
	    }
	
	/*@AfterMethod
	public void closeup() {
		 home_page.SignOut();
	}*/
	

	@Test
	public void NavtoOverviewofTrees() {
		tree_page.OverviewBtn();	
		String actualTitle = login_page.PageTitle();
		String expectedTitle = Login.get(1).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		 
	}

	@Test
	public void NavtoTryherepg() {
		
		tree_page.OverviewBtn();
		tree_page.TryhereBtn();
		String actualTitle = login_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		tree_page.RunBtn();
		tree_page.DriverNavigation();
		 
	}
  
    @Test
    public void ValidTryHereFunctionalityOverview() {
    	tree_page.OverviewBtn();
		tree_page.TryhereBtn();
		tree_page.ValidTextEditor();
		tree_page.RunBtn();
		String actualcode = tree_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		 tree_page.DriverNavigation();	
		 
    }
    
    @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
	public void InvalidTryHereFunctionalityOverview(String Code, String alert, String error) {
    	
		tree_page.OverviewBtn();
		tree_page.TryhereBtn();
		tree_page.TextEditor(Code);
		tree_page.RunBtn();
    		    
	    
		if(error== "syntax") {
			
			String expectedalert = alert;
			String actualalert = tree_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = tree_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		tree_page.AcceptAlert();
	    tree_page.DriverNavigation();
	    
	}
    @Test
    public void EmptyTryeditorOverview() {
    	tree_page.OverviewBtn();
		tree_page.TryhereBtn();
		tree_page.RunBtn();
	
		try {
		    Alert alert = 	tree_page.AssertAlert();
		    String actualAlert =alert.getText();
		    Assert.assertNotNull(actualAlert);
		    	}catch(NoAlertPresentException e){
		    		Assert.fail("Alert is not present");
		    	}finally {
		    		tree_page.DriverNavigation();
		    	}
		
		 	    }
		    	
    

    
//*******************************************************************************************************************************
//2.Terminologies
    
    @Test
	public void Terminologies() {
		tree_page.TerminologiesBtn();	
		String actualTitle = login_page.PageTitle();
        String expectedTitle = Login.get(29).get("title");
        Assert.assertEquals(actualTitle,expectedTitle);
        
	}
	@Test
	public void NavtoTryherepgTermimology() {
		
		tree_page.TerminologiesBtn();
		tree_page.TryhereBtn();
		String actualTitle = login_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		tree_page.RunBtn();
		tree_page.DriverNavigation();	
		 
	}
  
    @Test
    public void ValidTryHereFunctionalityTerm() {
    	tree_page.TerminologiesBtn();
		tree_page.TryhereBtn();
		tree_page.ValidTextEditor();
		tree_page.RunBtn();
		String actualcode = tree_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		 tree_page.DriverNavigation();	
		 
    }
    
    @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
	public void InvalidTryHereFunctionalityTerm(String Code, String alert, String error) {
    	
    	tree_page.TerminologiesBtn();
		tree_page.TryhereBtn();
		tree_page.TextEditor(Code);
		tree_page.RunBtn();
    		    
	    
		if(error== "syntax") {
			
			String expectedalert = alert;
			String actualalert = tree_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = tree_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		tree_page.AcceptAlert();
	    tree_page.DriverNavigation();
	    
	}
    
    @Test
    public void EmptyTryeditorTerminologies() {
    	tree_page.TerminologiesBtn();
		tree_page.TryhereBtn();
		tree_page.RunBtn();
	
		try {
		    Alert alert = 	tree_page.AssertAlert();
		    String actualAlert =alert.getText();
		    Assert.assertNotNull(actualAlert);
		    	}catch(NoAlertPresentException e){
		    		Assert.fail("Alert is not present");
		    	}finally {
		    		tree_page.DriverNavigation();
		    	}
		
		 	    }
//******************************************************************************************************************************
    //3.Types of trees
    
    
    @Test(retryAnalyzer = RetryAnalyzer.class)
   	public void TypesofTrees() {
   		tree_page.TypesOfTreesBtn();	
   		String actualTitle = login_page.PageTitle();
  	    String expectedTitle = Login.get(30).get("title");
        Assert.assertEquals(actualTitle,expectedTitle);
        
   	}
   	@Test
   	public void NavtoTryherepgTypesofTrees() {
   		tree_page.TypesOfTreesBtn();
   		tree_page.TryhereBtn();
   		String actualTitle = login_page.PageTitle();
		String expectedTitle = Login.get(3).get("title");
		Assert.assertEquals(actualTitle, expectedTitle);
		tree_page.RunBtn();
   		tree_page.DriverNavigation();
   	 
   	   	}
     
       @Test
       public void ValidTryHereFunctionalityTypesoftrees() {
       	tree_page.TerminologiesBtn();
   		tree_page.TryhereBtn();
   		tree_page.ValidTextEditor();
   		tree_page.RunBtn();
   		String actualcode = tree_page.OutputTxtEditorField();
   		String expectedcode = Login.get(0).get("output");
   		Assert.assertEquals(actualcode,expectedcode );
   		 tree_page.DriverNavigation();	
   		 
       }
       
       @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
	   	public void InvalidTryHereFunctionalityTYpesofTrees(String Code, String alert, String error) {
	    	  
	       	tree_page.TypesOfTreesBtn();
	   		tree_page.TryhereBtn();
	   		tree_page.TextEditor(Code);
	   		tree_page.RunBtn();
	       		    
	   	    
	   		if(error== "syntax") {
	   			
	   			String expectedalert = alert;
	   			String actualalert = tree_page.AlertText();
	   			Assert.assertTrue(actualalert.contains(expectedalert));
	   		}
	   		else {
	   			String expectedalert = alert;
	   			String actualalert = tree_page.AlertText();
	   			Assert.assertTrue(actualalert.contains(expectedalert));	
	   		}
	   		tree_page.AcceptAlert();
	   	    tree_page.DriverNavigation();
	   	    
	   	}
       
       @Test
       public void EmptyTryeditorTypesofTrees() {
    	tree_page.TypesOfTreesBtn();
   		tree_page.TryhereBtn();
   		tree_page.RunBtn();
   	
   		try {
   		    Alert alert = 	tree_page.AssertAlert();
   		    String actualAlert =alert.getText();
   		    Assert.assertNotNull(actualAlert);
   		    	}catch(NoAlertPresentException e){
   		    		Assert.fail("Alert is not present");
   		    	}finally {
   		    		tree_page.DriverNavigation();
   		    	}
   		
   		 	    }
//*********************************************************************************************************************************
       //4.Treetraversals
     
        
       @Test
      	public void TreeTraversals() {
      		tree_page.TreeTraversalsBtn();	
      		String actualTitle = login_page.PageTitle();
      	    String expectedTitle = Login.get(31).get("title");
            Assert.assertEquals(actualTitle,expectedTitle);
            
      	}
      	@Test
      	public void NavtoTryherepgTreeTraversals() {
      		
      		tree_page.TreeTraversalsBtn();
      		tree_page.TryhereBtn();
      		String actualTitle = login_page.PageTitle();
    		String expectedTitle = Login.get(3).get("title");
    		Assert.assertEquals(actualTitle, expectedTitle);
    		tree_page.RunBtn();
      		tree_page.DriverNavigation();
      		 
      	}
       
       
    
          @Test
          public void ValidTryHereFunctionalityTreeTraversals() {
          	tree_page.TreeTraversalsBtn();
      		tree_page.TryhereBtn();
      		tree_page.ValidTextEditor();
      		tree_page.RunBtn();
      		String actualcode = tree_page.OutputTxtEditorField();
      		String expectedcode = Login.get(0).get("output");
      		Assert.assertEquals(actualcode,expectedcode );
      		 tree_page.DriverNavigation();	
      		 
          }
          
          @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
	      	public void InvalidTryHereFunctionalityTreeTraversals(String Code, String alert, String error) {
	    	 
	          	tree_page.TreeTraversalsBtn();
	      		tree_page.TryhereBtn();
	      		tree_page.TextEditor(Code);
	      		tree_page.RunBtn();
	          		    
	      	    
	      		if(error== "syntax") {
	      			
	      			String expectedalert = alert;
	      			String actualalert = tree_page.AlertText();
	      			Assert.assertTrue(actualalert.contains(expectedalert));
	      		}
	      		else {
	      			String expectedalert = alert;
	      			String actualalert = tree_page.AlertText();
	      			Assert.assertTrue(actualalert.contains(expectedalert));	
	      		}
	      		tree_page.AcceptAlert();
	      	    tree_page.DriverNavigation();
	      	  
	      	}

          @Test
          public void EmptyTryeditorTreeTraversals() {
            tree_page.TreeTraversalsBtn();
      		tree_page.TryhereBtn();
      		tree_page.RunBtn();
      	
      		try {
      		    Alert alert = 	tree_page.AssertAlert();
      		    String actualAlert =alert.getText();
      		    Assert.assertNotNull(actualAlert);
      		    	}catch(NoAlertPresentException e){
      		    		Assert.fail("Alert is not present");
      		    	}finally {
      		    		tree_page.DriverNavigation();
      		    	}
      		
      		 	    }
 // ********************************************************************************************************************
         //5.Travels-Illustration
          
          @Test
        	public void TravelsIllus() {
        		tree_page.TraversalsIllusBtn();	
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(32).get("title");
        	    Assert.assertEquals(actualTitle,expectedTitle);
        	    
        	
        	}
        	@Test
        	public void NavtoTryherepgTravelsIllus() {
        		
        		tree_page.TraversalsIllusBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        	    tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		 
        	}
                     
            @Test
            public void ValidTryHereFunctionalityTraversalsIllus() {
            	tree_page.TraversalsIllusBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
            }   
            
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityTraversalsIllus(String Code, String alert, String error) {
           	
               	tree_page.TraversalsIllusBtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	 
           	}
            
            @Test
            public void EmptyTryeditorTravelsIllus() {
            	tree_page.TraversalsIllusBtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }
//********************************************************************************************************************************
   //6. BinaryTree
            
            @Test
        	public void BibaryTree() {
        		tree_page.BinaryTreeBtn();
        		 String actualTitle = login_page.PageTitle();
        		  String expectedTitle = Login.get(33).get("title");
        	      Assert.assertEquals(actualTitle,expectedTitle);
        	      
        	}
        	@Test
        	public void NavtoTryherepgBT() {
           		tree_page.BinaryTreeBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		
        		
        	}
       
            @Test
            public void ValidTryHereFunctionalityBT() {
            	tree_page.BinaryTreeBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
            }  
       	 @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
        	public void InvalidTryHereFunctionalityBT(String Code, String alert, String error) {
        	
        	    tree_page.BinaryTreeBtn();
        		tree_page.TryhereBtn();
        		tree_page.TextEditor(Code);
        		tree_page.RunBtn();
            		    
        	    
        		if(error== "syntax") {
        			
        			String expectedalert = alert;
        			String actualalert = tree_page.AlertText();
        			Assert.assertTrue(actualalert.contains(expectedalert));
        		}
        		else {
        			String expectedalert = alert;
        			String actualalert = tree_page.AlertText();
        			Assert.assertTrue(actualalert.contains(expectedalert));	
        		}
        		tree_page.AcceptAlert();
        	    tree_page.DriverNavigation();
        	 
        	}
       	 
       	 @Test
         public void EmptyTryeditorBT() {
       	   tree_page.BinaryTreeBtn();
     		tree_page.TryhereBtn();
     		tree_page.RunBtn();
     	
     		try {
     		    Alert alert = 	tree_page.AssertAlert();
     		    String actualAlert =alert.getText();
     		    Assert.assertNotNull(actualAlert);
     		    	}catch(NoAlertPresentException e){
     		    		Assert.fail("Alert is not present");
     		    	}finally {
     		    		tree_page.DriverNavigation();
     		    	}
     		
     		 	    }
//*************************************************************************************************************************
    //7.Types of BinaryTrees
            @Test
        	public void TypesofBT() {
            	tree_page.TypesBTBtn();
        		String actualTitle = login_page.PageTitle();
        		 String expectedTitle = Login.get(34).get("title");
        	     Assert.assertEquals(actualTitle,expectedTitle);
        	     
        	}
        	@Test
        	public void NavtoTryherepgTypesofBT() {
        	
        		tree_page.TypesBTBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		 
        	   	}
                        
            @Test
            public void ValidTryHereFunctionalityTypesofBT() {
            	tree_page.TypesBTBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
            }  
            
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityTypesofBT(String Code, String alert, String error) {
           	
           	    tree_page.TypesBTBtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	 
           	}
            
            @Test
            public void EmptyTryeditorTypesofBT() {
            	tree_page.TypesBTBtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }
//*******************************************************************************************************************************
    //8.Implementation In Python
         
            @Test
        	public void ImpinBT() {
        		tree_page.ImpPythonBtn();
        		String actualTitle = login_page.PageTitle();
        	    String expectedTitle = Login.get(35).get("title");
        	    Assert.assertEquals(actualTitle,expectedTitle);
        	    

        	}
        	@Test
        	public void NavtoTryherepgImpinBT() {
        		tree_page.ImpPythonBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		 
        		
        	}
       
            @Test
            public void ValidTryHereFunctionalityImpinBT() {
            	tree_page.ImpPythonBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
            }    
            
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityImpinBT(String Code, String alert, String error) {
           	
           	   tree_page.ImpPythonBtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	 
           	}
            
            @Test
            public void EmptyTryeditorImpinBT() {
            	tree_page.ImpPythonBtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }
 //*************************************************************************************************************************
     //9. Binary Tree Traversals
            @Test
        	public void BinTreeTrav() {
        		tree_page.BinTreeTravBtn();
            	 String actualTitle = login_page.PageTitle();
        	    String expectedTitle = Login.get(36).get("title");
                Assert.assertEquals(actualTitle,expectedTitle);
                
        	}
        	@Test
        	public void NavtoTryherepgBinTreeTrav() {
           		tree_page.BinTreeTravBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		//tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		 
        		
        	}
         
         
      
            @Test
            public void ValidTryHereFunctionalityBinTreeTrav() {
            	tree_page.BinTreeTravBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
            } 
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityBinTreeTrav(String Code, String alert, String error) {
           	
           	    tree_page.BinTreeTravBtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	 
           	}
            
            @Test
            public void EmptyTryeditorBinTreeTrav() {
            	tree_page.BinTreeTravBtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }
//******************************************************************************************************************************
     //10.Implementation of Binary Tree
            
            @Test
        	public void IBT() {
        		tree_page.IBTBtn();
        		String actualTitle = login_page.PageTitle();
        	    String expectedTitle = Login.get(37).get("title");
        		Assert.assertEquals(actualTitle,expectedTitle);
        		 
        	}
        	@Test
        	public void NavtoTryherepgIBT() {
           		tree_page.IBTBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		 
            	}
                       
            @Test
            public void ValidTryHereFunctionalityIBT() {
            	tree_page.IBTBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
            }     
            
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityIBT(String Code, String alert, String error) {
           	
           	    tree_page.IBTBtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	 
           	}
            
            @Test
            public void EmptyTryeditorIBT() {
            	tree_page.IBTBtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }
//***************************************************************************************************************************
 //  11.Applications of Binary Tree
            
            @Test
        	public void ABT() {
        		tree_page.ABTBtn();
        		String actualTitle = login_page.PageTitle();
        	    String expectedTitle = Login.get(38).get("title");
        		Assert.assertEquals(actualTitle,expectedTitle);
        		 
            }
        	
           	@Test
        	public void NavtoTryherepgABT() {
           		tree_page.ABTBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		        		
        	}
      
            @Test
            public void ValidTryHereFunctionalityABT() {
            	tree_page.ABTBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
      
            }
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityABT(String Code, String alert, String error) {
           	
           	    tree_page.ABTBtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	}
            
            @Test
            public void EmptyTryeditorABT() {
            	tree_page.ABTBtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }
            
 //***********************************************************************************************************           
    //12.Binary Search Tree
            @Test
        	public void BST() {
        		tree_page.BSTbtn();
        		String actualTitle = login_page.PageTitle();
        	    String expectedTitle = Login.get(39).get("title");
        		Assert.assertEquals(actualTitle,expectedTitle);
        		 
        	
        	}
        	@Test
        	public void NavtoTryherepgBST() {
        		
        		tree_page.BSTbtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		 
        		
        	}
       
            @Test
            public void ValidTryHereFunctionalityBST() {
            	tree_page.BSTbtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
      
            }
            
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityBST(String Code, String alert, String error) {
           	
           	    tree_page.BSTbtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	 
           	}
            
            @Test
            public void EmptyTryeditorBST() {
            	tree_page.BSTbtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }
//******************************************************************************************************************************
    //13. Implementation Of BST
  
            @Test
        	public void IBST() {
        		tree_page.IBSTBtn();
        		String actualTitle = login_page.PageTitle();
        	    String expectedTitle = Login.get(40).get("title");
        		Assert.assertEquals(actualTitle,expectedTitle);
        		 

        	
        	}
        	@Test
        	public void NavtoTryherepgIBST() {
        	
        		tree_page.IBSTBtn();
        		tree_page.TryhereBtn();
        		String actualTitle = login_page.PageTitle();
        		String expectedTitle = Login.get(3).get("title");
        		Assert.assertEquals(actualTitle, expectedTitle);
        		tree_page.RunBtn();
        		tree_page.DriverNavigation();
        		 
        	}
       
            @Test
            public void ValidTryHereFunctionalityIBST() {
            	tree_page.IBSTBtn();
        		tree_page.TryhereBtn();
        		tree_page.ValidTextEditor();
        		tree_page.RunBtn();
        		String actualcode = tree_page.OutputTxtEditorField();
        		String expectedcode = Login.get(0).get("output");
        		Assert.assertEquals(actualcode,expectedcode );
        		 tree_page.DriverNavigation();	
        		 
            }
            
            @Test(dataProvider = "tryeditorDataTree", dataProviderClass = DataProviderClass.class)
           	public void InvalidTryHereFunctionalityIBST(String Code, String alert, String error) {
           	
           	    tree_page.IBSTBtn();
           		tree_page.TryhereBtn();
           		tree_page.TextEditor(Code);
           		tree_page.RunBtn();
               		    
           	    
           		if(error== "syntax") {
           			
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));
           		}
           		else {
           			String expectedalert = alert;
           			String actualalert = tree_page.AlertText();
           			Assert.assertTrue(actualalert.contains(expectedalert));	
           		}
           		tree_page.AcceptAlert();
           	    tree_page.DriverNavigation();
           	 
           	}
            
            @Test
            public void EmptyTryeditorIBST() {
            	tree_page.IBSTBtn();
        		tree_page.TryhereBtn();
        		tree_page.RunBtn();
        	
        		try {
        		    Alert alert = 	tree_page.AssertAlert();
        		    String actualAlert =alert.getText();
        		    Assert.assertNotNull(actualAlert);
        		    	}catch(NoAlertPresentException e){
        		    		Assert.fail("Alert is not present");
        		    	}finally {
        		    		tree_page.DriverNavigation();
        		    	}
        		
        		 	    }

   //*******************************************************************************************************************************
      //Practice
            @Test
            public void Practice() {
            	tree_page.TerminologiesBtn();
            	tree_page.PractQuesBtn();
            	String actualTitle = login_page.PageTitle();
           	    String expectedTitle = Login.get(43).get("title");
            	Assert.assertEquals(actualTitle,expectedTitle);
            	 
            }
   //*******************************************************************************************************************************
     //SignOut
              @Test
            	public void LogOut() {
            		tree_page.SignOut();
            		String actualTitle = tree_page.LoggedOutAlert();
            		 String expectedTitle = Login.get(4).get("alert");
            		Assert.assertEquals(actualTitle,expectedTitle);
       	}    
         	  
            }
            

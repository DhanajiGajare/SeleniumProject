package testNGTutorial;

import testNGTutorial.TestComponents.BaseTest;
import testNGTutorial.data.DataReader;
import testNGTutorial.pageobject.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testNGTutorial.pageobject.CheckOutPage;
import testNGTutorial.pageobject.OrderPage;
import testNGTutorial.pageobject.productCatelogue;




public class SubmitOrderTest extends BaseTest {
	   // String productName="ZARA COAT 3";
	    String countryName="india";
        @Test(dataProvider="getData")
    //    public void submitOrder(String email,String password,String productName) throws IOException,InterruptedException
        public void submitOrder(HashMap<String,String> input) throws IOException,InterruptedException
        
        {

		//WebDriverManager.chromiumdriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		//String countryName="india";
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//LandingPage landingpage=new LandingPage(driver);
		//LandingPage landingPage=launchApplication();
		
		//landingPage.goTo();
		
		  productCatelogue productcategogue=landingPage.loginApplication(input.get("email"),input.get("password"));
		  List<WebElement> products=productcategogue.getProductList();
		  productcategogue.addproductToCart(input.get("productName"));
		  CartPage cartPage=productcategogue.goToCartPage(); 
		  Boolean match=cartPage.VerifyProductDisplay(input.get("productName"));
		  Assert.assertTrue(match); 
		  CheckOutPage checkoutPage =cartPage.goToCheckout(); 
		  checkoutPage.selectCountry(countryName);
		  ConfiremationPage confiremationPage = checkoutPage.submitOrder();
		  String confirmassage=confiremationPage.verifyConfirmation();
		  Assert.assertTrue(confirmassage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
	    
	 
	   
	}
	
	
	  @Test(dependsOnMethods="submitOrder") 
	   public void OrderHistoryTest() {
	   productCatelogue productcategogue=landingPage.loginApplication("dhanaji@gmail.com","Dhanaji@123"); 
	   OrderPage orderPage = productcategogue.gotoOrderPage();
	   Assert.assertTrue( orderPage.VerifyOrderDisplay("ZARA COAT 3"));
	  
	  }
	  
	  @DataProvider
	  public Object[][] getData() throws IOException
	  {
		  
		  DataReader data=new DataReader();
		  List<HashMap<String,String>> data1 =data.getJsonDataToMap();
		  
		  return new Object[][] {{data1.get(0)}};	
		  
	  }
	  
	  
	 /* 
	1   . this is the first way
	    this method for getdata
	  
	   @Test(dataProvider="getData")
	    
	     if we have short data then we can use this way but if we have 1000 fields then we can not use this way
	    
	     public void SubmitOrderTest(String email,String password,String productName) 
	   	 
	   	  {
			  CheckOutPage checkOutPage =cartPage.goToCheckOut();
			  checkOutPage.selectCountry("india");
			  ProductCatelogue productCatelogue =landingPage.loginApplication(email,password);

          }
          
          this method for send data
          
           @DataProvider
           public Object[][] getData()
           {
    	        return new Object[][]{{"dhanaji@gmail.com","Dhanaji@123","ZARA COAT 3"}};
           }

	       
	  
	
	2.    *******this is for get the data************	 	
		
		  @Test(dataProvider="getData")
		  public void SubmitOrderTest(HashMap<String,String>input) 
		  {
		     CheckOutPage checkOutPage =cartPage.goToCheckOut();
		     checkOutPage.selectCountry("india");ProductCatelogue productCatelogue =landingPage.loginApplication(input.get("email"),input.get("password"));
		  }
		  
		  ******** this is for send the data**********
		   @DataProvider
           public Object[][] getData()
           {
				  HashMap<Object,Object> map=new HashMap<Object,Object>();
				 
				  map.put("email", "dhanaji@gmail.com");
				  map.put("password", "Dhanaji@123");
				  map.put("product", "ZARA COAT 3");
				 
		    	  return new Object[][]{{map}};		  
		  }	  
			
	    */
        
}
	
	
	
	



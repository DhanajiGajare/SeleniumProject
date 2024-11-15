package testNGTutorial;

import testNGTutorial.TestComponents.BaseTest;
import testNGTutorial.TestComponents.Retry;
import testNGTutorial.pageobject.*;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.Duration;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ErrorValidations extends BaseTest {
	
        @Test()//((retryAnalyzer= Retry.class)) you can add this test(here)
        public void loginErrorValidation() throws IOException
        {
		   String productName="ZARA COAT 3";
		   String countryName="india";
		   landingPage.loginApplication("dhanaji@gmail.com","Dhanaji123");
		   //landingPage.getErrorMassage();
		   Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMassage());
	   
	  	}
 
		/*
		 * @Test public void productErrorValidation() throws IOException,
		 * InterruptedIOException {
		 * 
		 * String productName="ZARA COAT 33"; String countryName="india";
		 * productCatelogue
		 * productcategogue=landingPage.loginApplication("dhanaji@gmail.com",
		 * "Dhanaji@123"); List<WebElement> products=productcategogue.getProductList();
		 * productcategogue.addproductToCart(productName); CartPage
		 * cartPage=productcategogue.goToCartPage(); Boolean match=
		 * cartPage.VerifyProductDisplay(productName); Assert.assertFalse(match);
		 * 
		 * }
		 */
}
	
	
	
	



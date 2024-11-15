package testNGTutorial.AbstractComponents;

import java.time.Duration;
import testNGTutorial.pageobject.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	
	WebDriver driver;
	
     @FindBy(xpath="//*[@routerlink='/dashboard/cart']")
     WebElement cartHeader;
     
     @FindBy(css="[routerlink*='myorders']")
     WebElement orderHeader;
     
	 //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	public AbstractComponent(WebDriver driver) {

       this.driver=driver;
       PageFactory.initElements(driver, this);
	}

	public void waitForElementToApper(By findBy)
	{
	
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForWebElementToApper(WebElement findBy)
	{
	
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
	 wait.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		
		CartPage cartPage=new CartPage(driver);
		
		return cartPage;
		
	}
	
	public OrderPage gotoOrderPage()
	{
		orderHeader.click();
	    OrderPage orderPage=new OrderPage(driver);
	    return orderPage;
	
	}
	
	
	public void WaitForElementToDisappear(WebElement ele)
	{
		//stop execution for some time because of timer
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
}	

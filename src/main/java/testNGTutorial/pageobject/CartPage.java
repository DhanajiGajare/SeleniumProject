package testNGTutorial.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {

      this.driver=driver;
      PageFactory.initElements(driver, this);
		
	}
	
	 //List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitles;
	
	//driver.findElement(By.cssSelector("[class*='subtotal'] button")).click();
    @FindBy(css="[class*='subtotal'] button")
    WebElement checkoutEle;
    
	

	public Boolean VerifyProductDisplay(String productName)
	{
		boolean match = productTitles.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
        return match;
	
	}
	
	public CheckOutPage goToCheckout()
	{
		
		checkoutEle.click();
		
		CheckOutPage checkOutPage=new CheckOutPage(driver);
				
		return checkOutPage;		
	}
	
	
	
	
	
	

}

package testNGTutorial.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testNGTutorial.AbstractComponents.AbstractComponent;

public class productCatelogue extends AbstractComponent{
	
	
	
	WebDriver driver;
	
	public productCatelogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productBy =By.cssSelector(".mb-3");
	By addToCart =By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
	
		waitForElementToApper(productBy);
	    return products;
	
	}
	
	public WebElement getproductByName(String productName)
	{
		WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	    return prod;
	}

	public void addproductToCart(String productName) {
		
		WebElement prod =getproductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToApper(toastmessage);
		WaitForElementToDisappear(spinner);
		
	}
	
	
	
	
	
	

}

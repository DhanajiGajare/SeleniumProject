package testNGTutorial.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testNGTutorial.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	    this.driver=driver;
	    
	    PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(css="[placeholder*='Select']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="//section[@class=\"ta-results list-group ng-star-inserted\"]//button[2]")
	WebElement selectCountry;
	
	By results =By.cssSelector(".ta-results");
	
	//By country1 =By.xpath("//button[contains(@class,'ta-item')])[2]");
	
	
	public void selectCountry(String countryName )
	{
		 Actions a=new Actions(driver);
		 a.sendKeys(country, countryName).build().perform();
		 waitForElementToApper(By.cssSelector(".ta-results"));
		 selectCountry.click();
		
	}
	
	
	public ConfiremationPage submitOrder()
	{
		submit.click();
		
		ConfiremationPage confirmationPage=new ConfiremationPage(driver);
		
		return confirmationPage;
		
		
	}
	
}
	
	
	
	
	
	
	
	
	
	



package testNGTutorial.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import testNGTutorial.AbstractComponents.AbstractComponent;

public class ConfiremationPage extends AbstractComponent{
	
	WebDriver driver;
	
	public ConfiremationPage(WebDriver driver) {
		super(driver);
	    this.driver=driver; 
	    PageFactory.initElements(driver, this);
	
	}
	// String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();

		 //Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
		 //driver.close();
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	
	public String verifyConfirmation()
	{
		 return confirmationMessage.getText();
		
	
	}
	
	

	
	
	
	
	

}

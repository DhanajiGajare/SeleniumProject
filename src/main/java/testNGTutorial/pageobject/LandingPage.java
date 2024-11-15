package testNGTutorial.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testNGTutorial.AbstractComponents.AbstractComponent;

public class LandingPage  extends AbstractComponent{
	
	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//WebElement userName =driver.findElement(By.id("userEmail"));-> we can write like this
	 
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public productCatelogue loginApplication(String user,String pass)
	{
		userEmail.sendKeys(user);
		
		userPassword.sendKeys(pass);
		
		submit.click();
		
		productCatelogue productcategogue=new productCatelogue(driver);
		
		return productcategogue;
		
	}
	
	public String getErrorMassage()
	{
		
		waitForWebElementToApper(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}

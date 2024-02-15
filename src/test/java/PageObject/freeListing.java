package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class freeListing extends BasePage{

	public freeListing(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Locators
	@FindBy(xpath = "//div[@class='pushengage-subscription-overlay__close-btn']") WebElement ad2;
	@FindBy(xpath = "//a[@class='btn cardFooterButtonBlue']") WebElement freeListing;
	@FindBy(xpath = "//button[text() ='Click here to login']") WebElement loginHere;
	@FindBy(xpath = "//input[@id='loginEmail']") WebElement enterEmail;
	@FindBy(xpath = "//input[@id='loginPassword']") WebElement enterPassword;
	@FindBy(xpath = "//button[@id='loginRes']") WebElement login;
	@FindBy(xpath = "//div[@id='errdiv']") WebElement errorMessage;
	
	
	
	//Actions
	
	//Closing the pop-up
	public void stopAd()
	{
		try
		{
			if(ad2.isDisplayed())
			{
				ad2.click();
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	//Clicking on freeListing button
	public void clickFreeListing()
	{
		highlightElement(freeListing);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",freeListing);
		explicitWait(freeListing,5);
		freeListing.click();
	}

	
	//Click on clickToLogin button
	public void clickToLogin()
	{
		highlightElement(loginHere);
		explicitWait(loginHere,5);
		loginHere.click();
	}

	
	//Enter invalid input and password and then click on the login button
	public void clicklogin(String mail, String pass)
	{
		String email = mail;
		String password = pass;
		enterEmail.sendKeys(email);
		enterPassword.sendKeys(password);
		highlightElement(login);
		explicitWait(login,5);
		login.click();
	}
	
	
	//Capture the error message and print it
	public void getErrorMessage()
	{
		System.out.println("  ");
		System.out.println("The Error message is : "+errorMessage.getText());
		System.out.println("  ");
	}
	
	
	
	//Going back to the mainPage 
	public void backToMainPage()
	{
		driver.navigate().back();
		driver.navigate().back();
	}
}

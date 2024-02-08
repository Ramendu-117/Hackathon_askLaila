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
	
	public void clickFreeListing()
	{
		highlightElement(freeListing);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",freeListing);
		freeListing.click();
	}

	public void clickToLogin()
	{
		highlightElement(loginHere);
		loginHere.click();
	}

	public void clicklogin(String mail, String pass)
	{
		String email = mail;
		String password = pass;
		enterEmail.sendKeys(email);
		enterPassword.sendKeys(password);
		highlightElement(login);
		login.click();
	}
	
	public void getErrorMessage()
	{
		System.out.println("The Error message is : "+errorMessage.getText());
		System.out.println("  ");
	}
	
	public void backToMainPage()
	{
		driver.navigate().back();
		driver.navigate().back();
	}
}

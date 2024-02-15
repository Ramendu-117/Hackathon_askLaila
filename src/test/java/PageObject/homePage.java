package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends BasePage{

	public homePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//Locators
	@FindBy(xpath = "//div[@class='pushengage-subscription-overlay__close-btn']") WebElement ad2;
	@FindBy(xpath = "//input[@title='Search']") WebElement searchBox;
	@FindBy(xpath = "//button[@type='submit']") WebElement clickButton;
	@FindBy(xpath = "//a[text()='Telecom and Internet Service Providers']") WebElement scrollUpto;
	@FindBy(xpath = "//a[text()='Gyms']") WebElement gym;
	
	
	
	
	//Actions
	public void clickButton() throws InterruptedException
	{
		explicitWait(clickButton,5);
		clickButton.click();
	}
	
	
	
	//Entering the search element and then clicking the search button
	public void enterElement(String keyWord)
	{
		highlightElement(searchBox);
		explicitWait(searchBox,5);
		searchBox.sendKeys(keyWord);
	}
	
	
	//Handling the pop-up
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
	
	
	//Scrolling up-to the gym box
	public void scroll() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",scrollUpto);
	}
	
	
	//Clicking on the gym
	public void clickGym()
	{
		explicitWait(gym,5);
		gym.click();
	}
	

}

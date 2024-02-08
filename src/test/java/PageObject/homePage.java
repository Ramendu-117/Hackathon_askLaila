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
		clickButton.click();
	}
	
	public void enterElement(String keyWord)
	{
		highlightElement(searchBox);
		searchBox.sendKeys(keyWord);
	}
	
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
	
	public void scroll() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",scrollUpto);
	}
	
	public void clickGym()
	{
		gym.click();
	}
	

}

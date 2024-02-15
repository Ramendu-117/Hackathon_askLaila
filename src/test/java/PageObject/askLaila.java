package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.takeScreenShot;

public class askLaila extends BasePage {

	public askLaila(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	//Locators
	@FindBy(xpath = "//span[@class='hidden-xs']//button[text()='Nevermind! I am in a roaming mode.']") WebElement ad;
	@FindBy(xpath = "//h2[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 cityCardStyle']") List<WebElement> countries;
	@FindBy(xpath = "//img[@alt='Bangalore']" ) WebElement Bangalore;
	@FindBy(xpath = "//div[@class='pushengage-subscription-overlay__close-btn']") WebElement ad2;
	@FindBy(xpath = "//li[@name ='liWhat']") List<WebElement> dynamicDropDown;
	
	
	//Actions 
	
	//Clicking on the roaming mode option
	public void ignoreLogin()
	{
		try {
			if(ad.isDisplayed())
			{
				ad.click();
			}
		}
		catch(Exception e )
		{
			
		}
	}
	
	
	//Scrolling upto India option and then selecting India
	public void selectCountry() throws Exception
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.screenshot("//selectCountry.png");
		explicitWait(countries.get(0),5);
		countries.get(0).click();
	}
	
	
	//Scrolling upto Bangalore option and then selecting Bangalore
	public void selectLocation()throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.screenshot("//selectCity.png");
		explicitWait(Bangalore,5);
		Bangalore.click();
	}

	
	
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
	
	
	
	
	
	
		
	
}

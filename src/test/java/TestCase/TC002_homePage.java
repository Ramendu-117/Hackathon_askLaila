package TestCase;

import org.testng.annotations.Test;

import PageObject.homePage;
import Utilities.takeScreenShot;

public class TC002_homePage extends TC001_askLaila {
	


	@Test(priority = 4, groups = {"master", "regression"})
	public void enteringInputs() throws Exception
	{
		logger.info("Giving the input in the searchbox...");
		
		homePage hp = new homePage(driver);
		String search = "Car Washing Services";
		hp.enterElement(search);
		hp.stopAd();
		Thread.sleep(2000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.screenshot("//searchWindow.png");
		hp.clickButton();
		hp.stopAd();
	}
	
	
	@Test(priority = 12, groups = {"master", "regression"})
	public void clickingGym() throws Exception
	{
		logger.info("Scrolling till the gym and clicking the gym button ...");
		homePage hp = new homePage(driver);
		hp.scroll();
		Thread.sleep(2000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.screenshot("//selectGym.png");
		hp.clickGym();
	}
	
}

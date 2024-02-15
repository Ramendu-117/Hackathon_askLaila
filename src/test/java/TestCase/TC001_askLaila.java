package TestCase;

import org.testng.annotations.Test;

import PageObject.askLaila;
import TestBase.BaseClass;


//@Listeners(Utilities.ExtentReport.class)
public class TC001_askLaila   extends BaseClass
{
	@Test(priority = 1, groups = {"master", "regression"})
	public void ignoreAd() throws InterruptedException
	{
		logger.info("Selecting i'm on raoming mode ...");
		askLaila jD = new askLaila(driver);
		jD.stopAd();
		Thread.sleep(1000);
		jD.ignoreLogin();
		Thread.sleep(1000);
		jD.stopAd();
	}

	@Test(priority = 2, groups = {"master", "regression"})
	public void selectCountry() throws Exception
	{
		logger.info("Selecting the country : India ...");
		askLaila jD = new askLaila(driver);
		jD.selectCountry();
		Thread.sleep(1000);
		jD.stopAd();

	}
	
	
	@Test(priority = 3, groups = {"master", "regression"})
	public void selectCity() throws Exception
	{
		logger.info("Selecting the city : Bangalore ...");
		askLaila jD = new askLaila(driver);
		jD.selectLocation();
		Thread.sleep(1000);
		jD.stopAd();
	}
	
}

package TestCase;

import org.testng.annotations.Test;

import PageObject.freeListing;
import Utilities.takeScreenShot;

public class TC004_freeListing extends TC003_results {
	
	@Test(priority = 7, groups = {"master", "regression"})
	public void test7() throws Exception
	{
		logger.info("Clicking on the free listiing button ...");
		freeListing fl= new freeListing(driver); 
		fl.clickFreeListing();
		fl.stopAd();
		Thread.sleep(2000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.screenshot("//Login.png");
	}
	
	@Test(priority = 8, groups = {"master", "regression"})
	public void test8() throws Exception
	{
		logger.info("Clickcing on the ClickHereToLogin button ...");
		freeListing fl= new freeListing(driver); 
		fl.clickToLogin();
		Thread.sleep(1000);
		fl.stopAd();
	}
	
	@Test(priority = 9, groups = {"master", "sanity"})
	public void test9() throws Exception
	{
		logger.info("Entering invalid username and password  ...");
		freeListing fl= new freeListing(driver); 
		fl.clicklogin("yegfhbji", "hgdfdkfl");
		Thread.sleep(2000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.screenshot("//invalidInput.png");
	}
	
	@Test(priority = 10, groups = {"master", "regression"})
	public void test10() throws InterruptedException
	{
		logger.info("Getting the error message and printing it ...");
		freeListing fl= new freeListing(driver); 
		fl.getErrorMessage();
	}
	
	@Test(priority = 11, groups = {"master", "regression"})
	public void test11() throws InterruptedException
	{
		freeListing fl= new freeListing(driver); 
		fl.backToMainPage();
	}

}

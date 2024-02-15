package TestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.results;

public class TC003_results extends TC002_homePage {
	
	@Test(priority = 5, groups = {"master", "regression"})
	public void gettingCarWashResults() throws InterruptedException, IOException
	{
		logger.info("Getting the list of Car Washing centers with more than 4* rating ...");
		results res = new results(driver);
		res.getResult();
		Thread.sleep(2000);

	}
	@Test(priority = 6, groups = {"master", "regression"})
	public void clickingShareReviewReport() throws Exception
	{
		logger.info("Clicking on the review button and writing a review ...");
		results res = new results(driver);
		res.stopAd();
		res.clickReviewShareReport("Very Nice", "Report");
	}
	
	

	
	

	
	


}

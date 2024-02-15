package TestCase;

import org.testng.annotations.Test;

import PageObject.gymResults;
import Utilities.takeScreenShot;

public class TC005_gymResults extends TC004_freeListing {
	
	
	@Test(priority = 13, groups = {"master", "regression"})
	public void gettingSubCategory() throws Exception
	{
		logger.info("Clicking the subcategory menu and getting and printing the subcategory elements ...");
		gymResults gr = new gymResults(driver);
		gr.getSubCategoryValue();
		Thread.sleep(3000);
		takeScreenShot scShot = new takeScreenShot(driver);
		scShot.screenshot("//gymResults.png");
		
	}
	

}

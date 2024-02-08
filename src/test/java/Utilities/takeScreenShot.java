package Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import PageObject.BasePage;

public class takeScreenShot extends BasePage 
{


	public takeScreenShot(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String screenshot(String name) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String nameOfSS = name;
		String ssPath = System.getProperty("user.dir") + "\\Screenshots\\" +nameOfSS;
		try {
				File file = ts.getScreenshotAs(OutputType.FILE);
				File target = new File(ssPath);
				FileUtils.copyFile(file, target);	
		}
		catch(Exception e) 
		{
			e.getMessage();
		}
		
		return ssPath;
		
	}
}
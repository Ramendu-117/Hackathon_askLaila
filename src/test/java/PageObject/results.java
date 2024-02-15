package PageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;
import Utilities.takeScreenShot;

public class results extends BasePage {

	public results(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	//Locators
	@FindBy(xpath = "//div[@class='pushengage-subscription-overlay__close-btn']") WebElement ad2;
	@FindBy(xpath = "//span[@class='ratevalue']//ancestor::div[@class='col-xs-12 card']") List<WebElement> searchResults;
	@FindBy(xpath = "//label[@class='phonedisplay']") List<WebElement> mobNos;
	@FindBy(xpath = "//span[@class='ratevalue']") List<WebElement> ratings;
	@FindBy(xpath = "//h2[@class='resultTitle']") List<WebElement> names;
	@FindBy(xpath = "//h2[text()='Write Review']") WebElement review;
	@FindBy(xpath = "//textarea[@class='commentBox']") WebElement reviewBox;
	@FindBy(xpath = "//textarea[@class='form-control']") WebElement reportBox;
	@FindBy(xpath = "//h4[text()='FIX THIS LISTING']/preceding-sibling::button") WebElement closeReportButton;
	@FindBy(xpath = "//span[@class='fb fbicon shareIcon']") WebElement fbIcon;
    @FindBy(xpath = "//input[@id='email']")WebElement fbEmail;
    @FindBy(xpath = "//input[@id='pass']")WebElement fbPassword;
    @FindBy(xpath = "//label[@id='loginbutton']")WebElement fbLogin;
	@FindBy(xpath = "//span[@class='tw twicon shareIcon']") WebElement twitterIcon;
	
	
	
	List<Map<String, String>> maps = new ArrayList<>();
	Map<String,String> nameAndRate= new HashMap<String,String>();
	Map<String, String> nameAndNumber = new HashMap<String, String>();
	
	
	
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
	
	
	public  List<String> getValues( Map<String, String> nameAnd)
	{
		Map<String, String> map =nameAnd;
		List<String> val = new ArrayList<String>();
		for(String str :map.keySet())
		{
			val.add(map.get(str));
		}
		return val;
		
	}
	
	
	public void getResult() throws IOException
	{
		String xfile = System.getProperty("user.dir")+"\\TestData\\Car Washing services (Hackathon).xlsx";
		System.out.println("The Names, Mobile No. and the Ratings of the Car Washing Service Centers are : ");
		System.out.println("  ");
		for(int i =0;i<searchResults.size();i++)
		{
			
			String name = names.get(i).getText();
			String rating = ratings.get(i).getText();
			String mobNo = mobNos.get(i).getText();
			nameAndRate.put(name, rating);
			nameAndNumber.put(name, mobNo);
		}
		
		maps.add(nameAndNumber);
		maps.add(nameAndRate);
		List<String> newRating = getValues(maps.get(1));
		List<String> newNumber = getValues(maps.get(0));
		int i =0;
		int index=1;
		for(String name:nameAndRate.keySet())
		{
			
			String rate = newRating.get(i);
			String no = newNumber.get(i);
			if(Double.parseDouble(rate)>4)
			{
				System.out.println("Name : "+name+", Numbers : "+no +", Rating : "+rate);
				
				ExcelUtils.setCellData(xfile, "Sheet1", index, 0, name);
				ExcelUtils.setCellData(xfile, "Sheet1", index, 1, no);
				ExcelUtils.setCellData(xfile, "Sheet1", index, 2, rate);
				
				index++;
			}
			
			i++;
		}
		
		System.out.println("  ");
		System.out.println("The end of the list...");
		System.out.println("  ");
	}
	
	
	public void goToPage(String input)
	
	{
		String actualTitle = input;
		Set<String> handles = driver.getWindowHandles();
		for(String winId : handles)
		{
			String title = driver.switchTo().window(winId).getTitle();
			if(title.equalsIgnoreCase(actualTitle))
			{
				driver.switchTo().window(winId);
				break;
			}
		}
	}
	
	public int randomNumberGenerator(int size)
	{
		Random random = new Random();
		int randNum = random.nextInt(size);
		int randomnumb = randNum+1;
		return randomnumb;
	}
	
	
	public void clickReviewShareReport(String comment, String report) throws Exception
	{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			takeScreenShot scShot = new takeScreenShot(driver);
			int randomNumber = randomNumberGenerator(searchResults.size());
			
			
			//Clicking on the review button and writing a review 
			WebElement reviewButton = driver.findElement(By.xpath("(//button[@class='hidden-xs btn btn-default cardFooterButtonBlue'])["+randomNumber+"]"));
			highlightElement(reviewButton);
			explicitWait(reviewButton,5);
			reviewButton.click();
			String reviewInput = comment;
			reviewBox.sendKeys(reviewInput);
			Thread.sleep(2000);
			scShot.screenshot("//writeReview.png");
			driver.navigate().back();
			
			
			//Clicking on the share button and then clicking on both the Fb and then giving wrong input and capturing the message and then clicking on twitter option
			WebElement share = driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-share whiteColor'])["+randomNumber+"]"));
			highlightElement(share);
			js.executeScript("arguments[0].scrollIntoView();",share);
			explicitWait(share,5);
			share.click();
			Thread.sleep(2000);
			scShot.screenshot("//shareButton.png");
			WebElement facebook = driver.findElement(By.xpath("(//span[@class='fb fbicon shareIcon'])["+randomNumber+"]"));
			highlightElement(facebook);
			facebook.click();
			goToPage("Facebook");
			Thread.sleep(2000);
			scShot.screenshot("//Facebook.png");
			fbEmail.sendKeys("abc@xyz");
			fbPassword.sendKeys("acbsdh1234");
			fbLogin.click();
			Thread.sleep(2000);
			scShot.screenshot("//FacebookError.png");
			String err_msg = driver.findElement(By.xpath("//div[@class='_li']//div[contains(@class,'pam login_error_box')]")).getText();
			System.out.println(" ");
			System.out.println("Error message coming from entering invalid input : " + err_msg);
			Thread.sleep(1000);
			goToPage("Top car washing services near me in Bangalore - AskLaila");
			Thread.sleep(1000);
			share.click();
			WebElement twitter = driver.findElement(By.xpath("(//span[@class='tw twicon shareIcon'])["+randomNumber+"]"));
			highlightElement(twitter);
			twitter.click();
			goToPage("Twitter");
			Thread.sleep(2000);
			scShot.screenshot("//Twitter.png");
			goToPage("Top car washing services near me in Bangalore - AskLaila");
			
			
			//Clicking on the report button and writing a report
			WebElement reportButton = driver.findElement(By.xpath("(//button[@title='Report'])["+randomNumber+"]"));
			highlightElement(reportButton);
			reportButton.click();
			String reportInput = report;
			reportBox.sendKeys(reportInput);
			Thread.sleep(2000);
			scShot.screenshot("//writeReport.png");
			closeReportButton.click();
			
			
	}
	
}

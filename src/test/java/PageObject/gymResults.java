package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

public class gymResults extends BasePage {

	public gymResults(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	//Locators
	@FindBy(xpath = "//div[@id='searchSubCategory']") WebElement subCategory;
	@FindBy(xpath = "//div[@class='btn-group cardWrap open']//a[contains(text(),'Gym')]") List<WebElement> subcategoryValue;
	
	
	
	
	
	//Actions
	
	
	//Click on the subCategory button and print all the subCategories
	public void getSubCategoryValue() throws IOException
	{
		String xfile = System.getProperty("user.dir")+"\\TestData\\Car Washing services (Hackathon).xlsx";
		int index = 1;
		highlightElement(subCategory);
		explicitWait(subCategory,5);
		subCategory.click();
		System.out.println("The subcategory values are : "); 
		for(int i =0;i<subcategoryValue.size();i++)
		{
			
			System.out.println(subcategoryValue.get(i).getText());
			ExcelUtils.setCellData(xfile, "Sheet2", index, 0, subcategoryValue.get(i).getText());
			index++;
		}
		System.out.println("  ");
	}

}

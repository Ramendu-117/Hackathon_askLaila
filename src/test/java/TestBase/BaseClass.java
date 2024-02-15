package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties  p;

	
	
	
	@BeforeTest(groups = {"master"})
	@Parameters({"os","browser"})
	public void setUp(String os,String bname) throws IOException
	{
		logger = LogManager.getLogger(this.getClass());
		
		
		ChromeOptions chrmOpt = new ChromeOptions();
		chrmOpt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		chrmOpt.addArguments("--disable-notifications");
		
		EdgeOptions edgOpt = new EdgeOptions();
		edgOpt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		edgOpt.addArguments("--disable-notifications");
		
		
		
		FileReader file = new FileReader(".//src//test//resources//Configure.properties");
		p = new Properties();
		p.load(file);
		
		
			if(p.getProperty("execution_env").equalsIgnoreCase("remote"))

					 	{	

						DesiredCapabilities capabilities=new DesiredCapabilities();

						//os

						if(os.equalsIgnoreCase("windows"))

						{

							capabilities.setPlatform(Platform.WIN11);

						}

						else if(os.equalsIgnoreCase("mac"))

						{

							capabilities.setPlatform(Platform.MAC);

						}

						else

						{

							System.out.println("No matching os..");

							return;

						}

						//browser

						switch(bname.toLowerCase())

						{

						case "chrome" : capabilities.setBrowserName("chrome"); break;

						case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;

						default: System.out.println("No matching browser.."); return;

						}

						driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

					    }

					 //If execution_env is local then run in local system

					else if(p.getProperty("execution_env").equalsIgnoreCase("local"))

					{

						//launching browser based on condition - locally

						switch(bname.toLowerCase())

						{

						case "chrome": driver=new ChromeDriver(chrmOpt); break;

						case "edge": driver=new EdgeDriver(edgOpt); break;

						default: System.out.println("No matching browser..");

									return;

						}

					}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("Url"));

		
	}
	
	@AfterTest(groups = {"master"})
	public void closeBrowser()
	{
		driver.quit();
	}

}

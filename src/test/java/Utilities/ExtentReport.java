
package Utilities;
 
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;
 

public class ExtentReport extends BaseClass implements ITestListener

{

	public ExtentSparkReporter sparkReporter;  // UI of the report

	public ExtentReports extent;  //populate common info on the report

	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	
	String repName ="";

 
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		repName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

//		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");//specify location of the report

		
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report

		sparkReporter.config().setReportName("Functional Testing"); // name of the report

		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();

		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name","localhost");

		extent.setSystemInfo("Environment","QA");

		extent.setSystemInfo("Tester Name","Ramendu");

		extent.setSystemInfo("os","Windows10");

		extent.setSystemInfo("Browser name","Chrome,Edge");

	}
 
 
	public void onTestSuccess(ITestResult result) 
	{
		
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s

		try {
			String imagePath = new takeScreenShot(driver).screenshot(result.getName());
			test.addScreenCaptureFromPath(imagePath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
//	
//	public void onTestSuccess(ITestResult result) {
//		test = extent.createTest(result.getName()); // create a new enty in the report
//		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
//		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
//		try {
//			String imgPath = new Screenshots(driver).ScreenShot(result.getName());
//			test.addScreenCaptureFromPath(imgPath);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
// 
	
 
	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());

		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());

		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 

	}
 
	public void onTestSkipped(ITestResult result) {
 
		test = extent.createTest(result.getName());

		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());

	}
 
	

	public void onFinish(ITestContext context) {

		extent.flush();

	}


}

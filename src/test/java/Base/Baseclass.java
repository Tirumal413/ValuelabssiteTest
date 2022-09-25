package Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Runner.SubscriptionTestClass;
import Utilities.TestUtility;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Baseclass extends TestUtility {
	public WebDriver driver;
	public  ExtentReports er;
	public TestUtility tu;
	public Properties pr;
	public  ExtentTest et;
	
	public WebDriver openbroweser()
	{
		//et.setDescription("Opening Browser");
		tu = new TestUtility();
		driver = tu.openBrowser("chrome");
		tu.launchSite(driver,"https://subscribe.stctv.com/");
		//et.setDescription("Opened the site");
		return driver;
	}
	
	public void extentreportdec(String Testname)
	{
		er = new ExtentReports("E:\\Selenium\\ValuelabssiteTest\\target\\extentreports.html",false);
		et = er.startTest(Testname);	
	}
	
	public void closeextentreportdec(String Testname)
	{
		er.endTest(et);
		er.flush();		
	}
	
}

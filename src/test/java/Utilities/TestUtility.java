package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtility  
{
	public WebDriver openBrowser(String bn)
	{
		WebDriver driver;
		if(bn.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			EdgeOptions eo=new EdgeOptions();
			eo.setBinary("C:\\Program Files (x86)\\microsoft\\Edge Beta\\Application\\msedge.exe");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(eo);
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return(driver);
	}
	public void launchSite(WebDriver driver,String url)
	{
		driver.get(url);		
	}
	public void closeSite(WebDriver driver)
	{
		driver.quit();
	}
	
	public String pageScreenshot(WebDriver driver) throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		String ssname=sf.format(dt)+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("E:\\"+ssname);
		FileHandler.copy(src,dest);
		return(dest.getAbsolutePath());
	}
	

}










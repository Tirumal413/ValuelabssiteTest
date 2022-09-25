package Runner;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.SubscriptionPgae;
import Utilities.ListnerTest;


@Listeners(ListnerTest.class)

public class SubscriptionTestClass extends Baseclass {
	
	public WebDriver driver;		
    public WebDriverWait w;
	public Baseclass bc;
	public SubscriptionPgae subscriptionpage;
		
	Logger log = Logger.getLogger(SubscriptionTestClass.class);
	
	@BeforeTest
	public void setup()
	{
		bc = new Baseclass();
	}
	
	@BeforeMethod
	public void intialiseel() {
		
		driver = bc.openbroweser();
		w = new WebDriverWait(driver,5000);	
		subscriptionpage = new SubscriptionPgae(driver);
	}
	
	@Test(enabled = true)
	public void Subscrition_KSA() throws Exception {
		
		log.debug("****************************** Starting test cases execution  *****************************************");
		
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current Url is " + currenturl);
		log.debug("Url is -------------" + currenturl);
	    driver.manage().window().maximize();
	   
	    w.until(ExpectedConditions.elementToBeClickable(subscriptionpage.changelanguagebutton));
	    subscriptionpage.changelanguagebutton_click();
	    log.info("Change language button Click completed");
	    
	    //Validation Whether Choose your plan text is present
	    String plantext = subscriptionpage.subscription_chooseplan_text();
	    Assert.assertEquals(plantext, "Choose Your Plan");
	    
	    //Validation for Package list count
	    List<WebElement> spackagelist = subscriptionpage.getsubscription_packagelist();
	    System.out.println("Size is " + spackagelist.size());
	    Assert.assertEquals(spackagelist.size(), 4);
	    
	  
	    List<String> ExpectedPlanList = new ArrayList<String>();
	    List<String> ActualPlanList = new ArrayList<String>();
	    
	    ExpectedPlanList.add("LITE");
	    ExpectedPlanList.add("CLASSIC");
	    ExpectedPlanList.add("PREMIUM");
	    
	    HashMap<String,String> KSAPrice_List = new HashMap<String, String>();
	    KSAPrice_List.put("LITE", "15");
	    KSAPrice_List.put("CLASSIC","25");
	    KSAPrice_List.put("PREMIUM","60");
	    
	    //Validations for Price,Type,Currency
	    
	    for (int i =0; i < spackagelist.size()-1; i++)
	    {
	    	//String price = spackagelist.get(i).findElement(By.xpath("(.//child::div//span)[1]")).getText();
	    	String price = subscriptionpage.getsubscriptionprice(spackagelist.get(i));
	    	System.out.println("Price is " +  price);
	    	
	    
	    	String currency = subscriptionpage.getsubscriptioncurrency(spackagelist.get(i));
	    	System.out.println("Currency is " +  currency);
	    	
	    
	    	
	    	String subscriptiontype = subscriptionpage.getsubscriptionType(spackagelist.get(i));
	    	System.out.println("Type is " + subscriptiontype);
	    
	      // Validation for Price
	    	Assert.assertEquals(price, KSAPrice_List.get(subscriptiontype));
	    	
	     // Validation for Currency
	    	Assert.assertEquals(currency, "SAR");
	    	ActualPlanList.add(subscriptiontype);
	    }
	    
	    //Validate whether the List Has all the PlanTypes
	    Assert.assertEquals(ActualPlanList, ExpectedPlanList);
	    
	    
	}
	
	@Test(enabled = true)
	public void Subscrition_Bharian() throws Exception {
		
		log.info("****************************** Starting test cases execution  *****************************************");
		
		String x = driver.getCurrentUrl();
		System.out.println("Current Url is " + x);
	    driver.manage().window().maximize();
	    
	    Thread.sleep(2000);
	    w.until(ExpectedConditions.elementToBeClickable(subscriptionpage.changelanguagebutton));
	    subscriptionpage.changelanguagebutton_click();
	   // Thread.sleep(2000);
	    
	    w.until(ExpectedConditions.elementToBeClickable(subscriptionpage.Country_change));
	    
	    subscriptionpage.CountryChange_click();
	    
	    subscriptionpage.SelectBhCOuntry_click();
	    
	    //Thread.sleep(5000);
	    
	    w.until(ExpectedConditions.visibilityOf(subscriptionpage.Country_change));
	    //Validation Whether Choose your plan text is present
	    String plantext = subscriptionpage.subscription_chooseplan_text();
	    Assert.assertEquals(plantext, "Choose Your Plan");
	    
	    //Validation for Package list count
	    List<WebElement> spackagelist = subscriptionpage.getsubscription_packagelist();
	    System.out.println("Size is " + spackagelist.size());
	    Assert.assertEquals(spackagelist.size(), 4);
	    
	  
	    List<String> ExpectedPlanList = new ArrayList<String>();
	    List<String> ActualPlanList = new ArrayList<String>();
	    
	    ExpectedPlanList.add("LITE");
	    ExpectedPlanList.add("CLASSIC");
	    ExpectedPlanList.add("PREMIUM");
	    
	    HashMap<String,String> KSAPrice_List = new HashMap<String, String>();
	    KSAPrice_List.put("LITE", "2");
	    KSAPrice_List.put("CLASSIC","3");
	    KSAPrice_List.put("PREMIUM","6");
	    
	    //Validations for Price,Type,Currency
	    
	    for (int i =0; i < spackagelist.size()-1; i++)
	    {
	    	//String price = spackagelist.get(i).findElement(By.xpath("(.//child::div//span)[1]")).getText();
	    	String price = subscriptionpage.getsubscriptionprice(spackagelist.get(i));
	    	System.out.println("Price is " +  price);
	    	
	    
	    	String currency = subscriptionpage.getsubscriptioncurrency(spackagelist.get(i));
	    	System.out.println("Currency is " +  currency);
	    	
	    
	    	
	    	String subscriptiontype = subscriptionpage.getsubscriptionType(spackagelist.get(i));
	    	System.out.println("Type is " + subscriptiontype);
	    
	      // Validation for Price
	    	Assert.assertEquals(price, KSAPrice_List.get(subscriptiontype));
	    	
	     // Validation for Currency
	    	Assert.assertEquals(currency, "BHD");
	    	ActualPlanList.add(subscriptiontype);
	    }
	    
	    //Validate whether the List Has all the PlanTypes
	    Assert.assertEquals(ActualPlanList, ExpectedPlanList);
	    
	    
	}

	@Test(enabled = true)
	public void Subscrition_Kuwait() throws Exception {
		
		log.info("****************************** Starting test cases execution  *****************************************");
		
		String x = driver.getCurrentUrl();
		System.out.println("Current Url is " + x);
	    driver.manage().window().maximize();
	    
	   // Thread.sleep(2000);
	    w.until(ExpectedConditions.elementToBeClickable(subscriptionpage.changelanguagebutton));
	    subscriptionpage.changelanguagebutton_click();
	   
	    w.until(ExpectedConditions.visibilityOf(subscriptionpage.Country_change));
	    subscriptionpage.CountryChange_click();
	    
	    subscriptionpage.SelectkwCOuntry_click();
	    
	    //Thread.sleep(5000);
	    
	    
	    //Validation Whether Choose your plan text is present
	    
	    String plantext = subscriptionpage.subscription_chooseplan_text();
	    Assert.assertEquals(plantext, "Choose Your Plan");
	    
	    //Validation for Package list count
	    w.until(ExpectedConditions.elementToBeClickable(subscriptionpage.Country_change));
	    List<WebElement> spackagelist = subscriptionpage.getsubscription_packagelist();
	    System.out.println("Size is " + spackagelist.size());
	    Assert.assertEquals(spackagelist.size(), 4);
	    
	  
	    List<String> ExpectedPlanList = new ArrayList<String>();
	    List<String> ActualPlanList = new ArrayList<String>();
	    
	    ExpectedPlanList.add("LITE");
	    ExpectedPlanList.add("CLASSIC");
	    ExpectedPlanList.add("PREMIUM");
	    
	    HashMap<String,String> KSAPrice_List = new HashMap<String, String>();
	    KSAPrice_List.put("LITE", "1.2");
	    KSAPrice_List.put("CLASSIC","2.5");
	    KSAPrice_List.put("PREMIUM","4.8");
	    
	    //Validations for Price,Type,Currency
	    
	    for (int i =0; i < spackagelist.size()-1; i++)
	    {
	    	//String price = spackagelist.get(i).findElement(By.xpath("(.//child::div//span)[1]")).getText();
	    	String price = subscriptionpage.getsubscriptionprice(spackagelist.get(i));
	    	System.out.println("Price is " +  price);
	    	
	    
	    	String currency = subscriptionpage.getsubscriptioncurrency(spackagelist.get(i));
	    	System.out.println("Currency is " +  currency);
	    	
	    	String subscriptiontype = subscriptionpage.getsubscriptionType(spackagelist.get(i));
	    	System.out.println("Type is " + subscriptiontype);
	    
	      // Validation for Price
	    	Assert.assertEquals(price, KSAPrice_List.get(subscriptiontype));
	    	
	     // Validation for Currency
	    	Assert.assertEquals(currency, "KWD");
	    	ActualPlanList.add(subscriptiontype);
	    }
	    
	    //Validate whether the List Has all the PlanTypes
	    Assert.assertEquals(ActualPlanList, ExpectedPlanList);
	    
	    
	}
	@AfterMethod
	public void AfterMethod()
	{
		driver.close();
	}
	
	
}

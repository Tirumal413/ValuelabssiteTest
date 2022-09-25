package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscriptionPgae {

	public WebDriver driver;
	public WebDriverWait w;
	
	@FindBy(how=How.XPATH, using ="(//h3[@class='selectPlan-title-withHeader'])[1]")
	public WebElement subscription_chooseplan;
	
	@FindBy(how=How.ID, using = "changeLanguageButton")
	public WebElement changelanguagebutton;
	
	@FindBy(how=How.XPATH, using ="(//h3[@class='selectPlan-title-withHeader'])[1]")
	public List<WebElement> subscription_packageList;
	
	@FindBy(how=How.XPATH, using ="(//a[contains(@class,'header-btns-country')])[1]")
	public WebElement Country_change;
	
	@FindBy(how=How.XPATH, using ="//ul[contains(@class,'countryList-items')]//li[1]")
	public WebElement Select_Bh_Country;
	
	@FindBy(how=How.XPATH, using ="//ul[contains(@class,'countryList-items')]//li[3]")
	public WebElement Select_kw_Country;
	
	public SubscriptionPgae(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	public void changelanguagebutton_click()
	{
		changelanguagebutton.click();
	}
	
	public String subscription_chooseplan_text()
	{
	   String text = subscription_chooseplan.getText();
	   return text;
	}
	
	public List<WebElement> getsubscription_packagelist()
	{
	   List<WebElement> subsciptionlist = driver.findElements(By.xpath("//div[@class='package-container']/child::div"));
       return subsciptionlist;
	}
	
	public String getsubscriptionprice(WebElement element)
	{
	   String price = element.findElement(By.xpath("(.//child::div//span)[1]")).getText();
       return price;
	}

	public String getsubscriptioncurrency(WebElement element)
	{
	   String currency = element.findElement(By.xpath("(.//child::div//span)[2]")).getText();
       return currency;
	}
	
	public String getsubscriptionType(WebElement element)
	{
	   String subscriptiontype = element.findElement(By.xpath(".//h1")).getText();
       return subscriptiontype;
	}

	public void CountryChange_click()
	{
		Country_change.click();
	}
	
	public void SelectBhCOuntry_click()
	{
		Select_Bh_Country.click();
	}
	
	public void SelectkwCOuntry_click()
	{
		Select_kw_Country.click();
	}

	
}

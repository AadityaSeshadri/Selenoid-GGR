package pageobjects;
//import helpers.Log;

import java.sql.Driver;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import step_definitions.Hooks;
import step_definitions.Reusable_Functions;
//import pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class LandingPage {
	  final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomePage.class);
	 WebDriver driver = Hooks.driver;
	WebDriverWait wait  ;
	//****************Place required to change when xpath or property changes
	@FindBy(how=How.ID, using="search")
	public static WebElement Lnk_Home;
	//****************Place required to change when xpath or property changes


	public static void Navigate_LandingPage(WebDriver driver,String URL)
	{
		Reusable_Functions.Navigate(driver,URL);

	}
	
	public static void check_Landing_Page(WebDriver driver)
	{
		Reusable_Functions.waitForPageLoaded(driver);
		Assert.assertTrue(Lnk_Home.isDisplayed());
		Reusable_Functions.AddStepLogToReport("Home Page Displayed");
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
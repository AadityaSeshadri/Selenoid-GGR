package pageobjects;
//import helpers.Log;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import step_definitions.Hooks;
import step_definitions.Reusable_Functions;

//public class HomePage extends BaseClass{
	public class HomePage {

	private static Logger logger;
	//Logger logger ;
	WebDriver driver = Hooks.driver;

	/*public HomePage(WebDriver driver){
		super(driver);
	}*/

	//****************Place required to change when xpath or property changes
	@FindBy(how=How.XPATH, using="//a[@class='_2s25']")
	public static WebElement Lnk_Home;
	//****************Place required to change when xpath or property changes


	public static void check_HomePage()
	{
		Assert.assertTrue(Lnk_Home.isDisplayed());
		Reusable_Functions.AddStepLogToReport("Home Page Displayed");

	}
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
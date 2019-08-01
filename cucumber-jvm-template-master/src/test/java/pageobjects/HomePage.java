package pageobjects;
//import helpers.Log;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.apache.log4j.Logger;
import step_definitions.Hooks;
import step_definitions.Reusable_Functions;
//import pageobjects.Log;;
//public class HomePage extends BaseClass{
	public class HomePage {
		//final Logger logger = Log.getLogData(Log.class.getName());
		   //logger.Log.getLogData(Log.class.getName());
	  final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HomePage.class);
	//Logger logger ;
	WebDriver driver = Hooks.driver;

	/*public HomePage(WebDriver driver){
		super(driver);
	}*/

	//****************Place required to change when xpath or property changes
	@FindBy(how=How.XPATH, using="//strong[text()='Your account has been disabled']")
	public static WebElement Lnk_Home;
	//****************Place required to change when xpath or property changes


	public static void check_HomePage()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(Lnk_Home.isDisplayed());
		Reusable_Functions.AddStepLogToReport("Home Page Displayed");
		//log.info("@@@@@@@@@@@@@Driver Initialized@@@@@@@@@@@@@@@@@");
		

	}
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
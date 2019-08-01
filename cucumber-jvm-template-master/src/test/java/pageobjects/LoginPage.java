package pageobjects;
//import helpers.Log;

import java.io.IOException;

import org.codehaus.plexus.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.qameta.allure.Step;
import step_definitions.*;
import pageobjects.*;

//public class LoginPage extends BaseClass{

	public class LoginPage {
		//Logger logger = Log.getLogData(Log.class.getName());
		// Logger logger = Log.getLogData(Log.class.getName());
		final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoginPage.class);
	WebDriver driver = Hooks.driver;

	@FindBy(how=How.XPATH, using="//input[@id='email']")
	public static WebElement Txt_User_Name;
	
	@FindBy(how=How.XPATH, using="//input[@id='pass']")
	public static WebElement Txt_password;
	
	@FindBy(how=How.XPATH, using="//input[@value='Log In']")
	public static WebElement signin_button;
	//****************Place required to change when xpath or property changes


	@Step("Entering user Name:{0}")
	public static void Enter_Username(String UName) throws IOException {
		//log.info("Inside Entering Username");
		//logger.info("@@@@@@@@@@@@@Driver Initialized@@@@@@@@@@@@@@@@@");
		
		Reusable_Functions.ClearTextBox(Txt_User_Name);
		Reusable_Functions.AddStepLogToReport("Username cleared");
		Reusable_Functions.EnterTextBox(Txt_User_Name,UName);
		//log.info("@@@@@@@@@@@@@@Enter usernameo@@@@@@@@@@@     "+  UName  );
		Reusable_Functions.AddStepLogToReport("Username entered " + UName);
		

	}
	@Step("Entering Password:{0}")
	public static void Enter_Password(String Password)
	{
		//logger.info("@@@@@@@@@@@@@@Enter Password@@@@@@@@@@@");
		log.info("!!!!!!!!!!!!!!Inside Entering Username!!!!!!!!!!!!!!!!!!!!!");
		Reusable_Functions.ClearTextBox(Txt_password);
		Reusable_Functions.AddStepLogToReport("Password cleared");
		Reusable_Functions.EnterTextBox(Txt_password,Password);
		//log.info("@@@@@@@@@@@@@@Enter Password@@@@@@@@@@@     "+  Password  );
		Reusable_Functions.AddStepLogToReport("Password Entered XXXXXXXXX");
	}

	public static void Click_Signin()
	{
		
		Reusable_Functions.ButtonClick(signin_button);
		//log.info("@@@@@@@@@@@@@@Click Sign ino@@@@@@@@@@@");
		Reusable_Functions.AddStepLogToReport("Sign in Button Clicked");
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

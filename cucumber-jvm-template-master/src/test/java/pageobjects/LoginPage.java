package pageobjects;
//import helpers.Log;

import cucumber.api.Scenario;
import helpers.Log;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import step_definitions.Hooks;
import step_definitions.Reusable_Functions;

import java.io.File;
import java.io.IOException;

//public class LoginPage extends BaseClass{

	public class LoginPage {
	WebDriver driver = Hooks.driver;

	@FindBy(how=How.XPATH, using="//input[@id='email']")
	public static WebElement Txt_User_Name;
	
	@FindBy(how=How.XPATH, using="//input[@id='pass']")
	public static WebElement Txt_password;
	
	@FindBy(how=How.XPATH, using="//input[@value='Log In']")
	public static WebElement signin_button;
	//****************Place required to change when xpath or property changes



	public static void Enter_Username(String UName) throws IOException {

		Reusable_Functions.ClearTextBox(Txt_User_Name);
		Reusable_Functions.AddStepLogToReport("Username cleared");
		Reusable_Functions.EnterTextBox(Txt_User_Name,UName);
		Reusable_Functions.AddStepLogToReport("Username entered " + UName);

	}

	public static void Enter_Password(String Password)
	{
		Reusable_Functions.ClearTextBox(Txt_password);
		Reusable_Functions.AddStepLogToReport("Password cleared");
		Reusable_Functions.EnterTextBox(Txt_password,Password);
		Reusable_Functions.AddStepLogToReport("Password Entered XXXXXXXXX");
	}

	public static void Click_Signin()
	{
		Reusable_Functions.ButtonClick(signin_button);
		Reusable_Functions.AddStepLogToReport("Sign in Button Clicked");
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

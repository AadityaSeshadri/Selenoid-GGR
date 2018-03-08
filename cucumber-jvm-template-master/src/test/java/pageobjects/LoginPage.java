package pageobjects;
//import helpers.Log;

import helpers.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BaseClass{
	//static org.apache.log4j.Logger Log = org.apache.log4j.Logger.getLogger("LoginPage.java");
	public LoginPage(WebDriver driver){
		super(driver);
		//Logger Log = Logger.getLogger("LoginPage.java");
		//PropertyConfigurator.configure("log4j.properties");
	}    

	//****************Place required to change when xpath or property changes
	//@FindBy(how=How.XPATH, using="//input[@id='email']")
	@FindBy(how=How.ID, using="email")
	public static WebElement Txt_User_Name;
	
	//@FindBy(how=How.XPATH, using="//input[@id='pass']")
	@FindBy(how=How.ID, using="pass")
	public static WebElement Txt_password;
	
	//@FindBy(how=How.XPATH, using="//input[@value='Log In']")
	@FindBy(how=How.ID, using="loginbutton")
	public static WebElement signin_button;
	//****************Place required to change when xpath or property changes



	public static void Enter_Username(String UName)
	{
		Log.info("Logged Entered Usernamer in Login Page");
		Txt_User_Name.clear();
		Txt_User_Name.sendKeys(UName);
	}

	public static void Enter_Password(String Password)
	{
		Txt_password.clear();
		Txt_password.sendKeys(Password);
		Log.info("Password Entered" + Password);
	}

	public static void Click_Signin()
	{
		signin_button.click();
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

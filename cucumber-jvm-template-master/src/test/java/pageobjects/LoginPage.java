package pageobjects;
import helpers.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver){
		super(driver);
	}    

	//****************Place required to change when xpath or property changes
	@FindBy(how=How.XPATH, using="//input[@id='email']")
	public static WebElement Txt_User_Name;
	
	@FindBy(how=How.XPATH, using="//input[@id='pass']")
	public static WebElement Txt_password;
	
	@FindBy(how=How.XPATH, using="//input[@value='Log In']")
	public static WebElement signin_button;
	//****************Place required to change when xpath or property changes



	public static void Enter_Username(String UName)
	{
		Txt_User_Name.clear();
		Txt_User_Name.sendKeys(UName);
	}

	public static void Enter_Password(String Password)
	{
		Txt_password.clear();
		Txt_password.sendKeys(Password);
	}

	public static void Click_Signin()
	{
		signin_button.click();
	}
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

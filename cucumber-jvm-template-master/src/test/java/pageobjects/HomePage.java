package pageobjects;
import helpers.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class HomePage extends BaseClass{

	public HomePage(WebDriver driver){
		super(driver);
	}

	//****************Place required to change when xpath or property changes
	@FindBy(how=How.XPATH, using="//a[@class='_2s25']")
	public static WebElement Lnk_Home;
	//****************Place required to change when xpath or property changes


	public static void check_HomePage()
	{
		Lnk_Home.isDisplayed();
	}
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
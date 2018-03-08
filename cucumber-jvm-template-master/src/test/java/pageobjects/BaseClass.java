package pageobjects;

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;

public abstract class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;
	//public static Scenario scenario;

	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
		//BaseClass.scenario = scenario;
	}

}

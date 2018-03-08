package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import helpers.Log;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePage;
import pageobjects.LoginPage;
//import helpers.Log;


public class StepDefinitions {
    public WebDriver driver;
    //org.apache.log4j.Logger Log = org.apache.log4j.Logger.getLogger("StepDefinitions.java");

    public StepDefinitions()
    {
    	driver = Hooks.driver;
        PropertyConfigurator.configure("log4j.properties");

    }


    @When("^User Navigates to Facebook and Login with Username \"(.*?)\" and Password \"(.*?)\"$")
    public void user_Navigates_to_Facebook_and_Login_with_Username_and_Password(String arg1, String arg2) throws Throwable {

        //logger =
        PageFactory.initElements(driver, LoginPage.class);
        //logger.de
        Log.info("Started Execution");
        driver.get("https://www.facebook.com");
        Log.info("Navigated to Facebook");

        LoginPage.Enter_Username(arg1);
        Log.info("Entered Username");

        LoginPage.Enter_Password(arg2);
        Log.info("Entered Password");

        LoginPage.Click_Signin();
        Log.info("CLicked on sign in Button");



    }

    @Then("^User should be able to view Homepage$")
    public void user_should_be_able_to_view_Homepage() throws Throwable {
        PageFactory.initElements(driver, HomePage.class);
        HomePage.check_HomePage();
        Log.info("Checked for Homepage");

    }

    
}
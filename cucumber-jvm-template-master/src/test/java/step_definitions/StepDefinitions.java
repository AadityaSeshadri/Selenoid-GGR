package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import cucumber.api.Scenario;
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
    public Scenario scenario;
    //org.apache.log4j.Logger Log = org.apache.log4j.Logger.getLogger("StepDefinitions.java");

    public StepDefinitions()
    {
    	driver = Hooks.driver;
    	 scenario = Hooks.scenario;



    }


    //@When("^User Navigates to Facebook and Login with Username \"(.*?)\" and Password \"(.*?)\"$")
    @When("^User Logins Facebook$")
    public void user_Logins_Facebook() throws Throwable {
      //  public void user_Navigates_to_Facebook_and_Login_with_Username_and_Password(String arg1, String arg2) throws Throwable {
        System.out.println("Scenario name inside -------------------------" + scenario.getName());
        //logger =
        PageFactory.initElements(driver, LoginPage.class);
        //logger.de
        Log.info("Started Execution");
        driver.get("https://www.facebook.com");
        Log.info("Navigated to Facebook");

        //LoginPage.Enter_Username(arg1,scenario.getName(),scenario);

        LoginPage.Enter_Username(Reusable_Functions.hashMap.get("UserName"));
        Log.info("Entered Username");
        Reusable_Functions.Take_Screenshot(driver,scenario);

        //LoginPage.Enter_Password(arg2,scenario);
        LoginPage.Enter_Password(Reusable_Functions.hashMap.get("Password"));
        Log.info("Entered Password");
        Reusable_Functions.Take_Screenshot(driver,scenario);

        LoginPage.Click_Signin();
        Log.info("CLicked on sign in Button");
        Reusable_Functions.Take_Screenshot(driver,scenario);



    }

    @Then("^User should be able to view Homepage$")
    public void user_should_be_able_to_view_Homepage() throws Throwable {
        PageFactory.initElements(driver, HomePage.class);
        HomePage.check_HomePage();
        Log.info("Checked for Homepage");

    }

    
}
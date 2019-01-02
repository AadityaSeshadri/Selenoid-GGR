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

    public StepDefinitions()
    {
    	driver = Hooks.driver;
    	 scenario = Hooks.scenario;
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, HomePage.class);



    }

    @When("^User Logins Facebook with Username \"(.*?)\"  and Password \"(.*?)\"$")
    public void user_Logins_Facebook_with_Username_and_Password(String uname, String pass) throws Throwable {
        System.out.println("Scenario name inside -------------------------" + scenario.getName());
        Reusable_Functions.AddStepLogToReport("Execution Started");
        driver.get("https://www.facebook.com");
        Reusable_Functions.AddStepLogToReport("Navigated to Facebook Website");
        LoginPage.Enter_Username(uname);
        Reusable_Functions.Take_Screenshot(driver,scenario);
        LoginPage.Enter_Password(pass);
        Reusable_Functions.Take_Screenshot(driver,scenario);

        LoginPage.Click_Signin();
        Reusable_Functions.Take_Screenshot(driver,scenario);



    }

    @Then("^User should be able to view Homepage$")
    public void user_should_be_able_to_view_Homepage() throws Throwable {

        HomePage.check_HomePage();
        Log.info("Checked for Homepage");

    }

    
}
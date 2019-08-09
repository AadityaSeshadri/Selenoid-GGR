package step_definitions;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

import java.util.List;

public class StepDefinitions {
    public WebDriver driver;
    public Scenario scenario;

    public StepDefinitions()
    {
    	driver = Hooks.driver;
    	scenario = Hooks.scenario;
        PageFactory.initElements(driver, LoginPage.class);
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, LandingPage.class);



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

    }

    @Given("^User Navigates to Landing Page$")
    public void User_Navigates_Landing_Page(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        LandingPage.Navigate_LandingPage(driver,list.get(0));

    }
  
    @Then("^Validates Landing Page Elements$")
    public void Validates_LandingPage() throws Throwable {
        LandingPage.check_Landing_Page(driver);

    }

    
}
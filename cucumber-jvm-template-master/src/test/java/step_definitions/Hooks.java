package step_definitions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import helpers.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.imageio.ImageIO;

public class Hooks{
    public static WebDriver driver;
    public static Scenario scenario;

    @Before
    public void openBrowser(Scenario scenario) throws IOException {
        Hooks.scenario = scenario;
        //Reusable_Functions.Set_PreRequisites(scenario);

        //Phantom Driver Headless Execution
  /*Capabilities caps = new DesiredCapabilities();
        ((DesiredCapabilities) caps).setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0");
        File src = new File(System.getProperty("user.dir") +"//src//test//resources//Driver//phantomjs.exe");
        System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
        Log.info("Phantom Path Set");
        driver = new PhantomJSDriver(caps);*/


  //Chrome Headless
/*      System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        driver = new ChromeDriver(options);*/

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        driver = new ChromeDriver(options);



        Log.info("Driver Initialized");
        Log.info("******Excecution  started for the scenario*****"+ scenario.getName());
       }

     
    @After
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            Log.info("******Failure Noted in scenario*****"+ scenario.getName());
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                Log.info("Screenshot taken for error ");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
            Log.info("******Excecution  finished for the scenario*****"+ scenario.getName());
            driver.quit();

        }
        else
        {
            Log.info("******Excecution  finished for the scenario*****"+ scenario.getName());
            driver.quit();
        }
    }



}
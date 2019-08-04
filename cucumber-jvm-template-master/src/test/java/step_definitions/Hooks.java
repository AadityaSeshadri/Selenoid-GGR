package step_definitions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
//import io.github.bonigarcia.wdm.FirefoxDriverManager;
//import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageobjects.Utilites;
//import pageobjects.LoggerMech;


public class Hooks {
   
     final Logger logger = Utilites.getLogData(Logger.class.getName());
     //final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Hooks.class);

    //final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Hooks.class);
    public static  RemoteWebDriver driver;
    public static Scenario scenario;
    public static String OS_Name;

    //@Before("@Login")
    /*public void first (Scenario scenario)
    {
        System.out.println("*******************************mv ***********************************");
        try {
            //Reusable_Functions.getData(scenario.getName());
        } catch (IOException e) {
            System.out.println("Scenario Unable to Locate in Test Data");
        }

    }*/
    //@After("@Login")
    public void after(Scenario scenario)
    {
        Collections.emptyMap();
       /* for (Object objname : Reusable_Functions.hashMap.keySet()) {
            //System.out.println(objname);
            System.out.println(Reusable_Functions.hashMap.get(objname.toString()));

        }*/
        System.out.println("********" + Reusable_Functions.hashMap.get("DV1"));
    }


    @Before
    public void openBrowser(Scenario scenario) throws IOException {
        
        System.out.println("*********************Inside Before********************");
        Hooks.scenario = scenario;
        //Log.startLog("Test starts in Hooks Before");
       

       /*  if(Browser_To_Execute.equals("Chrome")||Browser_To_Execute.equals("chrome"))
        {
            OS_Name =  System.getProperty("os.name");
            OS_Name = OS_Name.contains("Windows")? System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe"):System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Driver/chromedriver_MAC");
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("headless");
            // options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);
        }
        if(Browser_To_Execute.equals("Chrome-Headless")||Browser_To_Execute.equals("chrome-headless"))
        {
            OS_Name =  System.getProperty("os.name");
            OS_Name = OS_Name.contains("Windows")? System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe"):System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Driver/chromedriver_MAC");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            // options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);
        }
        if(Browser_To_Execute.equals("Firefox")||Browser_To_Execute.equals("firefox"))
        {
            OS_Name =  System.getProperty("os.name");
            OS_Name = OS_Name.contains("Windows")? System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\chromedriver.exe"):System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Driver/chromedriver_MAC");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            // options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);
        }*/
        /*String FIREFOX = "firefox";
        String IE = "ie";
        String DEFAULT = "chrome";
        String browser = System.getProperty("Browser");
        System.out.println("browser"+ browser);

        if(browser.equals("IE"))
        {
            InternetExplorerDriverManager.getInstance().setup();
            driver = new InternetExplorerDriver();

        }
        else if (browser.equals("CHROME"))
        {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();

        }
        else if (browser.equals("CHROME-HEADLESS"))
        {
            ChromeDriverManager.getInstance().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);

        }
        else if(browser.equals("FIREFOX"))
        {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();

        }
        else if(browser.equals("HUB"))
        {
            DesiredCapabilities dr=null;

                dr=DesiredCapabilities.chrome();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                dr.setBrowserName("chrome");
                dr.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                dr.setPlatform(Platform.LINUX);
             driver=new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), dr);
        }
*/


DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setBrowserName("chrome");
capabilities.setVersion("75.0");

/*capabilities.setBrowserName("firefox");
capabilities.setVersion("68.0");*/



capabilities.setCapability("enableVNC", true);
capabilities.setCapability("enableVideo", true);
capabilities.setCapability("enableLog", true);
logger.info("@@@@@@@@@@@@@Capabilities Set@@@@@@@@@@@@@@@@@");
 driver = new RemoteWebDriver(
   URI.create("http://selenoid:4444/wd/hub").toURL(),
    //URI.create("http://test:test-password@127.0.0,1:4444/wd/hub").toURL(),
    capabilities
);
     System.out.println("**************************Driver Initialized***************************************");;
         logger.info("@@@@@@@@@@@@@Driver Initialized@@@@@@@@@@@@@@@@@");
        logger.info("@@@@@@@@@@@@@@Excecution  started for the scenario@@@@@@@@@@@"+ scenario.getName());
       }

     
    @After(order = 1)
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            /*Log.info("******Failure Noted in scenario*****"+ scenario.getName());
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


*/

            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                //This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                //Building up the destination path for the screenshot to save
                //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
                File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-ExtendedReports/screenshots/" + screenshotName + ".png");

                //Copy taken screenshot from source location to destination location
                //FileUtils.copy(sourcePath, destinationPath);
                FileUtils.copyFile(sourcePath, destinationPath);

                //This attach the specified screenshot to the test
                com.cucumber.listener.Reporter.addScreenCaptureFromPath(destinationPath.getAbsolutePath().toString());

                //test.fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString() + "/screenshotFolder/screenshot.png").build());
                //driver.quit();
            } catch (IOException e) {
            }

        }

        driver.quit();
        logger.info("****************************Execution Finished**************************");
    }
    //@After(order = 0)
    /*public void AfterSteps() throws InterruptedException {

            CucumberDetailedResults results = new CucumberDetailedResults();
            results.setOutputDirectory("target/");
            results.setOutputName("cucumber-results");
            results.setSourceFile(System.getProperty("user.dir")+"/target/cucumber.json");
            // Thread.sleep(2000);
            try {
                results.execute(true,true);
            } catch (Exception e) {
                e.printStackTrace();
            }


        driver.quit();

    }

*/

}
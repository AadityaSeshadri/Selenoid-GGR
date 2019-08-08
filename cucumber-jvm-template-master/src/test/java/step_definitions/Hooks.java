package step_definitions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import step_definitions.*;

public class Hooks {

    final Logger logger = Utilites.getLogData(Logger.class.getName());
    public static RemoteWebDriver driver;
    public static Scenario scenario;
    public static String OS_Name;
    @Before
    public void openBrowser(Scenario scenario) throws IOException {
       // logger.info("@@@@@@@@@@@@@Driver Initialized@@@@@@@@@@@@@@@@@"+ System.getProperty("Browser"));
        //System.out.println("&&&&&&&&&&&&&&&&&&Browser Value&&&&&&&&&&&&&&&&&" + System.getProperty("Browser"));
        File file = new File(System.getProperty("user.dir") + "\\ExecutionLog.log"); 
        if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        {
            System.out.println("File Not Present"); 
        }
        System.out.println("*********************Inside Before********************");
        Hooks.scenario = scenario;
        DesiredCapabilities capabilities = new DesiredCapabilities();
         //***********Chrome*********** */
        /*capabilities.setBrowserName("chrome");
        capabilities.setVersion("76.0");*/
        //***********FireFox***********/
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("68.0");
        //***********Opera*********** */
        /*capabilities.setBrowserName("chrome");
        capabilities.setVersion("62.0");*/
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLog", true);
        logger.info("@@@@@@@@@@@@@Capabilities Set@@@@@@@@@@@@@@@@@");
        driver = new RemoteWebDriver(
               // URI.create("http://selenoid:4444/wd/hub").toURL(),
                 URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities);
        System.out.println("**************************Driver Initialized***************************************");
        ;
        logger.info("@@@@@@@@@@@@@Driver Initialized@@@@@@@@@@@@@@@@@");
        logger.info("@@@@@@@@@@@@@@Excecution  started for the scenario@@@@@@@@@@@" + scenario.getName());
        
    }

    @After(order = 1)
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                // This takes a screenshot from the driver at save it to the specified location
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir")
                        + "/target/cucumber-ExtendedReports/screenshots/" + screenshotName + ".png");
                FileUtils.copyFile(sourcePath, destinationPath);
                com.cucumber.listener.Reporter.addScreenCaptureFromPath(destinationPath.getAbsolutePath().toString());
            } catch (IOException e) {
            }

        }

        driver.quit();
        logger.info("****************************Execution Finished**************************");
    }
   
}
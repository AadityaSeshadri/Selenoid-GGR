package step_definitions;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Reusable_Functions {

    public static void Take_Screenshot(WebDriver driver, Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
    public static void Set_PreRequisites(Scenario scenario) throws IOException {
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+scenario.getName()));
        PropertyConfigurator.configure("log4j.properties");


    }
}

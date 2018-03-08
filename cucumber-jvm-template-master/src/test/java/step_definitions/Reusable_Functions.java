package step_definitions;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusable_Functions {

    public static void Take_Screenshot(WebDriver driver, Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}

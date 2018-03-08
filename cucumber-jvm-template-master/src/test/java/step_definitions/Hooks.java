package step_definitions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.imageio.ImageIO;

public class Hooks{
    public static WebDriver driver;
    public static Scenario scenario;

    /*public Hooks(Scenario scenario)
    {
        Hooks.scenario = scenario;
    }*/
    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     *
     */


    public void openBrowser(Scenario scenario) throws IOException {
        Hooks.scenario = scenario;
 /*       File file = new File(System.getProperty("user.dir")+"//log");
        String[] myFiles;
        if(file.isDirectory()){
            myFiles = file.list();
            for (int i=0; i<myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }*/
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"//log"));
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots"));
        FileUtils.forceMkdir(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshots\\"+scenario.getName()));

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aaditya Seshadri\\Downloads\\cucumber-jvm-template-master\\cucumber-jvm-template-master\\src\\test\\resources\\Driver\\chromedriver.exe");
    	//driver = new ChromeDriver();
        //driver = new HtmlUnitDriver();

        //Headless with HTMLUNITDriver
      /*  driver = new HtmlUnitDriver(BrowserVersion.CHROME);
    	driver.manage().deleteAllCookies();
    	//driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1920, 1200));*/

        Capabilities caps = new DesiredCapabilities();
        //((DesiredCapabilities) caps).setJavascriptEnabled(true);


      //  ((DesiredCapabilities) caps).setCapability(
        //          PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
        //      System.getProperty("user.dir") +"//src//test//resources//Driver//phantomjs.exe"
        //);


       // ((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {"--web-security=no", "--ignore-ssl-errors=yes"});
        //((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
        ((DesiredCapabilities) caps).setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0");
        //((DesiredCapabilities) caps).setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36");
          //((DesiredCapabilities) caps).setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (Linux; U; Android 2.3.3; en-us; LG-LU3000 Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        File src = new File(System.getProperty("user.dir") +"//src//test//resources//Driver//phantomjs.exe");
        System.setProperty("phantomjs.binary.path", src.getAbsolutePath());
        driver = new PhantomJSDriver(caps);
        //driver.manage().window().setSize(new Dimension(1280, 1024));
    }

     
   // @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
   /* public void embedScreenshot(Scenario scenario) {
       
       // if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());

         //byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

            //BufferedImage buff = Graphics2DRenderer.renderToImageAutoSize(driver.getCurrentUrl(), 1024);
            //ImageIO.write(buff, "png", new File("screenshot.png"));
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }

        driver.quit();
    }*/




}
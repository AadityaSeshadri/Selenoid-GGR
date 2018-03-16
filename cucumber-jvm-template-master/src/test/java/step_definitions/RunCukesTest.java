package step_definitions;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import helpers.ConfigReaderClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-json-report.json","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-ExtendedReports/report.html"})
		//tags = {"@initial"})

@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
		//retryCount = 3,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		//coverageReport = true,
		jsonUsageReport = "target/cucumber-usage.json",
		usageReport = true,
		toPDF = true,
		outputFolder = "target/cucumber-html-report")

public class RunCukesTest{

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
	
}
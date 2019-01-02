package step_definitions;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import helpers.ConfigReaderClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import sun.security.util.Debug;

import java.io.File;



@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
		//retryCount = 0,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		//coverageReport = true,
		jsonUsageReport = "target/cucumber-usage.json",
		usageReport = true,
		toPDF = true,
		//excludeCoverageTags = {"@flaky" },
		includeCoverageTags = {"@Login" },
		outputFolder = "target/")

@CucumberOptions(
		features = "classpath:features",
		//features = "./src/test/resources/features",
		//glue = "C:\\SeleniumCucumberCOde\\resent code\\cucumber-jvm-template-master\\src\\test\\java\\step_definitions",
		//"json:target/cucumber.json",
		//"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",   "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"
		plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-ExtendedReports/report.html"},
		//plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",   "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-ExtendedReports/report.html"},
		tags = {"@Login"},
		monochrome = true
		)
		//tags = {"@initial"})

public class RunCukesTest{

	//private static final Debug FileReaderManager = ;

	@AfterClass
	public static void writeExtentReport() {
		/*Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//configs//extent-config.xml"));
		//Reporter.loadXMLConfig(new File(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath())));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");*/

	}
	
}
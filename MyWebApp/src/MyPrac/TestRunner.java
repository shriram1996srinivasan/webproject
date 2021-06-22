package MyPrac;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		plugin = {"pretty","html:report/html","json:report/json/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		features = "src/MyPrac/Demo.feature",
		tags= {"@test1"},
		glue = {"MyPrac"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}

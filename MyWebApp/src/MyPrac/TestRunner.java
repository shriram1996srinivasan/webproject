package MyPrac;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		plugin = {"pretty","html:report/html","json:report/json/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","rerun:target/rerun.txt"},
		features = "src/MyPrac/Demm.feature",
//		features = "@target/rerun.txt",
		monochrome=true,
		snippets=SnippetType.CAMELCASE,
		tags= {"@test"},
		glue = {"MyPrac"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}

package parallel;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/test/resources/parallel" }, 
glue = { "parallel"}, monochrome = true, 
plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"timeline:test-output-thread/" })
public class ParallelRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)

	public Object[][] scenarios() {
		return super.scenarios();

	}
}

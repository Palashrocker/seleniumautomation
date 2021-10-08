package parallel;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.factory.DriverFactory;
import com.util.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private Configuration config;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		config = new Configuration();
		prop = config.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void screenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			String ScreenShotName = scenario.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenShotName);
			// byte is used so that it can be uploaded to jenkinds or ci/cd tool
			/* Take Screenshot
			 * File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 * FileUtils.copyFile(src, new File(""));
			 */
		}
	}
}

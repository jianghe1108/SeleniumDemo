package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testGrid2 {

	WebDriver driver = null;

	String baseUrl = "http://www.baidu.com/";

	@Parameters({ "nodeUrl", "browser" })
	@BeforeClass
	public void startBrowser(String node, String browser)
			throws MalformedURLException {
		DesiredCapabilities capability = null;
		if (browser.equalsIgnoreCase("ff")) {
			capability = DesiredCapabilities.firefox();

			
		} else if (browser.equalsIgnoreCase("ie")) {
			capability = DesiredCapabilities.internetExplorer();

		} else if (browser.equalsIgnoreCase("chrome")) {

			capability = DesiredCapabilities.chrome();


		} else {
			this.driver = new FirefoxDriver();
		}

		this.driver = new RemoteWebDriver(new URL(node), capability);
	}

	@AfterClass
	public void quitBrowser() {
		this.driver.quit();
	}

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		this.driver.get(baseUrl);
		Thread.sleep(5000);

	}

}

package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class testGrid1 {

	WebDriver driver = null;
	String nodeUrl="http://10.7.90.212:6655/wd/hub";
	String baseUrl="htttp://www.baidu.com/";
	@Test
	public void testFF() throws MalformedURLException, InterruptedException{
		DesiredCapabilities capability = DesiredCapabilities.firefox();
	  this.driver = new RemoteWebDriver(new URL(nodeUrl),capability);
	this.driver.get(baseUrl);
	Thread.sleep(5000);
	this.driver.quit();
	}
	
	@Test
	public void testIE() throws MalformedURLException, InterruptedException{
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
	  this.driver = new RemoteWebDriver(new URL(nodeUrl),capability);
	this.driver.get(baseUrl);
	Thread.sleep(5000);
	this.driver.quit();
	}
}

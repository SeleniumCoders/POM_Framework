package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Factory;

import NotPartOfFramework.LoginMultipleTimesWithFactory;
import config.ConfigurationReader;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeSuite
	public void readConfiguration()
	{
		ConfigurationReader.getInstance().readConfigFile();
	}

	
	@BeforeMethod
	public WebDriver beforeMethod(ITestContext context) throws MalformedURLException
	{
		String type = ConfigurationReader.getInstance().browseType;
		String url = ConfigurationReader.getInstance().url;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch(type)
		{
			case "chrome": //System.setProperty("webdriver.chrome.driver","F:\\Selenium\\JarFiles\\chromedriver.exe"); 	
			capabilities = DesiredCapabilities.chrome();
	        driver = new RemoteWebDriver(new URL("http://192.168.0.2:4444/wd/hub"), capabilities);
			
			
			break;
			
			case "ie": //System.setProperty("webdriver.ie.driver","F:\\Selenium\\JarFiles\\IEDriverServer.exe");  
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			driver = new RemoteWebDriver(new URL("http://192.168.0.2:4444/wd/hub"), capabilities);
			break;
			
			case "firefox": //System.setProperty("webdriver.gecko.driver","F:\\Selenium\\JarFiles\\geckodriver.exe");
			capabilities = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http://192.168.0.2:4444/wd/hub"), capabilities);
			break;
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		context.setAttribute("driver", driver);
		return driver;
	}
	
/*	@BeforeMethod
	public void beforeMethod()
	{
		
		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\JarFiles\\chromedriver.exe"); 				
		driver=new ChromeDriver();        
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
	}
*/	
	
		
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

}


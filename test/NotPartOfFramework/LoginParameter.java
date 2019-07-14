package NotPartOfFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.login.LoginPage;

import base.BaseClass;

public class LoginParameter extends BaseClass {
	
	@Test()
	@Parameters({"username","password","browser"})
	public void Login_TC1(String username,String password, String browser)
	{
		
		System.out.println(username);
		WebDriver driver = createDriver(browser);
		LoginPage Lobj = new LoginPage(driver);
		Lobj.login(username,password);
		
		
	}
	
	

	public WebDriver createDriver(String type)
	{
		WebDriver driver = null;
		switch(type)
		{
			case "chrome": System.setProperty("webdriver.chrome.driver","F:\\Selenium\\JarFiles\\chromedriver.exe"); 				
			driver=new ChromeDriver(); 
			break;
			
			case "ie": System.setProperty("webdriver.ie.driver","F:\\Selenium\\JarFiles\\IEDriverServer.exe");  
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			driver = new InternetExplorerDriver(capabilities);
			break;
			case "firefox": System.setProperty("webdriver.gecko.driver","F:\\Selenium\\JarFiles\\geckodriver.exe"); 
			driver = new FirefoxDriver();     
			break;
		}
		
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		
		return driver;
	}
	

}

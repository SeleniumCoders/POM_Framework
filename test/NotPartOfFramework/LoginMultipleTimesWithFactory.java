package NotPartOfFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.login.LoginPage;

public class LoginMultipleTimesWithFactory
{
    private String param = "";
 
    public LoginMultipleTimesWithFactory(String param) {
        this.param = param;
    }
 
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before SimpleTest class executed.");
    }
 
    @Test
    public void testMethod() {
        System.out.println("testMethod parameter value is: " + param);
        System.setProperty("webdriver.chrome.driver","F:\\Selenium\\JarFiles\\chromedriver.exe"); 				
        WebDriver driver=new ChromeDriver(); 
        driver.get("http://demo.guru99.com/v4/");
        LoginPage Lobj = new LoginPage(driver);
		Lobj.login(param,"");
    }
    
    
    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                                new LoginMultipleTimesWithFactory("one"),
                                new LoginMultipleTimesWithFactory("two")
                            };
    }
}
 

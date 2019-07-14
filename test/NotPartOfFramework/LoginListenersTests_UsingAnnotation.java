package NotPartOfFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import com.login.LoginPage;
import base.BaseClass;

@Listeners(listeners.TestListeners.class)
public class LoginListenersTests_UsingAnnotation extends BaseClass {
	
	
	
	
	@Test()
	public void Login_TC1()
	{
		System.out.println("TC1");
		WebDriver driver = getDriver();
		LoginPage Lobj = new LoginPage(driver);
		Lobj.login("Login_TC1");
		
		Assertion assertion = new Assertion();
		assertion.assertEquals(false, true);
		
	}

	
}

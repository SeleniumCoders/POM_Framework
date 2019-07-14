package NotPartOfFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.login.LoginPage;

import base.BaseClass;

public class LoginMultipleTimes extends BaseClass {
	
	@Test(dataProvider="dataMethod")
	public void Login_TC1(String username,String password,String other)
	{
		System.out.println("TC1");
		WebDriver driver = getDriver();
		LoginPage Lobj = new LoginPage(driver);
		Lobj.login(username,password);
	}
	
	@DataProvider
	public Object[][] dataMethod(){
		Object obj[][] = {{"uid1","pwd","kiran"},{"uid2","pwd","dsg"}};
		return obj;
	}

}

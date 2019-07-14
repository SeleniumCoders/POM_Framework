package com.customer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.login.LoginPage;
import com.login.NavigationPage;
import com.login.NewCustomerPage;

import base.BaseClass;

public class NewCustomerTests extends BaseClass {
	
	@Test()
	public void NewCustomerValidation_TC1()
	{
		
		WebDriver driver = getDriver();
		//Setting implicit waits
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		LoginPage Lobj = new LoginPage(driver);
		Lobj.login("NewCustomerValidation_TC1");
		
		NavigationPage Nobj = new NavigationPage(driver);
		Nobj.navigateToNewCustomer();
		
		NewCustomerPage NCobj = new NewCustomerPage(driver);
		NCobj.eneterFormDetails();
		
	}

}

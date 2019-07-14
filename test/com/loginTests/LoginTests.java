package com.loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.login.LoginPage;

import base.BaseClass;

public class LoginTests extends BaseClass {
	
	
	
	@Test(enabled=false)
	public void Login_Disabled()
	{
		WebDriver driver = getDriver();
		LoginPage Lobj = new LoginPage(driver);
		Lobj.login("Login_Disabled");	
		
	}
	
	
	@Test(priority=7,groups={"R1"})
	public void Login_TC1()
	{
		System.out.println("TC1");
		WebDriver driver = getDriver();
		LoginPage Lobj = new LoginPage(driver);
		Lobj.login("Login_TC1");
		
		Assertion assertion = new Assertion();
		assertion.assertEquals(false, true);
		
	}

	
	@Test(priority=1, groups={"R2"})
	public void Login_TC2()
	{
		System.out.println("TC2");
		WebDriver driver = getDriver();
		LoginPage Lobj = new LoginPage(driver);
		Lobj.validateLoginPage();
		
		
	}
	
	@Test(expectedExceptions={NoSuchFieldException.class}, dependsOnMethods={"Login_TC2"})
	public void Login_TC3()
	{
		
		WebDriver driver = getDriver();
		LoginPage Lobj = new LoginPage(driver);
		Lobj.resetValidation();
		
		
	}
}

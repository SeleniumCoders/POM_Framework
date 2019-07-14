package com.login;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import config.ConfigurationReader;
import functions.FunctionLib;

public class LoginPage {
	
		
	@FindBy(name="uid")
	WebElement txt_userName;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	
	@FindBy(name="btnLogin")
	WebElement btn_submit;
	
	@FindBy(xpath="//*[text()='UserID']")
	WebElement lbl_UserID;
	
	@FindBy(xpath="//*[text()='Passwrod']")
	WebElement lbl_password;
	
	@FindBy(name="btnReset")
	WebElement btn_reset;
	
	FunctionLib fun = new FunctionLib();
	ConfigurationReader config = ConfigurationReader.getInstance();
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
		 this.driver = driver;
	}
	
	
	public void login(String userName, String Password)
	{
		txt_userName.sendKeys(userName);
		txt_password.sendKeys(Password);
		btn_submit.click();
	}
	
	
	public void login(String id)
	{
		HashMap<String, String> row = config.getRow("LogInDetails-"+id);
		txt_userName.sendKeys(row.get("UserName"));
		txt_password.sendKeys(row.get("Password"));
		
		
		fun.pageScreenPrint(driver,"Login");
		btn_submit.click();
	}
	
	public void resetValidation()
	{
		txt_userName.sendKeys("mngr204992");
		txt_password.sendKeys("pUhevyg");
		btn_reset.click();
		
		fun.checkTextDefaultValue(txt_userName, "");
		fun.checkTextDefaultValue(txt_password, "");
		
		
	}
	
	public void validateLoginPage()
	{
		fun.checkDisplayed(txt_userName, true);
		
		txt_userName.sendKeys("mngr204992");
		txt_password.sendKeys("pUhevyg");
		
		
		
		
		
	}
	

}


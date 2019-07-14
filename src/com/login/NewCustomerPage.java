package com.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	@FindBy(name="name")
	WebElement txt_CustomerName;
	
	public NewCustomerPage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
	}
	
	public void eneterFormDetails()
	{
		txt_CustomerName.sendKeys("Kiran");
	}

}

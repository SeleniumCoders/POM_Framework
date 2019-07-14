package com.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage {

	WebDriver driver ;
	@FindBy(linkText="New Customer")
	WebElement lnk_NewCustomer;
	
	public NavigationPage(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
		 this.driver = driver;
	}
	
	
	public void navigateToNewCustomer()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(lnk_NewCustomer));
		
		lnk_NewCustomer.click();
	}
}

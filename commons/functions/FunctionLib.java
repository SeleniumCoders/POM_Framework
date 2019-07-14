package functions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

public class FunctionLib {
	
	
	public void checkTextDefaultValue(WebElement ele, String expValue)
	{
		Assertion assertion = new Assertion();
		String actValue =ele.getAttribute("value");
		assertion.assertEquals(actValue, expValue);
	}
	
	public void checkDisplayed(WebElement ele, boolean expValue)
	{
		Assertion assertion = new Assertion();
		boolean actValue =ele.isDisplayed();
		assertion.assertEquals(actValue, expValue);
	}
	
	
	public void pageScreenPrint(WebDriver driver,String FileName)
	{
		try{
			TakesScreenshot tk = (TakesScreenshot) driver;
			File Src = tk.getScreenshotAs(OutputType.FILE);
			File dest = new File("F:\\Selenium\\Doccuments\\"+FileName+".jpg");
			FileUtils.copyFile(Src, dest);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}

}

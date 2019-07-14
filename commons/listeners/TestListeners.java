package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import functions.FunctionLib;

public class TestListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("The name of the testcase started is :"+result.getName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getName());
		String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("driver");
        
        FunctionLib func = new FunctionLib();
        func.pageScreenPrint(driver, methodName + "_FailledPage");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is :"+result.getName());		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}

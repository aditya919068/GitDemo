package framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Reporting;
import resources.base;

public class ListenersPage extends base implements ITestListener {
	ExtentReports extent=Reporting.config();
	ExtentTest Test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		Test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(Test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		// Code to make sure that the script doesn't gets confused with the drivers
		// instances and points to the real driver which is being initialized
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();

		}

		// Code to get the screenshot with the method name
		String TestcaseName = result.getMethod().getMethodName();

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshot(TestcaseName, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

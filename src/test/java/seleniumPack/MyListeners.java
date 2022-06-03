package seleniumPack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners extends DriverUtil implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		System.out.println("takeScreenshot  is called");
		takeScreenshot(result.getName() + " - " + browserName + " - " + result.getStatus());
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		System.out.println("takeScreenshot  is called");
		takeScreenshot(result.getName() + " - " + browserName + " - " + result.getStatus());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}


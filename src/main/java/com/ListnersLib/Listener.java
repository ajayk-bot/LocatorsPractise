package com.ListnersLib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.baseLibraries.TestBase;

//https://www.swtestacademy.com/how-to-use-testng-listeners/

public class Listener extends TestBase implements ITestListener {

	
	
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	}

	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		
//		Date date = new Date();
//		System.out.println("Printing date value: " + date);
//		SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//		timestamp.format(date).toString();
//		System.out.println("timestap variable : " +timestamp);
		
		String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		
		TakesScreenshot screen_shot = (TakesScreenshot) driver;
		File source = screen_shot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\AllScreenShot\\"+"Screenshot_" + timestamp + ".jpeg");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
					System.out.println("Error occur while taking screenshot!!!!!");
		}

		
		
		
	}

	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
	}

	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
	}

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

}

package listnersInTestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class createdListesners implements ITestListener {

	
	 
	   public void onTestStart(ITestResult result) {
		   System.out.println("Test Started : " +result.getName());
	   }

	  
	   public void onTestSuccess(ITestResult result) {
		   System.out.println("Test Successfully Finished : " +result.getName());
	   }

	  
	   public void onTestFailure(ITestResult result) {
	     System.out.println("Test Failure : "+ result.getName());
	     
	     TakesScreenshot ts = (TakesScreenshot)PractiseListner.driver;
			File file = ts.getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(file, new File("E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\AllScreenShot\\testFailure.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("screenshot is taken");
	     
	   }

	  
	   public  void onTestSkipped(ITestResult result) {
		   System.out.println("Test OnSkipped : "+ result.getName());
	   }

	 
	   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		   System.out.println("Test Failed but within success percentage : " +result.getName());
	   }

	   
	   public void onTestFailedWithTimeout(ITestResult result) {
	     System.out.println("Test onTestFailedWithTimeout : "+ result.getName());
	   }

	   
	   public void onStart(ITestContext context) {
		   System.out.println("This is onStart method : " +context.getOutputDirectory()); //where the output directories.
	   }

	   public void onFinish(ITestContext context) {
		   System.out.println("This is onPassed method : " +context.getPassedTests()); //list of all test are passed
			System.out.println("This is onFinish method : " +context.getFailedTests());
	   }
	
	
	
}

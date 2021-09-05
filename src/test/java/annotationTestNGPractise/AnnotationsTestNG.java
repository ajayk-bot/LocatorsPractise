package annotationTestNGPractise;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsTestNG {

	public WebDriver driver;
	public String url = "https://www.lambdatest.com/";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("The setup process is completed");
	}

	@BeforeTest
	public void profileSetup() {
		driver.manage().window().maximize();
		System.out.println("The profile setup process is completed");

	}

	@BeforeClass
	public void appSetup() {
		driver.get(url);
		System.out.println("The app setup process is completed");
	}

	@BeforeMethod
	public void checkLogin() {
		driver.get("https://accounts.lambdatest.com/login");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ajaykumarzib@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ANshu@1234");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		System.out.println("The login process on lamdatest is completed");
	}

	@Test(groups = "urlValidation")
	public void testCurrentUrl() throws InterruptedException {
		driver.findElement(By.xpath("//div[4]/a[1]")).click();
		Thread.sleep(6000);
		String currentUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, "https://automation.lambdatest.com/timeline/?viewType=build&page=1",
				"url did not matched");
		System.out.println("The url validation test is completed");
	}

	@AfterMethod
	public void screenShot() throws IOException {
		TakesScreenshot scr = ((TakesScreenshot) driver);
		File file1 = scr.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file1, new File("E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\AllScreenShot\\LambdaTest.PNG"));
		System.out.println("Screenshot of the test is taken");
	}

	@AfterClass
	public void closeUp() {
		driver.close();
		System.out.println("The close_up process is completed");
	}

	@AfterTest
	public void reportReady() {
		System.out.println("Report is ready to be shared, with screenshots of tests");
	}

	@AfterSuite
	public void cleanUp() {

		System.out.println("All close up activities completed");
	}

	@BeforeGroups("urlValidation")
	public void setUpSecurity() {
		System.out.println("url validation test starting");
	}

	@AfterGroups("urlValidation")
	public void tearDownSecurity() {
		System.out.println("url validation test finished");
	}

}
package practiseScreenShotAndListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SaveScreenshotWithTime {

	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		 driver = new ChromeDriver();
	}

	@Test
	public void browsePageTest() {

		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String pageTitle = driver.getTitle();
		System.out.println("The title of this page is ===> " + pageTitle);
		Assert.assertEquals(pageTitle, "Facebook – log in or sign up");
		try {
			screenShot(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}

	public static void screenShot(WebDriver driver) throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\AllScreenShot\\Screenshot_" + timestamp() + ".jpeg");
		FileUtils.copyFile(source, destination);

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
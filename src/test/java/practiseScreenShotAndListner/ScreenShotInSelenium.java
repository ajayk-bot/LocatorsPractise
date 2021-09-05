package practiseScreenShotAndListner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ScreenShotInSelenium {

	public WebDriver driver;

	@org.testng.annotations.BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();

		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("#txtUsername")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");

		TakesScreenshot takeScr = (TakesScreenshot) driver;
		File file = takeScr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,
				new File("E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\AllScreenShot\\loginpage.png"));
		System.out.println("login page screen shot is taken");
		
		
		driver.findElement(By.cssSelector("#btnLogin")).click();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("a#menu_admin_viewAdminModule.firstLevelMenu")).click();
		driver.findElement(By.cssSelector("input#searchSystemUser_userName[name='searchSystemUser[userName]']"))
				.sendKeys("Rebecca.Harmony");
		WebElement userRole = driver
				.findElement(By.cssSelector("#searchSystemUser_userType[name='searchSystemUser[userType]']"));
		userRole.click();
		Select dropDownUserRole = new Select(userRole);
		dropDownUserRole.selectByVisibleText("ESS");
		// dropDown.selectByValue(2);
		// dropDown.selectByIndex(3);

		driver.findElement(By.cssSelector("#searchSystemUser_employeeName_empName")).sendKeys("Rebecca Harmony");

		Select dropDownStatus = new Select(driver.findElement(By.cssSelector("#searchSystemUser_status")));
		dropDownStatus.selectByValue("1");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

		TakesScreenshot adminPage = (TakesScreenshot) driver;
		File scrFile = adminPage.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File("E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\AllScreenShot\\admin.png"));

	}

	@org.testng.annotations.AfterClass
	public void tearDown() {
		driver.quit();
	}

}

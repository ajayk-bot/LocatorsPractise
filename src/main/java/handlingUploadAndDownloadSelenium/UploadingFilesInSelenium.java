package handlingUploadAndDownloadSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//https://dzone.com/articles/how-to-download-amp-upload-files-using-selenium-wi

public class UploadingFilesInSelenium {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@Test
	public void TC01_HomePage() {
		System.out.println("tc01");
		WebElement uploadEle = driver.findElement(By.cssSelector("#uploadfile_0"));
		uploadEle.sendKeys("E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\logfile.log");

		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//button[@id='submitbutton']")).click();

		// use of explicit wait here.
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" h3 > center")));

		System.out.println(driver.findElement(By.cssSelector(" h3 > center")).getText());
		System.out.println("END here");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

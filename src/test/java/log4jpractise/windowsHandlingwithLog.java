package log4jpractise;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class windowsHandlingwithLog extends LoggingClass {
	public WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("chrome browser was launched. Excuated in @BeforeClass annotation");

	}

	@Test
	public void browsePageTest() {

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/");

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();

		String text = driver
				.findElement(By.xpath("//a[contains(text(),'Core java for Automation Testers + Interview Progr')]"))
				.getText();
		System.out.println(text);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(text);
		logger.error("wrong locators");
		System.out.println("succesfully");

		logger.info("Test completed. Excuated in @Test annotation");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("chrome browser was closed. Excuated in @AfterClass annotation");
	}

}

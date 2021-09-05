package handlingUploadAndDownloadSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFileInSelenium {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	//method to handle windows and new tab
	public void getWindows(List<String> list, int num) {
		String newTabID = list.get(num);
		driver.switchTo().window(newTabID);	
	}

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@Test
	public void TC01_downLoadFilePDF() throws InterruptedException {
		System.out.println("TC01");

		// handling new tab here
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent windows ID: " + parentWindow);
		System.out.println("Parent Window Handle: " + driver.getTitle());

		// click on this will open new tab
		driver.findElement(By.linkText("March 2020")).click();
	//	driver.findElement(By.linkText("February 2020")).click();
	//	driver.findElement(By.linkText("January 2020")).click();
	//	driver.findElement(By.linkText("December 2019")).click();
	//	driver.findElement(By.linkText("November 2019")).click();
		driver.findElement(By.linkText("RFP")).click();
		

		// define List here to collected New opened window here.
		List<String> clollectedNewTabID = new ArrayList<String>();
		// Now here is the New Tab handling code

		// Get All Tabs or Window handles and iterate using for each loop
		for (String handle : driver.getWindowHandles()) {
		//	System.out.println(handle);
			clollectedNewTabID.add(handle);
			//driver.switchTo().window(handle);
			//System.out.println(driver.getCurrentUrl());
		}

		System.out.println(clollectedNewTabID);
		getWindows(clollectedNewTabID, 1);
		System.out.println(driver.getCurrentUrl());
		
		//driver.switchTo().window(parentWindow);
		//System.out.println(driver.getTitle());

	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

}

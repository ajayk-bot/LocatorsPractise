package handlingUploadAndDownloadSelenium;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomatingFileHandling {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");

		//assgining the path to download the files.
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		driver = new ChromeDriver(options);
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	@Test
	public void TC01_HomePage() {
		System.out.println("tc01");
		driver.findElement(By.linkText("3.141.59")).click();

		File folder = new File(System.getProperty("user.dir"));
		File[] listOfFiles = folder.listFiles();
		
		boolean found = false;
		File f = null;
		/*
		 * for (File listOfFile : listOfFiles) { if (listOfFile.isFile()) { String
		 * fileName = listOfFile.getName(); System.out.println("File " +
		 * listOfFile.getName()); if
		 * (fileName.matches("selenium-server-standalone-3.141.59.jar")) { f = new
		 * File(fileName); System.out.println("Inside the loop"); found = true; }
		 * 
		 * } }
		 */
		
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fileName = listOfFile.getName();
				System.out.println("File " + listOfFile.getName());
				
				while(fileName.matches("selenium-server-standalone-3.141.59.jar")) {
					System.out.println("File is found");
					break;
				}

			}
			
		
		}
		
		
		
		
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}

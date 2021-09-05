package com.baseLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public static WebDriver driver;
	//Logs log = new Logs();
	
	
	
	
	@BeforeTest
	public void initializeMethod() {
		
		System.out.println("Called from Before TEST");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://www.behance.net/");
		//System.out.println(driver.getTitle());

	}
	
	
	@AfterTest
	public void tearDown() {
		System.out.println("Called from After TEST");
		if(driver!=null)
			driver.quit();
	}
	

}

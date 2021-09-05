package OrangeHRMTestCases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class byPassLoginStoredCookiesInFile {

	public static WebDriver driver;
	public static WebDriverWait wait;

	
	
	public static void main(String[] args) {

	
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.get("https://www.facebook.com/");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
	//	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	//	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	//	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		//try for facebook
	//	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ajaykumarzib@gmail.com");
	//	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Sherya@1234");
	//	driver.findElement(By.cssSelector("button[name='login'][type='submit']")).click();
		
		//try for automation practise
		
		driver.findElement(By.id("email")).sendKeys("ajaykumar.kumar937@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Adda@1234");
		driver.findElement( By.id("SubmitLogin")).click();
		
		
		// Create a file to store Login Information
		File file = new File("Cookiefile.data");
		try {
			// Delete old file if already exists
			file.delete();
			file.createNewFile();
			FileWriter file1 = new FileWriter(file);
			BufferedWriter Bwritecookie = new BufferedWriter(file1);

			// Getting the cookie information
			Set<Cookie> cookies = driver.manage().getCookies();
			System.out.println("getting cookies values : "+ cookies);
			for (Cookie ck : cookies) {
				Bwritecookie.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwritecookie.newLine();

				System.out.println( "Name: "+ck.getName());
				System.out.println( "Value: "+ck.getValue());
				System.out.println( "Domain: "+ck.getDomain());
				System.out.println( "Path: "+ck.getPath());
				System.out.println( "Expiry: "+ck.getExpiry());
				System.out.println( "Security: "+ck.isSecure());

			}

			Bwritecookie.close();

			file1.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		//System.out.println(driver.findElement(By.xpath("//a[@id='welcome']")).getText());
		//String dashBoard = driver.findElement(By.cssSelector(".head > h1")).getText();
		//Assert.assertEquals("Dashboard", dashBoard);
		
		

	}
}

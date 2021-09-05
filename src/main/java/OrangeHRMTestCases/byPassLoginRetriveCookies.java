package OrangeHRMTestCases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class byPassLoginRetriveCookies {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws IOException, InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		File file = new File("Cookiefile.data");
		FileReader fileRead = new FileReader(file);

		BufferedReader reader = new BufferedReader(fileRead);
		//to get expiryDate code
		// Tue Jul 04 20:36:14 IST 2023
		
		String strLine;

		while ((strLine = reader.readLine()) != null) {
			StringTokenizer stringToken = new StringTokenizer(strLine, ";");
			System.out.println(stringToken);
			while (stringToken.hasMoreTokens()) {
				String name = stringToken.nextToken();
				String value = stringToken.nextToken();
				String domain = stringToken.nextToken();
				String path = stringToken.nextToken();
				String date = stringToken.nextToken();
				System.out.println("print using tokenizer:"+date);
				
				String input = date;
				Date date1 = new SimpleDateFormat("EEE MMM d HH:mm:ss 'XXX' yyyy").parse(input);
				System.out.println(date1);
				String output = new SimpleDateFormat("yyyy-MM-dd").format(date1);
				System.out.println(output);
				
				Date expiry = null;
				String val;
				if (!(val = stringToken.nextToken()).equals("null")) {
					expiry = new Date(val);
				}

				/*
				 * Name: datr 
				 * Value: 2KbhYM36XuW3Qw2atupkm3H9 
				 * Domain: .facebook.com 
				 * Path: /
				 * Expiry: Tue Jul 04 17:47:29 IST 2023 
				 * Security: true
				 * 
				 */

				Boolean isSecure = new Boolean(stringToken.nextToken()).booleanValue();
				Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);

				driver.manage().addCookie(ck);
			}
		}
	//	driver.get("https://www.facebook.com/");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Thread.sleep(3000);
		System.out.println(
				driver.findElement(By.xpath("//span[contains(text(),'COVID-19 Information Centre')]")).getText());
		String covid19Msg = driver.findElement(By.xpath("//span[contains(text(),'COVID-19 Information Centre')]"))
				.getText();
		Assert.assertEquals("Dashboard", covid19Msg);
		driver.quit();
	}

}

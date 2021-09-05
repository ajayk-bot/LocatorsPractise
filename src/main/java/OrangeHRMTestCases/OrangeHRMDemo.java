package OrangeHRMTestCases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//https:opensource-demo.orangehrmlive.com/index.php/dashboard
//https://abstracta.us/blog/software-testing/best-demo-websites-for-practicing-different-types-of-software-tests/
//https://www.h2kinfosys.com/blog/cookies-handling-in-selenium-webdriver/
public class OrangeHRMDemo extends BaseTest {




	// Method() To store the Login Information create file named Cookies

	@Test(enabled = true)
	public void TC01_verifyLoginIn_LandOnDashBoard() throws IOException {
		System.out.println("tc01");
		// calling login method from base test
		

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
			for (Cookie ck : cookies) {
				Bwritecookie.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				Bwritecookie.newLine();

				System.out.println(ck.getName());
				System.out.println(ck.getValue());
				System.out.println(ck.getDomain());
				System.out.println(ck.getPath());
				System.out.println(ck.getExpiry());
				System.out.println(ck.isSecure());

			}

			Bwritecookie.close();

			file1.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println(driver.findElement(By.xpath("//a[@id='welcome']")).getText());
		String dashBoard = driver.findElement(By.cssSelector(".head > h1")).getText();
		Assert.assertEquals("Dashboard", dashBoard);
		
	}

	public void retriveCookies() throws IOException {
		File file = new File("Cookiefile.data");
		FileReader fileRead = new FileReader(file);

		BufferedReader reader = new BufferedReader(fileRead);
		String strLine;

		while ((strLine = reader.readLine()) != null) {
			StringTokenizer stringToken = new StringTokenizer(strLine, ";");
			System.out.println(stringToken);
			while (stringToken.hasMoreTokens()) {
				String name = stringToken.nextToken();
				String value = stringToken.nextToken();
				String domain = stringToken.nextToken();
				String path = stringToken.nextToken();

				Date expiry = null;
				String val;
				if (!(val = stringToken.nextToken()).equals("null")) {
					expiry = new Date(val);
				}
				Boolean isSecure = new Boolean(stringToken.nextToken()).booleanValue();
				Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
				driver.manage().addCookie(ck);
			}
		}

	}

	@Test
	public void TC02_verifyMenuList() throws IOException, InterruptedException {


		List<String> expectedlist = new ArrayList<String>();
		expectedlist.add("Admin");
		expectedlist.add("PIM");
		expectedlist.add("Leave");
		expectedlist.add("Time");
		expectedlist.add("Recruitment");
		expectedlist.add("My Info");
		expectedlist.add("Performance");
		expectedlist.add("Dashboard");
		expectedlist.add("Directory");
		expectedlist.add("Maintenance");
		expectedlist.add("Buzz");
		System.out.println("Expected List:  " + expectedlist);

		// getting list of menu from UI
		List<String> actualList = new ArrayList<String>();
		List<WebElement> menuList = driver.findElements(By.cssSelector("ul#mainMenuFirstLevelUnorderedList > li > a"));
		for (WebElement webElement : menuList) {
			actualList.add(webElement.getText());
		}
		System.out.println(actualList);

		Assert.assertEquals(actualList, expectedlist);
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Logout')]"))).click().build().perform();
		System.out.println(driver.getTitle());
		
	}
	
	
	

}

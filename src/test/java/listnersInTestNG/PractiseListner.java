package listnersInTestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listnersInTestNG.createdListesners.class)
public class PractiseListner {

	public static WebDriver driver;
	
	
	@Test // passing Test
	public void sampleTest1() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
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
		// to test listener on failureTest screenshot make the changes in locator and run 
		driver.quit();
	}

	@Test // Failing test Forcefully
	public void sampleTest2() {
		System.out.println("Forcely Failed Test Method");
		Assert.assertTrue(false);
	}

	int i = 0;

	@Test(successPercentage = 60, invocationCount = 5) // Test Failing But Within Success Percentage
	public void sampleTest3() {
		i++;
		System.out.println("Falied_test_on_success_percentage " + i);
		if (i == 1 || i == 2) {
			System.out.println("sampleTest3 Failed");
			Assert.assertEquals(i, 6);
		}

	}

	@Test // skiping the testcase
	public void sampleTest4() {
		throw new SkipException("Forcely skipping the sampleTest4");

	}

}

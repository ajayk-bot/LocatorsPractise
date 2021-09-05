package staleExceptionInterview;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleException2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.javatpoint.com/software-testing-tutorial");

		WebElement ele = driver.findElement(By.cssSelector("a[href='selenium-tutorial']"));
		ele.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		// handling stale exception using try and catch block
		try {
			ele.click();
		} catch (StaleElementReferenceException e) {
			ele = driver.findElement(By.cssSelector("a[href='selenium-tutorial']"));
			ele.click();
		}

		driver.quit();

	}

}

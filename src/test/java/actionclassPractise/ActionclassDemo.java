package actionclassPractise;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionclassDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		// System.out.println(driver.manage().timeouts().getImplicitWaitTimeout().toString());

		// whenever going for composite actions (multiple actions) use build().perform(), else perform().

		Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[1]"))).build().perform();

		//a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Watchlist')]"))).click().perform();
		//WebElement ele2 = driver.findElement(By.xpath("//span[contains(text(),'Watchlist')]"));
		//a.moveToElement(ele2).click().build().perform();
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(ele).click().keyDown(Keys.SHIFT).sendKeys("Text").perform();
		
		a.moveToElement(driver.findElement(By.xpath("//body/div[@id='a-page']/div[2]"))).click();
		
		
		System.out.println("End the script");
	}

}

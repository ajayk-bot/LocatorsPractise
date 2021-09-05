package naveenAutomatinLabs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2Challenge {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		List<WebElement> x_path = driver.findElements(By.xpath("//div[@class='sc-GTWni GkeGT'][1]"));
		x_path.get(0);
		 
		 
		
	}

}

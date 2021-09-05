package newSelenium4Updated;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocatorsNew {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys("testing");

		driver.findElement(
				withTagName("input").below(By.xpath("//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[1]/input[1]"))).sendKeys("email@gmail.com");

		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("22/04/2021");

		String lablewas = driver.findElement(withTagName("label").above(By.cssSelector("input[type='date']"))).getText();
		System.out.println(lablewas);
		
		//toLeftOf
		WebElement icecream = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(withTagName("input").toLeftOf(icecream)).click();
		Boolean value = driver.findElement(withTagName("input").toLeftOf(icecream)).isEnabled();
		System.out.println(value);
	
		
		
	}

}
